package bank_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class SignupThree extends JFrame implements ActionListener {
    
    JRadioButton saving, fixd, current, recuring;
    JCheckBox atm, mb, cb, ib, alert, st, terms;
    JButton submit, cancel;
    String fromno, pinnumber;
    
    SignupThree(String fromno){
        
        this.fromno = fromno;
        setLayout(null);
        
        JLabel text = new JLabel("Page 3 :  Account Details");
        text.setBounds(200, 50, 600, 50);
        text.setFont(new Font("Raleway", Font.BOLD, 38));
        add(text);
        
        JLabel acc = new JLabel("Account Type:");
        acc.setBounds(70, 145, 300, 40);
        acc.setFont(new Font("Raleway", Font.BOLD, 28));
        add(acc);
        
        saving = new JRadioButton("Saving Account");
        saving.setBounds(80, 200, 200, 40);
        saving.setFont(new Font("Arial", Font.BOLD, 20));
        saving.setBackground(Color.WHITE);
        add(saving);
        
        fixd = new JRadioButton("Fixed Deposite Account");
        fixd.setBounds(450, 200, 400, 40);
        fixd.setFont(new Font("Arial", Font.BOLD, 20));
        fixd.setBackground(Color.WHITE);
        add(fixd);
        
        current = new JRadioButton("Current Account");
        current.setBounds(80, 260, 200, 40);
        current.setFont(new Font("Arial", Font.BOLD, 20));
        current.setBackground(Color.WHITE);
        add(current);
        
        recuring = new JRadioButton("Recurring Deposite Account");
        recuring.setBounds(450, 260, 500, 40);
        recuring.setFont(new Font("Arial", Font.BOLD, 20));
        recuring.setBackground(Color.WHITE);
        add(recuring);
        
        ButtonGroup accountgroup = new ButtonGroup();
        accountgroup.add(saving);
        accountgroup.add(fixd);
        accountgroup.add(current);
        accountgroup.add(recuring);
        
        JLabel card = new JLabel("Card Number:");
        card.setBounds(70, 340, 300, 40);
        card.setFont(new Font("Raleway", Font.BOLD, 28));
        add(card);
        
        JLabel cd = new JLabel("XXXX-XXXX-XXXX-5525");
        cd.setBounds(400, 340, 400, 40);
        cd.setFont(new Font("Raleway", Font.BOLD, 28));
        add(cd);
        
        JLabel number = new JLabel("Your 16 Digit Card Number");
        number.setBounds(75, 370, 300, 40);
        number.setFont(new Font("Raleway", Font.BOLD, 15));
        add(number);
        
        JLabel pin = new JLabel("PIN:");
        pin.setBounds(70, 460, 300, 40);
        pin.setFont(new Font("Raleway", Font.BOLD, 28));
        add(pin);
        
        JLabel pp = new JLabel("XXXX");
        pp.setBounds(400, 460, 400, 40);
        pp.setFont(new Font("Raleway", Font.BOLD, 28));
        add(pp);
        
        JLabel digit = new JLabel("Your 4 Digit Password");
        digit.setBounds(70, 485, 300, 40);
        digit.setFont(new Font("Raleway", Font.BOLD, 15));
        add(digit);
        
        JLabel service = new JLabel("Service Recuired");
        service.setBounds(70, 580, 300, 40);
        service.setFont(new Font("Raleway", Font.BOLD, 28));
        add(service);
        
        atm = new JCheckBox("ATM CARD");
        atm.setBounds(80, 640, 300, 40);
        atm.setBackground(Color.WHITE);
        atm.setFont(new Font("Arial", Font.BOLD, 20));
        add(atm);
        
        ib = new JCheckBox("Internet Banking");
        ib.setBounds(380, 640, 300, 40);
        ib.setBackground(Color.WHITE);
        ib.setFont(new Font("Arial", Font.BOLD, 20));
        add(ib);
        
        mb = new JCheckBox("Mobile Banking");
        mb.setBounds(80, 700, 300, 40);
        mb.setBackground(Color.WHITE);
        mb.setFont(new Font("Arial", Font.BOLD, 20));
        add(mb);
        
        alert = new JCheckBox("Email & SMS Alert");
        alert.setBounds(380, 700, 300, 40);
        alert.setBackground(Color.WHITE);
        alert.setFont(new Font("Arial", Font.BOLD, 20));
        add(alert);
        
        cb = new JCheckBox("Cheque Book");
        cb.setBounds(80, 760, 300, 40);
        cb.setBackground(Color.WHITE);
        cb.setFont(new Font("Arial", Font.BOLD, 20));
        add(cb);
        
        st = new JCheckBox("E-Statement");
        st.setBounds(380, 760, 300, 40);
        st.setBackground(Color.WHITE);
        st.setFont(new Font("Arial", Font.BOLD, 20));
        add(st);
        
        terms = new JCheckBox("I hereby declares that the above entered details are correct to the best of my knowledge");
        terms.setBounds(70, 830, 800, 40);
        terms.setBackground(Color.WHITE);
        terms.setFont(new Font("Arial", Font.BOLD, 15));
        add(terms);
        
        submit = new JButton("Submit");
        submit.setBounds(250, 890, 100, 40);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Arial", Font.BOLD, 15));
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(450, 890, 100, 40);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Arial", Font.BOLD, 15));
        cancel.addActionListener(this);
        add(cancel);
        
        setSize(850, 1000);
        setLocation(450, 50);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
    }
    
    public void actionPerformed(ActionEvent ac){
        if (ac.getSource() == submit){
            String acctype = null;
            if(saving.isSelected()){
                acctype = "Saving Account";
            }else if(fixd.isSelected()){
                acctype = "Fixed Deposite Account";
            }else if(current.isSelected()){
                acctype = "Current Account";
            }else if(recuring.isSelected()){
                acctype = "Recurring Deposit Account";
            }
            
            Random ran = new Random();
            
            String cardnumber = "" + Math.abs((ran.nextLong() % 90000000L) + 5508239600000000L) ;
            pinnumber = "" +  Math.abs((ran.nextLong() % 9000L) + 1000L) ;

            String facility = "";
            if(atm.isSelected()){
                facility += " ATM CARD ";
            }
            if(mb.isSelected()){
                facility += " Mobile Banking ";
            }
            if(cb.isSelected()){
                facility += " Cheque Book ";
            }
            if(ib.isSelected()){
                facility += " Internet Banking ";
            } 
            if(alert.isSelected()){
                facility += " Email & SMS Alert ";
            }
            if(st.isSelected()){
                facility += " E-Statement ";
            }
            
            try{
                if(acctype.equals("")){
                    JOptionPane.showMessageDialog(null, "Account Type is Required");
                }else if(terms.isSelected()){
                    Conn c = new Conn();
                    String q = "insert into signupthree values('"+fromno+"','"+acctype+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
                    c.s.executeUpdate(q);
                    String q2 = "insert into login values('"+fromno+"','"+cardnumber+"','"+pinnumber+"')";
                    c.s.executeUpdate(q2);
                    JOptionPane.showMessageDialog(null, "Your Card Number: "+cardnumber + "\n Pin : "+pinnumber);
                    
                    setVisible(false);
                    new Deposite(pinnumber).setVisible(true);
                    
                }else{
                    JOptionPane.showMessageDialog(null, "Accept the terms & condition");
                }
                
            }catch(Exception e){
                System.out.println(e);
            }

        }else if (ac.getSource() == cancel){
            try{
                Conn c = new Conn();
                String q = "delete from signup where fromno = '"+fromno+"'";
                String q2 = "delete from signuptwo where fromno = '"+fromno+"'";
                c.s.executeUpdate(q);
                c.s.executeUpdate(q2);
                
                JOptionPane.showMessageDialog(null, "Thank you for using our application");
                System.exit(0);
                
            } catch(Exception e){
                System.out.println(e);
            }
        }
    }
    
    public static void main(String args[]){
        new SignupThree("");
    }
}
