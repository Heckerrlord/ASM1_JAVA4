package models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Favorite {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;
    @Column(name = "LIKEDATE")
    private Date likeDate;
    @ManyToOne
    @JoinColumn(name = "USERID")
     Users userFavorite;
    @ManyToOne
    @JoinColumn(name = "VIDEOID")
     Video videoFavorite;

    
    
	public Favorite() {
		super();
	}



	public Favorite(long id, Date likeDate, Users userFavorite, Video videoFavorite) {
		super();
		this.id = id;
		this.likeDate = likeDate;
		this.userFavorite = userFavorite;
		this.videoFavorite = videoFavorite;
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public Date getLikeDate() {
		return likeDate;
	}



	public void setLikeDate(Date likeDate) {
		this.likeDate = likeDate;
	}



	public Users getUserFavorite() {
		return userFavorite;
	}



	public void setUserFavorite(Users userFavorite) {
		this.userFavorite = userFavorite;
	}



	public Video getVideoFavorite() {
		return videoFavorite;
	}



	public void setVideoFavorite(Video videoFavorite) {
		this.videoFavorite = videoFavorite;
	}



	

	
    
    

}
