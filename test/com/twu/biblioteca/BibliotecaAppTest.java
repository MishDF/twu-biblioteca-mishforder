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
    public void bookListNotEmpty(){
        BibliotecaApp mockApp = Mockito.mock(BibliotecaApp.class);
        mockApp.initLists();
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

    @Test
    public void movieListNotEmpty(){
        BibliotecaApp mockApp = Mockito.mock(BibliotecaApp.class);
        mockApp.initLists();
        Assert.assertFalse(mockApp.movieList.isEmpty());
    }

    @Test
    public void movieStringCorrect(){
        Movie movie = new Movie("name", "1000", "director", 5);
        assertEquals(movie.toString(), "name  |   1000  |   director  |   5/10");
        Movie movie2 = new Movie("name", "1000", "director", 0);
        assertEquals(movie2.toString(), "name  |   1000  |   director  |   rating unavailable");
    }

    @Test
    public void checkoutMovieTest(){
        Movie movie = new Movie("name", "1000", "director", 5);
        movie.checkout();
        assertEquals(false, movie.getAvailable());
    }

    @Test
    public void checkoutMovieUnavaliable(){
        Movie movie = new Movie("name", "1000", "director", 5);
        movie.checkout();
        assertEquals(false, movie.checkout());

    }

    @Test
    public void userListNotEmpty(){
        BibliotecaApp mockApp = Mockito.mock(BibliotecaApp.class);
        mockApp.initLists();
        Assert.assertFalse(mockApp.userList.isEmpty());
    }

    @Test
    public void loginSuccess(){
        BibliotecaApp mockApp = Mockito.mock(BibliotecaApp.class);
        mockApp.userList.add(new User("111-1111", "123", "name", "default@email.com", "040000"));
        Assert.assertTrue(mockApp.loginValidation("111-1111", "123"));
    }

    @Test
    public void loginUserFail(){
        BibliotecaApp mockApp = Mockito.mock(BibliotecaApp.class);
        mockApp.userList.add(new User("111-1111", "123", "name", "default@email.com", "040000"));
        Assert.assertFalse(mockApp.loginValidation("112-1111", "123"));
    }

    @Test
    public void loginPasswordFail(){
        BibliotecaApp mockApp = Mockito.mock(BibliotecaApp.class);
        mockApp.userList.add(new User("111-1111", "123", "name",  "default@email.com", "040000"));
        Assert.assertFalse(mockApp.loginValidation("111-1111", "124"));
    }

    @Test (expected = NullPointerException.class)
    public void viewUserBooksFail(){
        BibliotecaApp mockApp = Mockito.mock(BibliotecaApp.class);
        mockApp.currentUser.getBooks();

    }

    @Test
    public void userStringCorrect() {
        User user = new User("111-1111", "123", "name", "default@email.com", "040000");
        assertEquals("name  |   default@email.com  |   040000", user.toString());
    }

    @Test (expected = NullPointerException.class)
    public void viewUserInfosFail(){
        BibliotecaApp mockApp = Mockito.mock(BibliotecaApp.class);
        mockApp.viewInfo();

    }

}
