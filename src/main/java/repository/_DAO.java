package repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class _DAO<T> implements _CRUDObject<T> {
    protected EntityManagerFactory entityManagerFactory;
    protected EntityManager entityManager;

    public _DAO (){
        entityManagerFactory = Persistence.createEntityManagerFactory("persistence_task");
    }
    protected void startNewEntityManager() {
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
    }

    @Override
    public abstract void create(T object);

    @Override
    public abstract void read(T object,Long id);

    @Override
    public abstract void update(T object,Long id);

    @Override
    public abstract void delete(T object,Long id) ;
}
