package pl.us.edu.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import pl.us.edu.types.LogType;

@Entity
@Table(name = "logs")
public class Log implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6521510834668017268L;

	@Column(name = "id", unique = true)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@Column(name = "ip")
	private String ip;

	@Column(name = "log_date")
	private Date logDate;

	@Column(name = "log_type")
	private LogType logType;

	public Log() {
		super();
	}

	public Log(User user, String ip, Date logDate, LogType logType) {
		super();
		this.user = user;
		this.ip = ip;
		this.logDate = logDate;
		this.logType = logType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Date getLogDate() {
		return logDate;
	}

	public void setLogDate(Date logDate) {
		this.logDate = logDate;
	}

	public LogType getLogType() {
		return logType;
	}

	public void setLogType(LogType logType) {
		this.logType = logType;
	}

}
