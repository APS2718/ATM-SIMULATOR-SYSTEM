package Atm.simulator.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class Deposite extends JFrame implements ActionListener {
    
    JTextField amounttext;
    JButton deposite,back;
    String pinnumber;
    
    
    Deposite(String pinnumber){
        
        this.pinnumber = pinnumber;
        
        
        setLayout(null);
        setSize(775,745);
        setLocation(290,0);
        setVisible(true);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        
        Image i2 = i1.getImage().getScaledInstance(775,745,Image.SCALE_DEFAULT);
        ImageIcon image = new ImageIcon(i2);
        
        JLabel image1 = new JLabel(image);
        image1.setBounds(0,0,775,745);
        add(image1);
        
        JLabel text = new JLabel("Enter the amount you want to deposite");
        text.setBounds(150,245,700,35);
        text.setFont(new Font("System",Font.BOLD,13));
        text.setForeground(Color.WHITE);
        image1.add(text);
        
        amounttext = new JTextField();
        amounttext.setBounds(150,290,280,24);
        amounttext.setFont(new Font("Raleway",Font.BOLD,16));
        image1.add(amounttext);
        
        deposite = new JButton("Deposite");
        deposite.setBounds(305,400,125,24);
        deposite.addActionListener(this);
        image1.add(deposite);
        
        back = new JButton("Back");
        back.setBounds(305,430,125,24);
        back.addActionListener(this);
        image1.add(back);
                
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == deposite){
            
            String amount = amounttext.getText();
            
            Date date = new Date();  // kaun si tarikh ko hmne paise ko deposite kiya h uske liye hmne Date class k use kiya h
                                     // Date class, util package ke andr hoti h.
           
            if(amount.equals("")){ // ynha hm check kar rhe h ki user ne knhi bina koi amount dale,deposite button pe click to nhi kar diya h
                                         //agr click kiya hoga to yh popup message shoe hoga use.
            JOptionPane.showMessageDialog(null,"Please enter the amount you want to deposite");
            
          }
            
            else { // user ne amount dala h uske baad wo deposite button pe click kiya h to hm data ko Bank table m store kar deng3e.
               
               try{ 
                   
               Conn c = new Conn();
               String query = "insert into Bank values('"+pinnumber+"','"+date+"','Deposite','"+amount+"')";
               c.s.executeUpdate(query);
               JOptionPane.showMessageDialog(null,"Rs "+amount+" is Deposited Successfully");
               setVisible(false);
               new Transactions(pinnumber).setVisible(true);
               
               } catch(Exception ae){
                   System.out.println(ae);
               }
                
            }
               
        
        } else if(e.getSource() == back){
            setVisible(false);
            new Transactions("").setVisible(true);
            
            
        }
       
    }
    
    public static void main(String[]args){
        
        new Deposite("");
    }

    
    
}
