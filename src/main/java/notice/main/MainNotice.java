package notice.main;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import chap19.common.RentTableModel;
import chap19.member.vo.MemberVo;
import notice.common.NoticeTableModel;
import notice.common.base.AbstractBaseWindow;
import notice.posts.controller.PostsController;
import notice.posts.controller.PostsControllerImpl;
import notice.posts.vo.PostsVo;


public class MainNotice extends AbstractBaseWindow {
	JButton btnNext, btnPrev, btnSearch;
	JLabel lSearch;
	JTextField tfSearch;
	JTable table;
	JPanel panelSearch, panelBtn;
	Object [][] postsItems = new String[0][6];
	String [] columnNames = {
			"post_id","title","content","author","created_posts","updated_posts"
	};
	boolean [] columnEditables = new boolean[] {false, true, true, true, true,true};
	NoticeTableModel ntm;
	PostsController postsController = new PostsControllerImpl();
	
	public MainNotice() {
		setTitle("자유게시판");
		
		
		
		startFrame();
	}
	
	protected void startFrame() {
		
		btnNext = new JButton("다음목록");
		btnPrev = new JButton("이전목록");
		btnSearch = new JButton("검색");
		
		panelSearch = new JPanel(new GridLayout(1,3));
		panelBtn = new JPanel(new GridLayout(1,3));
		
		lSearch = new JLabel("검색 : ");
		tfSearch = new JTextField(30);
		
		
		
		table = new JTable();
		ntm = new NoticeTableModel(postsItems, columnNames);
		table.setModel(ntm);
		
		
		List<PostsVo> list2 = postsController.postsList(new PostsVo());
		PostsloadTable(list2);
		
		
		
		panelSearch.add(lSearch);
		panelSearch.add(tfSearch);
		panelSearch.add(btnSearch);
		
		panelBtn.add(btnPrev);
		panelBtn.add(btnNext);
		
		add(panelSearch,BorderLayout.NORTH);
		add(new JScrollPane(table),BorderLayout.CENTER);
		add(panelBtn,BorderLayout.SOUTH);
		
		setSize(800,800);
		setLocation(200,200);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		
		
	}
	
	public static void main(String[] args) {
		MainNotice mn = new MainNotice();
			
	}
	
	public void PostsloadTable(List<PostsVo> postsList2) {
		if(postsList2 != null && postsList2.size() !=0) {
			postsItems = new String [postsList2.size()][6];
			for (int i =0; i<postsList2.size(); i++) {
				PostsVo vo = postsList2.get(i);
				postsItems[i][0] = Integer.toString(vo.getPost_id());
				postsItems[i][1] = vo.getTitle();
				postsItems[i][2] = vo.getContent();
				postsItems[i][3] = vo.getAuthor();
				postsItems[i][4] = vo.getCreated_posts().toString();
				postsItems[i][5] = vo.getUpdated_posts().toString();
				
			}
			ntm = new NoticeTableModel(postsItems, columnNames);
			table.setModel(ntm);
			ntm.fireTableDataChanged();
		} else {
			System.out.println("조회한 정보가 없습니다.");
			postsItems = new Object[0][5];
			ntm = new NoticeTableModel(postsItems, columnNames);
			table.setModel(ntm);
			ntm.fireTableDataChanged();
		}
	}
	
}
