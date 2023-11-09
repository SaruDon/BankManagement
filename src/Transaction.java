import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Transaction extends JFrame implements ActionListener{
    
    JButton exit,deposit,withdrawl,fastcash,ministatement,pinchange,balenceenquiry;
    String pinnumber;
    Transaction(String pinnumber){
        this.pinnumber= pinnumber;
        setTitle("ATM Transaction");
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

        JLabel text = new JLabel("Please select your Transactions");
        text.setBounds(210,300,700,35);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setForeground(Color.WHITE);
        image.add(text);

         deposit = new JButton("Deposit");
        deposit.setBounds(170, 415, 150, 30);
        deposit.addActionListener(this);
        image.add(deposit);

         withdrawl = new JButton("Cash Withdrowl");
        withdrawl.setBounds(355, 415, 150, 30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);

         fastcash = new JButton("Fast Cash");
        fastcash.setBounds(170, 450, 150, 30);
        fastcash.addActionListener(this);
        image.add(fastcash);

         ministatement = new JButton("Mini Statement");
        ministatement.setBounds(355, 450, 150, 30);
        ministatement.addActionListener(this);
        image.add(ministatement);

         pinchange = new JButton("Change Pin");
        pinchange.setBounds(170, 485, 150, 30);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
         balenceenquiry = new JButton("Balence Enquiry");
        balenceenquiry.setBounds(355, 485, 150, 30);
        balenceenquiry.addActionListener(this);
        image.add(balenceenquiry);
        
        exit = new JButton("Exit");
        exit.setBounds(355, 520, 150, 30);
        exit.addActionListener(this);
        image.add(exit);
    }   
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==exit) {
            System.exit(0);
        }else if (ae.getSource() == deposit) {
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }else if (ae.getSource() == withdrawl) {
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        }else if (ae.getSource()==fastcash) {
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        }else if (ae.getSource()==pinchange) {
            setVisible(false);
            new Pinchange(pinnumber).setVisible(true);
        }else if (ae.getSource()==balenceenquiry) {
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }else if (ae.getSource()==ministatement) {
            new MiniStatements(pinnumber).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new Transaction("");
    }
}
