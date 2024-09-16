package org.railanSantana.DAO;

import java.sql.*;

public class ConnectiondDAO {

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/ifConnection";
    private static final String USER = "postgres";
    private static final String PASSWORD = "railan13";

    public static Connection getConnection(){

        try{
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(DB_URL,USER,PASSWORD);
        }catch(SQLException e){
            throw new RuntimeException("" + e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void closeConnection(Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao fechar uma conexao com o banco");
        }

    }

    public static void closeConnection(Connection con, PreparedStatement stmt) {
        closeConnection(con);
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao fechar uma conexao com o banco");
        }
    }

    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {
        closeConnection(con, stmt);
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao fechar uma conexao com o banco");
        }
    }


}
