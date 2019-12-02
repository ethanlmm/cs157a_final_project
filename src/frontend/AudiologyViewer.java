package frontend;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import static backend.Connector.update;
import static backend.StatementMaker.INSERT_STATEMENT;
import static backend.util.Util.*;




public class AudiologyViewer extends Viewer {
	
	private final int TEXTFIELD_WIDTH = 20;
	
	private JButton saveButton = new JButton("Save");
	private JButton cancelButton = new JButton("Cancel");
	public String patientTHC;
	private static String[] T_XmInputs = new String[] {"PT","NB","NBN","WN"};
	
	private JTextField pta_Right = new JTextField(TEXTFIELD_WIDTH);
	private JTextField pta_Left = new JTextField(TEXTFIELD_WIDTH);
	private JTextField right_TRP = new JTextField(TEXTFIELD_WIDTH);
	private JTextField right_Trm = new JTextField(TEXTFIELD_WIDTH);
	private JTextField right_TLR = new JTextField(TEXTFIELD_WIDTH);
	private JTextField right_ThR = new JTextField(TEXTFIELD_WIDTH);
	private JTextField left_TLP = new JTextField(TEXTFIELD_WIDTH);
	private JTextField left_TLm = new JTextField(TEXTFIELD_WIDTH);
	private JTextField left_TLL = new JTextField(TEXTFIELD_WIDTH);
	
	
	private JTextField left_ThL = new JTextField(TEXTFIELD_WIDTH);
	private JTextField WNR = new JTextField(TEXTFIELD_WIDTH);
	private JTextField WNL = new JTextField(TEXTFIELD_WIDTH);
	private JTextField mml_Right = new JTextField(TEXTFIELD_WIDTH);
	private JTextField mml_Left = new JTextField(TEXTFIELD_WIDTH);
	private JTextField RSD = new JTextField(TEXTFIELD_WIDTH);
	private JTextField LSD = new JTextField(TEXTFIELD_WIDTH);
	private JTextField pt_LDL_Right = new JTextField(TEXTFIELD_WIDTH);
	private JTextField pt_LDL_Left = new JTextField(TEXTFIELD_WIDTH);
	
	private JTextField comments = new JTextField(TEXTFIELD_WIDTH);
	
	public AudiologyViewer(String patientName, String patientTHC, String visitSN, String visitDate)
	{ 		this.patientTHC=patientTHC;
		JDialog dialog = new JDialog();
		dialog.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
		dialog.setLayout(new BorderLayout());
		
		JPanel upperPanel = new JPanel();


		JLabel nameLabel = new JLabel("Name: " + patientName);
		JLabel patientTHCLabel = new JLabel("Patient THC: " + patientTHC);
		JLabel visitSNLabel = new JLabel("Visit SN: " + visitSN);
		JLabel visitDateLabel = new JLabel("Visit Date: " + visitDate);
		upperPanel.add(nameLabel);
		upperPanel.add(patientTHCLabel);
		upperPanel.add(visitSNLabel);
		upperPanel.add(visitDateLabel);
		
		JPanel leftPanel = new JPanel();
		leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));

		
		leftPanel.add(convertToPanel("pta_Right", pta_Right));
		leftPanel.add(convertToPanel("pta_Left", pta_Left));
		leftPanel.add(convertToPanel("right_TRP", right_TRP));
		leftPanel.add(convertToPanel("right_Trm", right_Trm));
		leftPanel.add(convertToPanel("right_TLR", right_TLR));
		leftPanel.add(convertToPanel("right_ThR", right_ThR));
		leftPanel.add(convertToPanel("left_TLP", left_TLP));
		leftPanel.add(convertToPanel("left_TLm", left_TLm));
		leftPanel.add(convertToPanel("left_TLL", left_TLL));
		
		JPanel rightPanel = new JPanel();
		rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
		rightPanel.add(convertToPanel("left_ThL", left_ThL));
		rightPanel.add(convertToPanel("WNR", WNR));
		rightPanel.add(convertToPanel("WNL", WNL));
		rightPanel.add(convertToPanel("mml_Right", mml_Right));
		rightPanel.add(convertToPanel("mml_Left", mml_Left));
		rightPanel.add(convertToPanel("RSD", RSD));
		rightPanel.add(convertToPanel("LSD", LSD));
		rightPanel.add(convertToPanel("pt_LDL_Right", pt_LDL_Right));
		rightPanel.add(convertToPanel("pt_LDL_Left", pt_LDL_Left));
		
		JPanel lowerPanel = new JPanel();
		lowerPanel.setLayout(new BorderLayout());
		JPanel topLowerPanel = new JPanel();
		topLowerPanel.add(convertToPanel("comments:", comments));
		JPanel botLowerPanel = new JPanel();
		botLowerPanel.add(saveButton);
		botLowerPanel.add(cancelButton);

		lowerPanel.add(topLowerPanel, BorderLayout.PAGE_START);
		lowerPanel.add(botLowerPanel,BorderLayout.PAGE_END);
		
		dialog.add(upperPanel, BorderLayout.PAGE_START);
		dialog.add(leftPanel, BorderLayout.LINE_START);
		dialog.add(rightPanel, BorderLayout.LINE_END);
		dialog.add(lowerPanel, BorderLayout.PAGE_END);
		
		dialog.pack();
		dialog.setVisible(true);
		dialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);




		saveButton.addActionListener(e -> {
			String comment=comments.getText();
			String[] contents=arr(""+comment.hashCode(),pta_Right.getText(),pta_Left.getText(),right_TRP.getText(),right_Trm.getText(),right_TLR.getText(),right_ThR.getText(),
					left_TLP.getText(),left_TLm.getText(),left_TLL.getText(),left_ThL.getText(),WNR.getText(),WNL.getText(),mml_Right.getText(),mml_Left.getText(),RSD.getText(),
					LSD.getText(),pt_LDL_Right.getText(),pt_LDL_Left.getText(),comment);
			String[] attributes=arr("Visit_visit_id","pta_Right","pta_Left","right_TRP","right_TRm","right_TLR","right_ThR",
					"left_TLP","left_TLm","left_TLL","left_ThL","WNR","WNL","mml_Right","mml_Left","RSD",
					"LSD","pt_LDL_Right","pt_LDL_Left","comments");

			String statement=INSERT_STATEMENT("audiology",attributes,contents);

			try {
				update(statement);
			} catch (SQLException ex) {
				ex.printStackTrace();
			}


		});
		cancelButton.addActionListener(e -> {
			dialog.dispose();
		});
	}
	
	public void addSaveButtonAction(ActionListener al)
	{
		saveButton.addActionListener(al);
	}
	
	public void addCancelButtonAction(ActionListener al)
	{
		cancelButton.addActionListener(al);
	}


}
