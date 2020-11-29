import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

public class FormHienThi extends JFrame {
    private Vector<MatHang> listMh = new Vector<>();
    private Vector<NhomHang> listSx = new Vector<>();
    private Vector<String> columnName = new Vector<>();
    private JTable table;

    public FormHienThi() {
        this.setSize(700, 400);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        columnName.add("Ma");
        columnName.add("Ten Hang");
        columnName.add("Loai san pham");
        columnName.add("Gia");

        String[] items = new String[]{"Chon mat hang", "Hang tieu dung", "Hang thoi trang", "Dien tu-Dien lanh"};
        JComboBox comboBox = new JComboBox(items);
        this.add(comboBox, BorderLayout.NORTH);

        readFile();
        sapXep();

        MatHangModel model = new MatHangModel(columnName, listMh);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        this.add(scrollPane, BorderLayout.CENTER);

        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox) e.getSource();
                int pos = cb.getSelectedIndex();
                MatHangModel data;
                switch (pos) {
                    case 0:
                        data = new MatHangModel(columnName, listMh);
                        table.setModel(data);
                        break;
                    case 1:
                        data = new MatHangModel(columnName, findNhom(1));
                        table.setModel(data);
                        break;
                    case 2:
                        data = new MatHangModel(columnName, findNhom(2));
                        table.setModel(data);
                        break;
                    case 3:
                        data = new MatHangModel(columnName, findNhom(3));
                        table.setModel(data);
                        break;

                }
            }
        });
    }

    private Vector<MatHang> findNhom(int i) {
        for (NhomHang nh : listSx) {
            if (nh.getTen().equals("Hang tieu dung") && i == 1) return nh.getDsHang();
            if (nh.getTen().equals("Hang thoi trang") && i == 2) return nh.getDsHang();
            if (nh.getTen().equals("Dien tu-Dien lanh") && i == 3) return nh.getDsHang();
        }
        return new Vector<>();
    }

    private void readFile() {
        try {
            Scanner sc = new Scanner(new File("MH.txt"));
            while (sc.hasNextLine()) {
                int maHang = Integer.parseInt(sc.nextLine());
                String tenMh = sc.nextLine();
                String nhom = sc.nextLine();
                double gia = Double.parseDouble(sc.nextLine());
                MatHang mh = new MatHang(maHang, tenMh, nhom, gia);
                listMh.add(mh);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    private void sapXep() {
        for (MatHang m : listMh) {
            int pos = check(m);
            if (pos > 0) {
                listSx.get(pos).getDsHang().add(m);
            } else {
                NhomHang nh = new NhomHang(m.getNhomMh());
                nh.getDsHang().add(m);
                listSx.add(nh);
            }
        }
    }

    private int check(MatHang m) {
        for (int i = 0; i < listSx.size(); i++) {
            if (listSx.get(i).getTen().equals(m.getNhomMh())) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        FormHienThi formHienThi = new FormHienThi();
        formHienThi.setVisible(true);
    }
}
