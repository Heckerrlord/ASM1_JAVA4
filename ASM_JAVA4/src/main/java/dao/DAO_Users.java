package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import Utils.JPAUtils;
import models.Users;
import models.Video;

public class DAO_Users {

	public List<Users> findAll() {
		EntityManager em = JPAUtils.getEntityManager();
		String hql = "SELECT u FROM Users u";
		TypedQuery<Users> query = em.createQuery(hql, Users.class);
		System.out.println(query.getResultList());
		return query.getResultList();
	}

	public void create(Users user) {
		EntityManager em = JPAUtils.getEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(user);
			em.getTransaction().commit();
			System.out.println("Thêm mới thành công!");
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			System.out.println("Thêm mới thất bại!");
		}

	}

	public void update(Users user) {
		EntityManager em = JPAUtils.getEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(user);
			em.getTransaction().commit();
			System.out.println("Cập nhật thành công");
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			System.out.println("Cập nhật thất bại");
		}

	}

	public void deleteAll() {
		EntityManager em = JPAUtils.getEntityManager();
		String hql = "Delete from Users";
		try {
			em.getTransaction().begin();
			em.createQuery(hql).executeUpdate();
			em.getTransaction().commit();
			System.out.println("Đã xóa tất cả");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Lỗi xóa");
		}

	}

	public void delete(String id) {
		EntityManager em = JPAUtils.getEntityManager();
		try {
			em.getTransaction().begin();
			Users user = em.find(Users.class, id);
			System.out.println(user);
			if (user != null) {
				System.out.println(user);
				em.remove(user);
				System.out.println("Xóa thành công!");
			} else {
				System.out.println("Xóa thất bại!");
			}
			em.getTransaction().commit();

		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}

	}

	public Users findBYID(String id) {
		EntityManager em = JPAUtils.getEntityManager();
		try {
			String hql = "SELECT u FROM Users u where u.id =:id";
			TypedQuery<Users> query = em.createQuery(hql, Users.class);
			query.setParameter("id", id);
			return query.getSingleResult();

		} catch (Exception e) {
			return null;
		}

	}

	public Users findBYGmail(String gmail) {
		EntityManager em = JPAUtils.getEntityManager();
		try {
			String hql = "SELECT u FROM Users u where u.email =:gmail";
			TypedQuery<Users> query = em.createQuery(hql, Users.class);
			query.setParameter("gmail", gmail);
			return query.getSingleResult();
		} catch (Exception e) {
			return null;
		}

	}

	public Users login(String username, String pass) {
		EntityManager em = JPAUtils.getEntityManager();
		try {
			String hql = "SELECT u FROM Users u where u.id =:username and u.password =:pass";
			TypedQuery<Users> query = em.createQuery(hql, Users.class);
			query.setParameter("username", username);
			query.setParameter("pass", pass);
			return query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public void resetPass(String email) {
		EntityManager em = JPAUtils.getEntityManager();
		try {
			em.getTransaction().begin();
			String password = String.valueOf((int) (Math.random() * ((9999 - 1000) + 1)) + 1000);
			String hql = "UPDATE Users SET password = :password WHERE email = :email";
			Query query = em.createQuery(hql);
			query.setParameter("email", email);
			query.setParameter("password", password);
			System.out.println(email + password);
			int affectedRows = query.executeUpdate();
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		}

	}

	public void changePass(String uID, String password) {
		EntityManager em = JPAUtils.getEntityManager();
		try {
			em.getTransaction().begin();
			String hql = "UPDATE Users SET password = :password WHERE id = :uID";
			Query query = em.createQuery(hql);
			query.setParameter("uID", uID);
			query.setParameter("password", password);
			int affectedRows = query.executeUpdate();
			System.out.println("Change thành công");
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			System.out.println("Change thất bại");
		}

	}
	
	 public long countUsers() {
	        EntityManager em = JPAUtils.getEntityManager();
	        try {
	            // Tạo truy vấn đếm số lượng bản ghi trong bảng Users với thuộc tính admin == 1
	            String jpql = "SELECT COUNT(u) FROM Users u WHERE u.admin = 0";
	            Query query = em.createQuery(jpql);

	            // Thực hiện truy vấn và lấy kết quả (số lượng bản ghi thỏa mãn điều kiện)
	            Long count = (Long) query.getSingleResult();
	            return count;
	        } finally {
	            em.close();
	        }
	    }

}
