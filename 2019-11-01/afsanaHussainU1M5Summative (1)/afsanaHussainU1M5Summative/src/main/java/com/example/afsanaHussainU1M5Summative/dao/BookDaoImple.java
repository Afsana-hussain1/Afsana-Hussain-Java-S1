package com.example.afsanaHussainU1M5Summative.dao;
import com.example.afsanaHussainU1M5Summative.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BookDaoImple implements BookDao {

    private static final String INSERT = "INSERT INTO book (isbn, publish_date, author_id, title, publisher_id, price) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String GET = "SELECT * FROM book WHERE book_id = ?";
    private static final String GET_BY_AUTHOR_ID = "SELECT * FROM book WHERE author_id = ?";
    private static final String DELETE = "DELETE FROM book WHERE book_id = ?";
    private static final String GET_ALL = "SELECT * FROM book";
    private static final String UPDATE = "UPDATE book SET isbn = ?, publish_date = ?, author_id = ?, title = ?, publisher_id = ?, price = ? WHERE book_id = ?";
    private static final String SELECT_LAST_INSERT_ID = "SELECT LAST_INSERT_ID()";
    @Autowired
    private JdbcTemplate jdbcTemplate;




    @Override
    public Book add(Book book) {
        jdbcTemplate.update(INSERT,
                book.getIsbn(),
                book.getPublisherDate(),
                book.getAuthorId(),
                book.getTitle(),
                book.getPublisherId(),
                book.getPrice());

        int id = jdbcTemplate.queryForObject(SELECT_LAST_INSERT_ID, Integer.class);

        book.setId(id);
        return book;
    }

    @Override
    public Book get(int id) {
        try {
            return jdbcTemplate.queryForObject(GET, this::mapper, id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public void update(Book book) {
        jdbcTemplate.update(UPDATE,
                book.getIsbn(),
                book.getPublisherDate(),
                book.getAuthorId(),
                book.getTitle(),
                book.getPublisherId(),
                book.getPrice(),
                book.getId());
    }
    @Override
    public void delete(int id) {
        jdbcTemplate.update(DELETE, id);
    }

    @Override
    public List<Book> getAll() {
        return jdbcTemplate.query(GET_ALL, this::mapper);
    }

    @Override
    public List<Book> findByAuthorId(int authorId) {
        return jdbcTemplate.query(GET_BY_AUTHOR_ID, this::mapper, authorId);
    }

    // Helper Method
    private Book mapper(ResultSet rs, int rowNum) throws SQLException {
        Book book = new Book();
        book.setPrice(rs.getDouble("price"));
        book.setTitle(rs.getString("title"));
        book.setPublisherId(rs.getInt("publisher_id"));
        book.setPublisherDate(rs.getDate("publish_date").toLocalDate());
        book.setIsbn(rs.getString("isbn"));
        book.setAuthorId(rs.getInt("author_id"));
        book.setId(rs.getInt("book_id"));
        return book;

    }
}