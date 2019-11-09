package com.company.AfsanaHussainU1Capstone.dao;


import com.company.AfsanaHussainU1Capstone.models.Tshirts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TshirtDaoImple implements TshirtDao {

    private static final String FIND_TSHIRT_BY_ID = "SELECT * FROM t_shirt WHERE t_shirt_id = ?";
    private static final String FIND_TSHIRT_BY_COLOR = "SELECT * FROM t_shirt WHERE color =?";
    private static final String FIND_TSHIRT_BY_SIZE = "SELECT * FROM t_shirt WHERE size =? ";
    private static final String FIND_ALL_TSHIRTS = "SELECT * FROM t_shirt";
    private static final String SAVE_TSHIRT = "INSERT INTO t_shirt (size, color, description, price, quantity) VALUES(?, ?, ?, ?, ?)";
    private static final String DELETE_TSHIRT = "DELETE FROM t_shirt WHERE t_shirt_id = ?";
    private static final String UPDATE_TSHIRT = "Update t_shirt SET size = ?, color =?, description = ?, price = ?, quantity = ?";
    private static final String SELECT_LAST_INSERT_ID = "SELECT LAST_INSERT_ID()";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public TshirtDaoImple(JdbcTemplate template) {
        this.jdbcTemplate = template;
    }

    @Override
    public Tshirts findTshirtById(int id) {
        try {
            return jdbcTemplate.queryForObject(FIND_TSHIRT_BY_ID, this::mapper, id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Tshirts> findTShirtByColor(String color) {
        return jdbcTemplate.query(FIND_TSHIRT_BY_COLOR, this::mapper, color);
    }

    @Override
    public List<Tshirts>findTShirtBySize(String size){
        return jdbcTemplate.query(FIND_TSHIRT_BY_SIZE,this::mapper,size);
    }

    @Override
    public List<Tshirts> findAllTshirts() {
        return jdbcTemplate.query(FIND_ALL_TSHIRTS, this::mapper);
    }

    @Override
    public Tshirts saveTshirt(Tshirts tshirts) {
        jdbcTemplate.update(SAVE_TSHIRT,
                tshirts.getSize(),
                tshirts.getColor(),
                tshirts.getDescription(),
                tshirts.getPrice(),
                tshirts.getQuantity()
        );

        int id = jdbcTemplate.queryForObject(SELECT_LAST_INSERT_ID, Integer.class);
        tshirts.setTShirtId(id);
        return tshirts;
    }

    @Override
    public void updateTshirt(Tshirts tshirts) {
        jdbcTemplate.update(UPDATE_TSHIRT,
                tshirts.getSize(),
                tshirts.getColor(),
                tshirts.getDescription(),
                tshirts.getPrice(),
                tshirts.getQuantity());


    }
    @Override
    public  void  deleteTshirtById(int id){jdbcTemplate.update(DELETE_TSHIRT, id);}

    // Helper Method
    private Tshirts mapper(ResultSet rs, int rowNum) throws SQLException {
      Tshirts tshirts = new Tshirts();
        tshirts.setSize(rs.getString("size"));
        tshirts.setColor(rs.getString("color"));
        tshirts.setDescription(rs.getString("description"));
        tshirts.setPrice(rs.getBigDecimal("price"));
        tshirts.setQuantity(rs.getInt("quantity"));

        tshirts.setTShirtId(rs.getInt("t_shirt_id"));
        return tshirts;
    }
}

