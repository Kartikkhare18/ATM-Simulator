package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Signup2 extends JFrame implements ActionListener{

    JTextField panTextField,aadharTextField;
    JButton next;
    JRadioButton exist_acc_yes, exist_acc_no, senior_yes, senior_no;
    JComboBox religion, category,occupation, qualification, income;
    String formno;
    
    Signup2(String formno) {
        this.formno = formno;
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        
        //Page title
        JLabel additionalDetails = new JLabel("Page 2: Additional Details");                      
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(290,80,400,30);
        add(additionalDetails);
        
        //Religion
        JLabel name = new JLabel("Religion:");                      
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100,140,100,30);
        add(name);
        
        String valReligion[] = {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
        religion = new JComboBox(valReligion);
        religion.setBounds(300, 140, 400, 30);
        religion.setBackground(Color.WHITE);
        add(religion);
        
        //Category
        JLabel fname = new JLabel("Category:");                      
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100,190,200,30);
        add(fname);
        
        String valCategory[] = {"General", "OBC", "SC/ST"};
        category= new JComboBox(valCategory);
        category.setBounds(300, 190, 400, 30);
        category.setBackground(Color.WHITE);
        add(category);
        
        //Income
        JLabel dob = new JLabel("Income:");                      
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100,240,200,30);
        add(dob);
        
        String valIncome[] = {"Null", "1,00,000-2,00,000", "2,00,000-3,00,000", "3,00,000-4,00,000", "4,00,000-5,00,000", "5,00,000-6,00,000","6,00,000-7,00,000", "7,00,000-8,00,000", "8,00,000-9,00,000",  "9,00,000-10,00,000", "10,00,000+"};
        income = new JComboBox(valIncome);
        income.setBounds(300, 240, 400, 30);
        income.setBackground(Color.WHITE);
        add(income);
        
        //Qualification
        JLabel email = new JLabel("Qualification:");                             
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100,290,200,30);
        add(email);
        
        String educationValues[] = {"10th Pass", "12th Pass", "Graduate", "Post-Graduate", "Doctorate", "Other"};
        qualification = new JComboBox(educationValues);
        qualification.setBounds(300, 290, 400, 30);
        qualification.setBackground(Color.WHITE);
        add(qualification);
        
        //Occupation
        JLabel marital = new JLabel("Occupation:");                      
        marital.setFont(new Font("Raleway", Font.BOLD, 20));
        marital.setBounds(100,340,200,30);
        add(marital);
        
        String occupationValues[] = {"Unemployed", "Self-Employed", "Corporate", "Business", "Student", "Retired", "Other"};
        occupation = new JComboBox(occupationValues);
        occupation.setBounds(300, 340, 400, 30);
        occupation.setBackground(Color.WHITE);
        add(occupation);
        
        //PAN Number
        JLabel address = new JLabel("PAN Number:");                      
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100,390,200,30);
        add(address);
        
        panTextField = new JTextField();
        panTextField.setFont(new Font("Raleway", Font.BOLD,14));
        panTextField.setBounds(300, 390, 400, 30);
        add(panTextField);
        
        //Aadhar Number
        JLabel city = new JLabel("Aadhar Number:");                      
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100,440,200,30);
        add(city);
        
        aadharTextField = new JTextField();
        aadharTextField.setFont(new Font("Raleway", Font.BOLD,14));
        aadharTextField.setBounds(300, 440, 400, 30);
        add(aadharTextField);
        
        //Senior Citizen
        JLabel state = new JLabel("Senior Citizen:");                      
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100,490,200,30);
        add(state);
        
        senior_yes = new JRadioButton("Yes");
        senior_yes.setBounds(300,490,100,30);
        senior_yes.setBackground(Color.WHITE);
        add(senior_yes);
        
        senior_no = new JRadioButton("No");
        senior_no.setBounds(450,490,100,30);
        senior_no.setBackground(Color.WHITE);
        add(senior_no);
        
        ButtonGroup seniorgroup = new ButtonGroup();
        seniorgroup.add(senior_yes);
        seniorgroup.add(senior_no);  
        
        //Existing Account
        JLabel pincode = new JLabel("Existing Account:");                      
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        pincode.setBounds(100,540,200,30);
        add(pincode);
        
        exist_acc_yes = new JRadioButton("Yes");
        exist_acc_yes.setBounds(300,540,100,30);
        exist_acc_yes.setBackground(Color.WHITE);
        add(exist_acc_yes);
        
        exist_acc_no = new JRadioButton("No");
        exist_acc_no.setBounds(450,540,100,30);
        exist_acc_no.setBackground(Color.WHITE);
        add(exist_acc_no);
        
        ButtonGroup accgroup = new ButtonGroup();
        accgroup.add(exist_acc_yes);
        accgroup.add(exist_acc_no);
        
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        //drop down items
        String sreligion = (String)religion.getSelectedItem();
        String scategory = (String)category.getSelectedItem();
        String sincome = (String)income.getSelectedItem();
        String squalification= (String)qualification.getSelectedItem();
        String soccupation = (String)occupation.getSelectedItem();
        
        //text field items
        String span = panTextField.getText();
        String saadhar = aadharTextField.getText();
        
        //Senior Citizen Selection
        String seniorcitizen = null;
        if (senior_yes.isSelected())
        {
            seniorcitizen = "yes";
        }
        else if (senior_no.isSelected())
        {
            seniorcitizen = "No";
        }
        
        //Existing Account selection
        String existacc = null;
        if(exist_acc_yes.isSelected())
        {
            existacc = "Yes";
        }
        else if (exist_acc_no.isSelected())
        {
            existacc = "No";
        }
        
        //database connection
        try{
               Conn c = new Conn();
               String query =  "insert into signup2 values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+squalification+"','"+soccupation+"','"+span+"','"+saadhar+"','"+seniorcitizen+"','"+existacc+"')";
               c.s.executeUpdate(query);
               
               //signup 3 class
               setVisible(false);
               new Signup3(formno).setVisible(true);
        }catch (Exception e)
        {
            System.out.println(e);
        }
    } 
    
    public static void main(String args[])
{
    new Signup2("");
}
}