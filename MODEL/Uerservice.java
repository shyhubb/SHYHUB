package MODEL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DATABASE.Conn;

public class Uerservice {


    // create acount 
    public static boolean new_acount(Users user){
        // sql for create new acount
       String new_acount  = "INSERT INTO `users` (`ACCOUNT`, `PASSWORD`, `NAME`,`EMAIL`, `CODEBANK`) VALUES ( ? , ? , ? , ? , ?);";

       Connection connection = Conn.new_Connection();
       try {
         PreparedStatement new_Acount = connection.prepareStatement(new_acount);
         new_Acount.setString(1, user.getAcccount());
         new_Acount.setString(2, user.getPassword());
         new_Acount.setString(3, user.getName());
         new_Acount.setString(4, user.getEmail());
         new_Acount.setString(5, user.getCodebank());

         new_Acount.executeUpdate();

       } catch (SQLException e) {
           e.printStackTrace();
           return false;
       }
        return true;
    }

    public static boolean login(String Acccount , String Password){
       // sql for check acount and password
       String sql = "SELECT ACCOUNT FROM `users` WHERE ACCOUNT = ? AND PASSWORD = ?";

       Connection connection = Conn.new_Connection();
       try {
        PreparedStatement Login = connection.prepareStatement(sql);

        Login.setString(1, Acccount);
        Login.setString(2, Password);

        ResultSet res = Login.executeQuery();
        if(res.next()) return true;
       } catch (SQLException e) {
          e.printStackTrace();
          return false;
       }
       return false;
    }

    public static double get_balance(int Id) {
        String sql = "SELECT BALANCE FROM `users` WHERE ID = ?";
        try (Connection connection = Conn.new_Connection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            
            statement.setInt(1, Id);
            try (ResultSet res = statement.executeQuery()) {
                if (res.next()) {
                    return res.getDouble("BALANCE");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // You can also log this error to a file or rethrow it if necessary
        }
        return 0; // If no result is found or there's an error
    }
    

    public static int get_id(String Account, String Password) {
        int id = -1;
        String sql = "SELECT ID FROM `users` WHERE ACCOUNT = ? AND PASSWORD = ?";
        Connection connection = null;
        PreparedStatement getid = null;
        ResultSet res = null;
        
        try {
            // Mở kết nối tới cơ sở dữ liệu
            connection = Conn.new_Connection();
            
            // Tạo câu lệnh SQL
            getid = connection.prepareStatement(sql);
            getid.setString(1, Account);
            getid.setString(2, Password);
            
            // Thực thi truy vấn
            res = getid.executeQuery();
            
            // Kiểm tra nếu có kết quả
            if (res.next()) {
                id = res.getInt("ID");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Đảm bảo đóng kết nối và các đối tượng khác
            try {
                if (res != null) res.close();
                if (getid != null) getid.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return id;
    }

    public static String getname(int Id){
        String sql = "SELECT NAME FROM `users` WHERE ID = ?";
        try (Connection connection = Conn.new_Connection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, Id);
            try (ResultSet res = statement.executeQuery()) {
                if (res.next()) {
                    return res.getString("NAME");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
        }
        return null; 
    }

    public static boolean get_money(int Id , double money){
        String sql = "UPDATE `users` SET BALANCE = BALANCE + ? WHERE ID = ?";
        try (Connection connection = Conn.new_Connection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDouble(1, money);
            statement.setInt(2, Id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); 
            return false;
        }
        return true; 
    }
    
}
