import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PharmacologyController {
	
	private PharmacologyViewer viewer;
	
	public PharmacologyController(PharmacologyViewer _viewer)
	{
		this.viewer = _viewer;
		
	}
	
	class SaveAction implements ActionListener
	{

		public void actionPerformed(ActionEvent e) {
			//get the fields from the viewer using the textfield getters (not implemented yet)
			//and use them to perform a query on the db like
			//INSERT INTO table (col1, col2) VALUES (val1, val2);
		}
	}

}
