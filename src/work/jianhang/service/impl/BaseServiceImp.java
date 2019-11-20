package work.jianhang.service.impl;

import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import work.jianhang.service.BaseService;

import java.util.List;

public class BaseServiceImp extends HibernateDaoSupport implements BaseService {

	@Override
	public void add(Object obj) {
		this.getHibernateTemplate().getSessionFactory().openSession().save(obj);
	}

	@Override
	public void delete(Object obj) {
		this.getHibernateTemplate().getSessionFactory().openSession().delete(obj);
	}

	@Override
	public void delete(int id, Class<Object> clazz) {
		String hql = "delete from " + clazz.getSimpleName() + "o where o.id = " + id;
		Query query = getQuery(hql);
		query.executeUpdate();
	}

	@Override
	public void update(Object obj) {
		this.getHibernateTemplate().getSessionFactory().openSession().update(obj);
	}

	@Override
	public Object getById(Class clazz, int id) {
		Object obj = this.getHibernateTemplate().getSessionFactory().openSession().get(clazz, id);
		return obj;
	}

	@Override
	public List<Object> getList(Class<Object> clazz, int pageno, int pagesize) {
		String hql = "select o from " + clazz + " o";
		Query query = this.getQuery(hql);
		query.setFirstResult((pageno - 1) * pagesize);
		query.setMaxResults(pagesize);
		List<Object> list = query.list();
		return list;
	}

	@Override
	public int getCount(Class<Object> clazz) {
		int count = 0;
		String hql = "select count(o) from " + clazz.getSimpleName() + " o";
		Query query = this.getQuery(hql);
		count = (int) query.uniqueResult();
		return count;
	}

	@Override
	public List<Object> getList(Class<Object> clazz, String[] params,
								List<Object> values, int pageno, int pagesize, String orderBy) {
		String hql = "selct o from " + clazz.getSimpleName() + " o where 1=1 ";
		Query query = null;
		if (params.length > 0) {
			for (String s : params) {
				hql = hql + " and o." + s + " = ?";
			}
			if (orderBy != null && !orderBy.equals("")) {
				hql += " order by o." + orderBy;
			}
			query = this.getQuery(hql);
			for (int i=0; i<values.size(); i++) {
				query.setParameter(i, values.get(i));
			}
		} else {
			query = this.getQuery(hql);
		}
		query.setFirstResult((pageno -1) * pagesize);
		query.setMaxResults(pagesize);
		return query.list();
	}

	@Override
	public int getCount(Class<Object> clazz, String[] params,
						List<Object> values) {
		int count = 0;
		String hql = "selct count(o) from " + clazz.getSimpleName() + " o where 1=1 ";
		Query query = null;
		if (params.length > 0) {
			for (String s : params) {
				hql = hql + " and o." + s + " = ?";
			}
			query = this.getQuery(hql);
			for (int i=0; i<values.size(); i++) {
				query.setParameter(i, values.get(i));
			}
		} else {
			query = this.getQuery(hql);
		}
		count = (Integer) query.uniqueResult();
		return count;
	}

	private Query getQuery(String hql) {
		return this.getSessionFactory().openSession().createQuery(hql);
	}
}
