import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class SignupThree extends JFrame implements ActionListener{
    

    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JCheckBox[] checkboxes;
    JButton submit, cancel;
    String sformNo;


    SignupThree(String sformNo){
        this.sformNo= sformNo;
        setLayout(null); 

        setSize(850,820);
        setLocation(350,0);
        setVisible(true);
        setBackground(Color.WHITE);
        
        JLabel l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway",Font.BOLD,22));
        l1.setBounds(280,40,400,40);
        add(l1);


        JLabel type = new JLabel("Account type");
        type.setFont(new Font("Raleway",Font.BOLD,22));
        type.setBounds(100,140,200,40);
        add(type);
        
        r1 = new JRadioButton("Savings Account:");
        r1.setFont(new Font("Raleway",Font.PLAIN,16));
        r1.setBackground(Color.WHITE);
        r1.setBounds(100,200,150,20);
        add(r1);

        r2 = new JRadioButton("Fiexed Deposit Acc:");
        r2.setFont(new Font("Raleway",Font.PLAIN,16));
        r2.setBackground(Color.WHITE);
        r2.setBounds(400,200,200,20);
        add(r2);

        r3 = new JRadioButton("Current Account:");
        r3.setFont(new Font("Raleway",Font.PLAIN,16));
        r3.setBackground(Color.WHITE);
        r3.setBounds(100,250,200,20);
        add(r3);
        
        r4 = new JRadioButton("Recurring Deposit Acc:");
        r4.setFont(new Font("Raleway",Font.PLAIN,16));
        r4.setBackground(Color.WHITE);
        r4.setBounds(400,250,200,20);
        add(r4);

        ButtonGroup accounttype = new ButtonGroup();
        accounttype.add(r1);
        accounttype.add(r2);
        accounttype.add(r3);
        accounttype.add(r4);


        JLabel card = new JLabel("Card No:");
        card.setFont(new Font("Raleway",Font.BOLD,22));
        card.setBounds(100,300,200,40);
        add(card);


        JLabel number = new JLabel("XXXX XXXX XXXX 4184");
        number.setFont(new Font("Raleway",Font.BOLD,22));
        number.setBounds(330,300,300,40);
        add(number);

        JLabel carddetail = new JLabel("This is your 16 digit card NO");
        carddetail.setFont(new Font("Raleway",Font.BOLD,12));
        carddetail.setBounds(330,320,200,40);
        add(carddetail);

        JLabel pin = new JLabel("PIN");
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        pin.setBounds(100,390,200,40);
        add(pin);

        
        JLabel pnumber = new JLabel("XXXX");
        pnumber.setFont(new Font("Raleway",Font.BOLD,22));
        pnumber.setBounds(330,390,300,40);
        add(pnumber);

        JLabel pindetail = new JLabel("This is your 4 digit pin no");
        pindetail.setFont(new Font("Raleway",Font.BOLD,12));
        pindetail.setBounds(330,410,200,40);
        add(pindetail);

        JLabel servicLabel = new JLabel("Service required:");
        servicLabel.setFont(new Font("Raleway",Font.BOLD,22));;
        servicLabel.setBounds(100,460,200,30);
        add(servicLabel);
        
        c1 = new JCheckBox("ATM Card");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBounds(100,500,200,30);
        add(c1);

        c2 = new JCheckBox("Interner Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBounds(330,500,200,30);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        c3.setBounds(100,550,200,30);
        add(c3);
     

        c4 = new JCheckBox("Email & SMS alert");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        c4.setBounds(330,550,200,30);
        add(c4);

        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        c5.setBounds(100,600,200,30);
        add(c5);

        c6 = new JCheckBox("E-Statement");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway",Font.BOLD,16));
        c6.setBounds(330,600,200,30);
        add(c6); 
        
        c7 = new JCheckBox(" I hereby declare that the information given above and in the enclosed documents is true ");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway", Font.BOLD, 16));
        c7.setBounds(80,660,700,30);
        add(c7);

        submit = new JButton("Submit");
        submit.setBackground(Color.GRAY);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway",Font.BOLD,14));
        submit.setBounds(250,720,100,30);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.GRAY);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway",Font.BOLD,14));
        cancel.setBounds(420,720,100,30);
        cancel.addActionListener(this);
        add(cancel);

        getContentPane().setBackground(Color.WHITE);

    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==submit) {
            String accountType = null;
            if (r1.isSelected()) {
                accountType="Savings Account";
            }else if (r2.isSelected()) {
                accountType ="Fiexed Deposit Account";
            }else if(r3.isSelected()){
                accountType="Current Account";
            }else if (r4.isSelected()) {
                accountType="Recurring Deposit Acc";
            }
            Random random = new Random();
            String cardnumber =""+Math.abs((random.nextLong()%90000000L) + 5040936000000000L);
            String pinnumber =""+Math.abs((random.nextLong()%9000L)+1000L);
            String facility= null;
            if (c1.isSelected()) {
                facility = facility+"ATM card ";
            }else if (c2.isSelected()) {
                facility += " Interner Banking";
            }else if (c3.isSelected()) {
                facility += " Mobile Banking ";
            }else if (c4.isSelected()) {
                facility += " Email & SMS alert ";
            }else if (c5.isSelected()) {
                facility += " Cheque Book ";
            }else if (c6.isSelected()) {
                facility += " E-Statement ";
            }

            try {
                if (accountType.equals("")) {
                    JOptionPane.showInputDialog("","Account type is required");
                }else{
                    Conn conn = new Conn();
                    String query1 = "insert into signupthree values ('" + sformNo + "','" + accountType + "','" + cardnumber + "','" + pinnumber + "','" + facility + "')";
                    String query2 = "insert into logintable values ('" + sformNo + "','" + cardnumber + "','" + pinnumber + "')";
                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);

                    JOptionPane.showMessageDialog(null, "Card Number"+cardnumber+"\n PIN: "+pinnumber);
                    
                    setVisible(false);
                    new Deposit(pinnumber).setVisible(true);
                }
            } catch (Exception e) {
                System.out.println(e);
            }

        }else if(ae.getSource()== cancel){
            setVisible(false);
            new Login().setVisible(true);
        }
    }
    
    
    public static void main(String[] args) {
        new SignupThree("");
    }


}
