package main.model;
import main.Koneksi;
import java.sql.*;
public class Aslab_m {
    StructAslab data[] = new StructAslab[100]; 
    Koneksi connector = new Koneksi();
    
    public StructAslab[] getAll(){
         try{
            int jumlahData = 0;
            String query = "SELECT * fROM aslab"; //pengambilan data dari 'karyawan'
            
            connector.statement = connector.koneksi.createStatement();
            ResultSet resultSet = connector.statement.executeQuery(query); 
            
            while(resultSet.next()){ 
                int id = resultSet.getInt("id");
                String nama = resultSet.getString("nama");
                double porto = resultSet.getDouble("portfolio");
                double microteach = resultSet.getDouble("microteaching");
                double wawancara = resultSet.getDouble("wawancara");
                data[jumlahData] = new StructAslab(id,nama,porto,microteach,wawancara);
                jumlahData++;
            }
            connector.statement.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("Data Not Found");
        }
    return data;
    }
}
