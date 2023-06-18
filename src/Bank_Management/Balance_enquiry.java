package Bank_Management;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Balance_enquiry extends JFrame implements ActionListener {
    String pin;
    JLabel l1,l2;
    JButton b1;

    Balance_enquiry(String pin){
        setSize(900,840);
        setLocation(300,0);
        setUndecorated(true);

        this.pin=pin;

        setLayout(null);

        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("Bank_Management/Icons/atm.jpg"));
        Image i1=img.getImage().getScaledInstance(900,840,Image.SCALE_DEFAULT);
        ImageIcon img1=new ImageIcon(i1);

        l1=new JLabel(img1);
        l1.setBounds(0,0,900,840);
        add(l1);

        int balance = 0;

        try {
            Connection_Class ob1 = new Connection_Class();
            String q1 = "select * from bank where pin='" + pin + "'";
            ResultSet rs1 = ob1.stm.executeQuery(q1);
            while (rs1.next()) {
                if (rs1.getString("amt_type").equals("Deposit")) {
                    balance = balance + Integer.parseInt(rs1.getString("amount"));
                }
                else if (rs1.getString("amt_type").equals("Withdrawl")) {
                    balance -= Integer.parseInt(rs1.getString("amount"));
                }
            }
        }
        catch(Exception e1){
            e1.printStackTrace();
        }

        l2=new JLabel("Your Current Account Balance is Rs."+balance);
        l2.setForeground(Color.YELLOW);
        l2.setFont(new Font("Arial",Font.BOLD,16));
        l2.setBounds(165,300,400,30);
        l1.add(l2);

        b1=new JButton("BACK");
        b1.setBounds(355,480,150,30);
        l1.add(b1);

        b1.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.setVisible(false);
        new Transactions(pin).setVisible(true);
    }

    public static void main(String[] args) {
        new Balance_enquiry("").setVisible(true);
    }
}
