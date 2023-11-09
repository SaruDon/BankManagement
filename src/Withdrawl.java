import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.TextField;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Withdrawl extends JFrame implements ActionListener {
    
    JTextField amount;
    JButton withdraw,back;
    String pinnumber;

    Withdrawl(String pinnumber){
        this.pinnumber = pinnumber;
        setBackground(Color.WHITE);
        
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);


        JLabel text = new JLabel("Enter the amount you want to Withdraw");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(170,300,400,20);
        image.add(text);

        amount = new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,22));
        amount.setBounds(170, 350, 320, 20);
        image.add(amount);

        withdraw = new JButton("Withdraw");
        withdraw.setBackground(Color.DARK_GRAY);
        withdraw.setForeground(Color.WHITE);
        withdraw.setBounds(355, 450, 150, 20);
        withdraw.addActionListener(this);
        image.add(withdraw);
        
        back = new JButton("Back");
        back.setBackground(Color.DARK_GRAY);
        back.setForeground(Color.WHITE);
        back.setBounds(355, 480, 150, 20);
        back.addActionListener(this);
        image.add(back);

        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
    }

    // public void actionPerformed(ActionEvent ae){

    // }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==withdraw) {
            try {
                String number = amount.getText();
                int no = Integer.valueOf(number);
                Date date = new Date();
                if (number.equals("")) {
                    JOptionPane.showMessageDialog(null,"Pls enter the amount you want to withdraw");
                }else{
                    Conn conn = new Conn();
                    int balance =0;
                    ResultSet rs = conn.s.executeQuery("select *from bank where pin ='"+pinnumber+"'");
                    while(rs.next()){
                        if(rs.getString("type").equals("Deposit")){
                            balance += Integer.parseInt(rs.getString("amount"));
                        }else{
                            balance -= Integer.parseInt(rs.getString("amount"));
                        }
                    }
                    if (balance<no) {
                        JOptionPane.showMessageDialog(null,"Insufficient Balance ");
                        setVisible(false);
                        new Transaction(pinnumber).setVisible(true);
                    }else{
                        String query1 ="insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+number+"')";
                        conn.s.executeUpdate(query1);
                        JOptionPane.showMessageDialog(null,"Amount "+number+" Withdrawled successfully");
                        setVisible(false);
                        new Transaction(pinnumber).setVisible(true);
                    }
                    
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }else if(ae.getSource()==back){
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
    }
    
    public static void main(String[] args) {
        new Withdrawl("");
    }


}
