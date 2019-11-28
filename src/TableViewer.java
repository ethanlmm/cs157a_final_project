import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

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
	
	public void clearChanges()
	{
		listener.changes.clear();
	}
	
	public Integer[] getChangedRows()
	{
		return listener.changes.keySet().toArray(new Integer[listener.changes.size()]);
	}
	
	public Integer[] getChangedCols(int row)
	{
		HashSet<Integer> changedCols = listener.changes.get(row);
		return changedCols.toArray(new Integer[changedCols.size()]);
	}
	
	public Object getTableContentsAt(int row, int col)
	{
		return table.getModel().getValueAt(row, col);
	}
	
	
	public class TableListener implements TableModelListener
	{
		private JTable table;
		private HashMap<Integer, HashSet<Integer>> changes;
		
		public TableListener()
		{
			changes = new HashMap<Integer, HashSet<Integer>>();
		}

		public TableListener(JTable table)
		{
			this.table = table;
			changes = new HashMap<Integer, HashSet<Integer>>();
		}

		public void setTable(JTable table)
		{
			this.table = table;
		}
		
		
		
		public void tableChanged(TableModelEvent e) {
			if (e.getType() == TableModelEvent.UPDATE)
			{
				int row = e.getFirstRow();
				int col = e.getColumn();
				
//				System.out.println("Changed at " + row);
				
				if (!changes.containsKey(row))
				{
					HashSet<Integer> values = new HashSet<Integer>();
					values.add(col);
					changes.put(row, values);
				} else
				{
					changes.get(row).add(col);
				}
				
			}
		}
		
	}


}
