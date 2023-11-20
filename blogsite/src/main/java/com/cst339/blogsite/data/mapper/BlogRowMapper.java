package com.cst339.blogsite.data.mapper;

import com.cst339.blogsite.entity.BlogPostEntity;
import org.springframework.jdbc.core.RowMapper;
import java.sql.SQLException;
import java.sql.ResultSet;

public class BlogRowMapper implements RowMapper<BlogPostEntity>{
    
    @Override
    public BlogPostEntity mapRow(ResultSet rs, int rowNumber) throws SQLException{
        return new BlogPostEntity(rs.getLong("ID"), rs.getString("TITLE"), rs.getString("DATE"), rs.getString("AUTHOR"), rs.getString("CONTENT"));
    }

}
