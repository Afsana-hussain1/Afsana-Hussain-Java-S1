package com.example.afsanaHussainU1M5Summative.dao;

import com.example.afsanaHussainU1M5Summative.models.Author;
import com.example.afsanaHussainU1M5Summative.models.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.awt.print.Book;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PublisherDaoImple implements PublisherDao{

    private static final String INSERT_PUBLISHER_SQL =
            "insert into publisher (name, city, " +
                    "street, state, postal_code, phone, email) values" +
                    " (?, ?, ?, ?, ?, ?, ?)";

    private static final String GET_PUBLISHER_SQL =
            "select * from publisher where publisher_id = ?";

    private static final String DELETE_PUBLISHER_SQL =
            "delete from publisher where publisher_id = ?";

    private static final String GET_ALL_PUBLISHERS_SQL =
            "select * from publisher";

    private static final String UPDATE_PUBLISHER_SQL =
            "update publisher set name = ?, city = ?, street = ?, " +
                     "state = ?, postal_code = ?, " +
                    "phone = ?, email = ? where publisher_id = ?";

    private static final String SELECT_LAST_INSERT_ID =
            "Select LAST_INSERT_ID()";

    @Autowired
    //grab class and set it to JDBC template in order to utilize it
    private JdbcTemplate template;



    @Override
    public Publisher add(Publisher publisher) {
        template.update(INSERT_PUBLISHER_SQL,

                publisher.getName(),
                publisher.getCity(),
                publisher.getStreet(),
                publisher.getState(),
                publisher.getPostalCode(),
                publisher.getPhone(),
                publisher.getEmail());


        int id = template.queryForObject(SELECT_LAST_INSERT_ID, Integer.class);
        publisher.setId(id);

        return publisher;

    }

    @Override
    public List<Publisher> getAll() {

        return template.query(GET_ALL_PUBLISHERS_SQL, this::mapToPublisher);
    }

    @Override
    public Publisher get(int id) {
        try {
            return template.queryForObject(GET_PUBLISHER_SQL, this::mapToPublisher, id);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void update(Publisher publisher) {

        template.update(UPDATE_PUBLISHER_SQL,

                publisher.getName(),
                publisher.getCity(),
                publisher.getStreet(),
                publisher.getState(),
                publisher.getPostalCode(),
                publisher.getPhone(),
                publisher.getEmail(),
                publisher.getId());

    }

    @Override
    public void delete(int id) {
        template.update(DELETE_PUBLISHER_SQL,id);
    }

    //helper method helps us translate from SQL format to the object

    private Publisher mapToPublisher(ResultSet rs, int rowNum) throws SQLException {
        Publisher publisher = new Publisher();
        publisher.setId(rs.getInt("publisher_id"));
        publisher.setName(rs.getString("name"));
        publisher.setStreet(rs.getString("street"));
        publisher.setCity(rs.getString("city"));
        publisher.setState(rs.getString("state"));
        publisher.setPostalCode(rs.getString("postal_code"));
        publisher.setPhone(rs.getString("phone"));
        publisher.setEmail(rs.getString("email"));

        return publisher;
    }
}


