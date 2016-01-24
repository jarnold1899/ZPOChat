package pl.us.edu.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Logowanie extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 513762554689779415L;
	private JPasswordField passwordText;
	private JLabel passwordLabel;
	private JTextField userText;
	private JLabel userLabel;
	private JLabel statusLabel;
	private Rejestracja rejestracja;

	public Logowanie() {
		super("Logowanie");
		rejestracja = new Rejestracja(this);
		rejestracja.setVisible(false);
		setSize(300, 170);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setVisible(true);
		setLayout(null);

		userLabel = new JLabel("U¿ytkownik");
		userLabel.setBounds(10, 10, 80, 25);
		add(userLabel);

		userText = new JTextField(20);
		userText.setBounds(100, 10, 160, 25);
		add(userText);

		passwordLabel = new JLabel("Has³o");
		passwordLabel.setBounds(10, 40, 80, 25);
		add(passwordLabel);

		passwordText = new JPasswordField(20);
		passwordText.setBounds(100, 40, 160, 25);
		add(passwordText);
		

		JButton loginButton = new JButton("login");
		loginButton.setBounds(10, 80, 80, 25);
		add(loginButton);

		JButton registerButton = new JButton("rejestracja");
		registerButton.setBounds(160, 80, 120, 25);
		add(registerButton);

		statusLabel = new JLabel(" ");
		statusLabel.setBounds(10, 110, 300, 25);
		add(statusLabel);

		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Arrays.equals("stackoverflow".toCharArray(), passwordText.getPassword())
						&& "stackoverflow".equals(userText.getText())) {
					new MainFrame();
					setVisible(false);
				} else {
					statusLabel.setText("Niepoprawna nazwa lub has³o");
				}
			}
		});
		
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rejestracja.setVisible(true);
			}
		});
	}
}
