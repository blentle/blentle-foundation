package top.blentle.foundation.review.arithmetic.nlp;

import org.deeplearning4j.models.embeddings.loader.WordVectorSerializer;
import org.deeplearning4j.models.word2vec.Word2Vec;
import org.deeplearning4j.text.sentenceiterator.LineSentenceIterator;
import org.deeplearning4j.text.sentenceiterator.SentenceIterator;
import org.deeplearning4j.text.sentenceiterator.SentencePreProcessor;
import org.deeplearning4j.text.tokenization.tokenizer.preprocessor.CommonPreprocessor;
import org.deeplearning4j.text.tokenization.tokenizerfactory.DefaultTokenizerFactory;
import org.deeplearning4j.text.tokenization.tokenizerfactory.TokenizerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Collection;

public class Word2VectorTest {

    private static final Logger logger = LoggerFactory.getLogger(Word2VectorTest.class);

    public static void main(String[] args) throws Exception {
        logger.info("Load data....");
        SentenceIterator iter = new LineSentenceIterator(new File("E:\\nlp-dataset\\text8"));
        iter.setPreProcessor(new SentencePreProcessor() {
            @Override
            public String preProcess(String sentence) {
                return sentence.toLowerCase();
            }
        });
        TokenizerFactory t = new DefaultTokenizerFactory();
        t.setTokenPreProcessor(new CommonPreprocessor());
        logger.info("Building model....");
        Word2Vec vec = new Word2Vec.Builder()
                .minWordFrequency(5)
                .layerSize(200)
                .seed(42)
                .windowSize(8)
                .iterate(iter)
                .negativeSample(25)
                .workers(16)
                .elementsLearningAlgorithm("org.deeplearning4j.models.embeddings.learning.impl.elements.CBOW")
                .tokenizerFactory(t)
                .build();

        logger.info("Fitting Word2Vec model....");
        vec.fit();
        // Write word vectors
        WordVectorSerializer.writeWord2VecModel(vec, new FileOutputStream("E:\\nlp-dataset\\word2vec-model"));
        logger.info("Closest Words:");
        Collection<String> lst = vec.wordsNearest("man", 10);
        System.out.println(lst);
//        Word2Vec word2Vec = WordVectorSerializer.readWord2VecModel("E:\\nlp-dataset\\word2vec-model");
//        Collection<String> lst = word2Vec.wordsNearest("cat", 10);
//        System.out.println(lst);
    }
}
