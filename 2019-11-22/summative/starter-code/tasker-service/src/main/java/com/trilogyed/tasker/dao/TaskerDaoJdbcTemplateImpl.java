package com.trilogyed.tasker.dao;

import com.trilogyed.tasker.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Repository
public class TaskerDaoJdbcTemplateImpl implements TaskerDao {

    private static final String INSERT_TASK =
            "insert into task (task_description, create_date, due_date, category) values (?, ?, ?, ?)";
    private static final String SELECT_TASK_BY_ID =
            "select * from task where task_id = ?";
    private static final String SELECT_ALL_TASKS =
            "select * from task";
    private static final String SELECT_TASKS_BY_CATEGORY =
            "select * from task where category = ?";
    private static final String UPDATE_TASK =
            "update task set task_description = ?, create_date = ?, due_date = ?, category = ? where task_id = ?";
    private static final String DELETE_TASK =
            "delete from task where task_id = ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public TaskerDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional
    public Task createTask(Task task) {
        jdbcTemplate.update(INSERT_TASK,
                task.getDescription(),
                task.getCreateDate(),
                task.getDueDate(),
                task.getCategory());

        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);

        task.setId(id);

        return task;
    }

    @Override
    public Task getTask(int id) {
     try {
      return jdbcTemplate.queryForObject(SELECT_TASK_BY_ID, this::maprowtotask, id);
     }catch(EmptyResultDataAccessException e) {
         //if nothing returned catch exception and return null
         return null;
     }
    }

    @Override
    public List<Task> getAllTasks() {
        return jdbcTemplate.query(SELECT_ALL_TASKS,this::maprowtotask);
    }

    @Override
    public List<Task> getTasksByCategory(String category) {
        return jdbcTemplate.query(SELECT_TASKS_BY_CATEGORY, this::maprowtotask, category);
    }

    @Override
    public void updateTask(Task task) {
        jdbcTemplate.update(UPDATE_TASK,
                task.getDescription(),
                task.getCreateDate(),
                task.getDueDate(),
                task.getCategory(),
                task.getId());


    }

    @Override
    public void deleteTask(int id) {
        jdbcTemplate.update(DELETE_TASK, id);


    }

    //Helper method
   private  Task maprowtotask(ResultSet rs, int rowNum)throws SQLException {
        Task task = new Task();
        task.setId(rs.getInt("task_id"));
        task.setDescription(rs.getString("task_description"));
        task.setCreateDate(rs.getDate("create_date").toLocalDate());
        task.setDueDate(rs.getDate("due_date").toLocalDate());
        task.setCategory(rs.getString("category"));

        return task;

   }
}
