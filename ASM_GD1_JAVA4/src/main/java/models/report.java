package models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.StoredProcedureParameter;


@Entity
public class report {
	@Id
	private Serializable group;
	Long likes;
	Date newest;
	Date oldwest;
	public report() {
		super();
	}
	public report(Serializable group, Long likes, Date newest, Date oldwest) {
		super();
		this.group = group;
		this.likes = likes;
		this.newest = newest;
		this.oldwest = oldwest;
	}
	public Serializable getGroup() {
		return group;
	}
	public void setGroup(Serializable group) {
		this.group = group;
	}
	public Long getLikes() {
		return likes;
	}
	public void setLikes(Long likes) {
		this.likes = likes;
	}
	public Date getNewest() {
		return newest;
	}
	public void setNewest(Date newest) {
		this.newest = newest;
	}
	public Date getOldwest() {
		return oldwest;
	}
	public void setOldwest(Date oldwest) {
		this.oldwest = oldwest;
	}
	

}
