package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.jasypt.util.password.StrongPasswordEncryptor;

public class User {
    private Integer userId;
    private String name;
    private String email;
    private String password;
    private Integer userType;

    private StrongPasswordEncryptor spe = new StrongPasswordEncryptor();

    public User() {

    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User(String name, String email, String password, Integer userType) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.userType = userType;
    }

    public boolean loginUser() {
        boolean flag = false;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecart_db?user=root&password=1234");

            String query = "select password,user_id,name,user_type from users where email=?";

            PreparedStatement ps = con.prepareStatement(query);
            
            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                String encryptedPassword = rs.getString(1);
                if(spe.checkPassword(password, encryptedPassword)) {
                    userId = rs.getInt(2);
                    name = rs.getString(3);
                    userType = rs.getInt(4);
    
                    flag = true;
                }
            }

            con.close();
        } catch(SQLException|ClassNotFoundException e) {
            e.printStackTrace();
        }

        return flag;
    }

    public boolean addUser() {
        boolean flag = false;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecart_db?user=root&password=1234");

            String query = "insert into users (name, email, password, user_type) value (?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, spe.encryptPassword(password));
            ps.setInt(4, userType);

            System.out.println(ps);

            int count = ps.executeUpdate();

            if(count==1)
                flag = true;

            con.close();
        } catch(SQLException|ClassNotFoundException e) {
            e.printStackTrace();
        }

        return flag;
    }

    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }
    
    
}
