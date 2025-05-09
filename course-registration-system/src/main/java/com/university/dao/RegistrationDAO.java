package com.university.dao;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public class RegistrationDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public boolean registerStudentToCourse(int studentId, int courseId) {
        String checkSql = "SELECT COUNT(*) FROM registrations WHERE student_id = ? AND course_id = ?";
        int count = jdbcTemplate.queryForObject(checkSql, Integer.class, studentId, courseId);

        if (count > 0) return false; // already registered

        String insertSql = "INSERT INTO registrations (student_id, course_id, date) VALUES (?, ?, ?)";
        jdbcTemplate.update(insertSql, studentId, courseId, LocalDate.now());
        return true;
    }
}
