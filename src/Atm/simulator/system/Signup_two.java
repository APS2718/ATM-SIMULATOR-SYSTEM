package Atm.simulator.system;

import java.util.*;
import javax.swing.*;
import javax.swing.JComboBox;
import java.awt.*;
import java.awt.event.*;


public class Signup_two extends JFrame implements ActionListener {
    
    String formno;
    JTextField pantext,aadhartext;
    JButton next;
    JRadioButton yes,no,yes1,no1;
    JComboBox religionDrop,categoryDrop,incomeDrop,educationalqualificationDrop,occupationDrop;
    
    Signup_two(String formno){
        
        this.formno = formno;
        
        getContentPane().setBackground(Color.YELLOW);
        
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        
        setSize(850,740);
        setLocation(280,0);
        setVisible(true);
        setLayout(null);
        
        JLabel additionaldetails = new JLabel("Page 2: Additional Details");
        additionaldetails.setBounds(290,80,400,30);
        additionaldetails.setFont(new Font("Raleway",Font.BOLD,22));
        add(additionaldetails);
        
        JLabel religion = new JLabel("Religion:");
        religion.setBounds(100,140,100,30);
        religion.setFont(new Font("Raleway",Font.BOLD,20));
        add(religion);
        
        JLabel category = new JLabel("Category:");
        category.setBounds(100,190,200,30);
        category.setFont(new Font("Raleway",Font.BOLD,20));
        add(category);
        
        JLabel income = new JLabel("Income:");
        income.setBounds(100,240,200,30);
        income.setFont(new Font("Raleway",Font.BOLD,20));
        add(income);
        
        JLabel education = new JLabel("Educational");
        education.setBounds(100,290,200,30);
        education.setFont(new Font("Raleway",Font.BOLD,20));
        add(education);
        
        JLabel qualification = new JLabel("Qualification:");
        qualification.setBounds(100,315,200,30);
        qualification.setFont(new Font("Raleway",Font.BOLD,20));
        add(qualification);
        
        JLabel occupation = new JLabel("Occupation:");
        occupation.setBounds(100,365,200,30);
        occupation.setFont(new Font("Raleway",Font.BOLD,20));
        add(occupation);
        
        JLabel pan = new JLabel("PAN Number:");
        pan.setBounds(100,415,200,30);
        pan.setFont(new Font("Raleway",Font.BOLD,20));
        add(pan);
        
        JLabel aadhar = new JLabel("AADHAR Number:");
        aadhar.setBounds(100,465,200,30);
        aadhar.setFont(new Font("Raleway",Font.BOLD,20));
        add(aadhar);
        
        JLabel seniorcitizen = new JLabel("Senior Citizen:");
        seniorcitizen.setBounds(100,515,200,30);
        seniorcitizen.setFont(new Font("Raleway",Font.BOLD,20));
        add(seniorcitizen);
        
        yes = new JRadioButton("Yes");
        yes.setBounds(300,515,60,30);
        yes.setFont(new Font("Raleway",Font.BOLD,15));
        yes.setBackground(Color.YELLOW);
       // yes.setForeground(Color.BLACK);
        add(yes);
        
        no = new JRadioButton("No");
        no.setBounds(420,515,60,30);
        no.setFont(new Font("Raleway",Font.BOLD,15));
        no.setBackground(Color.YELLOW);
       // no.setForeground(Color.BLACK);
        add(no);
        
        ButtonGroup seniorcitizengroup = new ButtonGroup();
        seniorcitizengroup.add(yes);
        seniorcitizengroup.add(no);
       
        JLabel existingaccount = new JLabel("Existing Account:");
        existingaccount.setBounds(100,565,200,30);
        existingaccount.setFont(new Font("Raleway",Font.BOLD,20));
        add(existingaccount);
        
        yes1 = new JRadioButton("Yes");
        yes1.setBounds(300,565,60,30);
        yes1.setFont(new Font("Raleway",Font.BOLD,15));
        yes1.setBackground(Color.YELLOW);
       // yes.setForeground(Color.BLACK);
        add(yes1);
        
        no1 = new JRadioButton("No");
        no1.setBounds(420,565,60,30);
        no1.setFont(new Font("Raleway",Font.BOLD,15));
        no1.setBackground(Color.YELLOW);
       // no.setForeground(Color.BLACK);
        add(no1);
        
        ButtonGroup existingaccountgroup = new ButtonGroup();
        existingaccountgroup.add(yes1);
        existingaccountgroup.add(no1);
        
        // ab sb ke liye JTextField k use karke hm box create krenge jisme hm apna koi bhi data dal ske.
        
        JTextField religiontext = new JTextField();
        religiontext.setBounds(300,140,400,30);
        religiontext.setFont(new Font("Raleway",Font.BOLD,20));
        add(religiontext);
        
        // dropdown functonality ko dalne ke liye hm JComboBox class k use karte h jiske objext create karke hm dropdown
        // functionality ko dal skte h.
        
        String valReligion[] = {"Hindu","Muslim","Sikh","Christian","Other"};// since hme religiondropdown m string values pass karni 
                                                                  // so hmne ek String array create kri h.
        religionDrop = new JComboBox(valReligion);
        religionDrop.setBounds(300,140,420,30);
        religionDrop.setBackground(Color.WHITE);
        add(religionDrop);
        
        JTextField categorytext = new  JTextField();
        categorytext.setBounds(300,190,400,30);
        add(categorytext);
        
        String valCategory[] = {"General","OBC","SC","ST","Other"};
        
        categoryDrop = new JComboBox(valCategory);
        categoryDrop.setBounds(300,190,420,30);
        categoryDrop.setBackground(Color.WHITE);
        add(categoryDrop);
        
        JTextField incometext = new JTextField();
        incometext.setBounds(300,240,400,30);
        add(incometext);
        
        String valIncome[] = {"Null","< 1,50,000","< 2,50,000","< 5,00,000","Upto 10,00,000"}; 
        
        incomeDrop = new JComboBox(valIncome);
        incomeDrop.setBounds(300,240,420,30);
        incomeDrop.setBackground(Color.WHITE);
        add(incomeDrop);
        
        JTextField educationlaqualificationtext = new JTextField();
        educationlaqualificationtext.setBounds(300,315,400,30);
        add(educationlaqualificationtext);
        
        String valeducationalqulification[] = {"Non-Gradution","UnderGraduate","Graduate","Post-Gradution","Others"};
        
        educationalqualificationDrop = new JComboBox(valeducationalqulification);
        educationalqualificationDrop.setBounds(300,315,420,30);
        educationalqualificationDrop.setBackground(Color.WHITE);
        add(educationalqualificationDrop);
        
        JTextField occupationtext = new JTextField();
        occupationtext.setBounds(300,365,400,30);
        add(occupationtext);
        
        String valOccupation[] = {"Salaried","Self-Employed","Business","Student","Others"};
        
        occupationDrop = new JComboBox(valOccupation);
        occupationDrop.setBounds(300,365,420,30);
        occupationDrop.setBackground(Color.WHITE);
        add(occupationDrop);
        
        pantext = new JTextField();
        pantext.setBounds(300,415,420,30);
        pantext.setFont(new Font("Raleway",Font.BOLD,14));
        add(pantext);
        
        aadhartext = new JTextField();
        aadhartext.setBounds(300,465,420,30);
        aadhartext.setFont(new Font("Raleway",Font.BOLD,14));
        add(aadhartext);
        
        next = new JButton("Next");
        next.setBounds(620,645,80,30);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);
        
                              
    }
    
    
     @Override
    public void actionPerformed(ActionEvent e) {
        
        String sreligion = (String)religionDrop.getSelectedItem(); // getSelectedItem() function value ko as a object lata h to use hmne string m store karne ke liye use string m typecast karna pdega.
        String scategory = (String)categoryDrop.getSelectedItem();
        String sincome = (String)incomeDrop.getSelectedItem();
        String seducation = (String)educationalqualificationDrop.getSelectedItem();
        String soccupation = (String)occupationDrop.getSelectedItem();
        String span = pantext.getText();
        String saadhar = aadhartext.getText();
        String seniorcitizen = null;
        if(yes.isSelected()){
            seniorcitizen = "Yes";    
        }
        else if(no.isSelected()){
            seniorcitizen = "No";
        }
        
        
        String existingaccount = null;
        if(yes1.isSelected()){
            existingaccount = "Yes";
        }
        else if(no1.isSelected()){
            existingaccount = "No";
        }
        
        try{
            
                 Conn c = new Conn();
                 String query = "insert into Signup_two values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadhar+"','"+seniorcitizen+"','"+existingaccount+"')";
                 
                 c.s.executeUpdate(query);// ynha hmne Conn class k object bnaya h jiske through hm statement class ko access kar p rhe h   
                                              // ar statement class ke object ke through hm ek dml command(executeUpdate) ko run kar rhe h jisme hmne apni query ko pass kar diya
                 setVisible(false);
                
                new Signup_three(formno).setVisible(true);
                                              
        }catch(Exception ae){
            System.out.println(ae);
        }
        
        
    }
    public static void main(String[]args){
    new Signup_two("");
    }

   
    
}
