package repository;

public interface CRUDObject<T> {

    public void create(T object);

    public void read(T object);

    public void update(T object);

    public void delete(T object);
}
