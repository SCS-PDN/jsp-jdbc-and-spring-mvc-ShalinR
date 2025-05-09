package com.university.dao;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.university.model.Course;

@Repository
public class CourseDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Course> getAllCourses() {
        String sql = "SELECT * FROM courses";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Course c = new Course();
            c.setId(rs.getInt("course_id"));
            c.setName(rs.getString("name"));
            c.setInstructor(rs.getString("instructor"));
            c.setCredits(rs.getInt("credits"));
            return c;
        });
    }
}
