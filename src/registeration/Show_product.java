/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registeration;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author ahmed khaled
 */
public class Show_product {
     private Connection connection;
     ResultSet s1 = null;
    public  ArrayList<Product> productlist(){
        ArrayList<Product> productlist = new ArrayList<>();
        try {
              Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
               String connectionUrl1 = "jdbc:sqlserver://localhost:1433;databaseName=Project;user=admin;password=admin";
               connection = DriverManager.getConnection(connectionUrl1);
               System.out.println("Done !!");
               java.sql.Statement state=connection.createStatement();
               state=connection.createStatement();
               String query = "select * from Product";
               Statement State = connection.createStatement();
               s1=state.executeQuery(query);
               Product product;
              
               while(s1.next()){
                   product = new Product(s1.getInt("price"),s1.getString("name"),s1.getString("Exp_date"));
                   productlist.add(product);
                   //if(exp.compareTo(s1.getDate("Exp_date"))==0){
                  //JOptionPane.showMessageDialog(null,"hhhhhhhhhhhhhhhhhhhhhhhhhh");
                   //}
               }  
        } catch (Exception e) {
               System.out.println(e.getMessage());
        }
        return productlist;
  }
    public Show_product(){
       JFrame frame = new JFrame("SHOW");
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setResizable(false);
       frame.setSize(700, 700);
       Font f1 = new Font("lol", Font.CENTER_BASELINE , 27);
       Font f2 = new Font("lol", Font.CENTER_BASELINE , 22);
       Font f3 = new Font("lol", Font.CENTER_BASELINE , 15);
      JTable table = new JTable(0,3);
      table.setFont(f3);
      table.setBounds(100, 100, 550, 350);
       JToolBar tool1 = new JToolBar();
       JButton back = new JButton("Back");
       tool1.setRollover(true);
       tool1.setBounds(0, 0, 1000, 40);
       JButton notify= new JButton("notify");
       notify.setBounds(260, 500, 150, 70);
       
           back.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.setVisible(false);
            Admin admin2 = new Admin();
          }
       });
       ArrayList<Product> list = productlist();
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        Object[] row = new Object[3];
        row[0]="(NAME)";
        row[1]="(PRICE)";
        row[2]="(EXP_DATE)";
        model.addRow(row);
        int exp = 2022;
      
       notify.addActionListener(new ActionListener() {

           @Override
           public void actionPerformed(ActionEvent e) {
               try {
                
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
               String connectionUrl1 = "jdbc:sqlserver://localhost:1433;databaseName=Project;user=admin;password=admin";
               connection = DriverManager.getConnection(connectionUrl1);
               System.out.println("Done !!");
               java.sql.Statement state=connection.createStatement();
               state=connection.createStatement();
               String query = "select * from Product";
               Statement State = connection.createStatement();
               s1=state.executeQuery(query);
             
             
              while(s1.next()){                  
                      int noti = Integer.parseInt(s1.getString("Exp_date"));
                   if(exp>noti&&noti<2019){
                  JOptionPane.showMessageDialog(null, s1.getString("name")+" Expired");
                  System.out.println(s1.getString("Exp_date")); 
                  System.out.println(exp);
                   }
                   else if(exp>noti&&noti>=2019){
                  JOptionPane.showMessageDialog(null, s1.getString("name")+" will expire soon");
                  System.out.println(s1.getString("Exp_date")); 
                  System.out.println(exp);
                   }
               
        }
               } catch (Exception e5) {
                   System.out.println(e5.getMessage());
               }
           }
       });
        
       
        for(int i = 0;i<list.size();i++){
            row[0]=list.get(i).getName();
    
            row[1]=list.get(i).getPrice();
            row[2]=list.get(i).getExpire_date();
            model.addRow(row);
        }
       JScrollPane sp=new JScrollPane(table);
       tool1.add(back);
       frame.add(tool1);
       frame.add(notify);
       frame.add(table);
       frame.setLayout(null);
       frame.setVisible(true);
       frame.setResizable(true);
       frame.setResizable(false);
}
}

    
    
    
    
//      @Override
//           public void actionPerformed(ActionEvent e) {
//           
//           }