package main.controller;

import main.model.Aslab_m;
import main.view.dataView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.lang.model.util.ElementScanner6;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class AslabController {
    private dataView view;
    private Aslab_m model;

    public AslabController(dataView view, Aslab_m model){
        this.view = view;
        this.model = model;

        if (model.getJumlahData()!=0) {
            Object[][] data = this.model.getAll();
            view.tabel.setModel((new JTable(data, view.namaKolom)).getModel());
        }
        else {
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }

        view.btambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String nama = view.getNama();
                double portofolio = view.getPorto();
                double microteach = view.getMicroteach();
                double wawancara = view.getWawancara();
                double nilaiAkhir = view.getNilai();
                if(wawancara > 100 || portofolio > 100 || microteach > 100){
                    JOptionPane.showMessageDialog(null, "Nilai tidak boleh lebih dari 100");
                }else{
                    model.insert(nama, portofolio, microteach, wawancara, nilaiAkhir);
                }

                Object[][] data = model.getAll();
                view.tabel.setModel((new JTable(data, view.namaKolom)).getModel());
            }
        });

        view.tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mousePressed(e);
                    int baris = view.tabel.getSelectedRow();
                    //String dataterpilih = lihatVieww.tabel.getValueAt(baris, 1).toString();
                    String nama = view.tabel.getValueAt(baris, 0).toString();
                    String porto = view.tabel.getValueAt(baris, 1).toString();
                    String microteach = view.tabel.getValueAt(baris,2).toString();
                    String wawancara  = view.tabel.getValueAt(baris, 3).toString();
                    view.setNama(nama);
                    view.setPorto(porto);
                    view.setMicroteach(microteach);
                    view.setWawancara(wawancara); 
            }
        });

        view.bupdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String nama = view.getNama();
                double portofolio = view.getPorto();
                double microteach = view.getMicroteach();
                double wawancara = view.getWawancara();
                double nilaiAkhir = view.getNilai();
                if(wawancara > 100 || portofolio > 100 || wawancara > 100){
                    JOptionPane.showMessageDialog(null, "Nilai tidak boleh lebih dari 100");
                }else{
                    model.update(nama, portofolio, microteach, wawancara, nilaiAkhir);
                }
                model.update(nama, portofolio, microteach, wawancara, nilaiAkhir);

                Object[][] data = model.getAll();
                view.tabel.setModel((new JTable(data, view.namaKolom)).getModel());
            }
        });
        view.bdelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int selected = view.tabel.getSelectedRow();
                if(selected >= 0){
                    model.delete(view.tabel.getValueAt(selected, 0).toString());
                }else{
                    JOptionPane.showMessageDialog(null, "Data Belum Dipilih");
                }
                Object[][] data = model.getAll();
                view.tabel.setModel((new JTable(data, view.namaKolom)).getModel());
            }
        });

        view.bclear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                view.setNama("");
                view.setPorto("");
                view.setMicroteach("");
                view.setWawancara("");
                Object[][] data = model.getAll();
                view.tabel.setModel((new JTable(data, view.namaKolom)).getModel());
                
            }
        });
    }
}
