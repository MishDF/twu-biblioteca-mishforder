package com.twu.biblioteca;

public class Book {
    private String name;
    private String author;
    private String year;
    private Boolean available;

    Book(){
        name = "default";
        author = "default";
        year = "0000";
        available = true;
    }

    Book(String n, String a, String y){
        name = n;
        author = a;
        year = y;
        available = true;
    }

    public boolean getAvailable(){
        return available;
    }

    public void setAvailable(boolean a){
        available =a;
    }

    public String getName(){
        return name;
    }


    public String toString(){
        return name + "  |   " + author + "  |   " + year;
    }

    public boolean checkout(){
        if(available ==true){
            available=false;
            return true;
        }else {
            return false;
        }
    }

    public boolean returnBook(){

        if(available ==false){
            available=true;
            return true;
        }else {
            return false;
        }
    }
}
