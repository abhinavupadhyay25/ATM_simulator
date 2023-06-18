package Bank_Management;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Random;
import com.toedter.calendar.JDateChooser;

public class Signup extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
    JTextField t1,t2,t3,t4,t5,t6,t7;
    JButton b1;
    JRadioButton rb1,rb2,rb3,rb4,rb5;
    long rand;
    JDateChooser dc;

    Signup(){
        super("New Account Application Form - Page 1");
        setLocation(300,10);
        setSize(850,770);

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        Random ran=new Random();
        rand= Math.abs((ran.nextLong()%9000L)+1000L);


        l1=new JLabel("Application Form NO. "+rand);
        l1.setFont(new Font("Raleway",Font.BOLD,38));
        l1.setBounds(140,20,600,40);
        add(l1);

        l2=new JLabel("Page 1 : Personal Details");
        l2.setFont(new Font("Raleway",Font.BOLD,22));
        l2.setBounds(290,80,400,30);
        add(l2);

        l3=new JLabel("Name :");
        l3.setFont(new Font("Raleway",Font.BOLD,20));
        l3.setBounds(100,140,100,30);
        add(l3);

        t1=new JTextField();
        t1.setFont(new Font("Arial",Font.BOLD,14));
        t1.setBounds(300,140,400,30);
        add(t1);

        l4=new JLabel("Father's Name :");
        l4.setFont(new Font("Raleway",Font.BOLD,20));
        l4.setBounds(100,190,200,30);
        add(l4);

        t2=new JTextField();
        t2.setFont(new Font("Arial",Font.BOLD,14));
        t2.setBounds(300,190,400,30);
        add(t2);

        l5=new JLabel("Date Of Birth :");
        l5.setFont(new Font("Raleway",Font.BOLD,20));
        l5.setBounds(100,240,200,30);
        add(l5);

        //Adding Calendar Option

        dc=new JDateChooser();
        dc.setBounds(300,240,400,30);
        dc.setFont(new Font("Arial",Font.BOLD,14));
        dc.setForeground(Color.BLACK);
        add(dc);

        l6=new JLabel("Gender");
        l6.setFont(new Font("Raleway",Font.BOLD,20));
        l6.setBounds(100,290,200,30);
        add(l6);

        rb1=new JRadioButton("Male");
        rb1.setBounds(300,290,60,30);
        rb1.setBackground(Color.WHITE);
        add(rb1);

        rb2=new JRadioButton("Female");
        rb2.setBounds(450,290,120,30);
        rb2.setBackground(Color.WHITE);
        add(rb2);

        //For Choosing only one option

        ButtonGroup bg1=new ButtonGroup();
        bg1.add(rb1);
        bg1.add(rb2);

        l7=new JLabel("Email :");
        l7.setFont(new Font("Raleway",Font.BOLD,20));
        l7.setBounds(100,340,200,30);
        add(l7);

        t3=new JTextField();
        t3.setFont(new Font("Arial",Font.BOLD,14));
        t3.setBounds(300,340,400,30);
        add(t3);

        l8=new JLabel("Marital Status :");
        l8.setFont(new Font("Raleway",Font.BOLD,20));
        l8.setBounds(100,390,200,30);
        add(l8);

        rb3=new JRadioButton("Married");
        rb3.setBackground(Color.WHITE);
        rb3.setBounds(300,390,100,30);
        add(rb3);

        rb4=new JRadioButton("Unmarried");
        rb4.setBackground(Color.WHITE);
        rb4.setBounds(450,390,100,30);
        add(rb4);

        rb5=new JRadioButton("Other");
        rb5.setBackground(Color.WHITE);
        rb5.setBounds(630,390,100,30);
        add(rb5);

        ButtonGroup bg2=new ButtonGroup();
        bg2.add(rb3);
        bg2.add(rb4);
        bg2.add(rb5);

        l9=new JLabel("Address :");
        l9.setFont(new Font("Raleway",Font.BOLD,20));
        l9.setBounds(100,440,200,30);
        add(l9);

        t4=new JTextField();
        t4.setFont(new Font("Arial",Font.BOLD,14));
        t4.setBounds(300,440,400,30);
        add(t4);

        l10=new JLabel("City :");
        l10.setFont(new Font("Raleway",Font.BOLD,20));
        l10.setBounds(100,490,200,30);
        add(l10);

        t5=new JTextField();
        t5.setFont(new Font("Arial",Font.BOLD,14));
        t5.setBounds(300,490,400,30);
        add(t5);

        l11=new JLabel("State :");
        l11.setFont(new Font("Raleway",Font.BOLD,20));
        l11.setBounds(100,540,200,30);
        add(l11);

        t6=new JTextField();
        t6.setFont(new Font("Arial",Font.BOLD,14));
        t6.setBounds(300,540,400,30);
        add(t6);

        l12=new JLabel("Pincode :");
        l12.setFont(new Font("Raleway",Font.BOLD,20));
        l12.setBounds(100,590,200,30);
        add(l12);

        t7=new JTextField();
        t7.setFont(new Font("Arial",Font.BOLD,14));
        t7.setBounds(300,590,400,30);
        add(t7);

        b1=new JButton("NEXT");
        b1.setBounds(620,660,80,30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        add(b1);

        b1.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String form="" + rand;
        String name=t1.getText();
        String father=t2.getText();
        String dob=((JTextField) dc.getDateEditor().getUiComponent()).getText(); // converting into string
        String gender=null;
        if (rb1.isSelected()){
            gender="Male";
        }else if (rb2.isSelected()){
            gender="Female";
        }

        String email=t3.getText();
        String marital=null;
        if (rb3.isSelected()){
            marital="Married";
        }else if (rb4.isSelected()){
            marital="Unmarried";
        }else if (rb5.isSelected()){
            marital="Other";
        }

        String address=t4.getText();
        String city=t5.getText();
        String state=t6.getText();
        String pin=t7.getText();

        try{
            if (name.equals("")){
                JOptionPane.showMessageDialog(null,"Name is required");
            }
            Connection_Class ob=new Connection_Class();
            String q="insert into personal_details values('"+form+"','"+name+"','"+father+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+state+"','"+pin+"')";
            int a=ob.stm.executeUpdate(q);
            if (a==1){
                JOptionPane.showMessageDialog(null,"Details Submitted Successfully");
            }
            else {
                JOptionPane.showMessageDialog(null,"Fill details carefully");
            }
            this.setVisible(false);
            new Signup_2(form).setVisible(true);
        }
        catch (Exception e1){
            e1.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Signup().setVisible(true);
    }
}
