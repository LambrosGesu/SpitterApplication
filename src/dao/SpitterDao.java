package dao;

import domain.Spitter;

import java.sql.*;

public class SpitterDao {
    private Connection conn = null;
    private String connectionUrl = "jdbc:mysql://localhost:3306/mytrainingDb";
    private String username = "user1";
    private String password = "password";

    public void openConnection() throws Exception{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(connectionUrl, username, password);
        }catch (Exception e){
            System.out.println("connection failed!");
        }
    }

    public void closeConnection() throws Exception{
        try{
            if(conn !=null){
                conn.commit();
                conn.close();
            }
        }catch (Exception e){
            System.out.println("----- close connection failed -----");
        }
    }

    public void createSpitter(Spitter spitter) throws Exception{
        try{
            PreparedStatement stmt = conn.prepareStatement(" INSERT INTO SPITTERS VALUES(?, ?, ?, ?, ?)");
            stmt.setLong(1, spitter.getId());
            stmt.setString(2, spitter.getFirstname());
            stmt.setString(3, spitter.getLastname());
            stmt.setString(4, spitter.getUsername());
            stmt.setString(5, spitter.getPassword());
            int rs = stmt.executeUpdate();
            if(rs != 0){
                System.out.println("Spitter created!");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void updateSpitter(Spitter spitter, String firstname, String lastname) throws Exception {
        try{
            PreparedStatement stmt = conn.prepareStatement("UPDATE SPITTERS SET firstname=?, lastname = ?, username=?, password = ? WHERE id=?");
            stmt.setLong(5, spitter.getId());
            stmt.setString(1, firstname);
            stmt.setString(2, lastname);
            stmt.setString(3, spitter.getUsername());
            stmt.setString(4, spitter.getPassword());
            stmt.executeUpdate();
        }
        catch (Exception e){

        }
    }

    public void deleteSpitter(String id) throws Exception {
        try {
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM SPITTERS WHERE id=?");
            stmt.setString(1,id);
            stmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void readSpitters() throws Exception {
        try {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM SPITTERS");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("firstname"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
