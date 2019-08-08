package com.recepinanc.effectivejava.chapter2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Item9
{
    public static void main(String[] args)
    {
        //copy("a", "b");
    }
    
    static void copy(String src, String dest) throws IOException
    {
        InputStream inputStream = new FileInputStream(src);
        OutputStream outputStream = new FileOutputStream(dest);
        byte[] buf = new byte[122];
        int n;
        while ((n = inputStream.read(buf)) >= 0) {
            outputStream.write(buf, 0, n);
        }
        outputStream.close();
        inputStream.close();
    }
}
