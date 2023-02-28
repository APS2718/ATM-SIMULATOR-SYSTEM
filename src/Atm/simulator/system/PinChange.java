package Atm.simulator.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener {
    
    
    JPasswordField pinfield,repinfield;
    JButton change,back;
    String pinnumber;
    
    PinChange( String pinnumber){
        
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
        
        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setBounds(225,245,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,13));
        image1.add(text);   // kyoki hm image ke upr apna koi text dhikhana chahte h to isliye hmne image ke through add() function ko call kiya h.
        
        
        JLabel pintext = new JLabel("New PIN:");
        pintext.setBounds(140,290,180,25);
        pintext.setFont(new Font("System",Font.BOLD,13));
        pintext.setForeground(Color.WHITE);
        image1.add(pintext);
        
        pinfield = new  JPasswordField();
        pinfield.setBounds(265,290,165,25);
        pinfield.setFont(new Font("Raleway",Font.BOLD,13));
        pinfield.setForeground(Color.BLACK);
        image1.add(pinfield);
        
        JLabel repintext = new JLabel("Re-Enter New PIN:");
        repintext.setBounds(140,330,220,25);
        repintext.setFont(new Font("System",Font.BOLD,13));
        repintext.setForeground(Color.WHITE);
        image1.add(repintext);
        
        repinfield = new  JPasswordField();
        repinfield.setBounds(265,330,165,25);
        repinfield.setFont(new Font("Raleway",Font.BOLD,13));
        repinfield.setForeground(Color.BLACK);
        image1.add(repinfield);
        
        
        change  = new JButton("CHANGE");
        change.setBounds(305,400,125,24);
        change.addActionListener(this);
        image1.add(change);
        
        back  = new JButton("BACK");
        back.setBounds(305,430,125,24);
        back.addActionListener(this);
        image1.add(back);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == change){
        
        try{
            String pin = pinfield.getText();
            String repin = repinfield.getText();
            
            if(!pin.equals(repin)){
                JOptionPane.showMessageDialog(null,"Entered PIN does not match");
                return ;
            }
            
            if(pin.equals("")){
                
                JOptionPane.showMessageDialog(null,"Please enter new PIN");
                return ;
                
            }
            
            if(repin.equals("")){
                JOptionPane.showMessageDialog(null,"Please re-enter new PIN");
                return ;
                
            }
            
            Conn c = new Conn();
            String query1 = "update Bank set PIN_Number = '"+repin+"'where PIN_Number = '"+pinnumber+"'";
            String query2 = "update Login set PIN_Number = '"+repin+"'where PIN_Number = '"+pinnumber+"'";
            String query3 = "update Signup_three set PIN_Number = '"+repin+"'where PIN_Number = '"+pinnumber+"'";
            
            c.s.executeUpdate(query1);
             c.s.executeUpdate(query2);
              c.s.executeUpdate(query3);
              
              JOptionPane.showMessageDialog(null,"PIN changed successfully");
              
              setVisible(false);
              new Transactions(repin).setVisible(true);
            
            
            
        }
        catch(Exception ae){
        System.out.println(ae);
        
    }
        
    }else{
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
    
    public static void main (String [] args){
        
        new PinChange("");
        
    }
    
}
