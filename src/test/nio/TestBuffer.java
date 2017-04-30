package test.nio;

import java.nio.ByteBuffer;
import java.nio.LongBuffer;

public class TestBuffer {

	public static void main(String[] args) {
		ByteBuffer buf = ByteBuffer.allocate(48);
		
		
		buf = ByteBuffer.allocateDirect(48);
		
		LongBuffer longBuf = LongBuffer.allocate(48);

	}

}
