package com.exam.exam.service;

import com.exam.exam.exception.SameBookException;
import com.exam.exam.model.Book;
import com.exam.exam.repo.BookRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private BookRepo bookRepo;

    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    public Book addbook(Book book){
        Optional<Book>bookWithSameThis =bookRepo.getbythis(book.getTitle(),book.getPublisher(),book.getPublishingYear());
        if(bookWithSameThis.isPresent()){
            throw new SameBookException();
        }
        return bookRepo.createBook(book);
    }

    public List<Book> getByTitle() {
        return bookRepo.getByTitle();
    }
}
