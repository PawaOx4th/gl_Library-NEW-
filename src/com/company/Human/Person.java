package com.company.Human;

import com.company.Enum;

public class Person {
    private String name, sername;
    private String id ;
    private String password ;
    private Enum.Position position;


    //==============================Constructer===========================//
    public Person(String name, String sername, String id, String password, Enum.Position position) {
        this.name = name;
        this.sername = sername;
        this.id = id;
        this.password = password;
        this.position = position;
    }

    //==============================Setter===========================//
    public void setName(String name) {
        this.name = name;
    }
    public void setSername(String sername) {
        this.sername = sername;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setPosition(Enum.Position position) {
        this.position = position;
    }

    //==============================Getter===========================//
    public String getName() {
        return name;
    }
    public String getSername() {
        return sername;
    }
    public String getId() {
        return id;
    }
    public String getPassword() {
        return password;
    }
    public Enum.Position getPosition() {
        return position;
    }
}
