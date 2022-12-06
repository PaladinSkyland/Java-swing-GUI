// the package statement
// import the required swing classes:
// Import the two required interfaces:
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;



public class SwingEventWindow extends JFrame implements ActionListener, ItemListener {
    // Declare the checked radio button variable flag:
// this global and private variable is set to an initial value of 1
// which refer to the first radio button to be selected by default
// You can name "rdoChecked"
// Create JPanel main container object:
    private int rdoChecked = 1;
    JPanel maincontainer = new JPanel();

// You create JPanel sub containers objects for each section of the GUI:

    // Create JComponents Items based on the assignment requirements:
// Panel#1 for lblMain -
// Panel#2 for lblRequest -
// Panel#3 for txtNum
// Panel#4 for the 4 radio buttons
// Panel#5 for the calculate button
// Panel#6 for the result label and the result output textfield
    JPanel JPLblTitle = new JPanel();
    JPanel JPLblRequest = new JPanel();
    JPanel JPTxtNum = new JPanel();
    JPanel JPRadioButtons = new JPanel();
    JPanel JPCalculatebutton = new JPanel();
    JPanel JPResult = new JPanel();

    JLabel labelEF = new JLabel("Excel Function ");
    JLabel labelrequest = new JLabel("Enter numbers separated by spaces ");
    JTextField numberstextF = new JTextField();
    JButton Calculatebutton = new JButton("Calculate");
    JTextField resulttextF = new JTextField();

    ButtonGroup group = new ButtonGroup();
    JRadioButton jr1 = new JRadioButton(" Auto Sum");
    JRadioButton jr2 = new JRadioButton(" Average");
    JRadioButton jr3 = new JRadioButton(" Maximum");
    JRadioButton jr4 = new JRadioButton(" Minimum");

// Using ButtonGroup class for grouping the 4 related radio buttons
// Create/Declare the ButtonGroup object
// for grouping the radio button inside the constructor method


    // Class Constructor:
    public SwingEventWindow() {
        JFrame frame = new JFrame("My Swing GUI");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLayout(new GridLayout());
        maincontainer.setLayout(new GridBagLayout());
        maincontainer.setBackground(Color.YELLOW);


// No need to assign/set any value to the JComponents
// It's already done when they are all declared above
// Just group the four related JRadioButton components:
// by adding them to the ButtonGroup object that you declared earlier
// Adding the components to their panels:
        group.add(jr1);
        group.add(jr2);
        group.add(jr3);
        group.add(jr4);
        jr1.addItemListener(this);
        jr2.addItemListener(this);
        jr4.addItemListener(this);
        jr3.addItemListener(this);

        numberstextF.setPreferredSize(new Dimension(100,20));
        resulttextF.setPreferredSize(new Dimension(100,20));
        //resulttextF.setEditable(false);

        JPLblTitle.add(labelEF);
        JPLblRequest.add(labelrequest);
        JPTxtNum.add(numberstextF);
        JPRadioButtons.add(jr1);
        JPRadioButtons.add(jr2);
        JPRadioButtons.add(jr3);
        JPRadioButtons.add(jr4);
        JPCalculatebutton.add(Calculatebutton);
        JPResult.add(resulttextF);
        /*
         * IMPORTANT Note:
         * For quick demo, I used different and multiple JPanels objects
         * to layout the GUI components.
         * It's better to use the "GridLayout" based on the instructions
         */

// Adding all the 6 sub panels to the main panel (the main container):
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0; c.gridy=0;c.gridwidth = 1;
        maincontainer.add(JPLblTitle,c);
        c.gridy = 1;
        maincontainer.add(JPLblRequest,c);
        c.gridy = 2;
        maincontainer.add(JPTxtNum,c);
        c.gridy = 3;
        maincontainer.add(JPRadioButtons,c);
        c.gridy = 4;
        maincontainer.add(JPCalculatebutton,c);
        c.gridy = 5;
        maincontainer.add(JPResult,c);
// Adding the main panel "mainPanel" (JPanel object) to the JFrame:
        frame.add(maincontainer);

        Calculatebutton.addActionListener(this);

// Adding/attaching the required Events to some components:
        /*
         * We need to add the required events to each radio button
         * and to the submit "Calculate" button only
         */
        // end constructor
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    Excel excel = new Excel(numberstextF.getText());
            if(rdoChecked==1){
        resulttextF.setText(""+excel.findTotal());
    }
            else if(rdoChecked ==2){
        resulttextF.setText(""+excel.findAvg());
    }
            else if(rdoChecked==3){
        resulttextF.setText(""+excel.findMax());
    }
            else if(rdoChecked==4){
        resulttextF.setText(""+excel.findMin());
    }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(jr1.isSelected()){
            rdoChecked = 1;
        }
        else if(jr2.isSelected()){
            rdoChecked = 2;
        }
        else if (jr3.isSelected()){
            rdoChecked = 3;
        }
        else if (jr4.isSelected()) {
            rdoChecked = 4;
        }
    }

// Implementing the two required methods (event-handler)
// for each interface:
/*
@Override
public void Event-Handler method for the calculate button {
// Getting the user's input string from the first textfield:
// Save it into a variable of String data type:
// Initialize our "Excel" class object:
        /*
         * Passing the String value of the user's input to the constructor
         * Java will pick the second constructor from the Excel class
         * based on the passing data type of the argument which is "String"
         */
// Run the if condition for checking the value of the flag variable "rdoChecked"
       /* if (rdoChecked equals 1) then:
// call the findTotal() method
// output/Print the result (value) in the result's textfield
        else if (rdoChecked equals 2) then:
// call the findAvg() method
// output/Print the result (value) in the result's textfield
        else if (rdoChecked equals 3) then:
// call the findMax() method
// output/Print the result (value) in the result's textfield
        else if (rdoChecked equals 4) then:
// call the findMin() method
// output/Print the result (value) in the result's textfield
        } // end Event-Handler method for the calculate button
        } // end class file

        */
}