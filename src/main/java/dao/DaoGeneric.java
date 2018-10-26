package dao;

import java.util.List;

public interface DaoGeneric<T, K> {

	void create(T objet);

	T findByKey(K key);

	T update(T objet);

	void delete(T objet);

	void deleteByKey(K key);

	List<T> findAll();

}
