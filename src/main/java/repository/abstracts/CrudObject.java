package repository.abstracts;

public interface CrudObject<T> {

//базовые CRUD по ID
    public void create(T object);
    public T read(Class<T> type,Long id);
    public void update(Class<T> type,T object,Long id);
    public void delete(Class<T> type, Long id);

}
