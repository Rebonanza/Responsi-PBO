package main.controller;

import main.model.Aslab_m;
// import main.model.StructAslab;
import main.view.dataView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
                model.insert(nama, portofolio, microteach, wawancara, nilaiAkhir);

                Object[][] data = model.getAll();
                view.tabel.setModel((new JTable(data, view.namaKolom)).getModel());
            }
        });
    }
}
