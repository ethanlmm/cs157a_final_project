package frontend;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainMenu {


	private JButton patientButton = new JButton("Patients");
	private JButton visitButton = new JButton("Visits");


	public JPanel getMenu() {

		JPanel eTRTCard = new JPanel();
		eTRTCard.setLayout(new FlowLayout());

		patientButton.addActionListener(e -> {
			Layout.switchCard(Layout.PATIENT_MENU);
		});
		visitButton.addActionListener(e -> {
			Layout.switchCard(Layout.VISIT_MENU);
		});


		eTRTCard.add(patientButton);
		eTRTCard.add(visitButton);
		return eTRTCard;
	}
}





