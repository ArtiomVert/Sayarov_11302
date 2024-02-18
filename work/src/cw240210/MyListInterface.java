public interface MyListInterface<T>{
	public T get(int i);
	public void add(T t);
	public void add(int i, T t);
	public void remove(int i);
	public int size();
}