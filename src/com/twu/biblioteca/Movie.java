package com.twu.biblioteca;

public class Movie {

    private String name;
    private String year;
    private String director;
    private int rating;
    private boolean available;


    Movie(){
        name = "default";
        year = "default";
        director = "default";
        rating = 0;
        available = true;
    }

    Movie(String n, String y, String d, int r){
        name =n;
        year = y;
        director = d;
        rating = r;
        available = true;
    }

    public String getName(){
        return name;
    }

    public boolean getAvailable(){
        return available;
    }

    public void setAvaliable(boolean a){
        available=a;
    }

    public String toString(){
        if(rating==0){
            return name + "  |   " + year + "  |   " + director + "  |   rating unavailable";
        }else{
            return name + "  |   " + year + "  |   " + director + "  |   " + rating + "/10";
        }
    }

    public boolean checkout(){
        if(available ==true){
            available=false;
            return true;
        }else {
            return false;
        }
    }

}
