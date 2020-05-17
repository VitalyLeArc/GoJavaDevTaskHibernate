package repository.abstracts;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public abstract class DAO<T> implements CrudObject<T> {
    protected static EntityManagerFactory entityManagerFactory;
    protected EntityManager entityManager;

    protected void startNewEntityManager() {
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
    }


    //базовые CRUD по ID
    @Override
    public void create(T object) {
        startNewEntityManager();
        entityManager.persist(object);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public T read(Class<T> type, Long id) {
        startNewEntityManager();
        T obj = entityManager.find(type, id);
        entityManager.close();
        return obj;
    }

    @Override
    public void update(Class<T> type, T object, Long id) {
        startNewEntityManager();
        T objFromDB = entityManager.find(type, id);
        entityManager.merge(object);
        entityManager.persist(objFromDB);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void delete(Class<T> type, Long id) {
        startNewEntityManager();
        T objFromDB = entityManager.find(type, id);
        entityManager.remove(objFromDB);
        entityManager.getTransaction().commit();
        entityManager.close();
    }


}
