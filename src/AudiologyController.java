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
			//save to database
		}
	}
	
	private class CancelActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			//add cancel button actions
			//don't save to database, go back to prev window
		}
	}

}
