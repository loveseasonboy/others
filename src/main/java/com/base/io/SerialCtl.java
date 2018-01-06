package com.base.io;

import java.io.*;

/**
 * 序列化中使用不需要序列化的字段
 */
public class SerialCtl implements Serializable {
    String a;
    transient String b;

    public SerialCtl(String aa, String bb) {
        a = "Not Transient :" + aa;
        b = "Transient:" + bb;
    }

    @Override
    public String toString() {
        return a + "\n" + b;
    }

    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        stream.writeObject(b);
    }

    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        b = (String) stream.readObject();
    }

    public static void main(String[] args) {
        SerialCtl sc = new SerialCtl("test1", "test2");
        System.out.println("Before:\n" + sc);
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        try {
            ObjectOutputStream o = new ObjectOutputStream(buf);
            o.writeObject(sc);
            ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(buf.toByteArray()));
            SerialCtl sc2 = (SerialCtl) in.readObject();
            System.out.println("After:\n" + sc2);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
