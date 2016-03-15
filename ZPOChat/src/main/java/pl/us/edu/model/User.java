package pl.us.edu.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4292062773829405406L;

	@Column(name = "id", unique = true)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "login", unique = true)
	private String login;

	@Column(name = "email", unique = true)
	private String email;

	@Column(name = "password")
	private String password;
	
	@Column(name = "color")
	private int color;
	
	@Column(name = "akt")
	private int akt;

	@SuppressWarnings("unused")
	private User() {
	}

	public User(String login, String email, String password, int i) {
		this.login = login;
		this.email = email;
		this.password = password;
		this.color = i;
		this.akt = 0;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public int getAkt() {
		return akt;
	}

	public void setAkt(int akt) {
		this.akt = akt;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
