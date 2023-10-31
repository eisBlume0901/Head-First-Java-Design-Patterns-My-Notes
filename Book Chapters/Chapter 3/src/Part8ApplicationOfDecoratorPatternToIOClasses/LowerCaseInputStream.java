package Part8ApplicationOfDecoratorPatternToIOClasses;

import java.io.*;
public class LowerCaseInputStream extends FilterInputStream
{
    public LowerCaseInputStream(InputStream in)
    {
        super(in);
    }

    public int read() throws IOException
    {
        int c = in.read(); // there might be an InputStream declared as
        // instance variable inside the FilterInputStream
        return (c == -1 ? c : Character.toLowerCase((char) c));
    }

    public int read(byte[] b, int offset, int len) throws IOException
    {
        int result = in.read(b,offset, len);
        for (int i = offset; i < offset +  result; i++)
            b[i] = (byte) Character.toLowerCase((char) b[i]);
        return result;
    }
}


class InputTest {
    public static void main(String[] args) throws IOException {
        int c;
        InputStream in = null;
        try {
            in =
                    new LowerCaseInputStream(
                            new BufferedInputStream(
                                    new FileInputStream("test")));

            while((c = in.read()) >= 0) {
                System.out.print((char)c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) { in.close(); }
        }
    }
}
