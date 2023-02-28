// yh class hmari database se connection establish krne k kam kregi.
package Atm.simulator.system;

import java.sql.*;


public class Conn {
    
    Connection c;    // ynha Connection ek class h jiska hmne object bnaya h.
    Statement s ;   // ynha statement ek class h jiska hmne object bnaya h. iski help se hm apni query ko execute kar skte h.
    
    public Conn(){     // since mysql ek external entity h to error aane ke chances jyada rhte h runtime m,compile time m nhi
                     // to un runtime m aane wale error ko handle krne ke liye hm ynha exception handling kr rhe h.
        try{
         //   Class.forName(com.mysql.cj.jdbc.Driver);// yh JDBC connctivity k first step h Ragister the driver.
                                                      // isme Class ek Class k nam h jiske ek static method hoti h forname()
                                                      //jiske andr hm apne driver k nam likh skte h.
                                                      // isme com.mysql.cj.jdbc.Driver  hmare driver k nam h.
                                                      // hmara jo driver h wo mysql connector java library ke andar hota h jise hmne import kar liya h. 
                                           //to ab java us library ke classpath ke andr se directly hmare driver ko access kar skta h,hme apne driver ko explicitly declare karne ki koi jrurat nhi h.  
           
         // step 2: create connnction   
         
        c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","Abhishek"); // ynha DriverManager ek class h jiske andr ek function hota h
                                                            // getConnction(), jiske andr hme ek url ko pass karna hota h which is a String
        
        // step 3: create statement
        
        s = c.createStatement(); // isme hmne connection ke through ek function createStatement() ko call kiya h;
        
        }     catch(Exception e){
            System.out.println(e);
        }
    
}
    
}
