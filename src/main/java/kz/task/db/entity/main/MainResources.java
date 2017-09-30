/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kz.task.db.entity.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import kz.task.db.core.JDBCUtils;

/**
 *
 * @author Nurbol
 */
public class MainResources {
    
    public static Main getMainById(long id) {
        try {
            Connection conn = JDBCUtils.getConnection();

            String sql = "SELECT * FROM MAIN_TABLE WHERE ID = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setLong(1, id);
            
            ResultSet rs = ps.executeQuery();
        
            Main main = null;
            
            while (rs.next()) {
                main = new Main(rs.getLong("id"), rs.getString("text"));
            }
            
            return main;
            
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
    
}
