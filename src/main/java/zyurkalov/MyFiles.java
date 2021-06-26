package zyurkalov;

import java.io.IOException;
import java.io.InputStream;

public class MyFiles {
    public static String pullBytes(InputStream is, int count) throws IOException {

        final StringBuilder sb = new StringBuilder();
        sb.append ( (char) is.read () );
        if(is.markSupported () ) {
            is.mark(100);
            for (int i=0; i<count; i++)
                sb.append ( (char) is. read ());
            is.skip (20);
            is.reset();
        }
        sb.append ( (char) is.read () );
        return sb.toString();
    }
    public static void main(String[] args) {

    }
}
