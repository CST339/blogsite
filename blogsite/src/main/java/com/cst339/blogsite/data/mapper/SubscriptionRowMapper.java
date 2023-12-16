package com.cst339.blogsite.data.mapper;

import com.cst339.blogsite.entity.SubscriptionEntity;
import org.springframework.jdbc.core.RowMapper;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 * Mapper for Subscriptions
 */
public class SubscriptionRowMapper implements RowMapper<SubscriptionEntity>{

    /**
     * map the row to the object entity
     * @param rs Resulting set
     * @param rowNumber number of row
     */
    @Override
    public SubscriptionEntity mapRow(ResultSet rs, int rowNumber) throws SQLException{
        return new SubscriptionEntity(rs.getLong("ID"), 
                                      rs.getLong("SUBSCRIBED_USER_ID"), 
                                      rs.getLong("USER_ID")
                                    );
    }

}

