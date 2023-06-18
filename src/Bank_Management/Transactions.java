package Bank_Management;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Transactions extends JFrame implements ActionListener {
    JLabel l1,l2;
    JButton b1,b2,b3,b4,b5,b6,b7;
    String pin;

    Transactions(String pin){
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

        l2=new JLabel("Please select your Transaction");
        l2.setBounds(220,260,700,35);
        l2.setFont(new Font("System",Font.BOLD,16));
        l2.setForeground(Color.WHITE);
        l1.add(l2);

        b1=new JButton("Cash Deposit");
        b1.setBounds(170,350,150,30);
        l1.add(b1);

        b2=new JButton("Cash Withdrawl");
        b2.setBounds(355,350,150,30);
        l1.add(b2);

        b3=new JButton("Fast Cash");
        b3.setBounds(170,385,150,30);
        l1.add(b3);

        b4=new JButton("Mini Statement");
        b4.setBounds(355,385,150,30);
        l1.add(b4);

        b5=new JButton("PIN Change");
        b5.setBounds(170,420,150,30);
        l1.add(b5);

        b6=new JButton("Balance Enquiry");
        b6.setBounds(355,420,150,30);
        l1.add(b6);

        b7=new JButton("EXIT");
        b7.setBounds(355,455,150,30);
        l1.add(b7);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==b7){
            System.exit(0);
        }
        else if (e.getSource()==b1){
            this.setVisible(false);
            new Deposit(pin).setVisible(true);
        }
        else if (e.getSource()==b2){
            this.setVisible(false);
            new Withdrawl(pin).setVisible(true);
        }
        else if (e.getSource()==b3){
            this.setVisible(false);
            new Fast_cash(pin).setVisible(true);
        }else if (e.getSource()==b5){
            this.setVisible(false);
            new Pinchange(pin).setVisible(true);
        }else if(e.getSource()==b6){
            this.setVisible(false);
            new Balance_enquiry(pin).setVisible(true);
        }else if (e.getSource()==b4){
            //this.setVisible(false);
            new Mini_stmt(pin).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Transactions("").setVisible(true);
    }
}
