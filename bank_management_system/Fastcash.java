package bank_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.sql.*;

public class Fastcash extends JFrame implements ActionListener{
    
    JButton r100, r500, r1000, r2000, r5000, r10000, back;
    String pin;
    
    Fastcash(String pin){
        
        this.pin = pin;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT); 
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        JLabel text = new JLabel("Please select the Amount ");
        text.setBounds(220, 300, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Arial", Font.BOLD, 16));
        image.add(text);
        
        r100 = new JButton("Rs 100");
        r100.setBounds(170, 415, 150, 30);
        r100.addActionListener(this);
        image.add(r100);
        
        r500 = new JButton("Rs 500");
        r500.setBounds(360, 415, 150, 30);
        r500.addActionListener(this);
        image.add(r500);
        
        r1000 = new JButton("Rs 1000");
        r1000.setBounds(170, 450, 150, 30);
        r1000.addActionListener(this);
        image.add(r1000);
        
        r2000 = new JButton("Rs 2000");
        r2000.setBounds(360, 450, 150, 30);
        r2000.addActionListener(this);
        image.add(r2000);
        
        r5000 = new JButton("Rs 5000");
        r5000.setBounds(170, 485, 150, 30);
        r5000.addActionListener(this);
        image.add(r5000);
        
        r10000 = new JButton("Rs 10000");
        r10000.setBounds(360, 485, 150, 30);
        r10000.addActionListener(this);
        image.add(r10000);       
        
        back = new JButton("Back");
        back.setBounds(360, 520, 150, 25);
        back.addActionListener(this);
        image.add(back);
      
        
        setSize(900, 900);
        setLocation(400, 10);
        getContentPane().setBackground(Color.WHITE);
        setUndecorated(true);
        setVisible(true);
                
    }
    
    public void actionPerformed(ActionEvent ae){
         Date date = new Date();
         
        if (ae.getSource() == back) {
            setVisible(true);
            new Transaction(pin).setVisible(true);
        }else {
             try {
                String am = ((JButton)ae.getSource()).getText().substring(3);               
                Conn c = new Conn();
                String q = "select * from bank where pin = '"+pin+"'";
                ResultSet rs = c.s.executeQuery(q);
                int bal = 0;
                
                while (rs.next()){
                    if(rs.getString("type").equals("Deposite")){
                        bal += Integer.parseInt(rs.getString("amount"));
                    }else {
                        bal -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                
                if(ae.getSource() != back && bal < Integer.parseInt(am)){
                    JOptionPane.showMessageDialog(null, "Insufficient Balance...!");
                    setVisible(false);
                    new Transaction(pin).setVisible(true);
                }else{
                    String st = "insert into bank values('"+pin+"', '"+date+"', 'Withdrall', '"+am+"')";
                    c.s.executeUpdate(st);
                    JOptionPane.showMessageDialog(null, "Rs " + am + " Debited Successfully");
                    setVisible(false);
                    new Transaction(pin).setVisible(true);
                }
                
            }catch(Exception e){
                System.out.println(e);
            }
        }
    } 
    
    public static void main(String args[]){
        new Fastcash("");
    }
}