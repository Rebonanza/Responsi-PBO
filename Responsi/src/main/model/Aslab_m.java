package main.model;
import main.Koneksi;
import java.sql.*;
import java.sql.ResultSet;

import javax.swing.JOptionPane;
public class Aslab_m {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/responsi2";
    static final String USER = "root";
    static final String PASS = "";

    Connection koneksi;
    Statement statement;

    public Aslab_m(){
        try{
            Class.forName(JDBC_DRIVER);
            koneksi = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Koneksi Berhasil");
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Koneksi Gagal");
        }
    }



    public int getJumlahData(){
        int jmlData = 0;
        try{
            statement = koneksi.createStatement();
            String query = "SELECT * FROM aslab";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                jmlData++;
            }
            return jmlData;

        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }


    public Object[][] getAll(){
         try{
            int jumlahData = 0;
            String query = "SELECT * fROM aslab"; //pengambilan data dari 'karyawan'
            Object data[][] = new Object[getJumlahData()][5];
            // connector.statement = statement.createStatement();
            ResultSet resultSet = statement.executeQuery(query); 
            
            while(resultSet.next()){ 
                // data[jumlahData][0] = resultSet.getInt("id");
                data[jumlahData][0] = resultSet.getString("nama");
                data[jumlahData][1] = resultSet.getDouble("portofolio");
                data[jumlahData][2] = resultSet.getDouble("microteaching");
                data[jumlahData][3] = resultSet.getDouble("wawancara");
                data[jumlahData][4] = resultSet.getDouble("nilai");
                jumlahData++;
            }
            return data;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("Data Not Found");
            return null;
        }
    }

    public void insert(String nama, double porto, double microteach, double wawancara, double nilai){
        int  similar=0;
        try {
            String query = "select * from aslab WHERE nama='"+nama+"'"; // cek apakah data sudah ada
            // System.out.println(Nama + " " + NoHp + " " + Umur + " " + Email);
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()){
                similar++;
            }

            if (similar == 0) { // jika data dengan no hp tsb belum ada
                query = "INSERT INTO aslab VALUES('"+nama+"','"+porto+"','"+microteach+"','"+wawancara+"','"+nilai+"')";

                statement = (Statement) koneksi.createStatement();
                statement.executeUpdate(query); //execute querynya
                System.out.println("Berhasil ditambahkan");
                JOptionPane.showMessageDialog(null, "Data Berhasil ditambahkan");
            }
            else {
                JOptionPane.showMessageDialog(null, "Data sudah ada");
            }
        } catch (Exception sql) {
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
}
