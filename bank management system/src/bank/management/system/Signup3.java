package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.sql.*;

public class Signup3 extends JFrame implements ActionListener{
    
    JRadioButton saveAcc,curAcc, recAcc, fixDepAcc;
    JCheckBox atm_card, internet_bank, mob_bank, alerts, cheque_book, e_stat, declaration;
    JButton submit,cancel;
    String formno;
    
    Signup3(String formno){
        
        this.formno = formno;
        setLayout(null);
        
        //Page title
        JLabel accDetails = new JLabel("Page 3: Account Details");                      
        accDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        accDetails.setBounds(280,40,400,40);
        add(accDetails);
        
        //Account type
        JLabel accType = new JLabel("Account Type");                      
        accType.setFont(new Font("Raleway", Font.BOLD, 22));
        accType.setBounds(100,140,200,30);
        add(accType);
        
        //type 1
        saveAcc = new JRadioButton("Savings Account");
        saveAcc.setFont(new Font ("Raleway", Font.BOLD, 16));
        saveAcc.setBackground(Color.WHITE);
        saveAcc.setBounds(100, 180, 250, 20);
        add(saveAcc);
        
        //type 2
        fixDepAcc = new JRadioButton("Fix Deposit Account");
        fixDepAcc.setFont(new Font ("Raleway", Font.BOLD, 16));
        fixDepAcc.setBackground(Color.WHITE);
        fixDepAcc.setBounds(350, 180, 250, 20);
        add(fixDepAcc);
        
        //type 3
        curAcc = new JRadioButton("Current Account");
        curAcc.setFont(new Font ("Raleway", Font.BOLD, 16));
        saveAcc.setBackground(Color.WHITE);
        curAcc.setBounds(100, 220, 250, 20);
        add(curAcc);
        
        //type 4
        recAcc = new JRadioButton("Recurring Deposit Account");
        recAcc.setFont(new Font ("Raleway", Font.BOLD, 16));
        recAcc.setBackground(Color.WHITE);
        recAcc.setBounds(350, 220, 250, 20);
        add(recAcc);
        
        ButtonGroup groupaccount = new ButtonGroup();
        groupaccount.add(saveAcc);
        groupaccount.add(fixDepAcc);
        groupaccount.add(curAcc);
        groupaccount.add(recAcc);
        
        //Card number
        JLabel card = new JLabel("Card Number:");                      
        card.setFont(new Font("Raleway", Font.BOLD, 22));
        card.setBounds(100,300,200,30);
        add(card);
        
        JLabel number = new JLabel("XXXX-XXXX-XXXX-XXXX");                      
        number.setFont(new Font("Raleway", Font.BOLD, 22));
        number.setBounds(330,300,300,30);
        add(number);
        
        //card detail
        JLabel carddetail= new JLabel("Your 16 digit card number.");                      
        carddetail.setFont(new Font("Raleway", Font.BOLD, 12));
        carddetail.setBounds(100,330,300,20);
        add(carddetail);       
        
        // PIN
        JLabel pin = new JLabel("PIN:");                      
        pin.setFont(new Font("Raleway", Font.BOLD, 22));
        pin.setBounds(100,370,200,30);
        add(pin);
        
        JLabel pin_number = new JLabel("XXXX");                      
        pin_number.setFont(new Font("Raleway", Font.BOLD, 22));
        pin_number.setBounds(330,370,300,30);
        add(pin_number);
        
        //pin detail
        JLabel services = new JLabel("Your 4 digit PIN number.");                      
        services.setFont(new Font("Raleway", Font.BOLD, 12));
        services.setBounds(100,400,200,20);
        add(services);
        
        //Services required
        JLabel card_detail= new JLabel("Services Required:");                      
        card_detail.setFont(new Font("Raleway", Font.BOLD, 22));
        card_detail.setBounds(100,450,250,20);
        add(card_detail);
        
        //Service Buttons 
        
        //atm card button 1
        atm_card = new JCheckBox("ATM CARD");
        atm_card.setBackground(Color.WHITE);
        atm_card.setFont(new Font("Raleway", Font.BOLD, 16));
        atm_card.setBounds(100,500,200,30);
        add(atm_card);
        
        //internet banking button 2
        internet_bank = new JCheckBox("Internet Banking");
        internet_bank.setBackground(Color.WHITE);
        internet_bank.setFont(new Font("Raleway", Font.BOLD, 16));
        internet_bank.setBounds(350,500,200,30);
        add(internet_bank);
        
        //mobile banking button 3
        mob_bank = new JCheckBox("Mobile Banking");
        mob_bank.setBackground(Color.WHITE);
        mob_bank.setFont(new Font("Raleway", Font.BOLD, 16));
        mob_bank.setBounds(100,550,200,30);
        add(mob_bank);
        
        //Email Alerts/SMS Alerts button 4
        alerts = new JCheckBox("Email & SMS Alerts");
        alerts.setBackground(Color.WHITE);
        alerts.setFont(new Font("Raleway", Font.BOLD, 16));
        alerts.setBounds(350,550,200,30);
        add(alerts);
        
        //Cheque Book button 5
        cheque_book = new JCheckBox("Cheque Book");
        cheque_book.setBackground(Color.WHITE);
        cheque_book.setFont(new Font("Raleway", Font.BOLD, 16));
        cheque_book.setBounds(100,600,200,30);
        add(cheque_book);
        
        //E-Statement button 6
        e_stat = new JCheckBox("E-Statement");
        e_stat.setBackground(Color.WHITE);
        e_stat.setFont(new Font("Raleway", Font.BOLD, 16));
        e_stat.setBounds(350,600,200,30);
        add(e_stat);
        
        //Declaration button 7 (different from above option buttons)
        declaration = new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge.");
        declaration.setBackground(Color.WHITE);
        declaration.setFont(new Font("Raleway", Font.BOLD, 12));
        declaration.setBounds(100,680,600,30);
        add(declaration);
        
        //submit button
        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBounds(250,720,100,30);
        submit.addActionListener(this);
        add(submit);
        
        //cancel button
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.setBounds(420,720,100,30);
        cancel.addActionListener(this);
        add(cancel);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850,820);
        setLocation(350,0);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit)
        {
           String accountType = null;
           if(saveAcc.isSelected())
           {
               accountType = "Saving Account";
           }
           else if (fixDepAcc.isSelected())
           {
               accountType = " Account";
           }
           else if (curAcc.isSelected())
           {
               accountType = "Current Account";
           }
           else if (recAcc.isSelected())
           {
               accountType = "Recurring Deposit Account";
           }
           
           //random card and pin number generation
           Random random = new Random();
           String cardnumber = "" + Math.abs((random.nextLong() % 9000000L) + 5040956000000000L);
           
           String pinnumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);
           
           //Service buttons facility
           String facility = "";
                   if (atm_card.isSelected())
                   {
                       facility = facility + "ATM Card";
                   }
                   else if (internet_bank.isSelected())
                   {
                       facility = facility + "Internet Banking";
                   }
                   else if (mob_bank.isSelected())
                   {
                       facility = facility + "Mobile Banking";
                   }
                   else if (alerts.isSelected())
                   {
                       facility = facility + "Email & SMS Alerts";
                   }
                   else if (cheque_book.isSelected())
                   {
                       facility = facility + "Cheque Book";
                   }
                   else if (e_stat.isSelected())
                   {
                       facility = facility + "E-Statement";
                   }                   
                   
                   //database connection
                   try{
                      if(accountType.equals(""))
                      {
                         JOptionPane.showMessageDialog(null, "Account Type is required");
                      }
                      else
                      {
                          Conn conn = new Conn();
                          String query1 = "insert into signup3 values('"+formno+"', '"+accountType+"', '"+cardnumber+"', '"+pinnumber+"', '"+facility+"')";   
                          String query2 = "insert into login values('"+formno+"','"+cardnumber+"', '"+pinnumber+"')";   

                          conn.s.executeUpdate(query1);
                          conn.s.executeUpdate(query2);
                          JOptionPane.showMessageDialog(null, "Card Number: " + cardnumber + "\n Pin: " + pinnumber);
                      
                          setVisible(false);
                          new Deposit(pinnumber).setVisible(false);
                      }
                   }catch (Exception e){
                       System.out.println(e);
                   }          
        }
        else if (ae.getSource() == cancel)
        {
            //back to login class
            setVisible(false);
            new Login().setVisible(true);
        }
    }    
    public static void main(String[] args){
        new Signup3("");
    }   
}