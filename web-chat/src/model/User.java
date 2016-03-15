package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import util.Active;

@Entity
@Table(name = "\"CUSER\"")
public class User {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Long id;
	@Column(name = "LOGIN", unique = true, nullable = false, length = 20)
	private String login;
	@Column(name = "PASSWORD", nullable = false, length = 16)
	private String password;
	@Column(name = "ACTIVE", nullable = false, length = 2)
	private Active active;
	
	public User() {

	}

	public User(String login, String password, Active active) {
		this.login = login;
		this.password = password;
		this.active = active;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Active getActive() {
		return active;
	}

	public void setActive(Active active) {
		this.active = active;
	}

}
