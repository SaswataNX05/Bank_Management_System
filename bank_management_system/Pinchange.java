package bank_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Pinchange extends JFrame implements ActionListener{
    
    JPasswordField oldpin, newpin1, newpin2;
    JButton enter, clear, back, exit;
    String pin;
    
    Pinchange(String pin){
        
        this.pin = pin;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT); 
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        JLabel pin1 = new JLabel("Enter Your current Pin");
        pin1.setBounds(170, 310, 700, 35);
        pin1.setForeground(Color.WHITE);
        pin1.setFont(new Font("Arial", Font.BOLD, 16));
        image.add(pin1);
        
        oldpin = new JPasswordField();
        oldpin.setBounds(380, 315, 100, 25);
        oldpin.setFont(new Font("Arial", Font.BOLD, 16));
        image.add(oldpin);
        
        JLabel pin2 = new JLabel("Enter Your New Pin");
        pin2.setBounds(170, 350, 700, 35);
        pin2.setForeground(Color.WHITE);
        pin2.setFont(new Font("Arial", Font.BOLD, 16));
        image.add(pin2);
        
        newpin1 = new JPasswordField();
        newpin1.setBounds(380, 355, 100, 25);
        newpin1.setFont(new Font("Arial", Font.BOLD, 16));
        image.add(newpin1);
        
        JLabel pin3 = new JLabel("Re-enter Your new Pin");
        pin3.setBounds(170, 390, 700, 35);
        pin3.setForeground(Color.WHITE);
        pin3.setFont(new Font("Arial", Font.BOLD, 16));
        image.add(pin3);
        
        newpin2 = new JPasswordField();
        newpin2.setBounds(380, 395, 100, 25);
        newpin2.setFont(new Font("Arial", Font.BOLD, 16));
        image.add(newpin2);
        
        enter = new JButton("Change pin");
        enter.setBounds(360, 450, 150, 30);
        enter.setFont(new Font("Arial", Font.BOLD, 15));
        enter.addActionListener(this);
        image.add(enter);
        
        clear = new JButton("Clear");
        clear.setBounds(360, 485, 150, 30);
        clear.setFont(new Font("Arial", Font.BOLD, 15));
        clear.addActionListener(this);
        image.add(clear);
        
        back = new JButton("Back");
        back.setBounds(170, 450, 150, 30);
        back.setFont(new Font("Arial", Font.BOLD, 15));
        back.addActionListener(this);
        image.add(back);
        
        exit = new JButton("Exit");
        exit.setBounds(170, 485, 150, 30);
        exit.setFont(new Font("Arial", Font.BOLD, 15));
        exit.addActionListener(this);
        image.add(exit);
        
        setSize(900, 900);
        setLocation(400, 10);
        getContentPane().setBackground(Color.WHITE);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == clear){
            oldpin.setText("");
            newpin1.setText("");
            newpin2.setText("");
        }else if(ae.getSource() == exit){
            System.exit(0);
        }else if(ae.getSource() == back){
            setVisible(false);
            new Transaction(pin).setVisible(true);
        }else if(ae.getSource() == enter){
            String old = oldpin.getText();
            String new1 = newpin1.getText();
            String new2 = newpin2.getText();
            
            if(old.equals("") || new1.equals("") || new2.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter pin..!");               
            }else if(!old.equals(pin)){
                JOptionPane.showMessageDialog(null, "Current pin is Invalid...!");
            }else if(!new1.equals(new2)){
                JOptionPane.showMessageDialog(null, "New pin doesnot match...!");
            }else{
                try{
                    Conn c = new Conn();
                    ResultSet r = c.s.executeQuery("select pin_number from login");
                    while(r.next()){
                        if(r.getString("pin_number").equals(new2)){
                            JOptionPane.showMessageDialog(null, "New Pin already exist..!");
                            return;
                        }
                    }
                    
                    String q1 = "update bank set pin = '"+new1+"' where pin = '"+pin+"'";
                    String q2 = "update login set pin_number = '"+new1+"' where pin_number = '"+pin+"'";
                    String q3 = "update signupthree set pin_number = '"+new1+"' where pin_number = '"+pin+"'";
                    c.s.executeUpdate(q1);
                    c.s.executeUpdate(q2);
                    c.s.executeUpdate(q3);
                    JOptionPane.showMessageDialog(null, "Pin succefully changed");
                    setVisible(true);
                    new Transaction(pin).setVisible(true);
                    
                }catch (Exception e){
                    System.out.println(e);
                }
                
            }
            
        }
    }
    
    public static void main(String args[]){
        new Pinchange("");
    }
}

