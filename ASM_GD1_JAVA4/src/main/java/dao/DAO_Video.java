package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import Utils.JPAUtils;

import models.Share;
import models.Video;

public class DAO_Video extends AbstractDAO<Video>{
	public List<Video> findAll() {
		try {
			EntityManager em = JPAUtils.getEntityManager();
			String hql = "SELECT a FROM Video a";
			TypedQuery<Video> query = em.createQuery(hql, Video.class);
			System.out.println(query.getResultList());
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
	public List<Video> findbyTitle(String keyword) {
		EntityManager em = JPAUtils.getEntityManager();
	String jsql = "SELECT DISTINCT o.videoFavorite FROM FAVORITE o WHERE o.videoFavorite.title LIKE:keyword";
	TypedQuery<Video> query = em.createQuery(jsql,Video.class);
		System.out.println(keyword);
		query.setParameter("keyword", "%" + keyword + "%");
		return query.getResultList();
	}
	public List<Video> fillRamdom4() {

			EntityManager em = JPAUtils.getEntityManager();
			String sql = "SELECT TOP 4 * FROM Videos ORDER BY newid()";
			TypedQuery<Video> query =  (TypedQuery<Video>) em.createNativeQuery(sql,Video.class);
			System.out.println(query.getFirstResult());
			return query.getResultList();
		
	}


	public List<Video> findIndex() {
		try {
			EntityManager em = JPAUtils.getEntityManager();
			String hql = "SELECT a FROM Video a";
			TypedQuery<Video> query = em.createQuery(hql, Video.class);
			query.setMaxResults(6); 
			System.out.println(query.getResultList());
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	
	public Video findBYID(String id) {
		EntityManager em = JPAUtils.getEntityManager();
		String hql = "SELECT u FROM Video u where u.id =:id";
		TypedQuery<Video> query = em.createQuery(hql, Video.class);
		query.setParameter("id", id);
		return query.getSingleResult();

	}
	
	// Đoạn mã sau đây giả định bạn đã có đối tượng Video và đối tượng đại diện cho phiên làm việc (Session) của Hibernate

	// Lấy đối tượng Video từ Hibernate
	

	
	public void moreViews(String vID) {
			EntityManager em = JPAUtils.getEntityManager();
			try {
				Video vd = findBYID(vID);
				em.getTransaction().begin();
				String hql = "UPDATE Video SET views = views+1 WHERE id = :vID";
				Query query = em.createQuery(hql);
				query.setParameter("vID", vID);
				System.out.println(vID);
				int affectedRows = query.executeUpdate();
				em.getTransaction().commit();
			} catch (Exception e) {
				em.getTransaction().rollback();
				e.printStackTrace();
			}

		}
	
	public List<Video> findAll(int pageNumber, int pageSize) {
		// Write Comment
		return super.findAll(Video.class, true, pageNumber, pageSize);
	}

	
//	public void create(Video vd) {
//		EntityManager em = JPAUtils.getEntityManager();
//		try {
//			em.getTransaction().begin();
//			em.persist(vd);
//			em.getTransaction().commit();
//			System.out.println("Thêm mới thành công!");
//		} catch (Exception e) {
//			em.getTransaction().rollback();
//			e.printStackTrace();
//			System.out.println("Thêm mới thất bại!");
//		}
//
//	}
//	public void share(Share s) {
//		EntityManager em = JPAUtils.getEntityManager();
//		try {
//			em.getTransaction().begin();
//			em.persist(s);
//			em.getTransaction().commit();
//			System.out.println("Share ok!");
//		} catch (Exception e) {
//			em.getTransaction().rollback();
//			e.printStackTrace();
//			System.out.println("Share fail!");
//		}
//
//	}
//
//	public void update(Video vd) {
//		EntityManager em = JPAUtils.getEntityManager();
//		try {
//			em.getTransaction().begin();
//			em.merge(vd);
//			em.getTransaction().commit();
//			System.out.println("Cập nhật thành công");
//		} catch (Exception e) {
//			em.getTransaction().rollback();
//			e.printStackTrace();
//			System.out.println("Cập nhật thất bại");
//		}
//
//	}
//	
//
//	public void deleteAll() {
//		EntityManager em = JPAUtils.getEntityManager();
//		String hql = "Delete from Video";
//		try {
//			em.getTransaction().begin();
//			em.createQuery(hql).executeUpdate();
//			em.getTransaction().commit();
//			System.out.println("Đã xóa tất cả");
//		} catch (Exception e) {
//			em.getTransaction().rollback();
//			System.out.println("Lỗi xóa");
//		}
//
//	}
//
//	public void delete(String id) {
//		EntityManager em = JPAUtils.getEntityManager();
//		try {
//			em.getTransaction().begin();
//			Video vd = em.find(Video.class, id);
//			System.out.println(vd);
//			if (vd != null) {
//				System.out.println(vd);
//				em.remove(vd);
//				System.out.println("Xóa thành công!");
//			} else {
//				System.out.println("Xóa thất bại!");
//			}
//			em.getTransaction().commit();
//
//		} catch (Exception e) {
//			em.getTransaction().rollback();
//			e.printStackTrace();
//		}
//
//	}

}
