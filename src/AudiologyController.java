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






			//INSERT INTO table (col1, col2) VALUES (val1, val2);
			
			//this function gets all the inputs from the viewer
			//you have to cast/handle each one yourself...
			//alternatively you get use the other get____() functions
			//but just know there are 19 of them, so pick your poison
			//I'm so sorry...
			
			Object[] fields = viewer.getAllFields();

			//or...
			
//			int Ptal = getPtal();
//			int T_pl = getT_pl();
//			String T_lm = getT_lm();
//			int T_ll = getT_ll();
//			int Th_l = getTh_l();
//			int Wnl = getWnl();
//			String Mml = getMml();
//			int Lsd = getLsd();
//			int Pt_ldl = getPt_ldl();
//			int Ptar = getPtar();
//			int T_pr = getT_pr();
//			String T_rm = getT_rm();
//			int T_lr = getT_lr();
//			int Th_r = getTh_r();
//			int Wnr = getWnr();
//			String Mmr = getMmr();
//			int Rsd = getRsd();
//			int Pt_rdl = getPt_rdl();
//			String Comments = getComments();

			

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
