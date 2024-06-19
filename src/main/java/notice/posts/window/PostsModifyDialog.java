package notice.posts.window;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import notice.posts.controller.PostsController;
import notice.posts.controller.PostsControllerImpl;
import notice.posts.vo.PostsVo;

public class PostsModifyDialog extends JDialog{
	JTextField tftitle, tfauthor;
	JTextArea tacontent;
	JButton btnRegister;
	PostsController postsController = new PostsControllerImpl();
	JPanel panelTop;
	JLabel ltitle, lauthor;
	int a;

	
	public PostsModifyDialog(PostsController p , String str , int a) {
		this.postsController = p;
		setTitle(str);
		this.a = a;
		
		init();
		
	}

	public void init() {
		System.out.println(a+"====");
		tftitle = new JTextField(10);
		tfauthor = new JTextField(10);
		tacontent = new JTextArea();
		btnRegister = new JButton("완료");
		panelTop = new JPanel();
		ltitle = new JLabel("제목 : ");
		lauthor = new JLabel("작성자 : ");
		
		panelTop.add(ltitle);
		panelTop.add(tftitle);
		panelTop.add(lauthor);
		panelTop.add(tfauthor);
		
		add(panelTop,BorderLayout.NORTH);
		add(new JScrollPane(tacontent),BorderLayout.CENTER);
		add(btnRegister,BorderLayout.SOUTH);
		
		btnRegister.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String title = tftitle.getText().trim();
				String author = tfauthor.getText().trim();
				String content = tacontent.getText().trim();
				
				PostsVo vo = PostsVo.builder()
						.post_id(a)
						.title(title)
						.author(author)
						.content(content)
						.build();
				postsController.ModifyPosts(vo);
				message("수정했습니다.");
				dispose();
				
			}
		});
		
		setSize(1000,1000);
		setLocation(100,0);
		setModal(true);
		setVisible(true);
	}
	
	
	public void message(String str) {
		JOptionPane.showMessageDialog(this, str, "알림창",JOptionPane.INFORMATION_MESSAGE);
	}
}
