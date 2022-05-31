package main.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.table.*;
import main.controller.*;


public class dataView extends JFrame implements MouseListener, ActionListener {

    
    JLabel ljudul = new JLabel("Data Penerimaan ASLAB");   
    DefaultTableModel dataModel;
    public JTable tabel;
    public Object namaKolom[] = {"Nama", "Portofolio", "Microteaching", "Wawancara", "Nilai Akhir"};
     // Form Section
     JPanel formPanel = new JPanel();
     // label
     JLabel Lnama = new JLabel("Nama : ");
     JLabel Lporto = new JLabel("Nilai Portofolio : ");
     JLabel Lmicroteach = new JLabel("Nilai Microteaching : ");
     JLabel Lwawancara = new JLabel("Nilai Wawancara : ");
     // text-field
     public JTextField Tnama = new  JTextField();
     public JTextField Tporto = new  JTextField();
     public JTextField Tmicroteach = new  JTextField();
     public JTextField Twawancara = new  JTextField();
     
     // button 
     public JButton btambah = new JButton("Tambah");
     public JButton bupdate = new JButton("Update");
     public JButton bdelete = new JButton("Delete");
     public JButton bclear = new JButton("Clear");
     
    
    public dataView(){
        addMouseListener(this); 
        setTitle("Data Penerimaan ASLAB");
        setSize(850,600);
        setVisible(true);
        setLayout(null);
        this.add(ljudul);
        ljudul.setFont(new Font("Arial",Font.BOLD,20));
        ljudul.setBounds(10, 10, 260, 40);
        
        // Table Section
        dataModel = new DefaultTableModel(namaKolom, 0);
        tabel = new JTable(dataModel);
        					
        TableColumn column;
        tabel.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF); 
        column = tabel.getColumnModel().getColumn(0); 
        column.setPreferredWidth(100);
        column = tabel.getColumnModel().getColumn(1); 
        column.setPreferredWidth(100); 
        column = tabel.getColumnModel().getColumn(2); 
        column.setPreferredWidth(100); 
        column = tabel.getColumnModel().getColumn(3); 
        column.setPreferredWidth(100); 
        column = tabel.getColumnModel().getColumn(4); 
        column.setPreferredWidth(100);
        
        tabel.setBackground(Color.PINK);
        tabel.setRowSelectionAllowed(true);
        tabel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        tabel.setFont(new Font("Arial",Font.PLAIN,14));
        tabel.setSelectionBackground(Color.GREEN);
        tabel.setSelectionForeground(Color.CYAN);
        tabel.addMouseListener(this);
        
        JScrollPane scroll = new JScrollPane(tabel);
        this.add(scroll);
        scroll.setBounds(20,50,520,200);
        
       // Form Section 
       formPanel.setBounds(550, 50, 250, 450);  
       formPanel.setLayout(null);
       Lnama.setBounds(10,0,100,20);
       Tnama.setBounds(10, 20, 200, 20);
       Lporto.setBounds(10, 60, 150, 20);
       Tporto.setBounds(10, 80, 200, 20);
       Lmicroteach.setBounds(10, 120, 150, 20);
       Tmicroteach.setBounds(10, 140, 200, 20);
       Lwawancara.setBounds(10, 180, 150, 20);
       Twawancara.setBounds(10, 200, 200, 20);
    
        btambah.setBounds(10, 250, 200, 25);
        bupdate.setBounds(10, 280, 200, 25);
        bdelete.setBounds(10, 330, 200, 25);
        bclear.setBounds(10, 360, 200, 25);

       formPanel.add(Tnama);
       formPanel.add(Lnama);
       formPanel.add(Tporto);
       formPanel.add(Lporto);
       formPanel.add(Tmicroteach);
       formPanel.add(Lmicroteach);
       formPanel.add(Twawancara);
       formPanel.add(Lwawancara);
       formPanel.add(btambah);
       formPanel.add(bupdate);
       formPanel.add(bdelete);
       formPanel.add(bclear);
       this.add(formPanel);   
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public String getNama(){
        return Tnama.getText();
    }

    public double getPorto(){
        double porto = Double.parseDouble(Tporto.getText());
        return porto;
    }

    public double getMicroteach(){
        double microteach = Double.parseDouble(Tmicroteach.getText());
        return microteach;
    }

    public double getWawancara(){
        double wawancara = Double.parseDouble(Twawancara.getText());
        return wawancara;
    }

    public double getNilai(){
        double nilai = (getPorto() + getMicroteach() + getWawancara())/3;
        return nilai;
    }

    public void setNama(String nama){
        Tnama.setText(nama);
    }
    public void setPorto(String porto){
        
        Tporto.setText(porto);
    }

    public void setMicroteach(String microteach){
        Tmicroteach.setText(microteach);
    }

    public void setWawancara(String wawancara){
        Twawancara.setText(wawancara);
    }








    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
    
}


