package pl.us.edu.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class MainFrame extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4094771683071340907L;

	private JButton post;
	private JTextArea chat, userList, message;

	public MainFrame() {
		super("ZPOChat");

		post = new JButton("<html><center>Wyœlij<br />wiadomoœæ</center></html>");
		post.addActionListener(this);


		JPanel center = new JPanel(new BorderLayout());

		chat = new JTextArea(10, 10);
		chat.setEditable(false);

		Container p1 = new Container();
		p1.setLayout(new BorderLayout());
		p1.add(new JLabel("Wiadomoœci"), BorderLayout.NORTH);
		p1.add(new JScrollPane(chat), BorderLayout.CENTER);

		center.add(p1);

		userList = new JTextArea(20, 20);

		userList.setEditable(false);
		JScrollPane scrollUserList = new JScrollPane(userList,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		Container p2 = new Container();
		p2.setLayout(new BorderLayout());
		p2.add(new JLabel("Zalogowani u¿ytkownicy"), BorderLayout.NORTH);
		p2.add(scrollUserList, BorderLayout.CENTER);
		
		center.add(p2, BorderLayout.EAST);

		// event = new JTextArea(80, 80);

		// event.setEditable(false);

		// appendEvent("Events log.\n");

		// center.add(new JScrollPane(event));
		add(center);

		JPanel south = new JPanel(new BorderLayout());
		message = new JTextArea(5, 80);
		south.add(message);
		south.add(post, BorderLayout.EAST);

		add(south, BorderLayout.SOUTH);

		// addWindowListener(this);

		setSize(800, 600);

		setVisible(true);
		
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
	// http://www.dreamincode.net/forums/topic/259777-a-simple-chat-program-with-clientserver-gui-optional/
}