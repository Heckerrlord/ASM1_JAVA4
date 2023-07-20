package models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
public class Users {
	@Id
	@Column(name = "ID")
	private String id;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "FULLNAME")
	private String fullname;

	@Column(name = "ADMIN")
	private boolean admin;
	
	@OneToMany(mappedBy = "userFavorite")
	List<Favorite> favorites;
	@OneToMany(mappedBy = "userShare")
	List<Share> shares;

	public Users() {

	}

	public Users(String id, String password, String email, String fullname, boolean admin, List<Favorite> favorites,
			List<Share> shares) {
		super();
		this.id = id;
		this.password = password;
		this.email = email;
		this.fullname = fullname;
		this.admin = admin;
		this.favorites = favorites;
		this.shares = shares;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public List<Favorite> getFavorites() {
		return favorites;
	}

	public void setFavorites(List<Favorite> favorites) {
		this.favorites = favorites;
	}

	public List<Share> getShares() {
		return shares;
	}

	public void setShares(List<Share> shares) {
		this.shares = shares;
	}
	

}
