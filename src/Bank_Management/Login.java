package Bank_Management;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JLabel l1,l2,l3,l4;
    JTextField t1;
    JPasswordField p1;
    JButton b1,b2,b3;

    Login(){
        super("Automated Teller Machine");
        setLocation(350,200);
        setSize(800,480);

        setLayout(null);

        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("Bank_Management/Icons/logo.jpg"));
        Image i1=img.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon img1=new ImageIcon(i1);

        l1=new JLabel(img1);
        l1.setBounds(70,10,100,100);
        add(l1);

        getContentPane().setBackground(Color.WHITE);

        l2=new JLabel("Welcome To ATM");
        l2.setFont(new Font("Osward",Font.BOLD,38));
        l2.setBounds(200,40,400,40);
        add(l2);

        l3=new JLabel("Card No :");
        l3.setFont(new Font("Raleway",Font.BOLD,28));
        l3.setBounds(120,150,150,30);
        add(l3);

        l4=new JLabel("PIN :");
        l4.setFont(new Font("Raleway",Font.BOLD,28));
        l4.setBounds(120,220,250,30);
        add(l4);

        t1=new JTextField();
        t1.setBounds(300,150,230,30);
        t1.setFont(new Font("Arial",Font.BOLD,14));
        add(t1);

        p1=new JPasswordField();
        p1.setBounds(300,220,230,30);
        p1.setFont(new Font("Arial",Font.BOLD,14));
        add(p1);

        b1=new JButton("SIGN IN");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(300,300,100,30);
        add(b1);

        b2=new JButton("CLEAR");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(430,300,100,30);
        add(b2);

        b3=new JButton("SIGN UP");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setBounds(300,350,230,30);
        add(b3);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==b1){
            try {
                Connection_Class ob1=new Connection_Class();
                String card=t1.getText();
                String pin=p1.getText();

                String q="select * from card_details where card_no='"+card+"' and pin='"+pin+"'";
                ResultSet rs1=ob1.stm.executeQuery(q);
                if (rs1.next()){
                    new Transactions(pin).setVisible(true);
                    this.setVisible(false);
                }
                else {
                    JOptionPane.showMessageDialog(null,"Wrong Card no. Or PIN !!");
                    this.setVisible(false);
                    new Login().setVisible(true);
                }

            }catch (Exception e1){
                e1.printStackTrace();
            }
        }
        if (e.getSource()==b2){
            t1.setText("");
            p1.setText("");
        }
        if (e.getSource()==b3){
            this.setVisible(false);
            new Signup().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Login().setVisible(true);
    }
}
