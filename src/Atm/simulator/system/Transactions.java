package Atm.simulator.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Transactions extends JFrame implements ActionListener {
    
    JButton deposite,withdrawl,fastcash,ministatement,pinchange,balance,exit;
    String pinnumber;
    
    Transactions(String pinnumber){
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
        
        JLabel text = new JLabel("Please select your Transaction");
        text.setBounds(195,245,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,13));
        image1.add(text);   // kyoki hm image ke upr apna koi text dhikhana chahte h to isliye hmne image ke through add() function ko call kiya h.
        
        
        deposite  = new JButton("Deposite");
        deposite.setBounds(145,342,125,24);
        deposite.addActionListener(this);
        image1.add(deposite);
        
        withdrawl  = new JButton("Cash Withdrawl");
        withdrawl.setBounds(305,342,125,24);
        withdrawl.addActionListener(this);
        image1.add(withdrawl);
        
        fastcash  = new JButton("Fast Cash");
        fastcash.setBounds(145,371,125,24);
        fastcash.addActionListener(this);
        image1.add(fastcash);
        
        ministatement  = new JButton("Mini Statement");
        ministatement.setBounds(305,371,125,24);
        ministatement.addActionListener(this);
        image1.add(ministatement);
        
        pinchange  = new JButton("PIN Change");
        pinchange.setBounds(145,400,125,24);
        pinchange.addActionListener(this);
        image1.add(pinchange);
        
        balance  = new JButton("Balance Enquiry");
        balance.setBounds(305,400,125,24);
        balance.addActionListener(this);
        image1.add(balance);
        
        exit  = new JButton("Exit");
        exit.setBounds(225,430,120,24);
        exit.addActionListener(this);
        image1.add(exit);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == exit){
            System.exit(0);
        }
        else if(e.getSource() == deposite){
            setVisible(false);
            new Deposite(pinnumber).setVisible(true);
        }
        else if (e.getSource() == withdrawl){
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        }  
        else if (e.getSource() == fastcash){
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        }
        else if(e.getSource() == pinchange){
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        }
        else if(e.getSource() ==  balance){
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }
        else if(e.getSource() == ministatement){
           // setVisible(false);
            new MiniStatement(pinnumber).setVisible(true);
        }
        
    }
    
    
    public static void main(String []args){

        new Transactions("");
    }

    
    
    
}
