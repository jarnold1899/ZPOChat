package pl.us.edu.main;

import java.awt.EventQueue;

import pl.us.edu.ui.Logowanie;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// AnnotationConfiguration config = new AnnotationConfiguration();
		// config.addAnnotatedClass(User.class);
		// config.addAnnotatedClass(Log.class);
		// config.addAnnotatedClass(Message.class);
		// config.configure("hibernate.cfg.xml");
		// new SchemaExport(config).create(true, true);

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Logowanie();
			}
		});
	}

}
