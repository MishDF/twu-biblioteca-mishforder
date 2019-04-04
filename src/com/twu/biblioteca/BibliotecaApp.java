package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {

    static String welcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    static Scanner scan = new Scanner(System.in);
    static ArrayList<Book> bookList = new ArrayList<Book>();

    public static void main(String[] args) {

        initList();

        System.out.println(welcomeMessage);

        int menuInput = 0;

        do {
            showMenu();
            try{
                menuInput = scan.nextInt();
                menuSelection(menuInput);

            } catch(InputMismatchException e){
                System.out.println("Invalid input");
                scan.nextLine();
            }


        } while (menuInput!=4);

    }
    public static void showMenu(){
        //show options
        System.out.println("Type a number to select an option");
        System.out.println("1 - Show list of books");
        System.out.println("2 - Checkout a book");
        System.out.println("3 - Return a book");
        System.out.println("4 - Quit");


    }

    public static void menuSelection(int i){
        //switch to trigger right function
        switch(i){
            case 1 :
                scan.nextLine();
                showBooks();
                break;
            case 2 :
                scan.nextLine();
                checkoutBook();
                break;
            case 3 :
                scan.nextLine();
                returnBook();
                break;
            case 4:
                scan.nextLine();
                System.out.println("Goodbye");
                break;
            default:
                scan.nextLine();
                System.out.println("Invalid number");
                break;
        }
    }

    public static void showBooks(){
        for(int i=0; i<bookList.size();i++){
            if(bookList.get(i).getAvalaible()==true) {
                String book = bookList.get(i).toString();
                System.out.println(book);
            }
        }
    }

    public static void initList(){

        bookList.add(new Book("name1", "author1", "1000"));
        bookList.add(new Book("name2", "author2", "1000"));
        bookList.add(new Book("name3", "author3", "1000"));
        bookList.add(new Book("name4", "author4", "1000"));
    }

    public static void checkoutBook(){
        System.out.println("Please type in the name of the book you want to checkout");
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
            if(bookList.get(bookIndex).checkout()){
                System.out.println("Thank You! Enjoy the book");
            }else{
                System.out.println("Sorry that is not avalaible");
            }
        }else{
            System.out.println("Sorry that is not avalaible");
        }

    }

    public static void returnBook(){

    }


}
