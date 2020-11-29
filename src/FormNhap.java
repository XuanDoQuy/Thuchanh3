import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FormNhap extends JFrame {
    private Scanner scanner;
    private FileWriter fileWriter;
    public FormNhap() throws FileNotFoundException {
        this.setSize(400,260);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);

        JLabel txtTen = new JLabel("Ten mat hang: ");
        txtTen.setBounds(10,10,90,30);

        JLabel txtNhom = new JLabel("Nhom hang: ");
        txtNhom.setBounds(10,50,90,30);

        JLabel txtGia = new JLabel("Gia mat hang: ");
        txtGia.setBounds(10,90,90,30);

        JTextField edtTen = new JTextField();
        edtTen.setBounds(90,10,250,30);

        JTextField edtGia = new JTextField();
        edtGia.setBounds(90,90,250,30);

        String[] items = new String[]{"Hang tieu dung","Hang thoi trang","Dien tu-Dien lanh"};
        JComboBox comboBox = new JComboBox(items);
        comboBox.setBounds(90,50,250,30);

        JButton btnLuu = new JButton("Luu");
        btnLuu.setBounds(150,130,100,40);

        this.add(txtGia);
        this.add(txtTen);
        this.add(txtNhom);
        this.add(edtGia);
        this.add(edtTen);
        this.add(comboBox);
        this.add(btnLuu);

        btnLuu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ten = edtTen.getText();
                String nhom = (String) comboBox.getSelectedItem();
                double gia = 0;
                try{
                    gia = Double.parseDouble(edtGia.getText());
                    if (ten.length()==0||gia<0){
                        showDialogError();
                        return;
                    }
                }catch (NumberFormatException exc){
                    showDialogError();
                    return;
                }
                showDialogSuccess();
                File f = new File("D:\\JavaOOP\\Bai7_BT3\\src\\Ma.txt");
                try {
                    scanner = new Scanner(f);
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
                int maMh = scanner.nextInt();
                maMh++;
                MatHang mh  = new MatHang(maMh,ten,nhom,gia);
                try {
                    FileWriter fileWriter = new FileWriter(f);
                    fileWriter.write(maMh+"");
                    fileWriter.close();
                    FileWriter fr = new FileWriter(new File("MH.txt"),true);
                    fr.write(maMh+"\n"+ten+"\n"+nhom+"\n"+gia+"\n");
                    fr.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            }
        });


    }

    public static void main(String[] args) throws FileNotFoundException {
        FormNhap form = new FormNhap();
        form.setVisible(true);
    }

    private void showDialogError(){
        JOptionPane.showMessageDialog(this,"Nhap sai!");
    }
    private void showDialogSuccess(){
        JOptionPane.showMessageDialog(this,"Luu thanh cong!");
    }
}
