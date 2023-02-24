package edu.jsu.mcis.cs310.coursedb.dao;

import java.sql.*;
import com.github.cliftonlabs.json_simple.*;
import java.util.ArrayList;

public class DAOUtility {
    
    public static final int TERMID_SP23 = 1;
    
    public static String getResultSetAsJson(ResultSet rs) {
        
        JsonArray records = new JsonArray();
        
        try {
        
            if (rs != null) {

                while (rs.next()) {
                    
                    ResultSetMetaData metaData = rs.getMetaData();
                    int columnCount = metaData.getColumnCount();
                    
                    JsonObject temp = new JsonObject();
                    
                    for (int x = 0; x < columnCount; x++) {
                        
                        String columnName = metaData.getColumnName(x + 1);
                        String string = rs.getString(columnName);
                        temp.put(columnName, string);
                        
                    }
                    
                    records.add(temp);
                    
                }

            }
            
        }
        
        catch (Exception e) {
            e.printStackTrace();
        }
        
        return Jsoner.serialize(records);
        
    }
    
}
