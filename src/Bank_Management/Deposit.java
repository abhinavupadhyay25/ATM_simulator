package Bank_Management;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener {
    JLabel l1,l2;
    JTextField t1;
    JButton b1,b2;
    String pin;

    Deposit(String pin){
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

        l2=new JLabel("Enter the amount you want to deposit");
        l2.setBounds(200,260,700,35);
        l2.setFont(new Font("System",Font.BOLD,16));
        l2.setForeground(Color.WHITE);
        l1.add(l2);

        t1=new JTextField();
        t1.setFont(new Font("Raleway",Font.BOLD,22));
        t1.setBounds(180,320,320,25);
        l1.add(t1);

        b1=new JButton("Deposit");
        b1.setBounds(355,445,150,30);
        l1.add(b1);

        b2=new JButton("Back");
        b2.setBounds(355,480,150,30);
        l1.add(b2);

        b1.addActionListener(this);
        b2.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==b1){
            String damt=t1.getText();
            Date date=new Date();
            if (damt.equals("")){
                JOptionPane.showMessageDialog(null,"You have to enter some amount to deposit..");
            }
            try {
                Connection_Class ob1=new Connection_Class();
                String q1="insert into bank values('"+pin+"','"+date+"','Deposit','"+damt+"')";
                ob1.stm.executeUpdate(q1);
                JOptionPane.showMessageDialog(null,"Rs."+damt+" Deposited Successfully");
                setVisible(false);
                new Transactions(pin).setVisible(true);

            }catch(Exception e1){
                e1.printStackTrace();
            }
        }
        if (e.getSource()==b2){
            this.setVisible(false);
            new Transactions(pin).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Deposit("").setVisible(true);
    }
}
