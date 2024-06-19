package notice.posts.window;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import notice.main.MainNotice;
import notice.posts.controller.PostsController;
import notice.posts.controller.PostsControllerImpl;
import notice.posts.vo.PostsVo;

public class PostsRegistDialog extends JDialog{
	JTextField tftitle, tfauthor;
	JTextArea tacontent;
	JButton btnRegister;
	PostsController postsController = new PostsControllerImpl();
	JPanel panelTop;
	JLabel ltitle, lauthor;
	
	public PostsRegistDialog(PostsController p, String str) {
		this.postsController = p;
		setTitle(str);
		
		init();
		
	}
	
	public void init() {
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
//			List<PostsVo> list1 = null;
			@Override
			public void actionPerformed(ActionEvent e) {
				PostsVo vo = PostsVo.builder()
						.title(tftitle.getText().trim())
						.author(tfauthor.getText().trim())
						.content(tacontent.getText().trim())
						.build();
				
				postsController.RegisterPosts(vo);
				message("등록했습니다.");
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
