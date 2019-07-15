package com.company.Exception;

public class InputError extends Exception    {

    int id,x ;

    public InputError(int x){
        id = 404 ;
    }

    public  String toString() {
        return "CustomEception [" + id + "]";

    }
}
