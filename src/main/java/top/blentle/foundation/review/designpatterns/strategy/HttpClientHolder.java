package top.blentle.foundation.review.designpatterns.strategy;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.slf4j.LoggerFactory;

/**
 *
 * @author blentle
 * @desc http 连接池持有者
 */
public class HttpClientHolder {

	private static CloseableHttpClient httpClient;

	private static PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();

	static {
		//连接池最大连接数:100应该够了
		cm.setMaxTotal(100);
		cm.setDefaultMaxPerRoute(20);
		if(httpClient == null) {
			httpClient = HttpClients.custom()
					.setConnectionManager(cm)
					.setDefaultRequestConfig(RequestConfig.custom()
					.setConnectTimeout(6000)
					.setSocketTimeout(3000).build())
					.build();

		}
		Runtime.getRuntime().addShutdownHook(new Thread(() -> {
			try {
				httpClient.close();
				cm.close();
			} catch (Exception e) {
				LoggerFactory.getLogger(HttpClientHolder.class).error("failed to close httpClient pool ！", e);
			}
		}));
	}


	public static CloseableHttpClient getHttpClient() {
		return httpClient;
	}

}