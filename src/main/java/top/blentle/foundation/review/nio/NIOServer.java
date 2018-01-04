package top.blentle.foundation.review.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Set;

/**
 * @author :  renhuan
 * @email : blentle.huan.ren@gmail.com
 * @time :  2018/1/2 0002
 * @description :
 * @since : 1.0
 */
public class NIOServer {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel server = ServerSocketChannel.open();
        server.configureBlocking(false);
        server.bind(new InetSocketAddress(10000));
        Selector selector = Selector.open();
        //给通道注册事件
        server.register(selector, SelectionKey.OP_ACCEPT);
        while (selector.select() > 0) {
            Set<SelectionKey> keys = selector.selectedKeys();
            for (SelectionKey key : keys) {
                if (key.isAcceptable()) {
                    System.err.println("accept ....");
                }
                if (key.isConnectable()) {
                    System.err.println("connect ....");
                }
            }
        }
    }
}
