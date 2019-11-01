package com.example.afsanaHussainU1M5Summative.dao;

import com.example.afsanaHussainU1M5Summative.models.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class AuthorDAOImple implements AuthorDao {
        private static final String INSERT_AUTHOR_SQL =
                "insert into author (first_name, last_name, street, " +
                        "city, state, postal_code, phone, email) values" +
                        " (?, ?, ?, ?, ?, ?, ?, ?)";

        private static final String GET_AUTHOR_SQL =
                "select * from author where author_id = ?";

        private static final String DELETE_AUTHOR_SQL =
                "delete from author where author_id = ?";

        private static final String GET_ALL_AUTHORS_SQL =
                "select * from author";

        private static final String UPDATE_AUTHOR_SQL =
                "update author set first_name = ?, last_name = ?, street = ?, " +
                        "city = ?, state = ?, postal_code = ?, " +
                        "phone = ?, email = ? where author_id = ?";

        private static final String SELECT_LAST_INSERT_ID =
                "Select LAST_INSERT_ID()";

        @Autowired
        //grab class and set it to JDBC template in order to utilize it
        private JdbcTemplate template;


        @Override
        public Author add(Author author) {
            template.update(INSERT_AUTHOR_SQL,
                    author.getFirstName(),
                    author.getLastName(),
                    author.getStreet(),
                    author.getCity(),
                    author.getState(),
                    author.getPostalCode(),
                    author.getPhone(),
                    author.getEmail());


            int id = template.queryForObject(SELECT_LAST_INSERT_ID, Integer.class);
            author.setId(id);

            return author;

        }

        @Override
        public List<Author> getAll() {

            return template.query(GET_ALL_AUTHORS_SQL, this::mapToAuthor);
        }

        @Override
        public Author get(int id) {
            try {
                return template.queryForObject(GET_AUTHOR_SQL, this::mapToAuthor, id);
            } catch (Exception e) {
                return null;
            }
        }

        @Override
        public void update(Author author) {

            template.update(UPDATE_AUTHOR_SQL,
                    author.getFirstName(),
                    author.getLastName(),
                    author.getStreet(),
                    author.getCity(),
                    author.getState(),
                    author.getPostalCode(),
                    author.getPhone(),
                    author.getEmail(),
                    author.getId());

        }

        @Override
        public void delete(int id) {
            template.update(DELETE_AUTHOR_SQL,id);


        }

        //helper method helps us translate from SQL format to the object

        private Author mapToAuthor(ResultSet rs, int rowNum) throws SQLException {
            Author author = new Author();
            author.setId(rs.getInt("author_id"));
            author.setFirstName(rs.getString("first_name"));
            author.setLastName(rs.getString("last_name"));
            author.setStreet(rs.getString("street"));
            author.setCity(rs.getString("city"));
            author.setState(rs.getString("state"));
            author.setPostalCode(rs.getString("postal_code"));
            author.setPhone(rs.getString("phone"));
            author.setEmail(rs.getString("email"));

            return author;
        }
    }


