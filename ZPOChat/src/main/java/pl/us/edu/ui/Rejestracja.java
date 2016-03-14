package pl.us.edu.ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import pl.us.edu.model.User;
import pl.us.edu.util.Operation;

public class Rejestracja extends JFrame {
	private JPasswordField passwordText;
	private JLabel passwordLabel;
	private JTextField userText;
	private JLabel userLabel;
	private JLabel statusLabel;
	private JFrame parent;
	private JLabel colorLabel;
	private JButton colorChoserbutton;
	private JLabel colorLabel2;
	private Color color;

	public Rejestracja(final JFrame parent) {
		super("Rejestracja");

		this.parent = parent;
		setSize(300, 200);
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

		colorLabel = new JLabel("Color");
		colorLabel.setBounds(10, 70, 80, 25);
		add(colorLabel);

		colorLabel2 = new JLabel(" ");
		colorLabel2.setOpaque(true);
		colorLabel2.setBounds(100, 70, 25, 25);
		color = new Color(0, 0, 0);
		colorLabel2.setBackground(color);
		add(colorLabel2);

		colorChoserbutton = new JButton("wybierz kolor");
		colorChoserbutton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Color colorC = JColorChooser.showDialog(parent, "Kolory", color);
				color = colorC;
				colorLabel2.setBackground(color);

			}
		});
		colorChoserbutton.setBounds(130, 70, 130, 25);
		add(colorChoserbutton);

		JButton rejestrujButton = new JButton("rejestruj");
		rejestrujButton.setBounds(10, 110, 120, 25);
		add(rejestrujButton);

		JButton cancelButton = new JButton("anuluj");
		cancelButton.setBounds(160, 110, 120, 25);
		add(cancelButton);

		statusLabel = new JLabel(" ");
		statusLabel.setBounds(10, 130, 300, 25);
		add(statusLabel);

		rejestrujButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (passwordText.getPassword() != null
						&& userText.getText() != null) {
					User user1 = new User(userText.getText(), userText.getText(), String.valueOf(passwordText.getPassword()), color.toString());
					Operation.saveUser(user1);
					setVisible(false);
				} else {
					statusLabel.setText("Podaj logi i has³o");
				}
			}
		});

		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
	}

}
