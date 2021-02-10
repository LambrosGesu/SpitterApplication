package dao;

import domain.Spitter;

import java.sql.*;

public class SpitterDao {
    private Connection conn = null;
    private String connectionUrl = "jdbc:mysql://localhost:3306/mytrainingDb";
    private String username = "user1";
    private String password = "password";

    public void createSpitter(Spitter spitter) throws Exception{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(connectionUrl, username, password);
            PreparedStatement stmt = conn.prepareStatement(" INSERT INTO SPITTERS VALUES(?, ?, ?, ?, ?)");
            stmt.setLong(1, spitter.getId());
            stmt.setString(2, spitter.getFirstname());
            stmt.setString(3, spitter.getLastname());
            stmt.setString(4, spitter.getUsername());
            stmt.setString(5, spitter.getPassword());
            int rs = stmt.executeUpdate();
            if(rs != 0){
                System.out.println("Connection successful");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            conn.close();
        }
    }

    public void updateSpitter(Spitter spitter) throws Exception {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(connectionUrl,username,password);
            PreparedStatement stmt = conn.prepareStatement("UPDATE SPITTERS SET firstname=?, lastname = ?, username=?, password = ? WHERE id=?");

            stmt.setLong(1, spitter.getId());
            stmt.setString(2, spitter.getFirstname());
            stmt.setString(3, spitter.getLastname());
            stmt.setString(4, spitter.getUsername());
            stmt.setString(5, spitter.getPassword());
            stmt.executeUpdate();
        }
        catch (Exception e){
            e.printStackTrace();
        }finally {
            conn.close();
        }
    }

    public void deleteSpitter(String id) throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(connectionUrl, username, password);
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM SPITTERS WHERE id=?");
            stmt.setString(1,id);
            stmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            conn.close();
        }
    }

    public void readSpitters() throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(connectionUrl, username, password);
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM SPITTERS");

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("firstname"));

            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            conn.close();
        }
    }
}
