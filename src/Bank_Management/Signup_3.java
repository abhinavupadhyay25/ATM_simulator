package Bank_Management;

import java.awt.*;
import java.awt.event.*;
import  javax.swing.*;
import java.util.Random;

public class Signup_3 extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4,l5,l6,l7,l8;
    JRadioButton rb1,rb2,rb3,rb4;
    JCheckBox cb1,cb2,cb3,cb4,cb5,cb6,cb7;
    JButton b1,b2;
    String form;

    Signup_3(String form){
        super("New Account Application Form - Page 3");
        setLocation(300,10);
        setSize(850,800);

        this.form=form;

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        l1=new JLabel("Page 3 : Account Details");
        l1.setFont(new Font("Raleway",Font.BOLD,22));
        l1.setBounds(290,80,400,30);
        add(l1);

        l2=new JLabel("Account Type :");
        l2.setFont(new Font("Raleway",Font.BOLD,20));
        l2.setBounds(100,140,400,30);
        add(l2);

        rb1=new JRadioButton("Saving Account");
        rb1.setBackground(Color.WHITE);
        rb1.setFont(new Font("Raleway",Font.BOLD,16));
        rb1.setBounds(100,180,150,20);
        add(rb1);

        rb2=new JRadioButton("Fixed Deposit Account");
        rb2.setBackground(Color.WHITE);
        rb2.setFont(new Font("Raleway",Font.BOLD,16));
        rb2.setBounds(350,180,250,20);
        add(rb2);

        rb3=new JRadioButton("Current Account");
        rb3.setBackground(Color.WHITE);
        rb3.setFont(new Font("Raleway",Font.BOLD,16));
        rb3.setBounds(100,220,180,20);
        add(rb3);

        rb4=new JRadioButton("Recurring Deposit Account");
        rb4.setBackground(Color.WHITE);
        rb4.setFont(new Font("Raleway",Font.BOLD,16));
        rb4.setBounds(350,220,250,20);
        add(rb4);

        ButtonGroup bg1=new ButtonGroup();
        bg1.add(rb1);
        bg1.add(rb2);
        bg1.add(rb3);
        bg1.add(rb4);

        l2=new JLabel("Card Number :");
        l2.setFont(new Font("Raleway",Font.BOLD,20));
        l2.setBounds(100,300,200,30);
        add(l2);

        l6=new JLabel("Your 16 digit card number");
        l6.setFont(new Font("Raleway",Font.BOLD,15));
        l6.setBounds(100,330,300,20);
        add(l6);

        l3=new JLabel("XXXX-XXXX-XXXX-7152");
        l3.setFont(new Font("Raleway",Font.BOLD,20));
        l3.setBounds(330,300,300,30);
        add(l3);

        l4=new JLabel("PIN :");
        l4.setFont(new Font("Raleway",Font.BOLD,20));
        l4.setBounds(100,370,100,30);
        add(l4);

        l7=new JLabel("Your 4 digit pin");
        l7.setFont(new Font("Raleway",Font.BOLD,15));
        l7.setBounds(100,400,300,20);
        add(l7);

        l5=new JLabel("XXXX");
        l5.setFont(new Font("Raleway",Font.BOLD,20));
        l5.setBounds(330,370,100,30);
        add(l5);

        l8=new JLabel("Services Required :");
        l8.setFont(new Font("Raleway",Font.BOLD,20));
        l8.setBounds(100,450,400,20);
        add(l8);

        cb1=new JCheckBox("ATM Card");
        cb1.setBackground(Color.WHITE);
        cb1.setFont(new Font("Raleway",Font.BOLD,16));
        cb1.setBounds(100,500,200,30);
        add(cb1);

        cb2=new JCheckBox("Internet Banking");
        cb2.setBackground(Color.WHITE);
        cb2.setFont(new Font("Raleway",Font.BOLD,16));
        cb2.setBounds(350,500,200,30);
        add(cb2);

        cb3=new JCheckBox("Mobile Banking");
        cb3.setBackground(Color.WHITE);
        cb3.setFont(new Font("Raleway",Font.BOLD,16));
        cb3.setBounds(100,550,200,30);
        add(cb3);

        cb4=new JCheckBox("Email & SMS Alerts");
        cb4.setBackground(Color.WHITE);
        cb4.setFont(new Font("Raleway",Font.BOLD,16));
        cb4.setBounds(350,550,200,30);
        add(cb4);

        cb5=new JCheckBox("Cheque Book");
        cb5.setBackground(Color.WHITE);
        cb5.setFont(new Font("Raleway",Font.BOLD,16));
        cb5.setBounds(100,600,200,30);
        add(cb5);

        cb6=new JCheckBox("E-Statement");
        cb6.setBackground(Color.WHITE);
        cb6.setFont(new Font("Raleway",Font.BOLD,16));
        cb6.setBounds(350,600,200,30);
        add(cb6);

        cb7=new JCheckBox("I hereby declares that the above entered details are correct to the best of my knowledge");
        cb7.setBackground(Color.WHITE);
        cb7.setFont(new Font("Raleway",Font.BOLD,12));
        cb7.setBounds(100,680,550,30);
        add(cb7);

        b1=new JButton("SUBMIT");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(250,720,100,30);
        add(b1);

        b2=new JButton("CANCEL");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(420,720,100,30);
        add(b2);

        b1.addActionListener(this);
        b2.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==b1){
            String acc=null;

            if (rb1.isSelected()){
                acc="saving account";
            }else if (rb2.isSelected()){
                acc="fixed deposit account";
            }else if (rb3.isSelected()){
                acc="current account";
            }else if(rb4.isSelected()){
                acc="recurring deposit account";
            }

            Random random=new Random();

            String card=""+Math.abs((random.nextLong() % 90000000L)+5040936000000000L);
            String pin=""+Math.abs((random.nextLong() % 9000L)+1000);

            String services="";
            if (cb1.isSelected()){
                services=services+" ATM Card";
            }else if (cb2.isSelected()){
                services=services+" Internet Banking";
            }else if (cb3.isSelected()){
                services=services+" Mobile Banking";
            }else if (cb4.isSelected()){
                services=services+" Email & SMS Alert";
            }else if (cb5.isSelected()){
                services=services+" Cheque Book";
            }else if (cb6.isSelected()){
                services=services+" E-statement";
            }

            try{
                if (acc.equals("")){
                    JOptionPane.showMessageDialog(null,"Account Type is required");
                }

                Connection_Class ob1=new Connection_Class();
                String q1="insert into account_details values('"+form+"','"+acc+"','"+card+"','"+pin+"','"+services+"')";
                String q2="insert into card_details values('"+form+"','"+card+"','"+pin+"')";
                ob1.stm.executeUpdate(q1);
                ob1.stm.executeUpdate(q2);

                JOptionPane.showMessageDialog(null,"Card number : "+card+"\nPIN : "+pin);

                this.setVisible(false);
                //new Login().setVisible(true);     -----> for zero balance account
                new Deposit(pin).setVisible(true);    //-------> for non-zero balance account
            }
            catch(Exception e1){
                e1.printStackTrace();
            }
        }
        if (e.getSource()==b2){
            this.setVisible(false);
            new Login().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Signup_3("").setVisible(true);
    }
}
