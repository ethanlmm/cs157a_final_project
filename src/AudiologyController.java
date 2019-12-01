import frontend.AudiologyViewer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import static backend.Connector.update;
import static backend.StatementMaker.INSERT_STATEMENT;
import static backend.util.Util.*;

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

			String T_pl =""+viewer.getT_pl();
			String T_lm = viewer.getT_lm();
			String T_ll =""+ viewer.getT_ll();
			String Th_l =""+viewer. getTh_l();
			String Wnl = ""+viewer.getWnl();
			String Mml =viewer. getMml();
			String Lsd = ""+viewer.getLsd();
			String Pt_ldl = ""+viewer.getPt_ldl();
			String Ptar =""+ viewer.getPtar();
			String Ptal=""+viewer.getPtal();
			String T_pr =""+ viewer.getT_pr();
			String T_rm = viewer.getT_rm();
			String T_lr = ""+viewer.getT_lr();
			String Th_r =""+ viewer.getTh_r();
			String Wnr =""+ viewer.getWnr();
			String Mmr = viewer.getMmr();
			String Rsd = ""+viewer.getRsd();
			String Pt_rdl =""+ viewer.getPt_rdl();
			String Comments = viewer.getComments();

			String where=str("\"THC_num\"","=",""+viewer.patientTHC);
			String statement = INSERT_STATEMENT("Audiology", arr("Visit_visit_id","pta_Right", "pta_Left", "right_TRP", "right_TRm", "right_TLR", "right_ThR", "left_TLP", "left_TLm","left_TLL","left_ThL","WNR","WNL","mml_Right","mml_Left","RSD","LSD","pt_LDL_Right","pt_LDL_Left","comments"),
					arr(""+str(T_pl,T_lm,T_ll).hashCode(),Ptar, Ptal, "0", "0", "0", "0", "0", "0","0","0","0","0","0","0","0","0","0","0","comments"));
			print(statement);
			try {
				update(statement);
			} catch (SQLException ex) {
				ex.printStackTrace();
			}







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
