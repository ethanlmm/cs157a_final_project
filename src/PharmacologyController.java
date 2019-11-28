import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PharmacologyController {
	
	private PharmacologyViewer viewer;
	
	public PharmacologyController(PharmacologyViewer _viewer)
	{
		this.viewer = _viewer;
		
		viewer.addSaveButtonAction(new SaveAction());
		viewer.addCancelButtonAction(new CancelAction());
	}
	
	class SaveAction implements ActionListener
	{

		public void actionPerformed(ActionEvent e) {
			//get the fields from the viewer using the textfield getters
			//and use them to perform a query on the db like
			//INSERT INTO table (col1, col2) VALUES (val1, val2);
			
			//get an array of the index of changed rows
			Integer[] changedRows = viewer.getChangedRows();
			for (int i = 0; i < changedRows.length; i++)
			{
				//get an array of changed columns in each changed row
				Integer[] changedCols = viewer.getChangedCols(changedRows[i]);
					for (int j = 0; j < changedCols.length; j++)
					{
						//TODO: DB Operations to insert into table
						//use this to get the table contents
						//viewer.getTableContentsAt(row, col)
						//returns an Object, so cast it appropriately
						
						//DB Operations go here
						System.out.println("There is a change at " + i + ", " + j);
					}
				
			}
			viewer.close();
		}
	}
	
	class CancelAction implements ActionListener
	{
		
		public void actionPerformed(ActionEvent e)
		{
			viewer.clearChanges();
			viewer.close();
		}
	}

}
