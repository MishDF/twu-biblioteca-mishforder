package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {

    static String welcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    static Scanner scan = new Scanner(System.in);
    static ArrayList<Book> bookList = new ArrayList<Book>();
    static ArrayList<Movie> movieList = new ArrayList<Movie>();
    static ArrayList<User> userList = new ArrayList<User>();
    static boolean loggedIn=false;
    static User currentUser;

    public static void main(String[] args) {

        initLists();

        System.out.println(welcomeMessage);

        int menuInput = 1000;

        do {
            showMenu();
            try{
                menuInput = scan.nextInt();
                menuSelection(menuInput);

            } catch(InputMismatchException e){
                System.out.println("Invalid input");
                scan.nextLine();
            }


        } while (menuInput!=0);

    }
    public static void showMenu(){
        //show options
        if(loggedIn==true) {
            System.out.println("Type a number to select an option");
            System.out.println("1 - Show list of books");
            System.out.println("2 - Checkout a book");
            System.out.println("3 - Return a book");
            System.out.println("4 - Show list of movies");
            System.out.println("5 - Checkout a movie");
            System.out.println("6 - View books you currently have checked out");
            System.out.println("7 - View your info");
            System.out.println("0 - Quit");

        }else{
            System.out.println("Type a number to select an option");
            System.out.println("1 - Login");
            System.out.println("2 - Show list of books");
            System.out.println("3 - Show list of movies");
            System.out.println("0 - Quit");
        }

    }

    public static void menuSelection(int i){
        //switch to trigger right function
        if(loggedIn==true) {
            switch (i) {
                case 1:
                    scan.nextLine();
                    showBooks();
                    break;
                case 2:
                    scan.nextLine();
                    checkoutBook();
                    break;
                case 3:
                    scan.nextLine();
                    returnBook();
                    break;
                case 4:
                    scan.nextLine();
                    showMovies();
                    break;
                case 5:
                    scan.nextLine();
                    checkoutMovie();
                    break;
                case 6:
                    scan.nextLine();
                    viewCheckedOutBooks();
                    break;
                case 7:
                    scan.nextLine();
                    viewInfo();
                    break;
                case 0:
                    scan.nextLine();
                    System.out.println("Goodbye");
                    break;
                default:
                    scan.nextLine();
                    System.out.println("Invalid number");
                    break;
            }
        }else{
            switch (i) {
                case 1:
                    scan.nextLine();
                    login();
                    break;
                case 2:
                    scan.nextLine();
                    showBooks();
                    break;
                case 3:
                    scan.nextLine();
                    showMovies();
                    break;
                case 0:
                    scan.nextLine();
                    System.out.println("Goodbye");
                    break;
                default:
                    scan.nextLine();
                    System.out.println("Invalid number");
                    break;
            }
        }

    }

    public static void showBooks(){
        for(int i=0; i<bookList.size();i++){
            if(bookList.get(i).getAvailable()==true) {
                String book = bookList.get(i).toString();
                System.out.println(book);
            }
        }
    }

    public static void initLists(){

        bookList.add(new Book("name1", "author1", "1000"));
        bookList.add(new Book("name2", "author2", "1000"));
        bookList.add(new Book("name3", "author3", "1000"));
        bookList.add(new Book("name4", "author4", "1000"));

        movieList.add(new Movie("name1", "1000", "director1", 5));
        movieList.add(new Movie("name2", "1000", "director2", 0));
        movieList.add(new Movie("name3", "1000", "director3", 5));
        movieList.add(new Movie("name4", "1000", "director4", 0));

        userList.add(new User("111-1111", "123", "name1", "default@email.com", "040000"));
        userList.add(new User("111-1112", "123", "name2", "default@email.com", "040000"));
        userList.add(new User("111-1113", "123", "name3", "default@email.com", "040000"));
        userList.add(new User("111-1114", "321", "name4", "default@email.com", "040000"));

    }

    public static void checkoutBook(){
        if(loggedIn==true) {
            System.out.println("Please type in the name of the book you want to checkout");
            //type in book name
            String bookName = scan.nextLine();
            //check if book
            boolean inList = false;
            int bookIndex = 0;
            for (int i = 0; i < bookList.size(); i++) {
                if (bookName.equals(bookList.get(i).getName())) {
                    inList = true;
                    bookIndex = i;
                }
            }

            if (inList == true) {
                if (bookList.get(bookIndex).checkout()) {
                    currentUser.addBook(bookList.get(bookIndex));
                    System.out.println("Thank You! Enjoy the book");
                } else {
                    System.out.println("Sorry that is not avalaible");
                }
            } else {
                System.out.println("Sorry that is not avalaible");
            }
        }else{
            System.out.println("Need to be logged in to do this");
        }

    }

    public static void returnBook(){
        System.out.println("Please type in the name of the book you want to return");
        //type in book name
        String bookName = scan.nextLine();
        //check if book
        boolean inList=false;
        int bookIndex=0;
        for(int i=0; i<bookList.size(); i++){
            if(bookName.equals(bookList.get(i).getName())){
                inList=true;
                bookIndex=i;
            }
        }

        if(inList==true){
            if(bookList.get(bookIndex).returnBook()){
                System.out.println("Thank You for returning the book");
            }else{
                System.out.println("That is not a valid book to return");
            }
        }else{
            System.out.println("That is not a valid book to return");
        }
    }

    static public void showMovies(){
        for(int i=0; i<movieList.size();i++){
            if(movieList.get(i).getAvailable()==true) {
                String book = movieList.get(i).toString();
                System.out.println(book);
            }
        }
    }

    static public void checkoutMovie(){
        System.out.println("Please type in the name of the movie you want to checkout");
        //type in book name
        String movieName = scan.nextLine();
        //check if book
        boolean inList=false;
        int movieIndex=0;
        for(int i=0; i<movieList.size(); i++){
            if(movieName.equals(movieList.get(i).getName())){
                inList=true;
                movieIndex=i;
            }
        }

        if(inList==true){
            if(bookList.get(movieIndex).checkout()){
                System.out.println("Thank You! Enjoy the movie");
            }else{
                System.out.println("Sorry that is not avalaible");
            }
        }else{
            System.out.println("Sorry that is not avalaible");
        }
    }


    static public void login(){
        System.out.println("please type in your library number (xxx-xxxx)");
        String number = scan.nextLine();
        System.out.println("please type in your password");
        String password = scan.nextLine();
        if(loginValidation(number, password)){
            System.out.println("Logged In!");
        }else{
            System.out.println("Login failed, incorrect library number or password");
        }
    }

    static public boolean loginValidation(String num, String pass) {
        boolean returnValue=false;
        boolean realUser = false;
        int userIndex = -1;

        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getNumber().equals(num)) {
                userIndex = i;
                realUser=true;
            }
        }
        if (realUser == true) {
            //check if password is same
            if (userList.get(userIndex).getPassword().equals(pass)) {
                currentUser = userList.get(userIndex);
                loggedIn = true;
                return true;
            }
        }
        return returnValue;
    }

    static public void viewCheckedOutBooks(){
        ArrayList<Book> userBooks =currentUser.getBooks();
        for(int i=0; i<userBooks.size(); i++) {
            System.out.println(userBooks.get(i).toString());
        }

    }

    static public void viewInfo(){
        String userInfo = currentUser.toString();
        System.out.println(userInfo);
    }
}
