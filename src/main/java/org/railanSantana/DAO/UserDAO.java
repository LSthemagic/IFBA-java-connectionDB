package org.railanSantana.DAO;

import org.railanSantana.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class UserDAO {

    public void insert(User user){
        Connection conn = ConnectiondDAO.getConnection();
        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement("INSERT INTO DATA_CLIENT (name_client, email_client) VALUES (?,?)");
            System.out.println(pstm);
            pstm.setString(1, user.getName());
            pstm.setString(2, user.getEmail());
            pstm.executeUpdate();
        }catch (SQLException ex){
            throw new RuntimeException(ex);
        }finally {
            ConnectiondDAO.closeConnection(conn,pstm);
        }
    }

    public Set<User> getAll(){
        Connection conn = ConnectiondDAO.getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Set<User> users = new HashSet<>();
        try {
            pstm = conn.prepareStatement("SELECT * FROM data_client");
            rs = pstm.executeQuery();
            while (rs.next()){
                users.add(new User(rs.getString("name_client"), rs.getString("email_client")));
            }
        }catch (SQLException ex){
            throw new RuntimeException(ex);
        }finally {
            ConnectiondDAO.closeConnection(conn, pstm, rs);
        }
        return users;
    }

}
