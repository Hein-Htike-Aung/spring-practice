package com.example.module02usinghsqldbwithjdbctemplate.dao;

import com.example.module02usinghsqldbwithjdbctemplate.entity.Employee;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import javax.sql.RowSet;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Repository
public class EmployeeDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Employee findById(int id) {

        return jdbcTemplate.queryForObject(
                "select * from employee where id=?",
                new Object[]{id},
                new EmployeeRowMapper()
//                this::rowMapperForEmployee
        );

    }

    public Map<String, Object> findByIdMapStructure(int id) {

        return jdbcTemplate.queryForMap(
                "select * from employee where id=?",
                id
        );
    }

    public String findEmployeeNameById(int id) {
        return jdbcTemplate.queryForObject(
                "select name from employee where id=?",
                new Object[]{id},
                String.class
        );

    }

    public List<Employee> findEmployeeList() {

        return jdbcTemplate.query(
                "select * from employee",
                new EmployeeRowMapper()
                //(a, b) -> this.rowMapperForEmployee(a, b)
        );
    }

    public List<String> findAllEmployeeNames() {

        return jdbcTemplate.queryForList(
                "select name from employee",
                String.class
        );
    }

    public int saveEmployee(Employee employee) {

        return jdbcTemplate.update(
                "insert into employee values (?,?,?,?)",
                employee.getId(), employee.getName(), employee.getHireDate(), employee.getSalary()
        );
    }

    public int deleteById(int id) {
        return jdbcTemplate.update(
                "delete from employee where id=?",
                id
        );
    }

    public int updateById(int id) {
        return jdbcTemplate.update(
                "update employee set name=? where id=?",
                "Winter", id
        );
    }

    public int[] updateEmployees(List<Employee> employeeList) {

        return jdbcTemplate.batchUpdate(
                "update employee set name=? where id=?",
                new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        ps.setString(1, employeeList.get(i).getName());
                        ps.setInt(2, employeeList.get(i).getId());
                    }

                    @Override
                    public int getBatchSize() {
                        return employeeList.size();
                    }
                }
        );
    }

    @SneakyThrows
    public Employee rowMapperForEmployee(ResultSet resultSet, int row) {

        return new Employee(
                resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getDate("hire_date"),
                resultSet.getDouble("salary")
        );
    }

    public double findEmployeeAvgSalary() {

        return jdbcTemplate.queryForList("select salary from employee", Double.class)
                .stream()
                .mapToDouble(Double::valueOf)
                .average()
                .orElse(0);
    }

    public int findEmployeeCount() {
        return jdbcTemplate.queryForObject("select COUNT(*) from employee", Integer.class);
    }

    class EmployeeRowMapper implements RowMapper<Employee> {

        @Override
        public Employee mapRow(ResultSet resultSet, int rowNum) throws SQLException {

            return new Employee(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getDate("hire_date"),
                    resultSet.getDouble("salary")
            );

        }
    }

}
