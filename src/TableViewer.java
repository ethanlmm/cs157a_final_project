import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

public class TableViewer extends Viewer{
	
	private JTable table;
	private TableListener listener;
	
	public TableViewer()
	{
		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setAutoCreateRowSorter(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}
	
	public void setTable(DefaultTableModel model)
	{
		table.setModel(model);
		listener = new TableListener(table);
		table.getModel().addTableModelListener(listener);
		table.changeSelection(0, 0, false, false);
	}
	
	public Object getTableRowContents(int col)
	{
		return table.getModel().getValueAt(table.getSelectedRow(), col);
	}
	
	protected JTable getTable()
	{
		return table;
	}
	
	public class TableListener implements TableModelListener
	{
		private JTable table;
		private HashMap<Integer, ArrayList<Object>> changes;
		
		public TableListener()
		{
			changes = new HashMap<Integer, ArrayList<Object>>();
		}
		
		public TableListener(JTable table)
		{
			this.table = table;
			changes = new HashMap<Integer, ArrayList<Object>>();
		}
		
		public void setTable(JTable table)
		{
			this.table = table;
		}
		
		public void tableChanged(TableModelEvent e) {
			if (e.getType() == TableModelEvent.UPDATE)
			{
//				
				int row = e.getFirstRow();
				int col = e.getColumn();
				
				System.out.print("Change at ");
				System.out.println(getTableContents(row, col));
			}
		}
		
		public void clearChanges()
		{
			changes.clear();
		}
		
		public Object getTableContents(int row, int col)
		{
			return table.getModel().getValueAt(row, col);
		}
		
	}
	

}
