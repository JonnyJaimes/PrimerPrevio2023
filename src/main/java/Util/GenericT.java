package Util;

import java.util.List;

public interface GenericT<T> {

	public List<T> list();
	public  <E> T find(E id);
	public void insert(T obj);
	public void update(T obj);
	public void delete(T obj);
}
