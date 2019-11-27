import java.awt.*;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainWindowViewer {
	
	private JFrame frame = new JFrame();
	private JPanel cards = new JPanel(new CardLayout());
	
	public final static String ETRT_CARD = "eTRT";
	public final static String PATIENT_CARD = "patient";
	public final static String VISIT_CARD = "visit";
	
	private JButton patientButton = new JButton("Patients");
	private JButton visitButton = new JButton("Visits");
	
	private JButton createPatientButton = new JButton("Add a new patient");
	private JButton editPatientButton = new JButton("View/edit an existing patient");
	private JButton returnPatientButton = new JButton("Go back");
	
	private JButton createVisitAppButton = new JButton("Make a Visit");
	private JButton editVisitButton = new JButton("View/Edit Visit");
	private JButton returnVisitButton = new JButton("Main Menu");
	
	public MainWindowViewer()
	{
		JPanel eTRTCard = new JPanel();
		
		eTRTCard.add(patientButton);
		eTRTCard.add(visitButton);
		
		JPanel patientCard = new JPanel();
		patientCard.setLayout(new FlowLayout());
		
		patientCard.add(createPatientButton);
		patientCard.add(editPatientButton);
		patientCard.add(returnPatientButton);
//		patientButton.addActionListener(new PatientActionListener());
//		returnPatientButton.addActionListener(new ReturnActionListener());
//		createPatientButton.addActionListener(new CreatePatientActionListener());
		
		JPanel visitCard = new JPanel();
		visitCard.add(createVisitAppButton);
		visitCard.add(editVisitButton);
		visitCard.add(returnVisitButton);
		
		cards.add(eTRTCard, ETRT_CARD);
		cards.add(patientCard, PATIENT_CARD);
		cards.add(visitCard, VISIT_CARD);
		
		frame.add(cards);
		
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
//	public static void main(String args[])
//	{
//		
//		System.out.println("TES");
//		
//		
//		
//		
//	}
	
	public void switchCard(String card)
	{
		CardLayout cl = (CardLayout)cards.getLayout();
		cl.show(cards, card);
	}
	
	//Add actions to the first eTRT menu buttons
	public void addPatientButtonAction(ActionListener al)
	{
		patientButton.addActionListener(al);
	}
	
	public void addVisitButtonAction(ActionListener al)
	{
		visitButton.addActionListener(al);
	}

	
	//Add actions to the Patient menu buttons
	public void addCreatePatientButtonAction(ActionListener al)
	{
		createPatientButton.addActionListener(al);
	}
	
	public void addEditPatientAction(ActionListener al)
	{
		editPatientButton.addActionListener(al);
	}

	public void addReturnPatientButtonAction(ActionListener al)
	{
		returnPatientButton.addActionListener(al);
	}
	
	//adds actions to the Visit menu button
	public void addVisitAppButtonAction(ActionListener al)
	{
		createVisitAppButton.addActionListener(al);
	}
	
	public void addEditVisitButtonAction(ActionListener al)
	{
		editVisitButton.addActionListener(al);
	}

	public void addReturVisitButtonAction(ActionListener al)
	{
		returnVisitButton.addActionListener(al);
	}
}
