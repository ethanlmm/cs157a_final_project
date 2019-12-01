package frontend;

import javax.swing.*;
import java.awt.*;

public class PatientMenu {
    private JButton createPatientButton = new JButton("Add a new patient");
    private JButton editPatientButton = new JButton("View/edit an existing patient");
    private JButton returnMainButton = new JButton("Go back");


    public JPanel getMenu(){
        JPanel patientCard = new JPanel();
        patientCard.setLayout(new FlowLayout());

        createPatientButton.addActionListener(e->{
            CreatePatientMenu cpv = new CreatePatientMenu();

        });
        editPatientButton.addActionListener(e->{
            PatientSearchMenu psv = new PatientSearchMenu();
        });

        returnMainButton.addActionListener(e->{Layout.switchCard(Layout.MAIN_MENU);});

        patientCard.add(createPatientButton);
        patientCard.add(editPatientButton);
        patientCard.add(returnMainButton);
        return patientCard;
    }


}
