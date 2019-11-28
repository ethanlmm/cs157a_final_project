import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Viewer {
	
	public static int MAX_WIDTH = 50;
	
	public JPanel convertToPanel(String componentLabel, JComponent component)
	{
		
		JPanel panel = new JPanel();
		JLabel label = new JLabel(componentLabel);
		panel.add(label);
//		component.setSize(MAX_WIDTH - label.getWidth(), component.getHeight());
		panel.add(component);
		return panel;
	}

}
