package repository;

public interface _CRUDObject<T> {

    public void create(T object);

    public void read(T object,Long id);

    public void update(T object,Long id);

    public void delete(T object, Long id);
}
