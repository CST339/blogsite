package com.cst339.blogsite.data.mapper;

import com.cst339.blogsite.entity.UserEntity;
import org.springframework.jdbc.core.RowMapper;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 * Mapper for Users
 */
public class UserRowMapper implements RowMapper<UserEntity>{
    
    /**
     * map the row to the object entity
     * @param rs Resulting set
     * @param rowNumber number of row
     */
    @Override
    public UserEntity mapRow(ResultSet rs, int rowNumber) throws SQLException{
        return new UserEntity(rs.getLong("ID"), rs.getString("USERNAME"), rs.getString("PASSWORD"), rs.getString("FIRST_NAME"), rs.getString("LAST_NAME"), rs.getString("PHONE_NUMBER"), rs.getString("EMAIL_ADDRESS"));
    }

}
