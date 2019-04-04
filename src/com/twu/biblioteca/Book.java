package com.twu.biblioteca;

public class Book {
    String name;
    String author;
    String year;
    Boolean avaliable;

    Book(){
        name = "default";
        author = "default";
        year = "0000";
        avaliable = true;
    }

    Book(String n, String a, String y){
        name = n;
        author = a;
        year = y;
        avaliable = true;
    }

    public boolean getAvalaible(){
        return avaliable;
    }

    public String getName(){
        return name;
    }


    public String toString(){
        return name + "  |   " + author + "  |   " + year;
    }

    public boolean checkout(){
        if(avaliable ==true){
            avaliable=false;
            return true;
        }else {
            return false;
        }
    }

    //return
}
