package com.recepinanc.effectivejava;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

// Original source code is at : https://www.geeksforgeeks.org/transient-keyword-java/

public class TransientKeyword implements Serializable
{

    private transient int x = 1;
    private int y = 2;


    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        TransientKeyword input = new TransientKeyword();
        FileOutputStream fos = null;
        fos = new FileOutputStream("abc.txt");
        ObjectOutputStream oos = null;
        oos = new ObjectOutputStream(fos);
        oos.writeObject(input);
        FileInputStream fis = new FileInputStream("abc.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        TransientKeyword output = (TransientKeyword) ois.readObject();
        System.out.println("i = " + output.x);
        System.out.println("j = " + output.y);
    }
    
    // Result
    
    // i = 0
    // j = 2
}
