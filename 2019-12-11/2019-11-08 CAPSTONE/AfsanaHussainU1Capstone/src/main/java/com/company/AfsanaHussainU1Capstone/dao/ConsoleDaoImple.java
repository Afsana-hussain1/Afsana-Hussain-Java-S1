package com.company.AfsanaHussainU1Capstone.dao;

import com.company.AfsanaHussainU1Capstone.models.Consoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ConsoleDaoImple implements ConsoleDao {

    private static final String FIND_CONSOLE_BY_ID = "SELECT * FROM console WHERE console_id = ?";
    private static final String FIND_ALL_CONSOLES = "SELECT * FROM console";
    private static final String SAVE_CONSOLE = "INSERT INTO console( manufacturer, memory_amount, model, price, processor, quantity) VALUES ( ?, ? ,?, ?, ? ,?)";
    private static final String DELETE_CONSOLE = "DELETE FROM console WHERE console_id = ?";
    private static final String UPDATE_CONSOLE = "UPDATE console SET manufacturer = ?, memory_amount = ?, model = ?, price = ? , processor = ?, quantity = ?";
    private static final String SELECT_LAST_INSERT_ID = "SELECT LAST_INSERT_ID()";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Consoles findConsoleById(int id) {
        try {
            return jdbcTemplate.queryForObject(FIND_CONSOLE_BY_ID, this::mapper, id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Consoles> findAllConsoles() {
        return jdbcTemplate.query(FIND_ALL_CONSOLES, this::mapper);

    }

    @Override
    public Consoles saveConsole(Consoles consoles) {
        jdbcTemplate.update(SAVE_CONSOLE,
                consoles.getManufacturer(),
                consoles.getMemoryAmount(),
                consoles.getModel(),
                consoles.getPrice(),
                consoles.getProccessor(),
                consoles.getQuantity()
        );
        int id = jdbcTemplate.queryForObject(SELECT_LAST_INSERT_ID, Integer.class);
        consoles.setConsoleId(id);
        return consoles;
    }

    @Override
    public void updateConsole(Consoles consoles) {
        jdbcTemplate.update(UPDATE_CONSOLE,
                consoles.getManufacturer(),
                consoles.getMemoryAmount(),
                consoles.getModel(),
                consoles.getPrice(),
                consoles.getProccessor(),
                consoles.getQuantity());

    }

    @Override
    public void deleteConsoleById(int id) {
        jdbcTemplate.update(DELETE_CONSOLE, id);
    }


  // Helper Method
    private Consoles mapper(ResultSet rs, int rowNum) throws SQLException {
        Consoles consoles = new Consoles();
        consoles.setManufacturer(rs.getString("manufacturer"));
        consoles.setMemoryAmount(rs.getString("memory_amount"));
        consoles.setModel(rs.getString("model"));
        consoles.setPrice(rs.getBigDecimal("price"));
        consoles.setProccessor(rs.getString("processor"));
        consoles.setQuantity(rs.getInt("quantity"));
        consoles.setConsoleId(rs.getInt("console_id"));

        return consoles;
    }
}

