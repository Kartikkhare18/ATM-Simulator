package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Transactions extends JFrame implements ActionListener{

    JLabel text;
    JButton deposit,withdrawal,fastcash,ministatement,pinchange,balance_enquiry,exit;
    String pinnumber;
    
    Transactions(String pinnumber){
        this.pinnumber = pinnumber;        
        setLayout(null);
        
        //image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        //top message
        text = new JLabel("Please Select Your Transaction");
        text.setBounds(210, 300, 700, 35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        add(text);
        
        //option 1 deposit
        deposit = new JButton("DEPOSIT");
        deposit.setBounds(170,415,150,30);
        deposit.addActionListener(this);
        image.add(deposit);                
        
        //option 2 cash withdrawal
        withdrawal = new JButton("CASH WITHDRAWL");
        withdrawal.setBounds(355,415,150,30);                      
        withdrawal.addActionListener(this);
        image.add(withdrawal);
        
        //option 3 fastcash
        fastcash = new JButton("FAST CASH");
        fastcash.setBounds(170,450,150,30);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        //option 4 mini statement
        ministatement = new JButton("MINI STATEMENT");
        ministatement.setBounds(355,450,150,30);
        ministatement.addActionListener(this);
        image.add(ministatement);
        
        //option 5 change pin
        pinchange= new JButton("PIN CHANGE");
        pinchange.setBounds(170,485,150,30);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        //option 6 balance enquiry
        balance_enquiry = new JButton("BALANCE ENQUIRY");
        balance_enquiry.setBounds(355,485,150,30);
        balance_enquiry.addActionListener(this);
        image.add(balance_enquiry);
        
        //option 7 exit
        exit = new JButton("EXIT");
        exit.setBounds(355,520,150,30);
        exit.addActionListener(this);
        image.add(exit);      
                
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);       
    }
    
    public void actionPerformed(ActionEvent ae){
        //EXIT
        if(ae.getSource()==exit)
        { 
            System.exit(0);
        }
        //DEPOSIT
        else if(ae.getSource()==deposit)
        { 
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }
        //WITHDRAWAL
        else if(ae.getSource()==withdrawal)
        { 
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        }
        //FAST CASH
        else if(ae.getSource()==fastcash)
        { 
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        }
        //PIN NUMBER
        else if(ae.getSource()==pinchange)
        { 
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        }
        // BALANCE INQUIRY
        else if(ae.getSource()==balance_enquiry)
        { 
            this.setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }
        //MINI STATEMENT
        else if(ae.getSource()==ministatement)
        { 
            new MiniStatement(pinnumber).setVisible(true);
        }
    }
    
    public static void main(String[] args){
        new Transactions("");
    }
}
