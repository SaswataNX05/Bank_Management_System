package bank_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    JButton login, clear, creat;
    JTextField cardbox;
    JPasswordField pinbox; 
    
    Login(){
        setTitle("Bank Login page");
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(60, 20, 100, 100);
        add(label);
        
        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setBounds(250, 40, 400, 40);
        add(text);
        
        JLabel cardno = new JLabel("Enter Card No:");
        cardno.setFont(new Font("Raleway", Font.BOLD, 25));
        cardno.setBounds(140, 150, 200, 40);
        add(cardno);
        
        cardbox = new JTextField();
        cardbox.setBounds(410, 150, 250, 40);
        cardbox.setFont(new Font("Arial", Font.BOLD, 15));
        add(cardbox);
                
        JLabel pin = new JLabel("Enter PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 25));
        pin.setBounds(140, 220, 250, 40);
        add(pin);
        
        pinbox = new JPasswordField();
        pinbox.setBounds(410, 220, 250, 40);
        pinbox.setFont(new Font("Arial", Font.BOLD, 15));
        add(pinbox);
        
        login = new JButton("SIGN IN");
        login.setBounds(410, 300, 100, 30);
        login.setBackground(Color.BLUE);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        clear = new JButton("CLEAR");
        clear.setBounds(560, 300, 100, 30);
        clear.setBackground(Color.BLUE);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        
        
        creat = new JButton("SIGN UP");
        creat.setBounds(410, 360, 250, 30);
        creat.setBackground(Color.BLUE);
        creat.setForeground(Color.white);
        creat.addActionListener(this);
        add(creat);
        
        getContentPane().setBackground(Color.white);
        
        setSize(800, 480);
        setVisible(true);
        setLocation(400, 200);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == clear){
            cardbox.setText("");
            pinbox.setText("");
        }else if(ae.getSource() == login){
            String cardno = cardbox.getText();
            String pin = pinbox.getText();
       
            String qr = "select * from login where card_number = '"+cardno+"' and pin_number = '"+pin+"' "; 
            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(qr);
                if(rs.next()){
                    setVisible(false);
                    new Transaction(pin).setVisible(true);       
                }else{
                    JOptionPane.showMessageDialog(null, "Incorrect Card Or Pin Numner");
                }
            }catch(Exception e){
                System.out.println(e);
            }
        }else if(ae.getSource() == creat){
            setVisible(false);
            new SignupOne().setVisible(true);
        }
    }
    
    public static void main(String args[]){
        new Login();
    }
}
