package models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.NamedQueries;

//@NamedQueries({
//		@NamedQuery(name = "Video.findByKeyword", query = "SELECT DISTINCT o.videoFavorite FROM FAVORITE o WHERE o.videoFavorite.title LIKE:keyword"),
//		@NamedQuery(name = "Video.findInRange", query = "SELECT DISTINCT o.videoFavorite FROM FAVORITE o  WHERE o.likeDate BETWEEN :min AND :max"),
//		@NamedQuery(name = "Video.findInMonths", query = "SELECT DISTINCT o.videoFavorite FROM FAVORITE o WHERE month(o.likeDate) IN (:months)") })


@Entity
@Table(name = "VIDEOS")
public class Video {
	@Id
	@Column(name = "ID")
	private String id;

	@Column(name = "TITLE")
	private String title;

	@Column(name = "POSTER")
	private String poster;

	@Column(name = "VIEWS")
	private int views;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "ACTIVE")
	private boolean active;
	
	@OneToMany(mappedBy = "videoFavorite")
	List<Favorite> favorites;
	@OneToMany(mappedBy = "videoShare")
	List<Share> shares;

	public Video() {

	}

	public Video(String id, String title, String poster, int views, String description, boolean active,
			List<Favorite> favorites, List<Share> shares) {
		super();
		this.id = id;
		this.title = title;
		this.poster = poster;
		this.views = views;
		this.description = description;
		this.active = active;
		this.favorites = favorites;
		this.shares = shares;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
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
