package registeration;

import static com.sun.javafx.scene.control.skin.Utils.getResource;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Test {
    public void Run(String oldUserName,String email){ 
    JFrame myframe = new JFrame("Client Page");
        JLabel label = new JLabel();
        label.setBounds(0,0,371,323);
        myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myframe.setSize(371, 340);
        JLabel firstlabel = new JLabel("Purchase a request from here:");
        firstlabel.setForeground(Color.GRAY);
        JPanel panel = new JPanel();
        myframe.add(panel);
       JComboBox Request = new JComboBox();
           try {
             System.out.println(".....");
               Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
               String connectionUrl1 = "jdbc:sqlserver://localhost:1433;user=admin;password=admin;"+"databaseName=Project";
        Connection connection = DriverManager.getConnection(connectionUrl1);
              
               java.sql.Statement state=connection.createStatement();
               state=connection.createStatement();
                String query1 = "select DISTINCT name from Product";
                PreparedStatement p2 = connection.prepareStatement(query1);
                ResultSet set = p2.executeQuery();
                while(set.next()){
                    Request.addItem(set.getString("name"));}
        } catch (Exception e) {
               System.out.println(e.getMessage());
        }
     
        try{
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=Project;user=admin;password=admin";
            Connection con = DriverManager.getConnection(url);
              Statement stmt2 = con.createStatement();
              String query ="SELECT  name from Product ";
              PreparedStatement pst = con.prepareStatement(query);
               String gender1;
            gender1 = Request.getSelectedItem().toString();
            pst.setString(1, gender1);
                        pst.executeUpdate();

        
        }
        catch(Exception Exe){
            System.out.println(Exe.getMessage());
        }
        JButton Order = new JButton("Request an order");
        JButton Report = new JButton("Generate Order's Report");
        JButton Edit = new JButton("Edit Profile");
                JButton invoice = new JButton("Generate the invoice");

        Request.setBackground(Color.WHITE);
        Request.setForeground(Color.BLACK);
        Order.setBackground(Color.WHITE);
        Order.setForeground(Color.BLACK);
        Order.setBackground(Color.WHITE);
        Order.setForeground(Color.BLACK);
        Report.setBackground(Color.WHITE);
        Report.setForeground(Color.BLACK);
                invoice.setBackground(Color.WHITE);
        invoice.setForeground(Color.BLACK);

        JMenuBar mybar = new JMenuBar();

        Request.setBounds(180, 75, 100, 30);
        Order.setBounds(45, 150, 200, 30);
        Report.setBounds(45, 190, 200, 30);
        invoice.setBounds(45, 230, 200, 30);
        Edit.setBounds(4, 4, 95, 30);
        firstlabel.setBounds(10, 50, 250, 30);
        
        myframe.add(Request);
        myframe.add(invoice);
        myframe.add(Order);
        myframe.add(Edit);
        myframe.add(Report);
        myframe.add(firstlabel);
        myframe.setJMenuBar(mybar);
         myframe.add(label);
        

        Order.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

                    String url = "jdbc:sqlserver://localhost:1433;databaseName=Project;user=admin;password=admin";
                    Connection con = DriverManager.getConnection(url);
                    Statement stmt = con.createStatement();
                     String request1;
                    request1 = Request.getSelectedItem().toString();
                   ResultSet rs1 = stmt.executeQuery("Select price from Product where name='"+request1+"'");
                   if(rs1.next()){
                     int price1= Integer.parseInt(rs1.getString("price"));
                     
                    String query = "insert into Request(name,uname,price) values(?,'"+oldUserName+"',"+price1+")";
                    String request;
                    request = Request.getSelectedItem().toString();
                    PreparedStatement pst = con.prepareStatement(query);
                    pst.setString(1, request);
                    pst.executeUpdate();}
                    JOptionPane.showMessageDialog(null,"Done");
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }

            }
        });
                Report.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

                    String url = "jdbc:sqlserver://localhost:1433;databaseName=Project;user=admin;password=admin";
                    Connection con = DriverManager.getConnection(url);
               
                     Statement stmt = con.createStatement();
                        ResultSet res = stmt.executeQuery("SELECT name from Request JOIN users ON Request.uname=users.userName WHERE users.userMail='"+email+"'");
                       int i; 
                        JFrame or= new JFrame("order");
                        or.setLayout(new FlowLayout());
                        or.setSize(300, 150);
                         JLabel ord2=new JLabel("you have ordered : ");
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
  invoice.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

                    String url = "jdbc:sqlserver://localhost:1433;databaseName=Project;user=admin;password=admin";
                    Connection con = DriverManager.getConnection(url);
               
                     Statement stmt = con.createStatement();
                        ResultSet res = stmt.executeQuery("SELECT sum (price) as sum from Request JOIN users ON Request.uname=users.userName WHERE users.userMail='"+email+"'");
                    if (res.next()) {
                  String cost=res.getString("sum");
                  
                    JOptionPane.showMessageDialog(null,"Total Cost: "+cost);
                    
                    }

                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }

            }
        });
            


        JMenuItem lastbar = new JMenuItem(new AbstractAction("Exit") {
            public void actionPerformed(ActionEvent e) {
                // Button pressed logic goes here
                System.exit(0);
            }
        });
        mybar.add(lastbar);

        Edit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("My Profile");
                frame.setSize(350, 300);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                JPanel top = new JPanel();
                top.setBackground(new Color(0xB1B1B1));
                JLabel head = new JLabel("My Profile");
                head.setFont(head.getFont().deriveFont(40.0f));
                head.setForeground(new Color(0x557A95));
                top.add(BorderLayout.CENTER, head);

                frame.add(BorderLayout.NORTH, top);

                JPanel center = new JPanel();
                center.setBackground(new Color(0xB1B1B1));
                GridLayout grid = new GridLayout(3, 2);
                center.setLayout(grid);

                JLabel userName = new JLabel("User Name");
                userName.setForeground(new Color(0x557A95));
                JTextField userNametf = new JTextField(10);

                JLabel email = new JLabel("Email ");
                email.setForeground(new Color(0x557A95));
                JTextField emailtf = new JTextField(30);

                JLabel password = new JLabel("Password");
                password.setForeground(new Color(0x557A95));
                JPasswordField passwordtf = new JPasswordField(10);

                center.add(userName);
                center.add(userNametf);

                center.add(email);
                center.add(emailtf);
                center.add(password);
                center.add(passwordtf);

                 frame.add(BorderLayout.CENTER, center);

                JPanel bot = new JPanel();
                JButton editProfile = new JButton("Edit Profile");
                JButton Back = new JButton("Back");
                bot.add(editProfile);
                bot.add(Back);
                editProfile.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        try {
                            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

                            String url = "jdbc:sqlserver://localhost:1433;databaseName=Project;user=admin;password=admin";
                            Connection con = DriverManager.getConnection(url);
                            java.sql.Statement state = con.createStatement();
                            String query = "UPDATE users SET userName=?,userMail=?,userPassword=? WHERE userName='"+oldUserName+"'";
                            PreparedStatement pst1 = con.prepareStatement(query);
                            pst1.setString(1, userNametf.getText());
                            pst1.setString(2, emailtf.getText());
                            pst1.setString(3, passwordtf.getText());
                            
                            pst1.executeUpdate();
                            JOptionPane.showMessageDialog(null,"Done");
                        } catch (Exception e1) {
                            System.out.println(e1.getMessage());
                        }
                    }
                });
                Back.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        frame.setVisible(false);
                        myframe.setVisible(true);
                    }
                });

                frame.setResizable(false);
                bot.setBackground(new Color(0xB1B1B1));
                frame.add(BorderLayout.SOUTH, bot);
                myframe.setVisible(false);
                frame.setVisible(true);

            }

        });

        myframe.setLayout(null);
        myframe.setResizable(false);
        myframe.setVisible(true);
    
       
    }
}