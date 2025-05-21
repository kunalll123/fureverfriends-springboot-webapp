package com.example.FureverFriends.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class DashboardService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public long getCount(String tableName) {
        String sql = "SELECT COUNT(*) FROM " + tableName;
        return jdbcTemplate.queryForObject(sql, Long.class);
    }
    public List<Map<String, Object>> getAllAdoptions() {
        String sql = "SELECT * FROM adoption";
        return jdbcTemplate.queryForList(sql);
    }

    public List<Map<String, Object>> getAllDonations() {
        String sql = "SELECT * FROM donations";
        return jdbcTemplate.queryForList(sql);
    }
}
