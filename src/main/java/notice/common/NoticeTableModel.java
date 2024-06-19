package notice.common;

import java.util.Arrays;

import javax.swing.table.AbstractTableModel;

public class NoticeTableModel extends AbstractTableModel {
		Object [][] memItems ;
		String [] columnNames ;
		boolean [] columnEditables ;
		
		public NoticeTableModel(Object [][] data ,String []column, boolean [] k) {
			this.memItems = data;
			this.columnNames = column;
			this.columnEditables =k;
		}
		public void setData(Object[][] data) {
		System.out.println("=======");
        this.memItems = data;
        System.out.println("Table model updated with data: " + Arrays.deepToString(memItems)); // 디버깅 출력
        fireTableDataChanged();
        System.out.println("==ddf==");
        
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

