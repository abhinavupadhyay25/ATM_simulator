package Bank_Management;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Mini_stmt extends JFrame implements ActionListener{
    String pin1;
    JLabel l1,l2,l3,l4;

    Mini_stmt(String pin){
        super("Mini-Statement");
        setSize(400,600);
        setLocation(20,20);

        this.pin1=pin;

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        l1=new JLabel();
        l1.setBounds(20,140,400,200);
        add(l1);

        l2=new JLabel("State Bank Of India");
        l2.setBounds(150,20,400,30);
        add(l2);

        l3=new JLabel();
        l3.setBounds(20,80,300,20);
        add(l3);

        l4=new JLabel();
        l4.setBounds(20,400,300,20);
        add(l4);

        try {
            Connection_Class ob1=new Connection_Class();
            String q1="select * from card_details where pin ='"+pin1+"'";
            ResultSet rs1=ob1.stm.executeQuery(q1);
            while (rs1.next()){
                l3.setText("CARD NUMBER : "+rs1.getString("card_no").substring(0,4)+"XXXXXXXX"+rs1.getString("card_no").substring(12));

            }

        }catch (Exception e1){
            e1.printStackTrace();
        }

        try{
            Connection_Class ob2=new Connection_Class();
            int balance=0;
            String q2="select * from bank where pin='"+pin1+"'";
            ResultSet rs2=ob2.stm.executeQuery(q2);
            while(rs2.next()){
                l1.setText(l1.getText()+ "<html>" + rs2.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs2.getString("amt_type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs2.getString("amount")+"<br><br><html>");

                if (rs2.getString("amt_type").equals("Deposit")) {
                    balance = balance + Integer.parseInt(rs2.getString("amount"));
                }
                else if (rs2.getString("amt_type").equals("Withdrawl")) {
                    balance -= Integer.parseInt(rs2.getString("amount"));
                }
            }
            l4.setText("Your current account balance is Rs."+balance);
        }
        catch (Exception e2){
            e2.printStackTrace();
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        new Mini_stmt("").setVisible(true);
    }

}
