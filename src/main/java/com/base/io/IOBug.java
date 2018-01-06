package com.base.io;

import java.io.*;

public class IOBug {
    public static void main(String[] args) {
        try {
            DataOutputStream out =new DataOutputStream(new BufferedOutputStream(new FileOutputStream("Data.txt")));
            out.writeDouble(3.12159);
            out.writeBytes("That was the value of pi\n");
            out.writeBytes("This is pi/2\n");
            out.writeDouble(3.14159);
            out.close();
            DataInputStream in =new DataInputStream(new BufferedInputStream(new FileInputStream("Data.txt")));
            BufferedReader inbr=new BufferedReader(new InputStreamReader(in));
            System.out.println(in.readDouble());
            System.out.println(inbr.readLine());
            System.out.println(inbr.readLine());
            //错误的原因是输出了乱码导致读取解析失败
            //System.out.println(inbr.readLine());
            //System.out.println(in.readDouble());//异常的出现地
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
