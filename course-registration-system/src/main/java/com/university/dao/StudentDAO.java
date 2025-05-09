package com.university;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.university.model.Student;

@Repository
public class StudentDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Student validateStudent(String email, String password) {
        try {
            String sql = "SELECT * FROM students WHERE email = ? AND password = ?";
            return jdbcTemplate.queryForObject(sql, new Object[]{email, password}, (rs, rowNum) -> {
                Student s = new Student();
                s.setId(rs.getInt("student_id"));
                s.setName(rs.getString("name"));
                s.setEmail(rs.getString("email"));
                return s;
            });
        } catch (Exception e) {
            return null;
        }
    }
}

