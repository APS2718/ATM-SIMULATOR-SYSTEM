package Atm.simulator.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class Signup_one extends JFrame implements ActionListener {
    
    long random;
    JTextField nametext,fnametext,emailtext,addresstext,citytext,statetext,pincodetext;
    JRadioButton male,female,married,unmarried,other;
    JDateChooser date;
    JButton next;
    
    Signup_one(){
        
        getContentPane().setBackground(Color.YELLOW);// Color class awt package ke andr hoti h to agr hme Color class k use
                                                      // karna h to hme awt package ko import krna pdega.
        
        setSize(850,740);
        setLocation(280,0);
        setVisible(true);
        setLayout(null);
        
                                   //Random class k use hm random number print karane ke liye karte h. 
        Random ran = new Random(); // Random class hmari util package ke andr hoti h to agr hme Random class k use karna h
                                  //to hme util package ko import karana pdega.
                                  
        random = (Math.abs(ran.nextLong() % 9000L)+1000L); // yh hme chaar digit k random number dega.
        
        JLabel formno = new JLabel("APPLICATION FORM NO. "+random); // ynha hmne random number ki value ko pass kr diya h.
        formno.setBounds(140,20,600,40);
        formno.setFont(new Font("Raleway",Font.BOLD,38));
        add(formno);
        
        JLabel personaldetails = new JLabel("Page 1: Personal Details");
        personaldetails.setBounds(290,80,400,30);
        personaldetails.setFont(new Font("Raleway",Font.BOLD,22));
        add(personaldetails);
        
        JLabel name = new JLabel("Name:");
        name.setBounds(100,140,100,30);
        name.setFont(new Font("Raleway",Font.BOLD,20));
        add(name);
        
        JLabel fname = new JLabel("Father's Name:");
        fname.setBounds(100,190,200,30);
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        add(fname);
        
        JLabel dob = new JLabel("Date of Birth:");
        dob.setBounds(100,240,200,30);
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        add(dob);
        
        JLabel gender = new JLabel("Gender:");
        gender.setBounds(100,290,200,30);
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        add(gender);
        
        JLabel email = new JLabel("Email Address:");
        email.setBounds(100,340,200,30);
        email.setFont(new Font("Raleway",Font.BOLD,20));
        add(email);
        
        JLabel marital = new JLabel("Marital Status:");
        marital.setBounds(100,390,200,30);
        marital.setFont(new Font("Raleway",Font.BOLD,20));
        add(marital);
        
        JLabel address = new JLabel("Address:");
        address.setBounds(100,440,200,30);
        address.setFont(new Font("Raleway",Font.BOLD,20));
        add(address);
        
        JLabel city = new JLabel("City:");
        city.setBounds(100,490,200,30);
        city.setFont(new Font("Raleway",Font.BOLD,20));
        add(city);
        
        JLabel state = new JLabel("State:");
        state.setBounds(100,540,200,30);
        state.setFont(new Font("Raleway",Font.BOLD,20));
        add(state);
        
        JLabel pincode = new JLabel("Pin Code:");
        pincode.setBounds(100,590,200,30);
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        add(pincode);
        
        // ab sare labels ke liye box create krenge jiske liye JTextField class k use krenge.
        
        nametext = new JTextField();
        nametext.setBounds(300,140,400,30);
        nametext.setFont(new Font("Raleway",Font.BOLD,14));
        add(nametext);
        
        fnametext = new JTextField();
        fnametext.setBounds(300,190,400,30);
        fnametext.setFont(new Font("Raleway",Font.BOLD,14));
        add(fnametext);
        
        emailtext = new JTextField();
        emailtext.setBounds(300,340,400,30);
        emailtext.setFont(new Font("Ralway",Font.BOLD,14));
        add(emailtext);
        
        addresstext = new JTextField();
        addresstext.setBounds(300,440,400,30);
        addresstext.setFont(new Font("Raleway",Font.BOLD,14));
        add(addresstext);
        
        citytext = new JTextField();
        citytext.setBounds(300,490,400,30);
        citytext.setFont(new Font("Raleway",Font.BOLD,14));
        add(citytext);
        
        statetext = new JTextField();
        statetext.setBounds(300,540,400,30);
        statetext.setFont(new Font("Raleway",Font.BOLD,14));
        add(statetext);
        
        pincodetext = new JTextField();
        pincodetext.setBounds(300,590,400,30);
        pincodetext.setFont(new Font("Raleway",Font.BOLD,14));
        add(pincodetext);
        
        // since hme date of birth m calendar lagana h to iske liye hm JDateChooser class k use karenge ar kyoki 
        //JDateChooser class, jar file JCalendar ke andr hoti h to hmne sbse phle libraries m jakarke apne system se
        // browse karke jar file JCalendar ko libraries m import karaya phir JDatechooser class ko hmne class m import kraya
        // jisse hm JDateChooser class k object create karke date of birth m calaendar add kar skte h.
       
        
        date = new JDateChooser();
        date.setBounds(300,240,200,30);
        add(date);
        
        // gender m  ar marital m radiobuttons lagane ke liye hm JRadioButton class k use krenge.
        
        male = new JRadioButton("Male");
        male.setBounds(300,290,60,30);
        male.setBackground(Color.YELLOW);
        add(male);
        
        female = new JRadioButton("Female");
        female.setBounds(420,290,80,30);
        female.setBackground(Color.YELLOW);
        add(female);
        
        ButtonGroup gendergroup = new ButtonGroup(); // JRadioButtons male and female ko group m karne ke liye means jaise he
        gendergroup.add(male);                    // male select kre to female deselect ho jaye ar jaise he female select kre
        gendergroup.add(female);                  // to male daselect ho jaye.
       
        married = new JRadioButton("Married");
        married.setBounds(300,390,100,30);
        married.setBackground(Color.YELLOW);
        add(married);
        
        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(450,390,100,30);
        unmarried.setBackground(Color.YELLOW);
        add(unmarried);
        
        other = new JRadioButton("Other");
        other.setBounds(630,390,100,30);
        other.setBackground(Color.YELLOW);
        add(other);
        
        ButtonGroup maritalgroup = new ButtonGroup();
        maritalgroup.add(married);
        maritalgroup.add(unmarried);
        maritalgroup.add(other);
        
        next = new JButton("Next");
        next.setBounds(620,645,80,30);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);
        
           
    }
    
     @Override
    public void actionPerformed(ActionEvent e) {
        
        String formno = "" + random;
        String name = nametext.getText(); // getText() function ke help se hm box ke andr jo kuch bhi likha h use data ko access kar skte h.
        String fname = fnametext.getText();
        String dob  =  ((JTextField)date.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected())
            gender = "Male";
        
        else if(female.isSelected())
            gender = "Female";
        
        String marital = null;
        if(married.isSelected())
            marital = "Married";
        
        else if(unmarried.isSelected())
            marital = "Unmarried";
        
        else if(other.isSelected())
            marital = "Other";
        
        String email = emailtext.getText();
        String address = addresstext.getText();
        String city = citytext.getText();
        String state = statetext.getText();
        String pincode = pincodetext.getText();
        
        try{
            if(name.equals("")){ // hm check kar rhe h ki name == null means user ne koi nam nhi dala h blank chod diya h.
                
                JOptionPane.showMessageDialog(null, "Name is required"); // ynha JOptionPane ek class h jiska use karke 
                                                    // hm user ko ek popup dikha skte h, isme ek function hota h ShowMessageDialog()
                                                    // jisme andr hm apna message likhte h jo hm user ko dhikhana chahte h.
            }  
            else {
                 Conn c = new Conn();
                 String query = "insert into Signup_one values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pincode+"','"+state+"')";
                 
                 c.s.executeUpdate(query);// ynha hmne Conn class k object bnaya h jiske through hm statement class ko access kar p rhe h   
                                              // ar statement class ke object ke through hm ek dml command(executeUpdate) ko run kar rhe h jisme hmne apni query ko pass kar diya
                setVisible(false);
                
                new Signup_two(formno).setVisible(true);
                                              
            
            } 
            
        }catch(Exception ae){
            System.out.println(ae);
        }
        
        
    }
    
    
    public static void main(String[]args){
        new Signup_one();
    }

   
}
