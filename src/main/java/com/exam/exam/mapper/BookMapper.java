package com.exam.exam.mapper;

import com.exam.exam.dto.BookDTO;
import com.exam.exam.model.Book;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

        public Book bookDTOtoBook(BookDTO bookDTO){
            return new Book(bookDTO.getTitle(),bookDTO.getAuthor(),bookDTO.getPublisher(),bookDTO.getPublishingYear());
        }
}
