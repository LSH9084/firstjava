package chap19.member.window;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import chap19.common.RentTableModel;
import chap19.member.controller.MemberController;
import chap19.member.controller.MemberControllerImpl;
import chap19.member.vo.MemberVo;

public class SearchMemDialog extends JDialog{
	JPanel panel, panelBtn;
	JLabel lId;
	JTextField tfId;
	JButton btnReg, btnModify, btnDelete, btnSearch;
	
	JTable memTable;
	
	//테이블 모델
	String[] columnNames = {
			"아이디",
			"비밀번호",
			"이름",
			"주소",
			"전화번호"
	};
	
	Object [] [] memItems = new String[0][5]; //테이블에 표시할 2차원 배열 초기화 및 선언
	int rowIdx = 0, colIdx = 0; //테이블 수정시 선택한 행과 열 인덱스 저장
	
	// 회원 관리 컨트롤러는 입력,수정,조회,삭제 작업요청시 작업 처리하는 객체
	MemberController memCon = new MemberControllerImpl();
	RentTableModel rm;
	
	//생성자
	public SearchMemDialog(MemberController memC, String str) {
		this.memCon = memC;
		
		setTitle(str);
		
		init();
	}
	
	private void init() {
		memTable = new JTable();
		
		
		
		panel = new JPanel(new GridLayout());
		panelBtn = new JPanel();
		lId = new JLabel("아이디");
		tfId = new JTextField(20);
		
		btnReg = new JButton("등록");
		btnDelete = new JButton("삭제");
		btnModify = new JButton("수정");
		btnSearch = new JButton("조회");
		
		panel.add(lId);
		panel.add(tfId);
		panel.add(btnSearch);
		
		panelBtn.add(btnReg);
		panelBtn.add(btnDelete);
		panelBtn.add(btnModify);
		
		btnReg.addActionListener(new MemBtnHandler());
		btnDelete.addActionListener(new MemBtnHandler());
		btnModify.addActionListener(new MemBtnHandler());
		btnSearch.addActionListener(new MemBtnHandler());
		
		// 테이블 설정
		rm = new RentTableModel(memItems,columnNames);
		memTable.setModel(rm);
		
		ListSelectionModel rowSel = memTable.getSelectionModel();
		rowSel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		ListSelectionModel colSel = memTable.getColumnModel().getSelectionModel();
		colSel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		rowSel.addListSelectionListener(new ListRowSel());
		colSel.addListSelectionListener(new ListColSel());
		
		
		
		
		add(panel,BorderLayout.NORTH);
		add(panelBtn,BorderLayout.SOUTH);
		add(new JScrollPane(memTable), BorderLayout.CENTER);
		
		setLocation(300,100);
		setSize(800,600);
		setModal(true); //항상 부모 창 위에 표시
		setVisible(true);
		
		
		
	}
	
	
	private void loadTableData (List<MemberVo> memList) {
		if(memList!=null && memList.size()!=0) {
//			List<MemberVo> list1 = new ArrayList<MemberVo>();
			memItems = new String [memList.size()][5]; //리스트의 개수만큼 행을 설정
			for (int i =0; i<memList.size(); i++) {
				MemberVo memVo = memList.get(i);
				memItems[i][0] = memVo.getId();
				memItems[i][1] = memVo.getPs();
				memItems[i][2] = memVo.getName();
				memItems[i][3] = memVo.getAddress();
				memItems[i][4] = memVo.getP_number();
			}
			//테이블 데이터 모델 설정
			rm = new RentTableModel(memItems, columnNames);
			//테이블 UI view에 테이블 데이터 모델 설정
			memTable.setModel(rm);
			
		} else {
			message("조회한 정보가 없습니다.");
			memItems = new Object[0][5];
			rm = new RentTableModel(memItems, columnNames);
			memTable.setModel(rm);
		}
	}
	
	private void message(String str) {
		JOptionPane.showMessageDialog(this, str,"메시지박스", JOptionPane.INFORMATION_MESSAGE);
	}
	
	class MemBtnHandler implements ActionListener {
		String Id = null;
		String Ps = null;
		String Name = null;
		String Address = null;
		String P_num = null;
		
		MemberVo vo1 = MemberVo.builder()
				.Id(Id)
				.ps(Ps)
				.name(Name)
				.address(Address)
				.p_number(P_num)
				.build();
		
		List<MemberVo> memList = null;
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==btnReg) {
				new RegMemDialog(memCon, "회원 등록창");
				return;
			}else if(e.getSource()==btnModify) {
				Id = (String) memItems[rowIdx][0];
				Ps = (String) memItems[rowIdx][1];
				Name = (String) memItems[rowIdx][2];
				Address = (String) memItems[rowIdx][3];
				P_num = (String) memItems[rowIdx][4];
				
				MemberVo vo = new MemberVo(Id, Ps, Name, Address, P_num);
				
				System.out.println("수정중" +vo);
				
				memCon.modMember(vo);
				message("수정성공");
				
				
			}else if(e.getSource()==btnDelete) {
				Id = (String) memItems[rowIdx][0];
				Ps = (String) memItems[rowIdx][1];
				Name = (String) memItems[rowIdx][2];
				Address = (String) memItems[rowIdx][3];
				P_num = (String) memItems[rowIdx][4];
				
				MemberVo vo = new MemberVo(Id, Ps, Name, Address, P_num);
				System.out.println("삭제할 회원 선택 : "+vo);
				
				memCon.removeMember(vo);
				message("삭제성공");
				
				
			}else if(e.getSource()==btnSearch) {
				String name = tfId.getText().trim();
				
				memList = new ArrayList<MemberVo>();
				MemberVo vo2 = new MemberVo();
				
				if(name != null && name.length()!=0) {
					vo2.setName(name);
					
					memList = memCon.listMember(vo2);
//					memList.stream().forEach(System.out::println);
					if(memList != null && memList.size() !=0) {
						loadTableData(memList);
					} else {
						loadTableData(null);
					}
				} else {
					memList = memCon.listMember(vo2);
//					memList.stream().forEach(System.out::println);
					loadTableData(memList);
				}
			}
		}
		
	}
	
	//테이블 목록 클릭시 이벤트 처리
	class ListRowSel implements ListSelectionListener{

		@Override
		public void valueChanged(ListSelectionEvent e) {
			if(!e.getValueIsAdjusting()) {
				ListSelectionModel lsm = (ListSelectionModel)e.getSource();
				rowIdx = lsm.getMinSelectionIndex();
				System.out.println((rowIdx+1)+"행"+(colIdx+1)+"열이 선택됨...");
			}
			
		}
		
	}
	//테이블 목록 클릭시 이벤트 처리	
	class ListColSel implements ListSelectionListener{

		@Override
		public void valueChanged(ListSelectionEvent e) {
			ListSelectionModel lsm = (ListSelectionModel)e.getSource();
			colIdx = lsm.getMinSelectionIndex();
			if(!e.getValueIsAdjusting()) {
				System.out.println((rowIdx+1)+"행"+(colIdx+1)+"열이 선택됨...");
			}
		}
		
	}
	
	
}
