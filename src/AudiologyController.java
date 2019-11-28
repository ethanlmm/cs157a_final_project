import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AudiologyController {
	
	private AudiologyViewer viewer;
	
	public AudiologyController(AudiologyViewer _viewer)
	{
		this.viewer = _viewer;
		viewer.addCancelButtonAction(new CancelActionListener());
		viewer.addSaveButtonAction(new SaveActionListener());
	}
	
	private class SaveActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			//add save button actions
			//get the changes to the table (might use a hashmap to send this)
			//and convert it or send it to the right class to save to database
			//will need to do a sql operation like this
			//UPDATE table SET col1 = val1, col2 = val3 WHERE id = id;
		}
	}
	
	private class CancelActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			//add cancel button actions
			//don't save to database, go back to prev window
			//clear the changes and close the dialog
		}
	}

}
