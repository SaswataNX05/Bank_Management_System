package bank_management_system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class Ministatement extends JFrame{
    
    String pin;
    
    Ministatement(String pin){
        
        this.pin = pin;
        setTitle("Mini Statement");
        setLayout(null);
        
        JLabel card = new JLabel("");
        card.setBounds(50, 20, 600, 30);
        card.setFont(new Font("Arial", Font.BOLD, 16));
        add(card);
        
        JLabel time = new JLabel("");
        time.setBounds(50, 50, 600, 550);
        time.setFont(new Font("Arial", Font.BOLD, 15));
        add(time);
     
        JLabel balance = new JLabel("asdfasfas");
        balance.setBounds(50, 600, 600, 30);
        balance.setFont(new Font("Arial", Font.BOLD, 15));
        add(balance);
        
        try{
            Conn c = new Conn();
            ResultSet r = c.s.executeQuery("select * from login where pin_number = '"+pin+"'");         
            while(r.next()){
                card.setText("Card Number :    " + r.getString("card_number").substring(0, 4) + "XXXXXXXX" +  r.getString("card_number").substring(12));
            }
        }catch (Exception e){
            System.out.println(e);
        }
        
        try{
            Conn c = new Conn();
            ResultSet r = c.s.executeQuery("select * from bank where pin = '"+pin+"'");         
            while(r.next()){
                time.setText(time.getText() + "<html>" + r.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + r.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + r.getString("amount") + "<br><br>" );
            }
        }catch (Exception e){
            System.out.println(e);
        }
        
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
            balance.setText("Total Account Balalnce:  " +  bal);
            new Transaction(pin).setVisible(true);
        }catch (Exception e){
            System.out.println(e);
        }
        
       
        
        setSize(500, 700);
        setLocation(100, 100);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    
    public static void main(String args[]){
        new Ministatement("");
    }
    
}
