package com.company.Users;

import com.company.Enum;
import com.company.Human.Person;

public class User extends Person {
    //extends Class Person  from Human Package
    public User(String name, String sername, String id, String password, Enum.Position position) {
        super(name, sername, id, password, position);
    }

}
