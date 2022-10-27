package com.hcf.learning.demo30;

import java.io.*;

public class SingleTonTest6 {
    public static void main(String[] args) {
        try (FileOutputStream fileInputStream = new FileOutputStream(new File("myObject-File.txt"));
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileInputStream);
        ) {
            MyObject6 myObject = MyObject6.getInstance();
            System.out.println("serializable myObject = " + myObject.hashCode() + " useInfo = " + myObject.userInfo.hashCode());
            objectOutputStream.writeObject(myObject);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (FileInputStream fileInputStream = new FileInputStream(new File("myObject-File.txt"));
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        ) {
            MyObject6 myObject6 = (MyObject6) objectInputStream.readObject();
            System.out.println("serializable myObject = " + myObject6.hashCode() + " useInfo = " + myObject6.userInfo.hashCode());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

    class MyObject6 implements Serializable {
        private static final long serialVersionUID = 1L;

        public static UserInfo userInfo = new UserInfo();

        private static MyObject6 myObject = new MyObject6();

        private MyObject6() {
        }

        public static MyObject6 getInstance() {
            return myObject;
        }

        protected Object readResolve() throws ObjectStreamException {
            System.out.println("readResolve() called");
            return MyObject6.myObject;
        }
    }

    class UserInfo {

    }
