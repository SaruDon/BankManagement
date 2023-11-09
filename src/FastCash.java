import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class FastCash extends JFrame implements ActionListener{
    
    JButton back,hundred,fivehundred,thounsand,twothousand,fivethousand,tenthousand;
    String pinnumber;
    FastCash(String pinnumber){
        this.pinnumber= pinnumber;
        setTitle("ATM FastCash");
        setLayout(null);
        setSize(900,900);
        setLocation(300,0);
        setBackground(Color.WHITE);
        // setUndecorated(true);
        setVisible(true);

        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Please select Withdrawl Amount");
        text.setBounds(210,300,700,35);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setForeground(Color.WHITE);
        image.add(text);

         hundred = new JButton("Rs 100");
        hundred.setBounds(170, 415, 150, 30);
        hundred.addActionListener(this);
        image.add(hundred);

         fivehundred = new JButton("Rs 500");
        fivehundred.setBounds(355, 415, 150, 30);
        fivehundred.addActionListener(this);
        image.add(fivehundred);

         thounsand = new JButton("Rs 1000");
        thounsand.setBounds(170, 450, 150, 30);
        thounsand.addActionListener(this);
        image.add(thounsand);

         twothousand = new JButton("Rs 2000");
        twothousand.setBounds(355, 450, 150, 30);
        twothousand.addActionListener(this);
        image.add(twothousand);

         fivethousand = new JButton("Rs 5000");
        fivethousand.setBounds(170, 485, 150, 30);
        fivethousand.addActionListener(this);
        image.add(fivethousand);
        
         tenthousand = new JButton("Rs 10000");
        tenthousand.setBounds(355, 485, 150, 30);
        tenthousand.addActionListener(this);
        image.add(tenthousand);
        
        back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);
    }   
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==back) {
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }else{
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            Conn conn = new Conn();
            try{
                ResultSet rs = conn.s.executeQuery("select *from bank where pin ='"+pinnumber+"'");
                int balance =0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if(ae.getSource()!=back && balance<= Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }
                Date date = new Date();
                String query1 ="insert into bank values('"+pinnumber+"','"+date+"','Withdrawl','"+amount+"')";
                conn.s.executeUpdate(query1);
                JOptionPane.showMessageDialog(null,"Amount "+amount+" Withdrawled successfully");
                
                setVisible(false);
                new Transaction(pinnumber).setVisible(true);
            }catch(Exception e){
                System.out.println(e);
            }

        }
        
    }
    public static void main(String[] args) {
        new FastCash("");
    }
}
