package chap17;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class E10JTableTest extends JFrame {
	JTable table;
	Object[] columnNames = {"사번","이름", "근무부서"};
	String[][] data = {
			{"220000","박길동","총무부"},
			{"220001","홍길동","관리부"},
			{"220002","이순신","회계부"},
			{"220003","임꺽정","개발부"},
			{"220004","강감찬","관리부"},
			{"220005","제임스","총무부"},
			{"220006","이길동","총무부"},
			{"220007","이갑돌","회계부"},
			{"220008","김유신","영업부"},
			{"220009","동순이","영업부"},
			{"220010","동길이","개발부"},
			{"220011","세종","영업부"},
			{"220012","흥부","회계부"},
			{"220013","놀부","총무부"}
	};
	public E10JTableTest () {
		table = new JTable(data, columnNames);
		setTitle("사원 정보 테이블");
		add(new JScrollPane(table));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		table.setAutoResizeMode(table.AUTO_RESIZE_ALL_COLUMNS);  양쪽 컬럼의 사이즈도 변경가능
//		table.setAutoResizeMode(table.AUTO_RESIZE_LAST_COLUMN); // 마지막 컬럼의 크기만 변경가능
//		table.setAutoResizeMode(table.AUTO_RESIZE_NEXT_COLUMN); // 다음열만
//		table.setAutoResizeMode(table.AUTO_RESIZE_OFF); // 컬럼사이즈 자동조절x 스크롤바를 통해 조절
		table.setAutoResizeMode(table.AUTO_RESIZE_SUBSEQUENT_COLUMNS); //기본값
		
		pack();
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		//JTable : 데이터 목록
		// TableModel 작성 -> JTable -> jscrollpanel에 jtable 추가 -> container에 추가
		E10JTableTest te = new E10JTableTest();
		
	}
}
