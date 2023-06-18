package Bank_Management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Fast_cash extends JFrame implements ActionListener {
    JLabel l1,l2;
    JButton b1,b2,b3,b4,b5,b6,b7;
    String pin;

    Fast_cash(String pin){
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

        l2=new JLabel("SELECT WITHDRAWL AMOUNT");
        l2.setBounds(220,260,700,35);
        l2.setFont(new Font("System",Font.BOLD,16));
        l2.setForeground(Color.WHITE);
        l1.add(l2);

        b1=new JButton("Rs.100");
        b1.setBounds(170,350,150,30);
        l1.add(b1);

        b2=new JButton("Rs.500");
        b2.setBounds(355,350,150,30);
        l1.add(b2);

        b3=new JButton("Rs.1000");
        b3.setBounds(170,385,150,30);
        l1.add(b3);

        b4=new JButton("Rs.2000");
        b4.setBounds(355,385,150,30);
        l1.add(b4);

        b5=new JButton("Rs.5000");
        b5.setBounds(170,420,150,30);
        l1.add(b5);

        b6=new JButton("Rs.10000");
        b6.setBounds(355,420,150,30);
        l1.add(b6);

        b7=new JButton("BACK");
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
            this.setVisible(false);
            new Transactions(pin).setVisible(true);
        }
        else {
            String amount=((JButton) e.getSource()).getText().substring(3);
            try {
                Connection_Class ob1=new Connection_Class();
                String q1="select * from bank where pin='"+pin+"'";
                ResultSet rs1=ob1.stm.executeQuery(q1);
                int balance=0;
                while (rs1.next()){
                    if (rs1.getString("amt_type").equals("Deposit")){
                        balance=balance+Integer.parseInt(rs1.getString("amount"));
                    }else if (rs1.getString("amt_type").equals("Withdrawl")){
                        balance-= Integer.parseInt(rs1.getString("amount"));
                    }
                }

                if (e.getSource()!=b7 && balance<Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }
                Date date=new Date();
                String q2="insert into bank values ('"+pin+"','"+date+"','Withdrawl','"+amount+"')";
                ob1.stm.executeUpdate(q2);
                JOptionPane.showMessageDialog(null,"Rs."+amount+" Debited Successfully..");
                this.setVisible(false);
                new Transactions(pin).setVisible(true);

            }catch (Exception e1){
                e1.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Fast_cash("").setVisible(true);
    }
}
