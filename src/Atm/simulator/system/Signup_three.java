package Atm.simulator.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Signup_three extends JFrame implements ActionListener { // JLabel,JFrame ke andr ar JFrame,swing package ke andr hota h.
    
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7; // JCheckBox class k use karke hm,jin boxes m hm right check bna ske aise boxes create kar skte h
                                   // isse hme ye pta chlega ki user ko in in chijo ki requirement h.
    JButton submit,cancle;
    String formno;
    
    
    Signup_three(String formno){
        this.formno = formno;
        
        getContentPane().setBackground(Color.YELLOW);
        
        setSize(850,820);
        setLocation(265,0);
        setVisible(true);
        
        setLayout(null);
        
        JLabel label = new JLabel("Page 3: Account Details");
        label.setBounds(300,40,400,40);
        label.setFont(new Font("Raleway",Font.BOLD,22));
        add(label);
        
        JLabel type = new JLabel("Account Type");
        type.setBounds(120,110,200,30);
        type.setFont(new Font("Raleway",Font.BOLD,22));
        add(type);
        
        r1 = new JRadioButton("Saving Account");
        r1.setBounds(120,155,150,20);
        r1.setFont(new Font("Raleway",Font.BOLD,16));
        r1.setBackground(Color.YELLOW);
        add(r1);
        
        r2 = new JRadioButton("Fixed Deposite Account");
        r2.setBounds(370,155,250,20);
        r2.setFont(new Font("Raleway",Font.BOLD,16));
        r2.setBackground(Color.YELLOW);
        add(r2);
        
        r3 = new JRadioButton("Current Account");
        r3.setBounds(120,195,160,20);
        r3.setFont(new Font("Raleway",Font.BOLD,16));
        r3.setBackground(Color.YELLOW);
        add(r3);
        
        r4 = new JRadioButton("Recurring Deposite Account");
        r4.setBounds(370,195,300,20);
        r4.setFont(new Font("Raleway",Font.BOLD,16));
        r4.setBackground(Color.YELLOW);
        add(r4);
        
        ButtonGroup groupaccount = new ButtonGroup();
        groupaccount.add(r1);
        groupaccount.add(r2);
        groupaccount.add(r3);
        groupaccount.add(r4);
        
        JLabel cardno = new JLabel("Card Number");
        cardno.setBounds(120,245,200,30);
        cardno.setFont(new Font("Raleway",Font.BOLD,22));
        add(cardno);
        
        JLabel number = new JLabel("XXXX-XXXX-XXXX-4184");
        number.setBounds(330,245,300,30);
        number.setFont(new Font("Raleway",Font.BOLD,22));
        add(number);
        
        JLabel carddetail = new JLabel("Your 16 Digit Card Number");
        carddetail.setBounds(120,275,300,20);
        carddetail.setFont(new Font("Raleway",Font.BOLD,12));
        add(carddetail);
        
        JLabel pin = new JLabel("PIN:");
        pin.setBounds(120,310,200,30);
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        add(pin);
        
        JLabel pinnumber = new JLabel("XXXX");
        pinnumber.setBounds(330,310,200,30);
        pinnumber.setFont(new Font("Raleway",Font.BOLD,22));
        add(pinnumber);
        
        JLabel pindetail = new JLabel("Your 4 Digit Card Password");
        pindetail.setBounds(120,340,300,20);
        pindetail.setFont(new Font("Raleway",Font.BOLD,12));
        add(pindetail);
                
        JLabel services = new JLabel("Services Required:");
        services.setBounds(120,390,200,30);
        services.setFont(new Font("Raleway",Font.BOLD,22));
        add(services);
        
        c1 = new JCheckBox("ATM CARD");
        c1.setBounds(120,435,200,30);
        c1.setBackground(Color.YELLOW);
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        add(c1);
        
        c2 = new JCheckBox("Internet Banking");
        c2.setBounds(370,435,200,30);
        c2.setBackground(Color.YELLOW);
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        add(c2);
        
        c3 = new JCheckBox("Mobile Banking");
        c3.setBounds(120,485,200,30);
        c3.setBackground(Color.YELLOW);
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        add(c3);
        
        c4 = new JCheckBox("EMAIL & SMS Alerts");
        c4.setBounds(370,485,200,30);
        c4.setBackground(Color.YELLOW);
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        add(c4);
        
        c5 = new JCheckBox("Cheque Box");
        c5.setBounds(120,535,200,30);
        c5.setBackground(Color.YELLOW);
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        add(c5);
        
        c6 = new JCheckBox("E-Statement");
        c6.setBounds(370,535,200,30);
        c6.setBackground(Color.YELLOW);
        c6.setFont(new Font("Raleway",Font.BOLD,16));
        add(c6);
        
        c7 = new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge.");
        c7.setBounds(120,595,600,30);
        c7.setBackground(Color.YELLOW);
        c7.setFont(new Font("Raleway",Font.BOLD,12));
        add(c7);
        
        cancle = new JButton("Cancle");
        cancle.setBounds(250,645,100,30);
        cancle.setBackground(Color.BLACK);
        cancle.setForeground(Color.WHITE);
        cancle.setFont(new Font("Raleway",Font.BOLD,14));
        cancle.addActionListener(this);
        add(cancle);
        
        submit = new JButton("Submit");
        submit.setBounds(420,645,100,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway",Font.BOLD,14));
        submit.addActionListener(this);
        add(submit);
        
        
    }
    

     @Override
    public void actionPerformed(ActionEvent e) {
      
        if(e.getSource()== submit){
            String accounttype = null;
            
            if(r1.isSelected()) // isSelected() function ke help se hm check kar rhe ki r1 select hua h ki nhi ydi select hua h to accounttype m hm Saving Account dal denge isi trh sb m h.
                accounttype = "Saving Account";
            
            else if(r2.isSelected())
                accounttype = "Fixed Deposite Account";
            
            else if(r3.isSelected())
                accounttype = "Current Account";
            
            else if(r4.isSelected())
                accounttype = "Recurring Deposite Account";
            
            
            Random random = new Random();
            String cardnumber = "" + Math.abs((random.nextLong() % 90000000L) + 5040936000000000L); // isme hm chah rhe h ki hmare atm card ke jo shru ke number h wo hmesha shame ho 
                                                                                     // to use hmne  yh 5040936000000000 set kar diya h.
            
            String pinnumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L); //isse hme hmara pin number milega.
            
            
            String  services = "";
            if(c1.isSelected())
                services = services + " ATM CARD";
            
            else if(c2.isSelected())
                services = services + " Internet Banking";
            
            else if(c3.isSelected())
                services = services + " Mobile Banking";
            
            else if(c4.isSelected())
                services = services + " EMAIL & SMS Alerts";
            
            else if(c5.isSelected())
                services = services + " Cheque Box";
            
            else if(c6.isSelected())
                services = services + " E-Statement";
            
            
            try{
                if(accounttype.equals(""))
                    
                    JOptionPane.showMessageDialog(null,"Account Type is Required");
                
                else{ 
                    
                    Conn conn = new Conn();
                    
                    String query1 = "insert into Signup_three values('"+formno+"','"+accounttype+"','"+cardnumber+"','"+pinnumber+"','"+services+"')";
                    String query2 = "insert into Login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);
                    
                    JOptionPane.showMessageDialog(null,"CARD Number: "+ cardnumber + "\n PIN: "+ pinnumber);
                    
                    setVisible(false);
                    new Deposite(pinnumber).setVisible(true);// ab hm ynha yh bta rhe h ki jaise he user ne puri trh se signup kar liya to use ab 
                                                             // apna account m user ko kuch paise deposite karna h,user 0rs se account nhi khol skta h
                }
                
                    
                
            } catch(Exception ae){
                System.out.println(ae);
            }
        }
        else if(e.getSource()== cancle){
            setVisible(false);
            new Login();
            
        }
        
    }
    
    public static void main (String[]args){
     
        new Signup_three("");
   
    }

   
}
