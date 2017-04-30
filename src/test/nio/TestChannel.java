package test.nio;

import java.io.RandomAccessFile;
import java.nio.channels.DatagramChannel;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class TestChannel {

	public static void main(String[] args) throws Exception{

		RandomAccessFile fromFile = new RandomAccessFile("fromFile.txt", "rw");
		FileChannel      fromChannel = fromFile.getChannel();
		
		RandomAccessFile toFile = new RandomAccessFile("toFile.txt", "rw");
		FileChannel      toChannel = toFile.getChannel();
		
		long position = 0;
		long count = fromChannel.size();
		
		toChannel.transferFrom(fromChannel, position, count);

		
		
//		FileChannel
//		DatagramChannel
//		SocketChannel
//		ServerSocketChannel
		
		DatagramChannel datagramChannel = null;
		SocketChannel socketChannel = null;
		ServerSocketChannel serverSocketChannel = null;
		
		toChannel.transferFrom(datagramChannel, position, count);
		toChannel.transferFrom(socketChannel, position, count);
//		toChannel.transferFrom(serverSocketChannel, position, count);
	}

}
