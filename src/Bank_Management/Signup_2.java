package Bank_Management;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Signup_2  extends JFrame implements ActionListener {
    JLabel l2,l3,l4,l5,l6,l7,l8,l9,l10,l11 ;
    //Choice ch1 ,ch2,ch3,ch4,ch5;
    JComboBox ch1,ch2,ch3,ch4,ch5;
    JTextField t1,t2;
    JRadioButton rb1,rb2,rb3,rb4;
    JButton b1;
    String form;

    Signup_2(String form){
        super("New Account Application Form - Page 2");
        setLocation(300,10);
        setSize(850,770);

        this.form=form;

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        l2=new JLabel("Page 2 : Additional Details");
        l2.setFont(new Font("Raleway",Font.BOLD,22));
        l2.setBounds(290,80,400,30);
        add(l2);

        l3=new JLabel("Religion :");
        l3.setFont(new Font("Raleway",Font.BOLD,20));
        l3.setBounds(100,140,100,30);
        add(l3);

        String [] rel={"Hindu","Muslim","Sikh","Christian","Others"};

        ch1=new JComboBox(rel);
        ch1.setFont(new Font("Arial",Font.BOLD,14));
        ch1.setBackground(Color.WHITE);
        ch1.setBounds(300,140,400,30);
        add(ch1);

        l4=new JLabel("Category :");
        l4.setFont(new Font("Raleway",Font.BOLD,20));
        l4.setBounds(100,190,200,30);
        add(l4);

        String [] cat={"General","OBC","SC","ST","Other"};

        ch2=new JComboBox(cat);
        ch2.setFont(new Font("Arial",Font.BOLD,14));
        ch2.setBackground(Color.WHITE);
        ch2.setBounds(300,190,400,30);
        add(ch2);

        l5=new JLabel("Income :");
        l5.setFont(new Font("Raleway",Font.BOLD,20));
        l5.setBounds(100,240,200,30);
        add(l5);

        String [] inc={"Null","< 1,50,000","< 2,50,000","< 5,00,000","upto 10,00,000"};

        ch3=new JComboBox(inc);
        ch3.setBounds(300,240,400,30);
        ch3.setFont(new Font("Arial",Font.BOLD,14));
        ch3.setBackground(Color.WHITE);
        add(ch3);

        l6=new JLabel("Education");
        l6.setFont(new Font("Raleway",Font.BOLD,20));
        l6.setBounds(100,290,200,30);
        add(l6);

        String [] edu={"Non-Graduate","Graduate","Post-Graduate","Other"};

        ch4=new JComboBox(edu);
        ch4.setBounds(300,290,400,30);
        ch4.setFont(new Font("Arial",Font.BOLD,14));
        ch4.setBackground(Color.WHITE);
        add(ch4);

        l7=new JLabel("Occupation :");
        l7.setFont(new Font("Raleway",Font.BOLD,20));
        l7.setBounds(100,340,200,30);
        add(l7);

        String [] occ={"Salaried","Self-Employed","Business","Student","Retired","Other"};

        ch5=new JComboBox(occ);
        ch5.setFont(new Font("Arial",Font.BOLD,14));
        ch5.setBounds(300,340,400,30);
        ch5.setBackground(Color.WHITE);
        add(ch5);

        l8=new JLabel("PAN Number :");
        l8.setFont(new Font("Raleway",Font.BOLD,20));
        l8.setBounds(100,390,200,30);
        add(l8);

        t1=new JTextField();
        t1.setFont(new Font("Arial",Font.BOLD,14));
        t1.setBounds(300,390,400,30);
        add(t1);

        l9=new JLabel("Aadhar Number :");
        l9.setFont(new Font("Raleway",Font.BOLD,20));
        l9.setBounds(100,440,200,30);
        add(l9);

        t2=new JTextField();
        t2.setFont(new Font("Arial",Font.BOLD,14));
        t2.setBounds(300,440,400,30);
        add(t2);

        l10=new JLabel("Senior Citizen :");
        l10.setFont(new Font("Raleway",Font.BOLD,20));
        l10.setBounds(100,490,200,30);
        add(l10);

        rb1=new JRadioButton("Yse");
        rb1.setBackground(Color.WHITE);
        rb1.setBounds(300,490,100,30);
        add(rb1);

        rb2=new JRadioButton("No");
        rb2.setBackground(Color.WHITE);
        rb2.setBounds(450,490,100,30);
        add(rb2);

        ButtonGroup bg1=new ButtonGroup();
        bg1.add(rb1);
        bg1.add(rb2);

        l11=new JLabel("Existing Account :");
        l11.setFont(new Font("Raleway",Font.BOLD,20));
        l11.setBounds(100,540,200,30);
        add(l11);

        rb3=new JRadioButton("Yes");
        rb3.setBackground(Color.WHITE);
        rb3.setBounds(300,540,100,30);
        add(rb3);

        rb4=new JRadioButton("No");
        rb4.setBackground(Color.WHITE);
        rb4.setBounds(450,540,100,30);
        add(rb4);

        ButtonGroup bg2=new ButtonGroup();
        bg2.add(rb3);
        bg2.add(rb4);

        b1=new JButton("NEXT");
        b1.setBounds(620,660,80,30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        add(b1);

        b1.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String rel=(String) ch1.getSelectedItem();
        String cat=(String) ch2.getSelectedItem();
        String inc=(String) ch3.getSelectedItem();
        String edu=(String) ch4.getSelectedItem();
        String occ=(String) ch5.getSelectedItem();
        String pan=t1.getText();
        String aadhar=t2.getText();
        String sc=null;
        if (rb1.isSelected()){
            sc="yes";
        }
        else if (rb2.isSelected()){
            sc="no";
        }

        String exa=null;
        if (rb3.isSelected()){
            exa="yes";
        }else if (rb4.isSelected()){
            exa="no";
        }

        try{
            Connection_Class ob1=new Connection_Class();
            String q="insert into additional_details values('"+form+"','"+rel+"','"+cat+"','"+inc+"','"+edu+"','"+occ+"','"+pan+"','"+aadhar+"','"+sc+"','"+exa+"')";
            int a=ob1.stm.executeUpdate(q);
            if (a==1){
                JOptionPane.showMessageDialog(null,"Details Submitted Successfully");
            }
            else {
                JOptionPane.showMessageDialog(null,"Fill details carefully");
            }
            this.setVisible(false);
            new Signup_3(form).setVisible(true);
        }
        catch (Exception e1){
            e1.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Signup_2("").setVisible(true);
    }
}
