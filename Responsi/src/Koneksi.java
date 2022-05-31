import java.sql.*;
public class Koneksi {
    String DBurl = "jdbc:mysql://localhost/responsi";
    String DBusername = "root";
    String DBpassword = "";
    public Connection koneksi;
    public Statement statement;
    public Koneksi() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            koneksi = DriverManager.getConnection(DBurl,DBusername,DBpassword);
            System.out.println("Terkoneksi");
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
}
