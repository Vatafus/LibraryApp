package com.exam.exam.service;

import com.exam.exam.exception.SameBookException;
import com.exam.exam.model.Book;
import com.exam.exam.repo.BookRepo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    @Mock
    private BookRepo bookRepo;
    @InjectMocks
    private BookService bookService;


    @Test
    @DisplayName("Book-lalalaa")
    void addbook() {
        Book book = new Book("ExamenJava", "Stefan", "Universitate",2010);
        Book addedBook = new Book(1,"ExamenJava", "Stefan", "Universitate",2010);
        when(bookRepo.getbythis(any(),any(),anyInt())).thenReturn(Optional.empty());
        when(bookRepo.createBook(any())).thenReturn(addedBook);

        Book rezultat = bookService.addbook(book);

        assertEquals(book.getTitle(), rezultat.getTitle());
        assertEquals(book.getAuthor(), rezultat.getAuthor());
        assertEquals(book.getPublisher(), rezultat.getPublisher());
        assertEquals(book.getPublishingYear(), rezultat.getPublishingYear());
        assertEquals(1, rezultat.getId());

        verify(bookRepo).getbythis(any(),any(),anyInt());
        verify(bookRepo).createBook(any());
    }

    @Test
    @DisplayName("The same book")
    void addbookThrowsException() {
        Book book = new Book("ExamenJava", "Stefan", "Universitate",2010);
        Book addedBook = new Book(1,"ExamenJava", "Stefan", "Universitate",2010);
        when(bookRepo.getbythis(any(),any(),anyInt())).thenReturn(Optional.of(addedBook));

        SameBookException exception = assertThrows(SameBookException.class, () -> bookService.addbook(book));

        assertEquals("This Book already exist", exception.getMessage());

        verify(bookRepo).getbythis(any(),any(),anyInt());
        verify(bookRepo, times(0)).createBook(any());
    }
}