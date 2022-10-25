package com.hcf.learning.demo30;

import java.io.*;

public class SingleTonTest6 {
    public static void main(String[] args) {
        try (FileOutputStream fileInputStream = new FileOutputStream(new File("myObject-File.txt"));
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileInputStream);
        ) {
            MyObject5 myObject = MyObject5.getInstance();
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
            MyObject5 myObject5 = (MyObject5) objectInputStream.readObject();
            System.out.println("serializable myObject = " + myObject5.hashCode() + " useInfo = " + myObject5.userInfo.hashCode());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

    class MyObject5 implements Serializable {
        private static final long serialVersionUID = 1L;

        public static UserInfo userInfo = new UserInfo();

        private static MyObject5 myObject = new MyObject5();

        private MyObject5() {
        }

        public static MyObject5 getInstance() {
            return myObject;
        }

        protected Object readResolve() throws ObjectStreamException {
            System.out.println("readResolve() called");
            return MyObject5.myObject;
        }
    }

    class UserInfo {

    }
