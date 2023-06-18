package Bank_Management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Connection_Class {
    Connection con=null;
    Statement stm;

    Connection_Class(){
        try{
            // Loading Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establishing Connection
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_management","root","rishu12345");
            //System.out.println("connection established");
            stm=con.createStatement();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Connection_Class();
    }
}
