package pl.podwikagrzegorz.MovieRentalServer.model;

import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer userId;

	private String username;

	private String password;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer id) {
		this.userId = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String name) {
		this.username = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String email) {
		this.password = email;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + userId +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				'}';
	}
}
