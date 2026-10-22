package bank_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;

public class SignupOne extends JFrame implements ActionListener{
    long ran;
    JTextField namefield, fatherfield, emailfield, pinfield, statefield, cityfield, addressfield;
    JButton next;
    JRadioButton male, female, other, married, unmarried;
    JDateChooser dobchoise ;
    String from;
    
    SignupOne(){
        
        setLayout(null);
        
        Random no = new Random();
        ran = Math.abs((no.nextLong() % 9000L) + 1000L); 
        JLabel fromno = new JLabel("APPLICATION FROM NO: " + ran);
        from = String.valueOf(ran);
        fromno.setBounds(140, 20, 600, 40);
        fromno.setFont(new Font("Raleway", Font.BOLD, 38));
        add(fromno);
        
        JLabel personal = new JLabel("Page 1: Personal Details");
        personal.setBounds(300, 80, 500, 40);
        personal.setFont(new Font("Oswald", Font.BOLD, 20));
        add(personal);
        
        JLabel name = new JLabel("Name: ");
        name.setBounds(100, 140, 300, 40);
        name.setFont(new Font("Oswald", Font.BOLD, 22));
        add(name);
        
        namefield = new JTextField();
        namefield.setFont(new Font("Raleway", Font.BOLD, 18));
        namefield.setBounds(400, 140, 400, 40);
        add(namefield);
        
        JLabel father = new JLabel("Father's Name: ");
        father.setBounds(100, 200, 300, 40);
        father.setFont(new Font("Oswald", Font.BOLD, 22));
        add(father);
        
        fatherfield = new JTextField();
        fatherfield.setFont(new Font("Raleway", Font.BOLD, 18));
        fatherfield.setBounds(400, 200, 400, 40);
        add(fatherfield);
        
        JLabel dob = new JLabel("Date Of Birth: ");
        dob.setBounds(100, 260, 300, 40);
        dob.setFont(new Font("Oswald", Font.BOLD, 22));
        add(dob);
        
        dobchoise = new JDateChooser();
        dobchoise.setBounds(400, 260, 400, 40);
        dob.setBackground(Color.black);
        add(dobchoise);
        
        
        JLabel gender = new JLabel("Gender: ");
        gender.setBounds(100, 320, 300, 40);
        gender.setFont(new Font("Oswald", Font.BOLD, 22));
        add(gender);
        
        male = new JRadioButton("Male");
        male.setBounds(400, 320, 100, 40);
        male.setBackground(Color.WHITE);
        add(male);
            
        female = new JRadioButton("Female");
        female.setBounds(550, 320, 100, 40);
        female.setBackground(Color.WHITE);
        add(female);
                
        other = new JRadioButton("Others");
        other.setBounds(700, 320, 100, 40);
        other.setBackground(Color.WHITE);
        add(other);
        
        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        gendergroup.add(other);

        
        JLabel eamil = new JLabel("Email Address: ");
        eamil.setBounds(100, 380, 300, 40);
        eamil.setFont(new Font("Oswald", Font.BOLD, 22));
        add(eamil);
        
        emailfield = new JTextField();
        emailfield.setFont(new Font("Raleway", Font.BOLD, 18));
        emailfield.setBounds(400, 380, 400, 40);
        add(emailfield);
        
        JLabel matstat = new JLabel("Material Status: ");
        matstat.setBounds(100, 440, 300, 40);
        matstat.setFont(new Font("Oswald", Font.BOLD, 22));
        add(matstat);
        
        married = new JRadioButton("Married");
        married.setBounds(400, 440, 100, 40);
        married.setBackground(Color.WHITE);
        add(married);
            
        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(600, 440, 100, 40);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);
    
        ButtonGroup matstatrgroup = new ButtonGroup();
        matstatrgroup.add(married);
        matstatrgroup.add(unmarried);
        
        JLabel address = new JLabel("Address: ");
        address.setBounds(100, 500, 300, 40);
        address.setFont(new Font("Oswald", Font.BOLD, 22));
        add(address);
        
        addressfield = new JTextField();
        addressfield.setFont(new Font("Raleway", Font.BOLD, 18));
        addressfield.setBounds(400, 500, 400, 40);
        add(addressfield);
        
        JLabel city = new JLabel("City: ");
        city.setBounds(100, 560, 300, 40);
        city.setFont(new Font("Oswald", Font.BOLD, 22));
        add(city);
        
        cityfield = new JTextField();
        cityfield.setFont(new Font("Raleway", Font.BOLD, 18));
        cityfield.setBounds(400, 560, 400, 40);
        add(cityfield);
        
        JLabel state = new JLabel("State: ");
        state.setBounds(100, 620, 300, 40);
        state.setFont(new Font("Oswald", Font.BOLD, 22));
        add(state);
        
        statefield = new JTextField();
        statefield.setFont(new Font("Raleway", Font.BOLD, 18));
        statefield.setBounds(400, 620, 400, 40);
        add(statefield);
        
        JLabel pin = new JLabel("Pin Code: ");
        pin.setBounds(100, 680, 300, 40);
        pin.setFont(new Font("Oswald", Font.BOLD, 22));
        add(pin);
        
        pinfield = new JTextField();
        pinfield.setFont(new Font("Raleway", Font.BOLD, 18));
        pinfield.setBounds(400, 680, 400, 40);
        add(pinfield);
        
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.white);
        next.setFont(new Font("Raleway", Font.BOLD, 15));
        next.setBounds(700, 770, 100, 40);
        next.addActionListener(this);
        add(next);
        
        setSize(850, 900);
        setLocation(450, 100);
        setVisible(true);
        getContentPane().setBackground(Color.white);
    }
    
    public void actionPerformed(ActionEvent ac){
        String fromno = "" + ran;
        String name = namefield.getText();
        String fname = fatherfield.getText();
        String email = emailfield.getText();
        String address = addressfield.getText();
        String city = cityfield.getText();
        String state = statefield.getText();
        String pin = pinfield.getText();
        
        String dob = ((JTextField) dobchoise.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()){
            gender = "Male";
        }else if(female.isSelected()){
           gender = "Female";
        }else if(other.isSelected()){
            gender = "Other";
        }
        String matstat = null;
        if(married.isSelected()){
            matstat = "Married";
        }else if(unmarried.isSelected()){
            matstat = "Unmarried";
        }
        
        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null, "Name is Required");
            }else if(fname.equals("")){
                JOptionPane.showMessageDialog(null, "Father's Name is Reuired");
            }else if(email.equals("")){
                JOptionPane.showMessageDialog(null, "Eamil is Reuired");
            }else if(address.equals("")){
                JOptionPane.showMessageDialog(null, "Address is Reuired");
            }else if(city.equals("")){
                JOptionPane.showMessageDialog(null, "City is Reuired");
            }else if(state.equals("")){
                JOptionPane.showMessageDialog(null, "State is Reuired");
            }else if(pin.equals("")){
                JOptionPane.showMessageDialog(null, "Pin Code is Reuired");
            }else if(dob.equals("")){
                JOptionPane.showMessageDialog(null, "Date of Birth is Reuired");
            }else{
                Conn c = new Conn();
                String query = "insert into signup values('"+fromno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+matstat+"','"+address+"','"+city+"','"+state+"','"+pin+"')";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new SignupTwo(from).setVisible(true);
            }
        }catch(Exception e){
            System.out.println(e);
        }
        
      }
    
    public static void main(String args[]){
        new SignupOne();
    }
    
}
