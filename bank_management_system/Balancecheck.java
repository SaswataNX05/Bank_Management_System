package bank_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class Balancecheck extends JFrame implements ActionListener{
    
    String pin;
    JButton back;
    
    Balancecheck(String pin){
        this.pin = pin;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        JLabel text = new JLabel("Your Current Account Balance is ");
        text.setBounds(170, 370, 700, 35);
        text.setFont(new Font("Arial", Font.BOLD, 14));
        text.setForeground(Color.WHITE);
        image.add(text);
        
        int bal = 0;
        try{
            Conn c = new Conn();
            ResultSet r = c.s.executeQuery("select * from bank where pin = '"+pin+"'");
            while(r.next()){
                if(r.getString("type").equals("Deposite")){
                    bal += Integer.parseInt(r.getString("amount"));
                }else{
                    bal -= Integer.parseInt(r.getString("amount"));
                }
            }
       
        }catch (Exception e){
            System.out.println(e);
        }
         
        JLabel am = new JLabel("Rs "+bal+" -/");
        am.setBounds(400, 370, 700, 35);
        am.setFont(new Font("Arial", Font.BOLD, 14));
        am.setForeground(Color.WHITE);
        image.add(am);
 
        back = new JButton("Back");
        back.setBounds(360, 515, 150, 30);
        back.addActionListener(this);
        image.add(back);
        
        setSize(900, 900);
        setLocation(400, 10);
        setUndecorated(true);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
         if (ae.getSource() == back) {
            setVisible(true);
            new Transaction(pin).setVisible(true);
        }
    }
    
    public static void main(String args[]){
        new Balancecheck("");
    }
}
