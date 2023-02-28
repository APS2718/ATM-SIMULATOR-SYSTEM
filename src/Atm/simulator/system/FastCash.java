package Atm.simulator.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;


public class FastCash extends JFrame implements ActionListener {
    
    JButton deposite,withdrawl,fastcash,ministatement,pinchange,balance,exit;
    String pinnumber;
    
    FastCash(String pinnumber){
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
        
        JLabel text = new JLabel("SELECT WITHDRAWL AMMOUNT");
        text.setBounds(195,245,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,13));
        image1.add(text);   // kyoki hm image ke upr apna koi text dhikhana chahte h to isliye hmne image ke through add() function ko call kiya h.
        
        
        deposite  = new JButton("Rs 100");
        deposite.setBounds(145,342,125,24);
        deposite.addActionListener(this);
        image1.add(deposite);
        
        withdrawl  = new JButton("Rs 500");
        withdrawl.setBounds(305,342,125,24);
        withdrawl.addActionListener(this);
        image1.add(withdrawl);
        
        fastcash  = new JButton("Rs 1000");
        fastcash.setBounds(145,371,125,24);
        fastcash.addActionListener(this);
        image1.add(fastcash);
        
        ministatement  = new JButton("Rs 2000");
        ministatement.setBounds(305,371,125,24);
        ministatement.addActionListener(this);
        image1.add(ministatement);
        
        pinchange  = new JButton("Rs 5000");
        pinchange.setBounds(145,400,125,24);
        pinchange.addActionListener(this);
        image1.add(pinchange);
        
        balance  = new JButton("Rs 10000");
        balance.setBounds(305,400,125,24);
        balance.addActionListener(this);
        image1.add(balance);
        
        exit  = new JButton("BACK");
        exit.setBounds(225,430,120,24);
        exit.addActionListener(this);
        image1.add(exit);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == exit){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
            
        }
        else{
            
            String amount = ((JButton)e.getSource()).getText().substring(3); // hm ynha pe yh kar rhe h ki jaise he hm kisi bhi button pe click kare us butto pe jo text likha hua hoga 
                                                                   // uski substring index 3 ke bad wala text wo amount m aake store ho jayega.
            Conn c = new Conn();
            
            try{
                
                ResultSet rs = c.s.executeQuery("select * from Bank where PIN_Number = '"+pinnumber+"'"); // hm ynha pe yh check kar rhe h ki user jitna amount debit karna chata hh utna amount uske account m h bhi ki nhi
                                                                                             // to ab resultset class m us pin number ki jitni rows hongi wo store ho jayegi.
                
                int balance = 0;
                
                while(rs.next()){ // is rs.next() m us pin number ki jitni bhi rows hongi wo store hongi.
                   if(rs.getString("Transaction_type").equals("Deposite")){
                       balance = balance + Integer.parseInt(rs.getString("Amount"));
                       
               }else{
                       balance = balance + Integer.parseInt(rs.getString("Amount"));
                    }
               }
                
                
                
                if(e.getSource() != exit && balance < Integer.parseInt(amount)){ // ynha hm yh check kar rhe h user ne exit button pe click to nhi kiya h ar agr balance, amount wale balance se km jitna user debit karna chahta h
                 JOptionPane.showMessageDialog(null, "Insufficient Balance");
                 return;    
                }
                
                Date date = new Date();
                String query = "insert into Bank Values('"+pinnumber+"','"+date+"','Withdrawl','"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs "+amount+" is Debited successfully");
                
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
                
            }catch(Exception ae){
                System.out.println(ae);
            }
        }
        
        
    }
    
    
    public static void main(String []args){

        new FastCash("");
    }
    
}
