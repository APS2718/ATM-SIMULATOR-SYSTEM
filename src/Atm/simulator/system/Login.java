package Atm.simulator.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
 JButton login,clear,signup;
 JTextField cardtext;
 JPasswordField pintext;

    
 Login(){
     
        setTitle("Automated Teller Machine"); // frame ke heading set karne ke liye.
        
        setLayout(null);// components ko frame m knhi bhi place karne ke liye swing m bhut sare layouts hote h 
                            // ynha hm setLayout function m value null pass karke system ko yh bta rhe h ki hm system ke kisi bhi layout 
                            // k use nhi karna chahte h, hm khud k dwara bnaye gye custom layout k use karna chahte h.
                            
                            // ydi hm setLayout function m value null pass nhi krenge to swing m by default border layout m ek property 
                            // hoti h center, to hmara component frame m center align ho jayega. 
        
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));// ImageIcon class k object ko hm JLable m pass kr skte h kyoki yh swing package ke andr hote h
                                                                                               // lekin image class ke object ko JLabel m pass nhi kar skte h kyoki Image class awt package ke andr hoti h.
       
        Image img1 = img.getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT);
        ImageIcon img2 = new ImageIcon(img1);
        JLabel image = new JLabel(img2);
        image.setBounds(90,10,100,100); // yh hmne image ko frame m knhi bhi place karne ke liye setBounds function ke through
                                                       // custom layout bnaya h.
        add(image);
        
        
        // hm JLable ke through frame ke uper kuch bhi content likh skte h.
        
        JLabel text = new JLabel("WELCOME TO ATM");
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(250,50,400,40);
        add(text);  // kisi bhi chiz ko frame m add karne ke liye hm add() function k use karte h.
        
        JLabel cardno = new JLabel("Card No:");
        cardno.setFont(new Font("Raleway",Font.BOLD,28));
        cardno.setBounds(170,170,400,30);
        add(cardno);
        
        // frame m box bnane ke liye hm JTextField k use karte h.
        
        cardtext = new JTextField();
        cardtext.setBounds(320,170,230,30);
        cardtext.setFont(new Font("Arial",Font.BOLD,14));
        add(cardtext);
        
        JLabel pinno = new JLabel("Pin No:");
        pinno.setFont(new Font("Raleway",Font.BOLD,28));
        pinno.setBounds(170,230,250,30);
        add(pinno);
          
        // JPasswordField k use karke bhi hm box create kar skte h lekin isme box ke andr jo kuch bhi hm likhenge wo hidden hoga
        // means user use dekh nhi payega.
        
        pintext = new JPasswordField(); 
        pintext.setBounds(320,230,230,30);
        pintext.setFont(new Font("Arial",Font.BOLD,14));
        add(pintext);
        
        // frame m button bnane ke liye hm JButton k use karte h.
        
        // Buttons m koi action lgane ke liye hm ActionListener interface k use karte h jise hm login class m implement kiya h.
        
        clear = new JButton("CLEAR");
        clear.setBounds(320,300,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        
        login = new JButton("SIGN IN");
        login.setBounds(450,300,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        signup = new JButton("SIGN UP");
        signup.setBounds(320,360,230,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);
        
         
       
        getContentPane().setBackground(Color.YELLOW);
         
        setSize(850,480);
        setVisible(true);
        setLocation(270,120);
        
        
    }
 
  @Override
    public void actionPerformed(ActionEvent e) {  // buttons m click karne par kya action performe hona chahiye 
                                                  // use hm is method ke andr implement karte h.
       if(e.getSource() == clear){
           
           cardtext.setText("");  // box ke andr kuch bhi manually set karne ke liye hm setText function k use karte h.
           pintext.setText("");
           
       }  else if(e.getSource() == login){
           
           Conn c = new Conn();
           
           String cardnumber = cardtext.getText();
           String pinnumber = pintext.getText(); // isme hmare getText() function m jo line bni hui h uska matlab h ki jo pinnumber h wo password field m bna h 
                                           // password field m getText() function k use nhi kar skte h. to ynha hmara getText() function password field ke liye replicate ho gya h.
           
           String query = "select * from Login where CARD_Number = '"+cardnumber+"' and PIN_Number = '"+pinnumber+"'"; // ynha hm table se dataa nikal rhe h since yh ek ddl command h to ise run karn ke liye hm
                                                                                        // executeQuery() function k use karenge.
          
           
           try{
               
                ResultSet rs = c.s.executeQuery(query); // ab table se jo data aayega us data k datatype ResultSet Class hoti h Jaise kisi bhi Integer ko store karane liye Integer class hoti h
                                                         // yh ResultSet class, sql package ke andr hoti h to use hme import karana hoga.
               
                if(rs.next()){ // isme hm check kar rhe h ki ydi table se data aaya h y phir user successufully login hua h to 
                                     // hm Login frame ko bnd kr rhe h ar Transaction class k frame open kar rhe h.
                   setVisible(false);
                   new Transactions(pinnumber).setVisible(true);
                }   
                   else{
                         JOptionPane.showMessageDialog(null,"Incorrect Card Number or Pin Number");
                     }
                    
                   
           
           } catch(Exception ae){
               System.out.println(ae);
           }
           
       }   else if(e.getSource() == signup){
           
           setVisible(false);
           new Signup_one().setVisible(true);
           
           
       }                               
       
    }

    
    public static void main(String[]args){
        new Login();
    }    

   
}
