package com.twu.biblioteca;

import java.util.ArrayList;

public class User {
    private String number;
    private String password;
    private String name;
    private String email;
    private String phone;
    private ArrayList<Book> books = new ArrayList<Book>();

    User(){
        number = "111-1111";
        password = "123";
        name = "name";
        email = "default@email.com";
        phone = "040000000";
    }


    User(String num, String p, String n, String e, String ph){
        number = num;
        password = p;
        name = n;
        email = e;
        phone = ph;
    }


    public ArrayList<Book> getBooks(){
        return books;
    }


    public void addBook(Book b){
        books.add(b);
    }

    public String getNumber(){
        return number;
    }

    public String getPassword(){
        return password;
    }

    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }

    public String getPhone(){
        return phone;
    }



    public String toString(){
        return name + "  |   " + email+ "  |   " + phone;
    }

}
