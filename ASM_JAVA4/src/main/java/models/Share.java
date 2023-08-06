package models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="SHARE")
public class Share {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;
	@ManyToOne @JoinColumn(name = "USERID")
    Users userShare;
	@ManyToOne @JoinColumn(name = "VIDEOID")
    Video videoShare;

    @Column(name = "EMAILS")
    private String emails;

    @Temporal(TemporalType.DATE)
    Date shareDate = new Date();

	public Share() {
		super();
	}

	public Share(long id, Users userShare, Video videoShare, String emails, Date shareDate) {
		super();
		this.id = id;
		this.userShare = userShare;
		this.videoShare = videoShare;
		this.emails = emails;
		this.shareDate = shareDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Users getUserShare() {
		return userShare;
	}

	public void setUserShare(Users userShare) {
		this.userShare = userShare;
	}

	public Video getVideoShare() {
		return videoShare;
	}

	public void setVideoShare(Video videoShare) {
		this.videoShare = videoShare;
	}

	public String getEmails() {
		return emails;
	}

	public void setEmails(String emails) {
		this.emails = emails;
	}

	public Date getShareDate() {
		return shareDate;
	}

	public void setShareDate(Date shareDate) {
		this.shareDate = shareDate;
	}

	
 
}
