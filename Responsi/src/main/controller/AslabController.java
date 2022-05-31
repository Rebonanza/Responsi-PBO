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

        view.tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mousePressed(e);
                    int baris = view.tabel.getSelectedRow();
                    //String dataterpilih = lihatVieww.tabel.getValueAt(baris, 1).toString();
                    System.out.println(baris);
                    String nama = view.tabel.getValueAt(baris, 0).toString();
                    String porto = view.tabel.getValueAt(baris, 1).toString();
                    String microteach = view.tabel.getValueAt(baris,2).toString();
                    String wawancara  = view.tabel.getValueAt(baris, 3).toString();
                    view.setNama(nama);
                    view.setPorto(Double.valueOf(porto));
                    view.setMicroteach(Double.valueOf(microteach));
                    view.setWawancara(Double.valueOf(wawancara));
        //   int input = JOptionPane.showConfirmDialog(null,
        //           "Apa anda ingin menghapus NoHp " + dataterpilih + "?", "Pilih Opsi...", JOptionPane.YES_NO_OPTION);

        //   if (input == 0) {
        //       lihatModell.deleteContact(dataterpilih);
        //       String dataKontak[][] = lihatModell.readContact();
        //       lihatVieww.tabel.setModel(new JTable(dataKontak, lihatVieww.namaKolom).getModel());
        //   } else {
        //       JOptionPane.showMessageDialog(null, "Tidak Jadi Dihapus");
        //   }
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
                model.update(nama, portofolio, microteach, wawancara, nilaiAkhir);

                Object[][] data = model.getAll();
                view.tabel.setModel((new JTable(data, view.namaKolom)).getModel());
            }
        });
    }
}
