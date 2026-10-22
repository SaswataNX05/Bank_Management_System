package bank_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.sql.*;

public class Withdrall extends JFrame implements ActionListener{
    
    String pin;
    JTextField amount;
    JButton enter, clear, back, exit;
    
    Withdrall(String pin){
        
        this.pin = pin;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        JLabel text = new JLabel("Enter the ammount You want to Withdrawl");
        text.setBounds(170, 345, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Arial", Font.BOLD, 16));
        image.add(text);
        
        amount = new JTextField();
        amount.setBounds(210, 390, 250, 25);
        amount.setFont(new Font("Arial", Font.BOLD, 16));
        image.add(amount);
        
        enter = new JButton("Withdraw");
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
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == clear){
            amount.setText("");
        }else if(ae.getSource() == exit){
            System.exit(0);
        }else if(ae.getSource() == back){
            setVisible(false);
            new Transaction(pin).setVisible(true);
        }else if(ae.getSource() == enter){
            String rs = amount.getText();
            Date date = new Date();
            int bal = 0;
            try{
                Conn c = new Conn();
                String ss = "select * from bank where pin = '"+pin+"'";
                ResultSet res = c.s.executeQuery(ss);
                
                while (res.next()){
                    if(res.getString("type").equals("Deposite")){
                        bal += Integer.parseInt(res.getString("amount"));
                    }else {
                        bal -= Integer.parseInt(res.getString("amount"));
                    }
                }
            }catch (Exception e){
                    System.out.println(e);
                }
            
            if(rs.equals("")){
                JOptionPane.showMessageDialog(null, "Amount not filled..!");
            }else if(bal > Integer.parseInt(rs)){
                try{
                    
                    String qr = "insert into bank values('"+pin+"', '"+date+"', 'Withdrawl', '"+rs+"')";
                    Conn c = new Conn();
                    c.s.executeUpdate(qr);
                    JOptionPane.showMessageDialog(null, "Rs " +rs+ " Withdrawled Succesfully");
                    setVisible(false);
                    new Transaction(pin).setVisible(true);
                }catch (Exception e){
                    System.out.println(e);
                }
            }else{
                    JOptionPane.showMessageDialog(null, "Insufficient Balance...!");
                    setVisible(false);
                    new Transaction(pin).setVisible(true);
            }
        }
    }
    
    public static void main(String args[]){
        new Withdrall("");
    }
}
