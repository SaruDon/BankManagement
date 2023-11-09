import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.*;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class SignupTwo extends JFrame implements ActionListener{
    

    JComboBox religionBox,categoryBox,incomeBox,qualificationBox,occupationBox;
    JTextField panNo,aadharNo;
    JRadioButton yes,no;
    JButton nextButton;
    String sformNo;

    SignupTwo(String sformNo){
        this.sformNo = sformNo;
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);

        setTitle("Page 2: Additional Details ");

        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway",Font.PLAIN,30));
        additionalDetails.setBounds(250,20,400,50);
        add(additionalDetails);

        JLabel religion = new JLabel("Religion");
        religion.setFont(new Font("Raleway",Font.PLAIN,26));
        religion.setBounds(70,100,400,30);
        add(religion);


        String valReligion[] = {"Hindu","Sikh","Christian","Muslim","Parsi","Jain"};
        categoryBox = new JComboBox(valReligion);
        categoryBox.setFont(new Font("Raleway",Font.BOLD,20));
        categoryBox.setBounds(300, 100, 400, 30); 
        add(categoryBox);

        JLabel category = new JLabel("Category:");
        category.setFont(new Font("Raleway",Font.PLAIN,26));
        category.setBounds(70,160,400,30);
        add(category);


        String valCategory[] = {"SC","ST","OPEN","NT"};
        religionBox = new JComboBox(valCategory);
        religionBox.setFont(new Font("Raleway",Font.PLAIN,20));
        religionBox.setBounds(300, 160, 400, 30); 
        add(religionBox);


        JLabel income = new JLabel("Income:");
        income.setFont(new Font("Raleway",Font.PLAIN,26));
        income.setBounds(70,210,400,30);
        add(income);

        String incomeCategory[] = {"Null","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000"};
        incomeBox = new JComboBox(incomeCategory);
        incomeBox.setFont(new Font("Raleway",Font.PLAIN,20));
        incomeBox.setBounds(300, 210, 400, 30); 
        add(incomeBox);

        JLabel education = new JLabel("Qducation");
        education.setFont(new Font("Raleway",Font.PLAIN,26));  //Qualification:
        education.setBounds(70,270,400,30);
        add(education);
        
        JLabel qualification = new JLabel("Qualification:");
        qualification.setFont(new Font("Raleway",Font.PLAIN,26));  //Qualification:
        qualification.setBounds(70,300,400,30);
        add(qualification);

        String qualificationCategory[] = {"Non-Graduation","Graduate","Post-Graduate","Doctorate","Other"};
        qualificationBox = new JComboBox(qualificationCategory);
        qualificationBox.setFont(new Font("Raleway",Font.PLAIN,20));
        qualificationBox.setBounds(300, 300, 400, 30); 
        add(qualificationBox);

        JLabel occupation = new JLabel("Occupation:");
        occupation.setFont(new Font("Raleway",Font.PLAIN,26));  
        occupation.setBounds(70,360,400,30);
        add(occupation);

        String occupationCategory[] = {"Salaied","Self-Employed","Bussiness","Student","Retired"};
        occupationBox = new JComboBox(occupationCategory);
        occupationBox.setFont(new Font("Raleway",Font.PLAIN,20));
        occupationBox.setBounds(300, 360, 400, 30); 
        add(occupationBox);

        JLabel pan = new JLabel("Pan No:");
        pan.setFont(new Font("Raleway",Font.PLAIN,26));  
        pan.setBounds(70,420,400,30);
        add(pan);

        panNo = new JTextField();
        panNo.setBounds(300,420,400,30);
        add(panNo);
        
        JLabel aadhar = new JLabel("Adhar No:");
        aadhar.setFont(new Font("Raleway",Font.PLAIN,26));  
        aadhar.setBounds(70,480,400,30);
        add(aadhar);

        aadharNo = new JTextField();
        aadharNo.setBounds(300,480,400,30);
        add(aadharNo);

        JLabel senior = new JLabel("Senior Citizen:");
        senior.setFont(new Font("Raleway",Font.PLAIN,26));  
        senior.setBounds(70,540,400,30);
        add(senior);

        yes = new JRadioButton("Yes");
        yes.setFont(new Font("Raleway",Font.PLAIN,28)); 
        yes.setBounds(300,540,80,30);
        add(yes);

        no = new JRadioButton("No");
        no.setFont(new Font("Raleway",Font.PLAIN,28)); 
        no.setBounds(500,540,80,30);
        add(no);

        ButtonGroup yesNoGrp = new ButtonGroup();
        yesNoGrp.add(yes);
        yesNoGrp.add(no);


        JLabel existingAcc = new JLabel("Existing Account:");
        existingAcc.setFont(new Font("Raleway",Font.PLAIN,26));  
        existingAcc.setBounds(70,600,400,30);
        add(existingAcc);

        yes = new JRadioButton("Yes");
        yes.setFont(new Font("Raleway",Font.PLAIN,28)); 
        yes.setBounds(300,600,80,30);
        add(yes);

        no = new JRadioButton("No");
        no.setFont(new Font("Raleway",Font.PLAIN,28)); 
        no.setBounds(500,600,80,30);
        add(no);


        yesNoGrp = new ButtonGroup();
        yesNoGrp.add(yes);
        yesNoGrp.add(no);

        nextButton = new JButton("Next");
        nextButton.setBackground(Color.GRAY);
        nextButton.setForeground(Color.WHITE);
        nextButton.setBounds(625,680,80,30);
        nextButton.addActionListener(this);
        add(nextButton);        
        }
        
        public void actionPerformed(ActionEvent ae) {
            String sreligion = (String) religionBox.getSelectedItem();
            String scategory = (String) categoryBox.getSelectedItem();
            String sincome = (String) incomeBox.getSelectedItem();
            String squalification = (String) qualificationBox.getSelectedItem();
            String soccupation = (String) occupationBox.getSelectedItem();
            String span = panNo.getText();
            String saadhar = aadharNo.getText();
            String ssenior = (yes.isSelected()) ? "Yes" : "No";
            String sexisting = (yes.isSelected()) ? "Yes" : "No";
        
            try {
                if (span.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Pan No is Required");
                } else {
                    Conn c = new Conn(); // Create a Conn object
                    String query1= "insert into signuptwo values ('" + sformNo + "','" + sreligion + "','" + scategory + "','" + sincome + "','" + soccupation + "','" + squalification + "','" + span + "','" + saadhar + "','" + ssenior + "','" + sexisting + "')";
                    c.s.executeUpdate(query1); // Use the s field from the Conn object

                    setVisible(false);
                    new SignupThree(sformNo).setVisible(true);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
 
        
    }

    public static void main(String[] args) {
        new SignupTwo("");
    }




}
