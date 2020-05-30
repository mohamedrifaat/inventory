/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registeration;
import javax.swing.*;
import java.awt.*;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ahmed khaled
 */
public class supplier {

    public supplier() {
  
  
   
    
      
            JFrame sup = new JFrame("ADD SUPPLIER");
            sup.setResizable(false);
            sup.setSize(450, 500);
            sup.setBackground(Color.RED);
            sup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //..................................................
             JToolBar tool1 = new JToolBar();
               JButton back = new JButton("Back");
                 tool1.setRollover(true);
               tool1.setBounds(0, 0, 1000, 40);
                 //...........................back button................................//
               back.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            sup.setVisible(false);
            Admin admin2 = new Admin();
          }
      });    
                tool1.add(back);
                sup.add(tool1);
            JLabel l1 = new JLabel("SUPPLIER");
            l1.setBounds(150,0 , 150, 70);
            sup.add(l1);
            //.....................................
            JLabel l2 = new JLabel("ID");
            l2.setBounds(10,150 , 150, 70);
            sup.add(l2);
            //.......................................
            JTextField t1 = new JTextField();
            t1.setBounds(180 , 170 ,  150 , 35);
            sup.add(t1);
            //..........................................
            JLabel l3 = new JLabel("TELEPHONE ");
            l3.setBounds(10,100 , 150, 70);
            sup.add(l3);
            //.......................................
            JTextField t2 = new JTextField();
            t2.setBounds(180 , 120 ,  150 , 35);
            sup.add(t2);
            //..........................................
            JLabel l4 = new JLabel("NAME ");
            l4.setBounds(10,60 , 120, 70);
            sup.add(l4);
            //.......................................
            JTextField t3 = new JTextField();
            t3.setBounds(180 , 75 ,  150 , 35);
            sup.add(t3);
            //..........................................
            JButton b1 = new JButton("ADD");
            b1.setBounds(130, 290, 90, 40);
            sup.add(b1);
          
              
            sup.setLayout(null);
            sup.setVisible(true);
          b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e2){
                 
 
            try{  
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
            String url="jdbc:sqlserver://localhost:1433;databaseName=Project;user=admin;password=admin"; 
            Connection con = DriverManager.getConnection(url);
            String sql = "insert into supplier1 ( id, tp , name) values (?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, t1.getText());
            pstmt.setString(2, t2.getText());
            pstmt.setString(3, t3.getText());
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "          Successfully added");
            con.close();
            }catch(Exception e)
            { System.out.println(e);}  
  
      
   
   }});
   
}};
          
      

        
    
    

