package top.blentle.foundation.review.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.Scanner;

/**
 * @author :  renhuan
 * @email : blentle.huan.ren@gmail.com
 * @time :  2018/1/4 0004
 * @description :
 * @since : 1.0
 */
public class NIOClient {
    public static void main(String[] args) throws IOException {
        SocketChannel client = SocketChannel.open(new InetSocketAddress("localhost",10000));
        client.configureBlocking(false);
        ByteBuffer bb = ByteBuffer.allocate(1024*1024);
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            String s = scanner.next();
            bb.put((new Date().toString() + "\n" + s).getBytes(Charset.forName("utf-8")));
            bb.flip();
            client.write(bb);
            bb.clear();
        }
        client.close();
    }
}
