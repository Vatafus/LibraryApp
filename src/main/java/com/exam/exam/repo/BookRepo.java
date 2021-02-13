package com.exam.exam.repo;

import com.exam.exam.model.Book;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

@Repository
public class BookRepo {
    private JdbcTemplate jdbcTemplate;

    public BookRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Book createBook(Book book){
        String sql = "insert into books values(null,?,?,?,?)";
        PreparedStatementCreator preparedStatementCreator =connection ->{
            PreparedStatement preparedStatement =connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,book.getTitle());
            preparedStatement.setString(2,book.getAuthor());
            preparedStatement.setString(3,book.getPublisher());
            preparedStatement.setInt(4,book.getPublishingYear());
            return preparedStatement;
        };
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(preparedStatementCreator,generatedKeyHolder);
        book.setId(generatedKeyHolder.getKey().longValue());
        return book;
    }

    public Optional<Book> getbythis(String title, String publisher, int publishingYear){
        String sql = "select * from books b where b.title = ? AND b.publisher = ? AND b.publishingYear = ?";
        List<Book> result = jdbcTemplate.query(sql,getBookRowMapper(),title,publisher,publishingYear);
        if(result != null && !result.isEmpty()) {
            return Optional.of(result.get(0));
        }else{
            return Optional.empty();
        }
    }

    public List<Book> getByTitle() {
        String sql = "select * from books order by books.title";
        return jdbcTemplate.query(sql, getBookRowMapper());
    }

    private RowMapper<Book> getBookRowMapper(){
        return(resultSet, rowNum) ->{
            Book book =new Book();
            book.setId(resultSet.getInt("id"));
            book.setTitle(resultSet.getString("title"));
            book.setAuthor(resultSet.getString("author"));
            book.setPublisher(resultSet.getString("publisher"));
            book.setPublishingYear(resultSet.getInt("publishingYear"));
            return book;
        };
    }
}
