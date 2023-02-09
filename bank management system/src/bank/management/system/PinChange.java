package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class PinChange extends JFrame implements ActionListener{
        
    JButton change, back;
    JLabel text, pintext, repintext;
    JPasswordField pin,repin;
    String pinnumber;
    
    PinChange(String pinnumber){
        this.pinnumber = pinnumber;
        
        setLayout(null);
        
        //image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        
        //Change PIN text
        text = new JLabel("CHANGE YOUR PIN");
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setForeground(Color.WHITE);
        text.setBounds(250,280,500,35);
        image.add(text);
        
        //NEW PIN text
        pintext = new JLabel("NEW PIN");
        pintext.setFont(new Font("System", Font.BOLD, 16));
        pintext.setForeground(Color.WHITE);
        pintext.setBounds(165,320,180,25);
        image.add(pintext);
        
        //textfield to enter pin
        pin = new JPasswordField();
        pin.setFont(new Font("Raleway", Font.BOLD, 16));
        pin.setBounds(330,320,180,25);
        image.add(pin);
                
        //Re enter new PIN text
        repintext = new JLabel("RE-ENTER NEW PIN");
        repintext.setFont(new Font("System", Font.BOLD, 16));
        repintext.setForeground(Color.WHITE);
        repintext.setBounds(165,360,180,25);
        image.add(repintext);
        
        //textfield to re enter new pin
        repin = new JPasswordField();
        repin.setFont(new Font("Raleway", Font.BOLD, 16));
        repin.setBounds(330,360,180,25);
        image.add(repin);
        
        //change button
        change = new JButton("CHANGE");
        change.setBounds(355,485,150,30);
        change.addActionListener(this);       
        image.add(change);
        
        //back button
        back = new JButton("BACK");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);
        
        
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);   
        
    }   
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == change)
        {
        try{        
            String npin = pin.getText(); //new pin
            String rpin = repin.getText(); // re enter pin
            
            //if enetered pin is wrong
            if(!npin.equals(rpin))
            {
                JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                return;
            }
            
            //if new pin isn't entered
            if(!npin.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please enter new PIN");
                return;
            }
            
            //if the user didn't re-entered the pin 
            if(!rpin.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please re-enter PIN");
                return;
            }
            
            //database connection
            Conn conn = new Conn();
            String query1 = "update bank set pin = '"+rpin+"' where pin = '"+pinnumber+"' ";
            String query2 = "update login set pin = '"+rpin+"' where pin = '"+pinnumber+"' ";
            String query3 = "update signup3 set pin = '"+rpin+"' where pin = '"+pinnumber+"' ";

            conn.s.executeUpdate(query1);
            conn.s.executeUpdate(query2);
            conn.s.executeUpdate(query3);

            JOptionPane.showMessageDialog(null, "PIN changed successfully");
            setVisible(false);
            new Transactions(rpin).setVisible(true);
            
            }catch(Exception e){
            System.out.println(e);
        }
        }
        else
            {
                //back to transaction class
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            }
    } 
    public static void main(String[] args)
    {
        new PinChange("");
    }   
}
