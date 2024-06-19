package notice.posts.window;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;
import javax.swing.text.DateFormatter;

import org.apache.commons.compress.utils.Sets;

import notice.comments.controller.CommentsController;
import notice.comments.controller.CommentsControllerImpl;
import notice.comments.vo.CommentsVo;
//import notice.comments.window.CommentsWindow;
import notice.common.NoticeTableModel;
//import notice.main.MainNotice.ListRowSel;
import notice.posts.controller.PostsController;
import notice.posts.controller.PostsControllerImpl;
import notice.posts.vo.PostsVo;

public class PostsClickDialog extends JDialog {
	JPanel panelTop,panelMiddle, panelBottom, panelBtn, panelComments, panelBtn2;
	JButton btnModify, btnRegister, btnDelete, btnDelete_comments;
	JLabel lpost_id, ltitle, lauthor, lcreate, lupdate, lauthor_comments;
	JTextArea tacontent, tacontent_comments;
	JTextField tfauthor;
	PostsController postsController = new PostsControllerImpl();
	CommentsController commentsController = new CommentsControllerImpl();
	int a,row,col;
	String b,c,d;
	ListSelectionModel rowSel;
	LocalDate e,f;
	JTable table ;
	Object [][] commentsItems = new String[0][5];
	String [] columnNames = {
		"comment_id","post_id","content_comments","author_comments","created_comments"
	};
	boolean [] columnEditables = new boolean[] {false, false, true, true, true};
	NoticeTableModel ntm;
	int comment_id;
	int post_id;
	
	
	
	public PostsClickDialog(PostsController p , String str , int a, String b, String c, String d, LocalDate e, LocalDate f) {
		this.postsController = p;
		setTitle(str);
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.e = e;
		this.f = f;
		
		init();
		
	}
	
	public PostsClickDialog(int a) {
		this.post_id =a; 
		this.ntm = new NoticeTableModel(commentsItems, columnNames, columnEditables);
		
		updateCommentsTable();
		
	}
	
	public void init() {
		tacontent_comments = new JTextArea(5,30);
		panelTop = new JPanel(new GridLayout(1, 3));
        panelMiddle = new JPanel(new BorderLayout());
        panelBottom = new JPanel(new BorderLayout());
        panelComments = new JPanel();
        panelBtn2 = new JPanel();
        
        
        
        btnModify = new JButton("수정");
        btnDelete = new JButton("삭제");
        btnRegister = new JButton("댓글 등록");
        btnDelete_comments = new JButton("댓글 삭제");

        
        
        table = new JTable();
        ntm = new NoticeTableModel(commentsItems, columnNames, columnEditables);
        table.setModel(ntm);
        
        lauthor_comments = new JLabel("작성자");
        lpost_id = new JLabel(Integer.toString(a));
        ltitle = new JLabel(b);
        lauthor = new JLabel(d);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        tfauthor = new JTextField(5);
        lcreate = new JLabel("작성일: " + e.format(formatter)); // 날짜 포맷 적용
        lupdate = new JLabel("수정일: " + f.format(formatter)); // 날짜 포맷 적용

        panelBtn2.add(lupdate);
        panelBtn2.add(btnModify);
        panelBtn2.add(btnDelete);
        
        tacontent = new JTextArea(c);
        tacontent.setLineWrap(true);
        tacontent.setWrapStyleWord(true);
        
        List<CommentsVo> list2 = commentsController.CommentsList(new CommentsVo().builder().post_id(a).build());
        commentsLoadTable(list2);
        
        panelTop.add(new JLabel(""));
        panelTop.add(lpost_id);
        panelTop.add(new JLabel(""));
        panelTop.add(ltitle);
        panelTop.add(new JLabel(""));
        panelTop.add(lauthor);
        panelTop.add(new JLabel(""));

        panelMiddle.add(new JScrollPane(tacontent), BorderLayout.CENTER);
        panelMiddle.add(lcreate, BorderLayout.NORTH);
        panelMiddle.add(panelBtn2, BorderLayout.SOUTH);
        panelMiddle.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));

        JPanel panelBtn = new JPanel();

        panelBtn.add(btnRegister);
        panelBtn.add(btnDelete_comments);
        btnModify.addActionListener(new PostHandle());
        btnDelete.addActionListener(new PostHandle());
        
        panelComments.add(lauthor_comments);
        panelComments.add(tfauthor);
        panelComments.add(new JScrollPane(tacontent_comments));
        
        panelBottom.add(new JScrollPane(table) ,BorderLayout.NORTH);
        panelBottom.add(panelComments);
        panelBottom.add(panelBtn, BorderLayout.SOUTH);
        panelBottom.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));
        tacontent_comments.setLineWrap(true);
        tacontent_comments.setWrapStyleWord(true);
        
        
        
        btnRegister.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String content_comments = tacontent_comments.getText().trim();
				String author_comments = tfauthor.getText().trim();
				CommentsVo vo4 = CommentsVo.builder()
						.post_id(a)
						.content_comments(content_comments)
						.author_comments(author_comments)
						.build();
				
				commentsController.registComments(vo4);
				
				updateCommentsTable();
				message("답글 성공!");
			}
		});
        
        rowSel = table.getSelectionModel();
		rowSel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		rowSel.addListSelectionListener(new ListRowSel());
		
//		ListSelectionModel colSel = table.getColumnModel().getSelectionModel();
//		colSel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		

        add(panelTop, BorderLayout.NORTH);
        add(panelMiddle, BorderLayout.CENTER);
        add(panelBottom, BorderLayout.SOUTH);

        setSize(1000, 1000); // 사이즈 조정 필요
        setLocation(100,0); // 화면 중앙에 배치
        setVisible(true);
		
        
		
	}
	class PostHandle implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()== btnModify) {
				new PostsModifyDialog(postsController, "수정창",a);
				
			} else if(e.getSource()==btnDelete) {
				PostsVo vo = PostsVo.builder()
						.post_id(a)
						.build();
				postsController.DeletePosts(vo);
				message("삭제 성공");
			}
				
//				if(Integer.toString(comment_id) == tfauthor.getText().trim()) {
//					
//					System.out.println("====click");
//					CommentsVo vo5 = CommentsVo.builder()
//							.comment_id(comment_id)
//							.build();
//					commentsController.deleteComments(vo5);
//				}
				
				
			
			
		}
		
	}
	
	void message(String str) {
		JOptionPane.showMessageDialog(this, str,"알림창",JOptionPane.INFORMATION_MESSAGE);
	}

	private void updateCommentsTable() {
		System.out.println(a);
		System.out.println("updateCommentsTable() called");
        List<CommentsVo> list = commentsController.CommentsList(new CommentsVo().builder().post_id(a).build());
        ntm.setData(getDataVector(list));
        
        
//        table.clearSelection();
    }
	
	private void updateCommentsTable2(int a) {
		System.out.println(a);
		System.out.println("updateCommentsTable() called");
        List<CommentsVo> list = commentsController.CommentsList(new CommentsVo().builder().post_id(a).build());
        ntm.setData(getDataVector(list));
        
//        table.clearSelection();
    }


    private Object[][] getDataVector(List<CommentsVo> commentsList) {
    	System.out.println("rrrrrrrr");
        Object[][] data = new String[commentsList.size()][5];
        for (int i = 0; i < commentsList.size(); i++) {
            CommentsVo vo = commentsList.get(i);
            data[i][0] = Integer.toString(vo.getComment_id());
            data[i][1] = Integer.toString(vo.getPost_id());
            data[i][2] = vo.getContent_comments();
            data[i][3] = vo.getAuthor_comments();
            data[i][4] = vo.getCreated_comments().toString();
        }
        System.out.println("rrrrrrrrrrrrrrr");
        return data;
    }
    
    public void commentsLoadTable(List<CommentsVo> commentsList) {
    	System.out.println("commentsLoadTable() called with commentsList size: " + commentsList.size());
        if (commentsList != null && commentsList.size() > 0) {
            Object[][] data = getDataVector(commentsList);
            ntm.setData(data);
        } else {

            ntm.setData(new Object[0][5]);
        }
    }
    
    class ListRowSel implements ListSelectionListener{
    	
    	int comment_id = 0;
    	int post_id = 0;
    	String content_comments = null;
    	String author_comments = null;
    	LocalDate created_comments = null;
    	List<CommentsVo> commentsList2 = null;
 

		@Override
		public void valueChanged(ListSelectionEvent e) {
//			updateCommentsTable();
			TableModel tm = table.getModel();
			System.out.println("=====");
			if(!e.getValueIsAdjusting()) {
				ListSelectionModel lsm = (ListSelectionModel)e.getSource();
				row = lsm.getMinSelectionIndex();
//				System.out.println(row);
				comment_id = Integer.parseInt(tm.getValueAt(row, 0).toString());
				post_id = Integer.parseInt(tm.getValueAt(row, 1).toString());
//				System.out.println(post_id);
				for (ActionListener al : btnDelete_comments.getActionListeners()) {
		            btnDelete_comments.removeActionListener(al);
		        }
				btnDelete_comments.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						CommentsVo vo = CommentsVo.builder()
								.comment_id(comment_id)
								.build();
						
						commentsController.deleteComments(vo);
						PostsClickDialog pcd = new PostsClickDialog(post_id);
//						pcd.updateCommentsTable2(post_id);
						
						message("삭제했습니다.");
						
					}
				});
				
				
				
				
//				commentsController.deleteComments(vo5);
				
//				commentsList2 = commentsController.clickComments(vo5);
				
				
				
				

				
			}
			
		}
    	
    }
}

