package bank_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transaction extends JFrame implements ActionListener{
    
    JButton deposit, witdrawl, fast, mini, pinn, balance, exit;
    String pin;
    
    Transaction(String pin){
        
        this.pin = pin;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT); 
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        JLabel text = new JLabel("Please select your Transaction ");
        text.setBounds(220, 300, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Arial", Font.BOLD, 16));
        image.add(text);
        
        deposit = new JButton("Deposite");
        deposit.setBounds(170, 415, 150, 30);
        deposit.addActionListener(this);
        image.add(deposit);
        
        witdrawl = new JButton("Cash Withdrall");
        witdrawl.setBounds(360, 415, 150, 30);
        witdrawl.addActionListener(this);
        image.add(witdrawl);
        
        fast = new JButton("Fast Cash");
        fast.setBounds(170, 450, 150, 30);
        fast.addActionListener(this);
        image.add(fast);
        
        mini = new JButton("Mini Statement");
        mini.setBounds(360, 450, 150, 30);
        mini.addActionListener(this);
        image.add(mini);
        
        pinn = new JButton("Pin Change");
        pinn.setBounds(170, 485, 150, 30);
        pinn.addActionListener(this);
        image.add(pinn);
        
        balance = new JButton("Balance Enquery");
        balance.setBounds(360, 485, 150, 30);
        balance.addActionListener(this);
        image.add(balance);
        
        exit = new JButton("Exit");
        exit.setBounds(360, 520, 150, 25);
        exit.addActionListener(this);
        image.add(exit);
      
        
        setSize(900, 900);
        setLocation(400, 10);
        getContentPane().setBackground(Color.WHITE);
        setUndecorated(true);
        setVisible(true);
                
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == exit) {
            System.exit(0);
        }else if(ae.getSource() == deposit){
            setVisible(false);
            new Deposite(pin).setVisible(true);
        }else if(ae.getSource() == witdrawl){
            setVisible(false);
            new Withdrall(pin).setVisible(true);
        }else if(ae.getSource() == fast){
            setVisible(false);
            new Fastcash(pin).setVisible(true);
        }else if(ae.getSource() == pinn){
            setVisible(false);
            new Pinchange(pin).setVisible(true);
        }else if(ae.getSource() == balance){
            setVisible(false);
            new Balancecheck(pin).setVisible(true);
        }else if(ae.getSource() == mini){
            setVisible(false);
            new Ministatement(pin).setVisible(true);
        }
    } 
    
    public static void main(String args[]){
        new Transaction("");
    }
}
