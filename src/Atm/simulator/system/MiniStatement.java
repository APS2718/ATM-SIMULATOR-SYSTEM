package Atm.simulator.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class MiniStatement extends JFrame implements ActionListener {
    
    String pinnumber;
    
    MiniStatement(String pinnumber){
        
        this.pinnumber = pinnumber;
        
        
        setLayout(null);
        getContentPane().setBackground(Color.YELLOW);
        
        
        setTitle("Mini Statement");
        
        setSize(400,550);
        setLocation(20,20);
        setVisible(true);
        
        JLabel minitext = new JLabel();
        minitext.setBounds(20,140,400,200);
        add(minitext);
        
        JLabel bank = new JLabel("State Bank of India");
        bank.setBounds(125,20,200,30);
        bank.setFont(new Font("Raleway",Font.BOLD,17));
        add(bank);
        
        JLabel cardno = new JLabel();
        cardno.setBounds(20,80,300,20);
        cardno.setFont(new Font("Raleway",Font.BOLD,14));
        add(cardno);
        
        JLabel bal = new JLabel();
        bal.setBounds(20,400,300,20);
        add(bal);
        
        try{
            
            Conn c = new Conn();
            
            ResultSet rs = c.s.executeQuery("select * from Login where PIN_Number = '2085'");
            while(rs.next()){
                cardno.setText("Card Number: " + rs.getString("CARD_Number").substring(0,4) + "xxxxxxxx" + rs.getString("CARD_Number").substring(12));
            }
            
        }catch(Exception ae){
            System.out.println(ae);
            
        }
        
        try{
            Conn c = new Conn();
            int balance = 0;
            ResultSet rs = c.s.executeQuery("select * from Bank where PIN_Number = '"+pinnumber+"'");
            
            while(rs.next()){
                minitext.setText(minitext.getText() + "<html>" + rs.getString("Date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("Transaction_type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("Amount") + "<br><br><html>");
                                       // hmne ynha pe &nbsp; k use space dene ke liye kiya h jo ki <html> m generallay use kiya jata h isiiye &nbsp; tag k use karne ke liye hmne 
                                          // sbse phle <html> k use kiya phir &nbsp; tag k use kiya.
        
                if(rs.getString("Transaction_type").equals("Deposite")){
                       balance = balance + Integer.parseInt(rs.getString("Amount"));
                       
               }else{
                       balance = balance + Integer.parseInt(rs.getString("Amount"));
                    }                          
                                          
            } 
            
            bal.setText("Your current account balance is Rs " + balance);
                                           
        }catch(Exception ae){
            System.out.println(ae);
        }
        
        
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
    }
    
    public static void main (String [] args){
    
        new MiniStatement("");
    }
    
}
