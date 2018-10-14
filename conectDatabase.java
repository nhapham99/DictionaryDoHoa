package dictionary2.pkg2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class conectDatabase {
    ResultSet rs;
    Statement st;
    PreparedStatement ps;
    Connection con;
    String url = "jdbc:mysql://localhost:3306/dictionary_1";
    String username = "root";
    String password = "1234";
    public void conect() {
         try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url,username, password);
            if (con != null) {
                System.out.println("ket noi thanh cong");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("loat driver khong thanh cong");
        } catch (SQLException e) {
            System.out.println("loi :" + e.getMessage());
        }
    }
}
