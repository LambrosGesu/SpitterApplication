package dao;

import domain.Spittle;

import java.sql.*;

public class SpittleDao {
    private Connection conn = null;
    private final String connectionUrl = "jdbc:mysql://localhost:3306/mytrainingDb";
    private final String username = "user1";
    private final String password = "password";

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
            if(conn == null) {
                System.out.println("----- close connection failed -----");
            }
        }
    }

    public void createSpittle(Spittle spittle) throws Exception {
        try{
            PreparedStatement stmt = conn.prepareStatement(" INSERT INTO SPITTLES VALUES(?, ?, ?)");
            stmt.setLong(1, spittle.getId());
            stmt.setString(2, spittle.getMessage());
            stmt.setString(3, spittle.getDate());
            int rs = stmt.executeUpdate();
        }catch(Exception e){
            if (conn == null) {
                conn.rollback();
            }
        }
    }

    public void updateSpittle(Spittle spittle,  String message, String date) throws Exception {
        try{
            PreparedStatement stmt = conn.prepareStatement("UPDATE SPITTLES SET message=?, date = ? WHERE id=?");
            stmt.setLong(3, spittle.getId());
            stmt.setString(1, message);
            stmt.setString(2, date);
            stmt.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
            conn.rollback();
        }
    }

    public void deleteSpittle(String id) throws Exception {
        try{
            conn = DriverManager.getConnection(connectionUrl,username,password);
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM SPITTLES WHERE id=?");

            stmt.setString(1, id);
            stmt.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
            conn.rollback();
        }
    }

    public void readSpittles() throws Exception {
        try {
            conn = DriverManager.getConnection(connectionUrl, username, password);
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM SPITTLES");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("message"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
