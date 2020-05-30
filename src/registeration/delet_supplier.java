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
public class delet_supplier {

    public delet_supplier() {
    
  
        
            JFrame sup = new JFrame("SUPPLIER");
            sup.setResizable(false);
            sup.setSize(350, 300);
            sup.setBackground(Color.RED);
            sup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //..................................................
          
            //.....................................
            JLabel l2 = new JLabel("ID");
            l2.setBounds(10,50 , 150, 70);
            sup.add(l2);
            //.......................................
            JTextField t1 = new JTextField();
            t1.setBounds(180 , 70 ,  150 , 35);
            sup.add(t1);
            //..........................................
           
            //.......................................
            
         
            //.......................................
              JToolBar tool1 = new JToolBar();
               JButton back = new JButton("Back");
                tool1.setRollover(true);
               tool1.setBounds(0, 0, 1000, 40);
              back.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            sup.setVisible(false);
            Admin admin2 = new Admin();
          }
      });    
                tool1.add(back);
               sup.add(tool1);
            //..........................................

            JButton b1 = new JButton("DELETE");
            b1.setBounds(120, 170, 90, 40);
            sup.add(b1);
            
             
            sup.setLayout(null);
            sup.setVisible(true);
              b1.addActionListener(new ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt){ 
            try{  
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
               String url="jdbc:sqlserver://localhost:1433;databaseName=Project;user=admin;password=admin"; 
               Connection con = DriverManager.getConnection(url);
            String sql = "delete from supplier1 where id = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, t1.getText());
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "deleted successfully");
            con.close();
            }catch(Exception e)
            { System.out.println(e);}  
  
      
   
}});
          
    }}


