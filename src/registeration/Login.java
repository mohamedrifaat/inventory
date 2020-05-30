    package registeration;

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Login {
    
  
    public Login() {
        JFrame f1 = new JFrame("inventory");
        f1.setResizable(false);
        f1.setSize(350, 300);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel l1 = new JLabel("INVENTORY");
        l1.setBounds(150,0 , 150, 70);
        f1.add(l1);
        JLabel l2 = new JLabel("USER NAME");
        l2.setBounds(10,60 , 150, 70);
        f1.add(l2);
        JTextField t1 = new JTextField();
        t1.setBounds(150, 80, 400, 30);
        f1.add(t1);
        JLabel l3 = new JLabel("PASSWORD");
        l3.setBounds(10,125 , 150, 70);
        f1.add(l3);
        JPasswordField t2 = new JPasswordField();
        t2.setBounds(150, 150, 400, 30);
        f1.add(t2);
        
        JButton b1 = new JButton("log in");
        b1.setBounds(50, 200, 90, 40);
        f1.add(b1);
        
        
          b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e2){
        try{
           
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                 String url="jdbc:sqlserver://localhost:1433;databaseName=Project;user=admin;password=admin";
            Connection con = DriverManager.getConnection(url);
                     String un = t1.getText();
                   String pw = t2.getText();
                    Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users where userName= '"+un+"' and userPassword='"+pw+"'");
            
          if(un.equals("admin") && pw.equals("admin")){
          
                Admin ad = new Admin();
              f1.setVisible(false);
              
          }
          else if (rs.next()){
               Test object=new Test();
               String useremail= rs.getString("userMail");
               object.Run(un,useremail);
              f1.setVisible(false);
           }
           else {
               JOptionPane.showMessageDialog(null,"username and password not correct ");}}
            
        catch(SQLException se){
        JOptionPane.showMessageDialog(null, se.toString());
        }       catch (ClassNotFoundException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    
        
        
        JButton b2 = new JButton("register");
        b2.setBounds(200, 200, 90, 40);
        f1.add(b2);
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                f1.setVisible(false);
                   JFrame frame = new JFrame("Registeration");
       frame.setSize(350,300);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
          JPanel top = new JPanel();
          top.setBackground(new Color(0xB1B1B1));
          JLabel head = new JLabel(" Registeration");
          head.setFont (head.getFont ().deriveFont (40.0f));
          head.setForeground(new Color(0x557A95));
           top.add(BorderLayout.CENTER,head);
          
            frame.add(BorderLayout.NORTH,top);
       
       JPanel center = new JPanel();
          center.setBackground(new Color(0xB1B1B1));
        GridLayout grid = new GridLayout(3, 2);
        center.setLayout(grid);
        
        
        JLabel userName = new JLabel("User Name");
        userName.setForeground(new Color(0x557A95 ));
        JTextField  userNametf = new JTextField(10);
        
        JLabel email = new JLabel("Email ");
         email.setForeground(new Color(0x557A95 ));
        JTextField emailtf = new JTextField(30);
        
        
        
        JLabel password = new JLabel("Password");
        password.setForeground(new Color(0x557A95 ));
        JPasswordField passwordtf = new JPasswordField(10);
              
      
           
           
        center.add(userName);
         center.add(userNametf);
     
        center.add(email);
         center.add(emailtf);
        center.add( password);
         center.add( passwordtf);
    
      
       
        
      frame.add(BorderLayout.CENTER ,center);
      
          JPanel bot = new JPanel();
       JButton regester = new JButton("Register");
       bot.add(BorderLayout.CENTER,regester);
       
      frame.setResizable(false);
       
      regester.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e1){
                
                    String userNames = userNametf.getText();
                    String emails = emailtf.getText();
                    String passwords = passwordtf.getText();
                    
                     try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=Project;user=admin;password=admin";
           
            try (Connection con = DriverManager.getConnection(url)) {
                Statement stmt = con.createStatement();
                stmt.execute("insert into users values ('"+userNames+"','"+passwords+"','"+emails+"')");
                 JOptionPane.showMessageDialog(null,"Done");
                  
            }
               
               
            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }   catch (ClassNotFoundException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
                     
                      f1.setVisible(true);
                     frame.setVisible(false);
         
                
           }
        });
        
       
        bot.setBackground(new Color(0xB1B1B1));
        frame.add(BorderLayout.SOUTH,bot);
       frame.setVisible(true);
            }

        });
    
        f1.setLayout(null);
        f1.setVisible(true);
        
    }
}