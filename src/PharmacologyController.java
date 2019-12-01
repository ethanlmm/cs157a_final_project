import frontend.PharmacologyViewer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import static backend.Connector.update;
import static backend.StatementMaker.UPDATE_STATEMENT;
import static backend.util.Util.*;

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
			//UPDATE table SET col1 = val1, col2 = val3 WHERE id = id;
			
			//get an array of the index of changed rows
			Integer[] changedRows = viewer.getChangedRows();
			for (int i = 0; i < changedRows.length; i++)
			{
				//get an array of changed columns in each changed row
				Integer[] changedCols = viewer.getChangedCols(changedRows[i]);
				System.out.println("NUM COLS " + changedCols.length);
					for (int j = 0; j < changedCols.length; j++)
					{
						//TODO: DB Operations to insert into table
						//System.out.println("There is a change at " + changedRows[i] + ", " + changedCols[j]);

						//use getTableContents to get the table contents
						//viewer.getTableContentsAt(row, col)
						//returns an Object, so cast it appropriately
						//DB Operations go here
						//INSERT INTO table (col1, col2) VALUES (val1, val2);
						String where=str("\"THC_num\"","=",""+viewer.getTableContentsAt(changedRows[i],0));
						String content=""+viewer.getTableContentsAt(changedRows[i],changedCols[i]);
						String column=""+viewer.getTableContentsAt(0,changedCols[i]);
						String statement =UPDATE_STATEMENT("PATIENT", arr(column),arr(content),where);
						print(statement);
						try {
							update(statement);
						} catch (SQLException ex) {
							ex.printStackTrace();
						}


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
