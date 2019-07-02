package com.company;

public class User extends  Person{
    public User(String name, String sername, String id, String password, Position position) {
        super(name, sername, id, password, position);
    }

    public static void main(String[] args) {
        User user = new User("mart","Bubparn","U001","U001",Position.user);

    }
}
