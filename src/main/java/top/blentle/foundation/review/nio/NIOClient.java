package top.blentle.foundation.review.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

/**
 * @author :  renhuan
 * @email : blentle.huan.ren@gmail.com
 * @time :  2018/1/4 0004
 * @description :
 * @since : 1.0
 */
public class NIOClient {
    public static void main(String[] args) throws IOException {
        SocketChannel client = SocketChannel.open();
        client.configureBlocking(false);
        client.connect(new InetSocketAddress("localhost",10000));

    }
}
