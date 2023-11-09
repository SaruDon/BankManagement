import javax.naming.spi.DirStateFactory.Result;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener{
    
    JButton login,signUp,pin,clear;
    JTextField cardNoEnter;
    JPasswordField pinField;
    
    Login(){

        setTitle("Login page");
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("./icons/logo.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        add(label);
        label.setBounds(70, 10, 100, 100);

        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward", Font.BOLD,38));
        text.setBounds(300, 40, 500, 40);
        add(text);

        JLabel cardNo= new JLabel("Card No");
        cardNo.setFont(new Font("Osward", Font.PLAIN,28));
        cardNo.setBounds(100, 150, 200, 40);
        add(cardNo);
        
        cardNoEnter = new JTextField();
        cardNoEnter.setBounds(250, 150, 300, 40);
        add(cardNoEnter);


        JLabel pin= new JLabel("Pin");
        pin.setFont(new Font("Osward", Font.PLAIN,28));
        pin.setBounds(100, 200, 500, 40);
        add(pin);

        pinField = new JPasswordField();
        pinField.setBounds(250, 200, 300, 40);
        add(pinField);

         login = new JButton("Login");
        login.setBounds(275, 275, 100, 50);
        login.setBackground(Color.DARK_GRAY);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
         
         clear = new JButton("Clear");
        clear.setBounds(400, 275, 100, 50);
        clear.setBackground(Color.DARK_GRAY);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        
         signUp = new JButton("Sign Up");
        signUp.setBounds(275, 350, 225, 50);
        signUp.setBackground(Color.DARK_GRAY);
        signUp.setForeground(Color.WHITE);
        signUp.addActionListener(this);
        add(signUp);
        

        setSize(800,480);
        setVisible(true);
        setLocation(350,200);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==clear) {
            cardNoEnter.setText("");
            pinField.setText("");
        }
        if (ae.getSource()==signUp) {
            setVisible(false);// to close current frame
            Signup signupOne = new Signup();
            signupOne.setVisible(true);
        }
        if (ae.getSource()==login) {
            Conn conn = new Conn();
            String cardnumber = cardNoEnter.getText();
            String pinnumber = pinField.getText();
            String query ="select *from logintable where cardnumber = '"+cardnumber+"' and pinno ='"+pinnumber+"'";
            try {
                ResultSet rs = conn.s.executeQuery(query);
                if (rs.next()) {
                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Incorrect Id or PIN");
                }
            } catch (Exception e) {
               System.out.println(e);
            }
        }
    }
    public static void main(String[] args) {
        new Login();
    }
}

