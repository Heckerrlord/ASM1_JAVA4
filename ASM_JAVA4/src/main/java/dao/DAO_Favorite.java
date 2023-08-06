package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import Utils.JPAUtils;
import models.Favorite;
import models.Video;

public class DAO_Favorite  {
	EntityManager em = JPAUtils.getEntityManager();
	public List<Favorite> findAll() {
		try {
			
			String hql = "SELECT a FROM Favorite a";
			TypedQuery<Favorite> query = em.createQuery(hql, Favorite.class);
			System.out.println("dasbdas");
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ga");
			return null;
		}

	}
	
	public List<Video> findListFavoritebyUser(String userID) {
		 EntityManager em = JPAUtils.getEntityManager();
		try {
			String jpql = "SELECT o.videoFavorite FROM Favorite o WHERE o.userFavorite.id = :userID";
		    TypedQuery<Video> query = em.createQuery(jpql, Video.class);
		    query.setParameter("userID", userID);
		    return query.getResultList();
		} catch (Exception e) {
			 return null;
		}
	}
	

	
	
	
	public void create(Favorite f) {
		try {
			em.getTransaction().begin();
			em.persist(f);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	public void update(Favorite f) {
		try {
			em.getTransaction().begin();
			em.merge(f);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	
	
	
	public Favorite findBYID(Long id) {
		String hql = "SELECT u FROM Favorite u where u.id =:id";
		TypedQuery<Favorite> query = em.createQuery(hql, Favorite.class);
		query.setParameter("id", id);
		return query.getSingleResult();
	}
	
	
	
	public void unlike(String uID, String vID) {
		try {
			em.getTransaction().begin();
			String hql = "DELETE FROM Favorite WHERE userFavorite.id = :uID AND videoFavorite.id = :vID";
			Query query = em.createQuery(hql);
			query.setParameter("uID", uID);
			query.setParameter("vID", vID);
			System.out.println(vID);
			int affectedRows = query.executeUpdate();
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}
	}



	
	
	
}
