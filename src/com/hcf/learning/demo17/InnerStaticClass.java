package com.hcf.learning.demo17;

public class InnerStaticClass {
    static private String username;
    static private String password;

    static class PrivateClass {
        private String age;
        private String address;

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public void printPublicProperty() {
            System.out.println(username + " " + password);
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

class Run1 {
    public static void main(String[] args) {
        InnerStaticClass innerStaticClass = new InnerStaticClass();
        innerStaticClass.setUsername("usernameValue");
        innerStaticClass.setPassword("passwordValue");
        System.out.println(innerStaticClass.getUsername() + " " +
                innerStaticClass.getPassword());

        InnerStaticClass.PrivateClass privateClass = new InnerStaticClass.PrivateClass();
        privateClass.setAge("ageValue");
        privateClass.setAddress("addressValue");
        System.out.println(privateClass.getAge() + " " + privateClass.getAddress());
    }
}