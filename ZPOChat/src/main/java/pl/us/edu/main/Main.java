package pl.us.edu.main;

import java.awt.EventQueue;

import org.hibernate.annotations.common.util.impl.Log;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import pl.us.edu.model.Message;
import pl.us.edu.model.User;
import pl.us.edu.ui.MainFrame;

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
				new MainFrame();
			}
		});
	}

}
