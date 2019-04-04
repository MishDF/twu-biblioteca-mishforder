package com.twu.biblioteca;

import junit.framework.TestCase;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.InputMismatchException;

import static junit.framework.TestCase.assertTrue;
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



}
