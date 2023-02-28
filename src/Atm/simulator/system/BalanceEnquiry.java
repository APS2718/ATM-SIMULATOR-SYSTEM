package Atm.simulator.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;


public class BalanceEnquiry extends JFrame implements ActionListener {
    
    
    JButton back;
    String pinnumber;
    
    BalanceEnquiry(String pinnumber){
       
        this.pinnumber = pinnumber;
        
        //getContentPane().setBackground(Color.YELLOW);
        
        setLayout(null);
        
        setSize(775,745);
        setLocation(290,0);
        // setUndecorated(true);// is function k use karke hm hmare frame ke upr jo bhi cheeje aati h jaise 
                                   // minimise karna, maximise karna, cancle karna wo sb cheeje ht jati h. ar ise hmesha 
                                   // setVisible() function ke phle likha jata h.
        setVisible(true);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        
        Image i2 = i1.getImage().getScaledInstance(775,745,Image.SCALE_DEFAULT);
        ImageIcon image = new ImageIcon(i2);
        
        JLabel image1 = new JLabel(image);
        image1.setBounds(0,0,775,745);
        add(image1);
        
        Conn c = new Conn();
        int balance = 0;
        
        try{
                // hm chahte h ki jaise he hm apna balanceEnquiry wala frame khole hme hmara total balance show ho jaye bina kisi button pe click kiye
                                 // to jb bhi hme bina kisi button pe click kiye apna kam karna hota h to us code ko constructor ke ande likhte h jaise is code ko likha h.
                
                ResultSet rs = c.s.executeQuery("select * from Bank where PIN_Number = '"+pinnumber+"'"); // hm ynha pe yh check kar rhe h ki user jitna amount debit karna chata hh utna amount uske account m h bhi ki nhi
                                                                                             // to ab resultset class m us pin number ki jitni rows hongi wo store ho jayegi.
                
               
                
                while(rs.next()){ // is rs.next() m us pin number ki jitni bhi rows hongi wo store hongi.
                   if(rs.getString("Transaction_type").equals("Deposite")){
                       balance = balance + Integer.parseInt(rs.getString("Amount"));
                       
               }else{
                       balance = balance - Integer.parseInt(rs.getString("Amount"));
                    }
               }
                
               
            }catch(Exception ae){
                System.out.println(ae);
            }
        
        JLabel text = new JLabel("Your Current Account balance is Rs "+ balance);
        text.setBounds(170,300,400,30);
        text.setForeground(Color.WHITE);
        image1.add(text);
           
        back  = new JButton("BACK");
        back.setBounds(305,430,125,24);
        back.addActionListener(this);
        image1.add(back);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
        
        
    }
    
    public static void main (String [] args){
        
        new BalanceEnquiry("");
        
    }
    
}
