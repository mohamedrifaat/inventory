/*
 * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registeration;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author ahmed khaled
 */
public class show_supplier {
   

 

     private Connection connection;
      
     ResultSet s1 = null;
    public ArrayList<supplier_info> supplierlist(){
        ArrayList<supplier_info> supplierlist = new ArrayList<>();
        try {
              Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
               String connectionUrl1 = "jdbc:sqlserver://localhost:1433;databaseName=Project;user=admin;password=admin";
               connection = DriverManager.getConnection(connectionUrl1);
               System.out.println("Done !!");
               java.sql.Statement state=connection.createStatement();
               state=connection.createStatement();
               String query = "select * from supplier1";
               Statement State = connection.createStatement();
               s1=state.executeQuery(query);
               supplier_info supplier;
               while(s1.next()){
                   supplier = new supplier_info(s1.getString("name"),s1.getString("id"),s1.getString("tp"));
                   supplierlist.add(supplier);
                   
               }
        } catch (Exception e) {
               System.out.println(e.getMessage());
        }
        return supplierlist;
  }
    public show_supplier(){
       JFrame frame = new JFrame("SHOW");
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setResizable(false);
       frame.setSize(700, 700);
       Font f1 = new Font("lol", Font.CENTER_BASELINE , 27);
       Font f2 = new Font("lol", Font.CENTER_BASELINE , 22);
       Font f3 = new Font("lol", Font.CENTER_BASELINE , 15);
      JTable table = new JTable(0,3);
      table.setFont(f3);
      table.setBounds(100, 100, 500, 300);
       JToolBar tool1 = new JToolBar();
       JButton back = new JButton("Back");
       tool1.setRollover(true);
       tool1.setBounds(0, 0, 1000, 40);
           back.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.setVisible(false);
            Admin admin2 = new Admin();
          }
       });
       ArrayList<supplier_info> list = supplierlist();
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        Object[] row = new Object[3];
        row[0]="(NAME)";
        row[1]="(ID)";
        row[2]="(TELEPHONE)";
        model.addRow(row);
        for(int i = 0;i<list.size();i++){
            row[0]=list.get(i).getName();
            row[1]=list.get(i).getId();
            row[2]=list.get(i).getTelephone();
           
            model.addRow(row);
        }
       JScrollPane sp=new JScrollPane(table);
       tool1.add(back);
       frame.add(tool1);
       frame.add(table);
       frame.setLayout(null);
       frame.setVisible(true);
       frame.setResizable(true);
     
    }

   
           public static void main(String[] args){ 
               show_supplier s = new show_supplier();
           }
       



}





