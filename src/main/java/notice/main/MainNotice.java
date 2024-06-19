package notice.main;

import java.awt.BorderLayout;
import java.awt.GridLayout;import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import javax.swing.JButton;
import javax.swing.JComboBox;
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
import chap19.member.vo.MemberVo;

import notice.common.NoticeTableModel;
import notice.common.base.AbstractBaseWindow;
import notice.posts.controller.PostsController;
import notice.posts.controller.PostsControllerImpl;
import notice.posts.vo.PostsVo;
import notice.posts.window.PostsClickDialog;
import notice.posts.window.PostsRegistDialog;


public class MainNotice extends AbstractBaseWindow {
	JButton btnNext, btnPrev, btnSearch, btnCreate;
	JLabel lSearch;
	JTextField tfSearch;
	JTable table;
	JPanel panelSearch, panelBtn, panelCreate;
	JComboBox combobox;
	Object [][] postsItems = new String[0][5];
	String [] columnNames = {
			"post_id","title","author","created_posts","updated_posts"
	};
	boolean [] columnEditables = new boolean[] {false, true, true, true, true};
	NoticeTableModel ntm;
	PostsController postsController = new PostsControllerImpl();
	int row, col ;
	public MainNotice() {
		setTitle("자유게시판");
		
		
		
		startFrame();
	}
	
	protected void startFrame() {
		
		btnNext = new JButton("다음목록");
		btnPrev = new JButton("이전목록");
		btnSearch = new JButton("검색");
		btnCreate = new JButton("글쓰기");
		
		btnCreate.addActionListener(new MemberHandler());
		
		combobox = new JComboBox();
		combobox.addItem("제목");
		combobox.addItem("작성자");
		
		panelSearch = new JPanel(new GridLayout(1,3));
		panelBtn = new JPanel(new GridLayout(1,3));
		panelCreate = new JPanel(new GridLayout(2,1));
		
		lSearch = new JLabel("검색 : ");
		tfSearch = new JTextField(30);
		
		
		
		table = new JTable();
		ntm = new NoticeTableModel(postsItems, columnNames,columnEditables);
		table.setModel(ntm);
		
		
		List<PostsVo> list2 = postsController.postsList(new PostsVo());
		PostsloadTable(list2);
		
		
		
		
		panelSearch.add(lSearch);
		panelSearch.add(combobox);
		panelSearch.add(tfSearch);
		panelSearch.add(btnSearch);
		
		panelBtn.add(btnPrev);
		panelBtn.add(btnNext);
		
		panelCreate.add(panelSearch,BorderLayout.NORTH);
		panelCreate.add(btnCreate,BorderLayout.EAST);
		
		add(panelCreate,BorderLayout.NORTH);
		add(new JScrollPane(table),BorderLayout.CENTER);
		add(panelBtn,BorderLayout.SOUTH);
		
		setSize(800,800);
		setLocation(200,200);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		btnSearch.addActionListener(new PostHandler());
		
		ListSelectionModel rowSel = table.getSelectionModel();
		rowSel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		ListSelectionModel colSel = table.getColumnModel().getSelectionModel();
		colSel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		rowSel.addListSelectionListener(new ListRowSel());
		colSel.addListSelectionListener(new ListColSel());
		
		
		
		
		
	}
	
	class PostHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			List<PostsVo> searchResults = null;
			String str = (String)combobox.getSelectedItem();
			if(str=="제목") {
				String inner = tfSearch.getText().trim();
				PostsVo vo = PostsVo.builder()
						.title(inner)
						.build();
				searchResults = postsController.searchList(vo, str ,inner );
			} else if (str =="작성자") {
				String inner = tfSearch.getText().trim();
				PostsVo vo = PostsVo.builder()
						.author(inner)
						.build();
				searchResults = postsController.searchList(vo, str,inner);
			}
			 if (searchResults != null) {
	                PostsloadTable(searchResults);
	            } else {
	                message("검색 결과가 없습니다.");
	            }
			
		}
		
	}
	
	public static void main(String[] args) {
		MainNotice mn = new MainNotice();
			
	}
	
	public void PostsloadTable(List<PostsVo> postsList2) {
		if(postsList2 != null && postsList2.size() !=0) {
			postsItems = new String [postsList2.size()][5];
			for (int i =0; i<postsList2.size(); i++) {
				PostsVo vo = postsList2.get(i);
				postsItems[i][0] = Integer.toString(vo.getPost_id());
				postsItems[i][1] = vo.getTitle();
//				postsItems[i][2] = vo.getContent();
				postsItems[i][2] = vo.getAuthor();
				postsItems[i][3] = vo.getCreated_posts().toString();
				postsItems[i][4] = vo.getUpdated_posts().toString();
				
			}
			ntm = new NoticeTableModel(postsItems, columnNames,columnEditables);
			table.setModel(ntm);
			ntm.fireTableDataChanged();
		} else {
			System.out.println("조회한 정보가 없습니다.");
			postsItems = new Object[0][5];
			ntm = new NoticeTableModel(postsItems, columnNames,columnEditables);
			table.setModel(ntm);
			ntm.fireTableDataChanged();
		}
	}
	
	class ListRowSel implements ListSelectionListener{
		int post_id = 0;
		String title = null;
		String content = null;
		String author = null;
		LocalDate created_posts = null;
		LocalDate updated_posts = null;
		
		List<PostsVo> postsList = null;
		
		PostsVo vo1 = PostsVo.builder()
				.post_id(post_id)
				.title(title)
				.content(content)
				.author(author)
				.created_posts(created_posts)
				.updated_posts(updated_posts)
				.build();
		
		@Override
		public void valueChanged(ListSelectionEvent e) {
			
			if(!e.getValueIsAdjusting()) {
				ListSelectionModel lsm = (ListSelectionModel)e.getSource();
				row = lsm.getMinSelectionIndex();
				post_id = Integer.parseInt((String)postsItems[row][0]);

				
				PostsVo vo = new PostsVo();
				vo.setPost_id(post_id);
				
				try {
					postsList = postsController.ClickPosts(vo);;
					if (!postsList.isEmpty()) {
	                PostsVo vo3 = postsList.get(0);
	                System.out.println("Post ID: " + vo3.getPost_id());
	                System.out.println("Title: " + vo3.getTitle());
	                System.out.println("Author: " + vo3.getAuthor());
	                System.out.println("Content: " + vo3.getContent());
	                System.out.println("Created Posts: " + vo3.getCreated_posts());
	                System.out.println("Updated Posts: " + vo3.getUpdated_posts());
	                new PostsClickDialog(postsController,"dd", vo3.getPost_id(), vo3.getTitle(),vo3.getContent(), vo3.getAuthor(), vo3.getCreated_posts(),vo3.getUpdated_posts());
	            }
					
				} catch (Exception e2) {}
				
			}
			
		}
	}
	class ListColSel implements ListSelectionListener{

		@Override
		public void valueChanged(ListSelectionEvent e) {
			ListSelectionModel lsm = (ListSelectionModel)e.getSource();
			col = lsm.getMinSelectionIndex();
			if(!e.getValueIsAdjusting()) {
				System.out.println((row+1)+"행"+(col+1)+"열이 선택됨...");
			}
		}
	}
	
	class MemberHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==btnCreate) {
				new PostsRegistDialog(postsController, "글쓰기");
			}
			
		}
		
	}
	public void message(String str) {
		JOptionPane.showMessageDialog(this, str, "알림창",JOptionPane.INFORMATION_MESSAGE);
	}
	
}
