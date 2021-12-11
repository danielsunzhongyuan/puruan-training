package org.github.zsun.java.puruantraining.javabasics.chapter4;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioBufferDemo {
    public static void main(String[] args) throws IOException {
        int bufferSize = 4;
        final String path = NioBufferDemo.class.getClassLoader().getResource("1.txt").getPath();
        final FileChannel src = new FileInputStream(path).getChannel();
        final String dest = path.replace("1.txt", "3.txt");
        final FileChannel destChannel = new FileOutputStream(dest).getChannel();
        final ByteBuffer buffer = ByteBuffer.allocate(bufferSize);
        while (src.read(buffer) != -1) {
            buffer.flip();
            destChannel.write(buffer);
            buffer.clear();
        }
    }
}
