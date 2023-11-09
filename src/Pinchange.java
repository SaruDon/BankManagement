import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Pinchange extends JFrame implements ActionListener{
    
    String pinnumber;
    JPasswordField pin,reEnterPin;
    JButton change,back;
    
    Pinchange(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
        setBackground(Color.WHITE);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);


        JLabel text = new JLabel("Change your pin");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(165,320,180,25);
        image.add(text);

        JLabel text2 = new JLabel("Re-Enter new Pin");
        text2.setForeground(Color.WHITE);
        text2.setFont(new Font("System",Font.BOLD,16));
        text2.setBounds(165,360,180,25);
        image.add(text2);

        pin = new JPasswordField();
        pin.setFont(new Font("Raleway",Font.BOLD,25));
        pin.setBounds(330,320,180,25);
        image.add(pin);

        reEnterPin = new JPasswordField();
        reEnterPin.setFont(new Font("Raleway",Font.BOLD,25));
        reEnterPin.setBounds(330,360,180,25);
        image.add(reEnterPin);

        change = new JButton("Change");
        change.setBackground(Color.DARK_GRAY);
        change.setForeground(Color.WHITE);
        change.setBounds(355,485,150,30);
        change.addActionListener(this);
        image.add(change);

        back = new JButton("Back");
        back.setBackground(Color.DARK_GRAY);
        back.setForeground(Color.WHITE);
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);
    }
    

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==back) {
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }else{
            try {
                String npin =pin.getText();
                String rpin = reEnterPin.getText();
                if (!npin.equals(rpin)) {
                    JOptionPane.showMessageDialog(null,"pin does not match");
                    return;
                }
                if (npin.equals("")) {
                    JOptionPane.showMessageDialog(null,"pin cannot be empty");
                    return;
                }if (rpin.equals("")) {
                    JOptionPane.showMessageDialog(null,"pin cannot be empty");
                    return;
                }
                Conn conn = new Conn();
                String query = "update bank set pin ='"+npin+"' where pin ='"+pinnumber+"'";
                String query1 = "update logintable set pinno ='"+npin+"' where pinno ='"+pinnumber+"'";
                String query2 = "update signupthree set pinno ='"+npin+"' where pinno ='"+pinnumber+"'";

                conn.s.executeUpdate(query);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query1);

                JOptionPane.showMessageDialog(null, "Password "+pinnumber+"Updated to: "+npin);

                setVisible(false);
                new Transaction(rpin).setVisible(true);
                
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
    
    
    public static void main(String[] args) {
        new Pinchange("");
    }
}
