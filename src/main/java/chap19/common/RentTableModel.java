package chap19.common;

import javax.swing.table.AbstractTableModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class RentTableModel extends AbstractTableModel{
	Object [][] memItems ;
	String [] columnNames ;
	boolean [] columnEditables = new boolean[] {false, true, true, true, true};
	
	public RentTableModel(Object [][] data ,String []column) {
		this.memItems = data;
		this.columnNames = column;
	}
	

	@Override
	public int getRowCount() {
		return memItems.length;
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return memItems[rowIndex][columnIndex];
	}
	
	public String getColumnName(int rowIndex) {
		return columnNames[rowIndex];
	}
	
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return columnEditables[columnIndex];
	}
	
	public void setValueAt(Object value, int rowIndex, int columnIndex) {
		memItems[rowIndex][columnIndex] = value;
		fireTableCellUpdated(rowIndex, columnIndex);
	}
		
	
	
}
