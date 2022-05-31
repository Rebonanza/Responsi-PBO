package main.model;

public class StructAslab {
    private int id;
    private String nama;
    private double porto, microteach, wawancara;

    public StructAslab(int id, String nama, double porto, double microteach, double wawancara){
        this.id = id;
        this.nama = nama;
        this.porto = porto;
        this.microteach = microteach;
        this.wawancara = wawancara;
    }

    public int getId(){
        return id;
    }

    public String getNama(){
        return nama;
    }

    public double getPorto(){
        return porto;
    }
    public double getMicroteach(){
        return microteach;
    }

    public double getWawancara(){
        return wawancara;
    }

    public double getNilai(){
        double nilai = (this.porto + this.microteach +this.wawancara)/3;
        return nilai;
    }

    public void settId(int id){
        this.id = id ;
    }

    public void setNama(String nama){
        this.nama = nama;
    }

    public void setPorto(double porto){
        this.porto = porto;
    }

    public void setMicroteach(double microteach){
        this.microteach = microteach;
    }

    public void setWawancara(double wawancara){
        this.wawancara = wawancara;
    }
  
      
}
