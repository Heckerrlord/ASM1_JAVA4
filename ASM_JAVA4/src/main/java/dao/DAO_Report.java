package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import Utils.JPAUtils;
import models.Favorite;

public class DAO_Report {
	EntityManager em = JPAUtils.getEntityManager();

	public List<Favorite> findAllFavorite() {
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
	public List<Favorite> findAllShare() {
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
	public List<Favorite> fillAllFavorite() {
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
}
