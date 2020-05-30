/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registeration;

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SearchProd {
    public  SearchProd(){
    JFrame s1= new JFrame("search");
    s1.setResizable(false);
        s1.setSize(350, 300);
        s1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        s1.setVisible(true);
        JButton search2 = new JButton("Search ");
        search2.setBounds(150, 160, 90, 60);
        s1.add(search2);
        s1.setLayout(null);
         JLabel l2 = new JLabel("Category");
        l2.setBounds(10,60 , 150, 70);
         s1.add(l2);
         JTextField t1 = new JTextField();
        t1.setBounds(150, 80, 400, 30);
        s1.add(t1);
        
            String cat = t1.getText();
        
        
        search2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

                    String url = "jdbc:sqlserver://localhost:1433;databaseName=Project;user=admin;password=admin";
                    Connection con = DriverManager.getConnection(url);
               
                     Statement stmt = con.createStatement();
                     String cat = t1.getText();
                        ResultSet res = stmt.executeQuery("SELECT name from Product WHERE cat='"+cat+"'");
 
                        JFrame or= new JFrame("search");
                        or.setLayout(new FlowLayout());
                        or.setSize(300, 150);
                         JLabel ord2=new JLabel("Result : ");
                          or.add(ord2);
                       while (res.next()) {
                           
                  String request=res.getString("name");
                   JLabel ord=new JLabel(request+" ,  ");
                   or.add(ord);
                   
                 
                    }   
                       or.setVisible(true);

                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }

            }
        });
        
        
        
        
        
        
        
        
        
        
        
        
        
         
        
      
        
}}
