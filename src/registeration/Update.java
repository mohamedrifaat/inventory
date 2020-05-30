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
public class Update {
    private String supplier;
    private int telephone;

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public Update() {
    
   
 
        JFrame sup = new JFrame("Update");
            sup.setResizable(false);
            sup.setSize(400, 500);
            sup.setBackground(Color.RED);
            sup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //..................................................
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
     //........................................................//          
            JLabel l1 = new JLabel("SUPPLIER");
            l1.setBounds(150,0 , 150, 70);
            sup.add(l1);
            //.....................................
            JLabel l2 = new JLabel("Supplier Name");
            l2.setBounds(10,60 , 120, 70);
            sup.add(l2);
            //.......................................
            JTextField t1 = new JTextField();
            t1.setBounds(180 , 75 ,  150 , 35);
            sup.add(t1);
            //..........................................
           
            JTextField t2 = new JTextField();
            t2.setBounds(180 , 120 ,  150 , 35);
            sup.add(t2);
            JLabel l3 = new JLabel("NEW ID ");
            l3.setBounds(10,100 , 150, 70);
            sup.add(l3);
            //.......................................
            
               JLabel l4 = new JLabel("NEW Telephone");
            l4.setBounds(10,150 , 150, 70);
            sup.add(l4);
            JTextField t3 = new JTextField();
            t3.setBounds(180 , 170 ,  150 , 35);
            sup.add(t3);
            //..........................................
            
            JButton b1 = new JButton("SUBMIT");
            b1.setBounds(130, 290, 90, 40);
            sup.add(b1);
            
             
            sup.setLayout(null);
            sup.setVisible(true);
            b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e2){
                  try {
                      try {
                            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    String url="jdbc:sqlserver://localhost:1433;databaseName=Project;user=admin;password=admin";
                    Connection con = DriverManager.getConnection(url);
                    String query="UPDATE supplier1 set id=?,tp=? where name = ?";
                    PreparedStatement pst = con.prepareStatement(query);
                    pst.setString(1, t2.getText());
                    pst.setString(2, t3.getText());
                    pst.setString(3, t1.getText());
                           
                    pst.executeUpdate();
                      } catch (Exception e1) {
                    System.out.println(e1.getMessage());
                      JOptionPane.showMessageDialog(null,"Please enter information Correctly");
                }
                  
                   JOptionPane.showMessageDialog(null, "          Successfully updated");
                  } 
                   catch (Exception w) {
                
                 JFrame f1 = new JFrame();
                 JOptionPane.showMessageDialog(f1,"Please enter information Correctly");
            }      
          
            
            }});  
            
            }
}  