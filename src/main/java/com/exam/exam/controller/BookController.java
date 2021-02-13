package com.exam.exam.controller;

import com.exam.exam.dto.BookDTO;
import com.exam.exam.mapper.BookMapper;
import com.exam.exam.model.Book;
import com.exam.exam.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private BookService bookService;
    private BookMapper bookMapper;

    public BookController(BookService bookService, BookMapper bookMapper) {
        this.bookService = bookService;
        this.bookMapper = bookMapper;
    }

    @PostMapping
    public ResponseEntity<Book>addAbook(
            @RequestBody
            @Valid
            BookDTO bookDTO){
    Book saveBook = bookService.addbook(bookMapper.bookDTOtoBook(bookDTO));
    return ResponseEntity.created(null).body(saveBook);
    }

    @GetMapping
    public List<Book> getBooks() {
        return bookService.getByTitle();
    }

}
