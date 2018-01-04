package top.blentle.foundation.review.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

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
            Iterator<SelectionKey> keys = selector.selectedKeys().iterator();
            while (keys.hasNext()) {
                SelectionKey key = keys.next();
                if (key.isAcceptable()) {
                    System.err.println("accept ....");
                    SocketChannel responseSocket = server.accept();
                    responseSocket.configureBlocking(false);
                    responseSocket.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE);
                } else if (key.isReadable()) {
                    SocketChannel sc = (SocketChannel) key.channel();
                    ByteBuffer bb = ByteBuffer.allocate(1024 * 1024);
                    int length = 0;
                    while ((length = sc.read(bb)) > 0) {
                        bb.flip();
                        System.err.println(new String(bb.array(), 0, length));
                        bb.clear();
                    }
                }
                keys.remove();
            }

        }
    }
}
