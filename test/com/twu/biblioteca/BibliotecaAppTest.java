package com.twu.biblioteca;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.InputMismatchException;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;

public class BibliotecaAppTest {

    @Test
    public void welcomeMessageShown() {
        TestCase.assertEquals("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!", BibliotecaApp.welcomeMessage);
    }

    @Test
    public void menuSelectionTest(){
        BibliotecaApp mockApp = Mockito.mock(BibliotecaApp.class);
        //if 1 then will call book list
        mockApp.menuSelection(1);
        Mockito.verify(mockApp, Mockito.times(1)).showBooks();

    }

    @Test
    public void bookListNotEmpty(){
        BibliotecaApp mockApp = Mockito.mock(BibliotecaApp.class);
        mockApp.initList();
        Assert.assertFalse(mockApp.bookList.isEmpty());
    }

    @Test
    public void bookStringCorrect(){
        Book book = new Book("name", "author", "0000");
        assertEquals(book.toString(), "name  |   author  |   0000");
    }

    @Test
    public void checkoutTest(){
        Book book = new Book("name", "author", "0000");
        book.checkout();
        assertEquals(false, book.getAvailable());
    }

    @Test
    public void checkoutUnavaliable(){
        Book book = new Book("name", "author", "0000");
        book.checkout();
        assertEquals(false, book.checkout());

    }

    @Test
    public void returnTest(){
        Book book = new Book("name", "author", "0000");
        book.setAvailable(false);
        book.returnBook();
        assertEquals(true, book.getAvailable());
    }

    @Test
    public void returnAvaliable(){
        Book book = new Book("name", "author", "0000");
        book.returnBook();
        assertEquals(false, book.returnBook());
    }

}
