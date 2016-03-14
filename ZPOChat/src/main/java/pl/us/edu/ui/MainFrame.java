package pl.us.edu.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

import pl.us.edu.model.MainModel;
import pl.us.edu.model.Message;
import pl.us.edu.util.Operation;

public class MainFrame extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4094771683071340907L;

	private JButton post;
	JTextPane chat;

	private JTextArea userList, message;

	private MainModel model;

	private JPanel topPanel;

	public MainFrame(final MainModel model) {
		
		super("ZPOChat");
		this.model = model;
		
		post = new JButton("<html><center>Wyœlij<br />wiadomoœæ</center></html>");
		post.addActionListener(this);


		JPanel center = new JPanel(new BorderLayout());

		chat = new JTextPane();
		chat.setEditable(false);
		topPanel = new JPanel();        

        EmptyBorder eb = new EmptyBorder(new Insets(10, 10, 10, 10));

        chat = new JTextPane();                
//        chat.setBorder(eb);
//        chat.setMargin(new Insets(5, 5, 5, 5));

        topPanel.add(chat);
        pack();

		Container p1 = new Container();
		p1.setLayout(new BorderLayout());
		p1.add(new JLabel("Wiadomoœci"), BorderLayout.NORTH);
		p1.add(new JScrollPane(topPanel), BorderLayout.CENTER);

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
		
		post.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (message.getText() != null) {
					Message msg = new Message( model.getUser(), new Date(), message.getText());
					Operation.post(msg);
					message.setText("");
					loadMsg();
				}
			}
		});
		
		int timerTimeInMilliSeconds = 5000;
	    javax.swing.Timer timer = new javax.swing.Timer(timerTimeInMilliSeconds, new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            loadMsg();
	        }
	    });
		
	}

	protected void loadMsg() {

		List<Message> lMsg = Operation.listMessage();
		StringBuilder sb = new StringBuilder();
		chat.setText("");
		for (Message msg : lMsg) {
//			sb.append("\n[" + msg.getTime() + "] "+ msg.getUser().getLogin() + ": "+ msg.getMessage());
			appendToPane(chat, "\n[" + msg.getTime() + "] "+ msg.getUser().getLogin() + ": "+ msg.getMessage(), Color.RED);
			
		}
        pack();

//		chat.setText(sb.toString());		

	}
	
	private void appendToPane(JTextPane tp, String msg, Color c)
    {
        StyleContext sc = StyleContext.getDefaultStyleContext();
        AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, c);

        aset = sc.addAttribute(aset, StyleConstants.FontFamily, "Lucida Console");

        tp.setCharacterAttributes(aset, false);
        tp.replaceSelection(msg);
    }

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}