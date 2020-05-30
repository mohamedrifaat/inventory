/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registeration;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author ahmed khaled
 */
public class Admin {
    public Admin() {
              
      JFrame frame = new JFrame("ADMINISTRATOR");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setResizable(false);
      frame.setSize(700, 900);
      Font f1 = new Font("lol", Font.CENTER_BASELINE , 27);
      Font f2 = new Font("lol", Font.CENTER_BASELINE , 22);
      Font f3 = new Font("lol", Font.CENTER_BASELINE , 19);
      //DEFINING//
      //........//
      JLabel l1 = new JLabel("Choose your operation");
      JLabel l2 = new JLabel("Products");
      JLabel l3 = new JLabel("Suppliers");
      JButton add = new JButton("ADD");
      JButton update = new JButton("UPDATE");
      JButton delete = new JButton("DELETE");
      JButton show = new JButton("SHOW");
      JButton add1 = new JButton("ADD");
      JButton update1 = new JButton("UPDATE");
      JButton delete1 = new JButton("DELETE");
      JButton show1 = new JButton("SHOW");
      JButton search1 = new JButton("SEARCH");
      search1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
              SearchProd s1=new SearchProd();
            }});
      //SETTING BOUNDS//
      //.............//
      l1.setBounds(170, 5, 350, 200);
      l2.setBounds(100, 150, 250, 200);
      l3.setBounds(470, 150, 250, 200);
      add.setBounds(90, 280, 120, 60);
      update.setBounds(90, 360, 120, 60);
      delete.setBounds(90, 440, 120, 60);
      show.setBounds(90, 520, 120, 60);
      add1.setBounds(460, 280, 120, 60);
      update1.setBounds(460, 360, 120, 60);
      delete1.setBounds(460, 440, 120, 60);
      show1.setBounds(460, 520, 120, 60);
      search1.setBounds(280,290, 120, 60);
    //SETTING FONTS//
      //..........//
      l1.setFont(f1);
      l2.setFont(f2);
      l2.setForeground(Color.red);
      l3.setFont(f2);
      l3.setForeground(Color.red);
      add.setFont(f2);
      update.setFont(f3);
      delete.setFont(f3);
      show.setFont(f3);
      add1.setFont(f2);
      update1.setFont(f3);
      delete1.setFont(f3);
      show1.setFont(f3);
      search1.setFont(f3);
     //ADDING IN THE FRAME//
      frame.add(l1);
      frame.add(l2);
      frame.add(l3);
      frame.add(add);
      frame.add(update);
      frame.add(delete);
      frame.add(show);
      frame.add(add1);
      frame.add(update1);
      frame.add(delete1);
      frame.add(show1);
      frame.add(search1);
      //..........//
      add.addActionListener(new ActionListener() {

          @Override
          public void actionPerformed(ActionEvent e) {
              Add_product p = new Add_product();
              frame.setVisible(false);
          }
      });
      show.addActionListener(new ActionListener() {

          @Override
          public void actionPerformed(ActionEvent e) {
              Show_product p = new Show_product();
              frame.setVisible(false);
          }
      });
      update.addActionListener(new ActionListener() {

          @Override
          public void actionPerformed(ActionEvent e) {
              Update_products u = new Update_products();
          }
      });
      delete.addActionListener(new ActionListener() {

          @Override
          public void actionPerformed(ActionEvent e) {
         Delete_products d = new Delete_products();
          }
      });
      add1.addActionListener(new ActionListener() {

          @Override
          public void actionPerformed(ActionEvent e) {
           supplier s = new supplier();
           frame.setVisible(false);
          }
      });
      show1.addActionListener(new ActionListener() {

          @Override
          public void actionPerformed(ActionEvent e) {
          show_supplier s1 = new show_supplier();
          frame.setVisible(false);
          }
      });
      update1.addActionListener(new ActionListener() {

          @Override
          public void actionPerformed(ActionEvent e) {
           Update u = new Update();
           frame.setVisible(false);
          }
      });
      delete1.addActionListener(new ActionListener() {

          @Override
           public void actionPerformed(ActionEvent e) {
           delet_supplier d = new delet_supplier();
           frame.setVisible(false);
          }
      });
     frame.setLayout(null);
     frame.setVisible(true);
    }
    
    
      public static void main(String[] args) {
      Admin admin = new Admin();
 }
      
}