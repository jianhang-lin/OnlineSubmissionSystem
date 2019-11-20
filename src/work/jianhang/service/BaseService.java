package work.jianhang.service;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public interface BaseService {
	/**
	 * 添加对象
	 * @param obj
	 */
	public void add(Object obj);
	/**
	 * 删除对象，
	 * @param obj
	 */
	public void delete(Object obj);
	/**
	 * 根据id和对象名删除
	 * @param id
	 * @param clazz
	 */
	public void delete(int id, Class<Object> clazz);
	/**
	 * 更新对象
	 * @param obj
	 */
	public void update(Object obj);
	/**
	 * 根据id获取对象
	 * @param clazz
	 * @param id
	 */
	public Object getById(Class<Object> clazz, int id);
	/**
	 * 获取列表，分页的
	 * @param clazz
	 * @param pageno
	 * @param pagesize
	 * @return
	 */
	public List<Object> getList(Class<Object> clazz, int pageno, int pagesize);
	/**
	 * 根据对象，获取总数
	 * @param clazz
	 * @return
	 */
	public int getCount(Class<Object> clazz);
	/**
	 * 根据对象和参数，获取一个列表
	 * @param clazz
	 * @param params
	 * @param values
	 * @return
	 */
	public List<Object> getList(Class<Object> clazz, String[] params, List<Object> values, int pageno, int pagesize, String orderBy);
	/**
	 * 根据对象和参数，获取对象的总数量
	 * @param clazz
	 * @param params
	 * @param values
	 * @return
	 */
	public int getCount(Class<Object> clazz, String[] params, List<Object> values);
}
