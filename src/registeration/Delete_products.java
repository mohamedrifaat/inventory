/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registeration;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;

/**
 *
 * @author ahmed khaled
 */
public class Delete_products {
    private Statement state = null;
  private Connection connection;
   ResultSet s1 = null;
    public Delete_products() {
 JFrame n1= new JFrame("DELETE");
               n1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               n1.setResizable(false);
               n1.setSize(700, 900);
                 Font f1 = new Font("lol", Font.CENTER_BASELINE , 27);
      Font f2 = new Font("lol", Font.CENTER_BASELINE , 22);
      Font f3 = new Font("lol", Font.CENTER_BASELINE , 19);
               //..................................//
               JToolBar tool1 = new JToolBar();
               JButton back = new JButton("Back");
               JTextField product1= new JTextField();
               JLabel label2 = new JLabel("Product name");
               
               JButton submit1 = new JButton("Submit");
               //..................................//
               tool1.setRollover(true);
               tool1.setBounds(0, 0, 1000, 40);
               label2.setBounds(120, 100, 190, 80);
               label2.setFont(f3);
     
        
               product1.setBounds(260, 100, 250, 70);
               product1.setFont(f3);
               submit1.setBounds(240, 600, 200, 80);
               submit1.setFont(f3);
        //...........................back button................................//
               back.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            n1.setVisible(false);
            Admin admin2 = new Admin();
          }
      });    
               //......................submit button......................................//
               submit1.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
           try {
               // String prod = product1.getText();
              //double price = Integer.parseInt(price1.getText());
                try {
                      System.out.println(".....");
               Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
               String connectionUrl1 = "jdbc:sqlserver://localhost:1433;databaseName=Project;user=admin;password=admin";
               connection = DriverManager.getConnection(connectionUrl1);
               System.out.println("Done !!");
               java.sql.Statement state=connection.createStatement();
               state=connection.createStatement();
               String query = "DELETE FROM Product WHERE name = ?";
               PreparedStatement p1 = connection.prepareStatement(query);
               p1.setString(1, product1.getText());
               p1.executeUpdate();
                } catch (Exception e1) {
                    System.out.println(e1.getMessage());
                }
              
             
                  JFrame f = new JFrame();
                 JOptionPane.showMessageDialog(f,"       Successfuly deleted");}
            catch (Exception w) {
                
                 JFrame f1 = new JFrame();
                 JOptionPane.showMessageDialog(f1,"Please enter information Correctly");
            }      
              
        }
    });
               
               
                  tool1.add(back);
               n1.add(tool1);
               n1.add(product1);
               n1.add(label2);
               n1.setLayout(null);
               n1.setVisible(true);
               n1.add(submit1);
               n1.setResizable(false);
    }
    
}
