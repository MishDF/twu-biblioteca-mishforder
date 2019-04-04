package com.twu.biblioteca;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BibliotecaApp {

    static String welcomeMessage = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

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


        } while (menuInput!=3);

    }
    public static void showMenu(){
        //show options
        System.out.println("Type a number to select an option");
        System.out.println("1 - Show list of books");
        System.out.println("3 - Quit");


    }

    public static void menuSelection(int i){
        //switch to trigger right function
        switch(i){
            case 1 :
                showBooks();
                break;
            case 3:
                System.out.println("Goodbye");
                break;
            default:
                System.out.println("Invalid number");
                break;
        }
    }

    public static void showBooks(){
        //blank for now
        System.out.println("running showing books");
    }




}
