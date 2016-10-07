package ibmdw.nio;// $Id$

import java.io.*;
import java.nio.*;
import java.nio.channels.*;

public class WriteSomeBytes
{
  static private final byte message[] = { 83, 111, 109, 101, 32,
                                          98, 121, 116, 101, 115, 46 };
  //写一些数据进文件中
  static public void main( String args[] ) throws Exception {
    FileOutputStream fout = new FileOutputStream( "e://writesomebytes.txt" );

    FileChannel fc = fout.getChannel();

    ByteBuffer buffer = ByteBuffer.allocate( 128 );

    for (int i=0; i<222; ++i) {
    	if(buffer.hasRemaining()){
    	    buffer.flip();
    	    fc.write( buffer );
    	    buffer.clear();
    	}
      buffer.put( ("ssd"+i+"---+"+"\n").getBytes() );
    }

    buffer.flip();

    fc.write( buffer );

    fout.close();
  }
}
