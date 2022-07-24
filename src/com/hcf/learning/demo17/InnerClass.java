package com.hcf.learning.demo17;

public class InnerClass {

    private String username;
    private String password;

    class PrivateClass {
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

class Run {
    public static void main(String[] args) {
        InnerClass innerClass = new InnerClass();
        innerClass.setUsername("usernameValue");
        innerClass.setPassword("passwordValue");
        System.out.println(innerClass.getUsername() + " " +
                innerClass.getPassword());

        InnerClass.PrivateClass privateClass = innerClass.new PrivateClass();
        privateClass.setAge("ageValue");
        privateClass.setAddress("addressValue");
        System.out.println(privateClass.getAge() + " " + privateClass.getAddress());
    }
}
