package notice.posts.window;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.ScrollPane;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DateFormatter;

import notice.posts.controller.PostsController;
import notice.posts.controller.PostsControllerImpl;
import notice.posts.vo.PostsVo;

public class PostsClickDialog extends JDialog {
	JPanel panelTop,panelMiddle, panelBottom, panelBtn;
	JButton btnModify, btnRegister, btnDelete;
	JLabel lpost_id, ltitle, lauthor, lcreate, lupdate;
	JTextArea tacontent;
	PostsController postsController = new PostsControllerImpl();
	int a;
	String b,c,d;
	LocalDate e,f;
	
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
	
	public void init() {
		panelTop = new JPanel(new GridLayout(1, 3));
        panelMiddle = new JPanel(new BorderLayout());
        panelBottom = new JPanel(new BorderLayout());

        btnModify = new JButton("수정");
        btnDelete = new JButton("삭제");

        lpost_id = new JLabel(Integer.toString(a));
        ltitle = new JLabel(b);
        lauthor = new JLabel(d);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        lcreate = new JLabel("작성일: " + e.format(formatter)); // 날짜 포맷 적용
        lupdate = new JLabel("수정일: " + f.format(formatter)); // 날짜 포맷 적용

        tacontent = new JTextArea(c);
        tacontent.setLineWrap(true);
        tacontent.setWrapStyleWord(true);
        
        panelTop.add(new JLabel(""));
        panelTop.add(lpost_id);
        panelTop.add(new JLabel(""));
        panelTop.add(ltitle);
        panelTop.add(new JLabel(""));
        panelTop.add(lauthor);
        panelTop.add(new JLabel(""));

        panelMiddle.add(new JScrollPane(tacontent), BorderLayout.CENTER);
        panelMiddle.add(lcreate, BorderLayout.NORTH);
        panelMiddle.add(lupdate, BorderLayout.SOUTH);
        panelMiddle.setBorder(new EmptyBorder(new Insets(10, 10, 10, 10)));

        JPanel panelBtn = new JPanel();
        panelBtn.add(btnModify);
        panelBtn.add(btnDelete);

        panelBottom.add(panelBtn, BorderLayout.SOUTH);

        add(panelTop, BorderLayout.NORTH);
        add(panelMiddle, BorderLayout.CENTER);
        add(panelBottom, BorderLayout.SOUTH);

        setSize(1000, 1000); // 사이즈 조정 필요
        setLocationRelativeTo(null); // 화면 중앙에 배치
        setVisible(true);
		
		
	}
	
}
