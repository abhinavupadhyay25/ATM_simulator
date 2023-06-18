package Bank_Management;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Pinchange extends JFrame implements ActionListener {
    String pin;
    JLabel l1,l2,l3,l4;
    JTextField t1,t2;
    JButton b1,b2;

    Pinchange(String pin){
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

        l2=new JLabel("CHANGE YOUR PIN");
        l2.setBounds(235,260,700,35);
        l2.setFont(new Font("System",Font.BOLD,16));
        l2.setForeground(Color.WHITE);
        l1.add(l2);

        l3=new JLabel("NEW PIN :");
        l3.setBounds(170,320,700,35);
        l3.setFont(new Font("System",Font.BOLD,16));
        l3.setForeground(Color.WHITE);
        l1.add(l3);

        t1=new JTextField();
        t1.setFont(new Font("Raleway",Font.BOLD,25));
        t1.setBounds(350,320,150,25);
        l1.add(t1);

        l4=new JLabel("RE-ENTER NEW PIN :");
        l4.setBounds(170,360,700,35);
        l4.setFont(new Font("System",Font.BOLD,16));
        l4.setForeground(Color.WHITE);
        l1.add(l4);

        t2=new JTextField();
        t2.setFont(new Font("Raleway",Font.BOLD,25));
        t2.setBounds(350,360,150,25);
        l1.add(t2);

        b1=new JButton("CHANGE");
        b1.setBounds(355,445,150,30);
        l1.add(b1);

        b2=new JButton("BACK");
        b2.setBounds(355,480,150,30);
        l1.add(b2);

        b1.addActionListener(this);
        b2.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==b1){
            String npin=t1.getText();
            String rpin=t2.getText();
            if (! npin.equals(rpin)){
                JOptionPane.showMessageDialog(null,"Entered pin does not match");
                return;
            }
            if (npin.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter new PIN");
                return;
            }
            if (rpin.equals("")){
                JOptionPane.showMessageDialog(null,"Please re-enter new PIN");
                return;
            }

            try {
                Connection_Class ob1=new Connection_Class();
                String q1="update bank set pin='"+rpin+"' where pin='"+pin+"'";
                String q2="update account_details set pin='"+rpin+"' where pin='"+pin+"'";
                String q3="update card_details set pin='"+rpin+"' where pin='"+pin+"'";

                ob1.stm.executeUpdate(q1);
                ob1.stm.executeUpdate(q2);
                ob1.stm.executeUpdate(q3);

                JOptionPane.showMessageDialog(null,"PIN changed successfully");
                this.setVisible(false);
                new Transactions(pin).setVisible(true);

            }catch (Exception e1){
                e1.printStackTrace();
            }
        }
        if (e.getSource()==b2){
            this.setVisible(false);
            new Transactions(pin).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Pinchange("").setVisible(true);
    }
}
