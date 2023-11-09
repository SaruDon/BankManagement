import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JCalendar;
import java.awt.event.*;
import java.sql.*;



import java.awt.*;


public class Signup extends  JFrame implements ActionListener {
    
    JTextField namTextField,fnamTextField,emailTextField,addressTextField,pincodeTextField,cityTextField,stateTextField;
    JButton next;
    JRadioButton male,female,married,other,unmarried;
    JDateChooser dateChooser;
    long rand;

    Signup(){
        setLayout(null);

        Random ran = new Random(); // Corrected the variable name.
        rand=Math.abs((ran.nextLong() % 9000L) + 1000L); // Added a semicolon at the end.
        JLabel formNo = new JLabel("Application form number"+rand);
        formNo.setFont(new Font("Raleway",Font.PLAIN,38));
        formNo.setBounds(140,20,600,40);
        add(formNo);


        JLabel personalDetails = new JLabel("Page 1: Personal Details");
        personalDetails.setFont(new Font("Raleway",Font.PLAIN,22));
        personalDetails.setBounds(290,80,400,30);
        add(personalDetails);

        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Raleway",Font.PLAIN,22));
        name.setBounds(100,140,200,30);
        add(name);

        namTextField= new JTextField();
        namTextField.setFont(new Font("Raleway",Font.PLAIN,22));
        namTextField.setBounds(300,140,400,30);
        add(namTextField);

        JLabel fname = new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway",Font.PLAIN,22));
        fname.setBounds(100,190,200,30);
        add(fname);

        fnamTextField= new JTextField();
        fnamTextField.setFont(new Font("Raleway",Font.PLAIN,22));
        fnamTextField.setBounds(300,190,400,30);
        add(fnamTextField);

        JLabel dob = new JLabel("Date Of Birth:");
        dob.setFont(new Font("Raleway",Font.PLAIN,22));
        dob.setBounds(100,240,200,30);
        add(dob);

         dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 240, 400, 30);
        add(dateChooser);

        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway",Font.PLAIN,22));
        gender.setBounds(100,290,200,30);
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(300,290,75,30);
        add(male);
        
        female = new JRadioButton("Female");
        female.setBounds(450,290,75,30);
        add(female);

        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);

        JLabel email = new JLabel("Email:");
        email.setFont(new Font("Raleway",Font.PLAIN,22));
        email.setBounds(100,340,200,30);
        add(email);

        emailTextField= new JTextField();
        emailTextField.setFont(new Font("Raleway",Font.PLAIN,22));
        emailTextField.setBounds(300,340,400,30);
        add(emailTextField);

        JLabel marital = new JLabel("Marital Status:");
        marital.setFont(new Font("Raleway",Font.PLAIN,22));
        marital.setBounds(100,390,200,30);
        add(marital);

         married = new JRadioButton("Married");
        married.setBounds(300,390,75,30);
        add(married);

         other = new JRadioButton("Other");
        other.setBounds(600,390,75,30);
        add(other);
        
         unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(450,390,90,30);
        add(unmarried);

        ButtonGroup maritalStausGroup = new ButtonGroup();
        maritalStausGroup.add(married);
        maritalStausGroup.add(unmarried);
        maritalStausGroup.add(other);


        JLabel address = new JLabel("Address");
        address.setFont(new Font("Raleway",Font.PLAIN,22));
        address.setBounds(100,440,200,30);
        add(address);

        addressTextField= new JTextField();
        addressTextField.setFont(new Font("Raleway",Font.PLAIN,22));
        addressTextField.setBounds(300,440,400,30);
        add(addressTextField);

        JLabel city = new JLabel("City");
        city.setFont(new Font("Raleway",Font.PLAIN,22));
        city.setBounds(100,490,200,30);
        add(city);

        cityTextField= new JTextField();
        cityTextField.setFont(new Font("Raleway",Font.PLAIN,22));
        cityTextField.setBounds(300,490,400,30);
        add(cityTextField);


        JLabel state = new JLabel("State");
        state.setFont(new Font("Raleway",Font.PLAIN,22));
        state.setBounds(100,540,200,30);
        add(state);

        stateTextField= new JTextField();
        stateTextField.setFont(new Font("Raleway",Font.PLAIN,22));
        stateTextField.setBounds(300,540,400,30);
        add(stateTextField);

        JLabel pinCode = new JLabel("Pincode");
        pinCode.setFont(new Font("Raleway",Font.PLAIN,22));
        pinCode.setBounds(100,590,200,30);
        add(pinCode);

        pincodeTextField= new JTextField();
        pincodeTextField.setFont(new Font("Raleway",Font.PLAIN,22));
        pincodeTextField.setBounds(300,590,400,30);
        add(pincodeTextField);

        next = new JButton("Next");
        next.setBackground(Color.GRAY);
        next.setForeground(Color.WHITE);
        next.setFont(new Font ("Raleway",Font.BOLD, 14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);


        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        String sformNo = ""+ rand;
        String name = namTextField.getText();
        String fname = fnamTextField.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText(); 
        String gender = null;
        if (male.isSelected()) {
            gender = "Male";
        }else{
            gender = "Female";
        }    
        String email = emailTextField.getText();
        String marital =null;
        if (married.isSelected()) {
            marital = "Married";
        }
        else if (married.isSelected()) {
            marital = "Unmarried";
        }
        else  {
            marital = "Other";
        }
        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pin = pincodeTextField.getText();


        try{
            if (name.equals("")) {
                JOptionPane.showMessageDialog(null, "Name is Required");
            } else {
                Conn c = new Conn(); // Create a Conn object
                String query = "insert into signup values ('" + sformNo + "','" + name + "','" + fname + "','" + dob + "','" + gender + "','" + email + "','" + marital + "','" + address + "','" + city + "','" + pin + "','" + state + "')";
                c.s.executeUpdate(query); // Use the s field from the Conn object

                setVisible(false);
                new SignupTwo(sformNo).setVisible(true);
            }
        }catch(Exception e){
            System.out.println(e);
        }

    }
    
    public static void main(String[] args) {
       new Signup();    
    }



}
