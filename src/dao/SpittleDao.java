package dao;

import domain.Spitter;
import domain.Spittle;

import java.sql.*;

public class SpittleDao {
    private Connection conn = null;
    private String connectionUrl = "jdbc:mysql://localhost:3306/mytrainingDb";
    private String username = "user1";
    private String password = "password";

    public void createSpittle(Spittle spittle) throws Exception {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(connectionUrl, username, password);
            PreparedStatement stmt = conn.prepareStatement(" INSERT INTO SPITTERS VALUES(?, ?, ?)");
            stmt.setLong(1, spittle.getId());
            stmt.setString(2, spittle.getMessage());
            stmt.setString(3, spittle.getDate());
            int rs = stmt.executeUpdate();
        }catch(Exception e){
            if (conn != null) {
                conn.rollback();
            }
        }finally {
            conn.close();
        }
    }

    public void updateSpittle(Spittle spittle) throws Exception {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(connectionUrl,username,password);
            PreparedStatement stmt = conn.prepareStatement("UPDATE SPITTLES SET message=?, date = ? WHERE id=?");

            stmt.setLong(1, spittle.getId());
            stmt.setString(2, spittle.getMessage());
            stmt.setString(3, spittle.getDate());
            stmt.executeUpdate();
        }
        catch (Exception e){
            e.printStackTrace();
        }finally {
            conn.close();
        }
    }

    public void deleteSpittle(String id) throws Exception {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(connectionUrl,username,password);
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM SPITTLES WHERE id=?");

            stmt.setString(1, id);
            stmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            conn.close();
        }
    }

    public void readSpittles() throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(connectionUrl, username, password);
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM SPITTLES");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("message"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }
    }

}
