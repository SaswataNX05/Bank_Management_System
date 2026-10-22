package bank_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener{
    
    JTextField panfield, adharfield;
    JRadioButton senior, notsenior, existing, notexisting;
    JComboBox religionbox, catagorybox, incomebox, educationbox, occupationbox; 
    JButton next;
    String fromno;
    
    SignupTwo(String fromno){
        
        this.fromno = fromno;
        setLayout(null);
        
        JLabel text = new JLabel("Page 2: Additional Details");
        text.setBounds(180, 50, 600, 50);
        text.setFont(new Font("Oswald", Font.BOLD, 35));
        add(text);
        
        JLabel religion = new JLabel("Religion:");
        religion.setBounds(100, 150, 300, 40);
        religion.setFont(new Font("Raleway", Font.BOLD, 24));
        add(religion);
        
        String valreligion[] = {"Hindu", "Muslim", "Sikh", "Jain", "Others"};
        religionbox = new JComboBox(valreligion);
        religionbox.setBounds(400, 150, 400, 40);
        religionbox.setBackground(Color.WHITE);
        add(religionbox);
        
        JLabel catagory = new JLabel("Catagory:");
        catagory.setBounds(100, 210, 300, 40);
        catagory.setFont(new Font("Raleway", Font.BOLD, 24));
        add(catagory);
        
        String valcatagory[] = {"Genaral", "SC", "ST", "OBC"};
        catagorybox = new JComboBox(valcatagory);
        catagorybox.setBounds(400, 210, 400, 40);
        catagorybox.setBackground(Color.WHITE);
        add(catagorybox);
        
        JLabel income = new JLabel("Income:");
        income.setBounds(100, 270, 300, 40);
        income.setFont(new Font("Raleway", Font.BOLD, 24));
        add(income);
        
        String valincome[] = {"NULL", "< 1,50,000", "< 2,50,000", "< 5,00,000", "< 10,00,000"};
        incomebox = new JComboBox(valincome);
        incomebox.setBounds(400, 270, 400, 40);
        incomebox.setBackground(Color.WHITE);
        add(incomebox);
        
        JLabel education = new JLabel("Educational");
        education.setBounds(100, 330, 300, 40);
        education.setFont(new Font("Raleway", Font.BOLD, 24));
        add(education);
        
        String valeducation[] = {"Matric Pass", "Higher Secondary Pass", "Graduate", "Under Graduate", "None"};
        educationbox = new JComboBox(valeducation);
        educationbox.setBounds(400, 345, 400, 40);
        educationbox.setBackground(Color.WHITE);
        add(educationbox);
        
        JLabel qualification = new JLabel("Qualification:");
        qualification.setBounds(100, 365, 300, 40);
        qualification.setFont(new Font("Raleway", Font.BOLD, 24));
        add(qualification);
        
        JLabel occupation = new JLabel("Occupation:");
        occupation.setBounds(100, 420, 300, 40);
        occupation.setFont(new Font("Raleway", Font.BOLD, 24));
        add(occupation);
        
        String valoccupation[] = {"Privet Service", "Standard", "Govt Service", "Bussiness", "Others"};
        occupationbox = new JComboBox(valoccupation);
        occupationbox.setBounds(400, 420, 400, 40);
        occupationbox.setBackground(Color.WHITE);
        add(occupationbox);
        
        JLabel pan = new JLabel("PAN Number:");
        pan.setBounds(100, 480, 300, 40);
        pan.setFont(new Font("Raleway", Font.BOLD, 24));
        add(pan);
        
        panfield = new JTextField();
        panfield.setBounds(400, 480, 400, 40);
        panfield.setFont(new Font("Arial", Font.BOLD, 15));
        add(panfield);
        
        JLabel adhar = new JLabel("Adhar Number:");
        adhar.setBounds(100, 540, 300, 40);
        adhar.setFont(new Font("Raleway", Font.BOLD, 24));
        add(adhar);
        
        adharfield = new JTextField();
        adharfield.setBounds(400, 540, 400, 40);
        adharfield.setFont(new Font("Arial", Font.BOLD, 15));
        add(adharfield);
        
        JLabel citizen = new JLabel("Senior Citizen:");
        citizen.setBounds(100, 600, 300, 40);
        citizen.setFont(new Font("Raleway", Font.BOLD, 24));
        add(citizen);
        
        senior = new JRadioButton("Yes");
        senior.setBounds(400, 600, 100, 40);
        senior.setBackground(Color.WHITE);
        add(senior);
        
        notsenior = new JRadioButton("No");
        notsenior.setBounds(600, 600, 100, 40);
        notsenior.setBackground(Color.WHITE);
        add(notsenior);
        
        ButtonGroup citizengroup = new ButtonGroup();
        citizengroup.add(senior);
        citizengroup.add(notsenior);
        
        JLabel exixting = new JLabel("Existing Account:");
        exixting.setBounds(100, 660, 300, 40);
        exixting.setFont(new Font("Raleway", Font.BOLD, 24));
        add(exixting);
        
        existing = new JRadioButton("Yes");
        existing.setBounds(400, 660, 100, 40);
        existing.setBackground(Color.WHITE);
        add(existing);
        
        notexisting = new JRadioButton("No");
        notexisting.setBounds(600, 660, 100, 40);
        notexisting.setBackground(Color.WHITE);
        add(notexisting);
        
        ButtonGroup existinggroup = new ButtonGroup();
        existinggroup.add(existing);
        existinggroup.add(notexisting);
        
        next = new JButton("Next");
        next.setBounds(680, 760, 100, 40);
        next.setBackground(Color.BLACK);
        next.setFont(new Font("Raleway", Font.BOLD, 18));
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);
        
        setSize(850, 900);
        setLocation(450, 100);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
        setTitle("NEW ACCOUNT AUTHENTICATION - PAGE 2");
        
    }
    
    public void actionPerformed(ActionEvent ae){
        String religion = (String)religionbox.getSelectedItem();
        String catagory = (String)catagorybox.getSelectedItem();
        String income = (String)incomebox.getSelectedItem();
        String education = (String)educationbox.getSelectedItem();
        String occupation = (String)occupationbox.getSelectedItem();
        String pan = panfield.getText();
        String adhar = adharfield.getText();
        
        String seniorcitizen = null;
        if(senior.isSelected()) seniorcitizen = "Yes";
        else if(notsenior.isSelected()) seniorcitizen = "No";
        
        String existingaccount = null;
        if(existing.isSelected()) existingaccount = "Yes";
        else if(notexisting.isSelected()) existingaccount = "No";
        
        try{
            Conn c = new Conn();
            String query = "insert into signuptwo values('"+fromno+"','"+religion+"','"+catagory+"','"+income+"','"+education+"','"+occupation+"','"+pan+"','"+adhar+"','"+seniorcitizen+"','"+existingaccount+"')";
            c.s.executeUpdate(query);
            
            setVisible(false);
            new SignupThree(fromno).setVisible(true);
        }catch (Exception e){
            System.out.println(e);
        }
        
    }
    
    public static void main(String args[]){
        new SignupTwo("");
    }
}
