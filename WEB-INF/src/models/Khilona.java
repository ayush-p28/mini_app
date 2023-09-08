package models;

import java.sql.*;
import java.util.ArrayList;

public class Khilona {
    private Integer khilonaId;
    private String name;
    private Integer price;
    private String ageGroup;
    private Integer quantity;
    private User user;

    public Khilona() {
    
    }   

    public Khilona(Integer khilonaId) {
        this.khilonaId = khilonaId;
    }

    public Khilona(String name, Integer price, String ageGroup, Integer quantity, User user) {
        this.name = name;
        this.price = price;
        this.ageGroup = ageGroup;
        this.quantity = quantity;
        this.user = user;
    }    

    public Khilona(Integer khilonaId, String name, Integer price, String ageGroup, Integer quantity) {
        this.khilonaId = khilonaId;
        this.name = name;
        this.price = price;
        this.ageGroup = ageGroup;
        this.quantity = quantity;
    }

    public static ArrayList<Khilona> collectAllKhilonas() {
        ArrayList<Khilona> khilonas = new ArrayList<Khilona>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecart_db?user=root&password=1234");

            String query = "select * from khilonas";

            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                khilonas.add(new Khilona(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5)));                
            }

            con.close();
        } catch(SQLException|ClassNotFoundException e) {
            e.printStackTrace();
        }

        return khilonas;
    }

    public void deleteKhilona() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecart_db?user=root&password=1234");

            String query = "delete from khilonas where khilona_id=?";

            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, khilonaId);

            ps.executeUpdate();

            con.close();
        } catch(SQLException|ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Khilona> collectAllKhilonas(Integer userId) {
        ArrayList<Khilona> khilonas = new ArrayList<Khilona>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecart_db?user=root&password=1234");

            String query = "select * from khilonas where user_id=?";

            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                khilonas.add(new Khilona(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5)));                
            }

            con.close();
        } catch(SQLException|ClassNotFoundException e) {
            e.printStackTrace();
        }

        return khilonas;
    } 

    public boolean addKhilona() {
        boolean flag = false;
        
        try{ 
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecart_db?user=root&password=1234");
           
           String query = "insert into khilonas (name,price,age_group,quantity,user_id) value (?,?,?,?,?)";

           PreparedStatement ps = con.prepareStatement(query);
           ps.setString(1, name);
           ps.setInt(2, price);
           ps.setString(3, ageGroup);
           ps.setInt(4, quantity);
           ps.setInt(5, user.getUserId());

           int val = ps.executeUpdate();

           if(val == 1) {
               flag = true;  
           }                   
           
           con.close();
        } catch(SQLException|ClassNotFoundException e) {
            e.printStackTrace();
        }

        return flag;
    }

    public Integer getKhilonaId() {
        return khilonaId;
    }

    public void setKhilonaId(Integer khilonaId) {
        this.khilonaId = khilonaId;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getPrice() {
        return price;
    }
    public void setPrice(Integer price) {
        this.price = price;
    }
    public String getAgeGroup() {
        return ageGroup;
    }
    public void setAgeGroup(String ageGroup) {
        this.ageGroup = ageGroup;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
