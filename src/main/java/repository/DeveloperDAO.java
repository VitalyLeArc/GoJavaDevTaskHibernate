package repository;

import domain.Developer;

public class DeveloperDAO extends _DAO<Developer> {

    private static final DeveloperDAO developerDAO = new DeveloperDAO();

    private DeveloperDAO() {}

    public static DeveloperDAO getDeveloperDAO(){
        return developerDAO;
    }

    @Override
    public void create(Developer developer) {
        startNewEntityManager();
        entityManager.persist(developer);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void read(Developer developer, Long id) {
        startNewEntityManager();

        entityManager.close();
    }

    @Override
    public void update(Developer developer, Long id) {
        startNewEntityManager();

        entityManager.close();
    }

    @Override
    public void delete(Developer developer, Long id) {
        startNewEntityManager();

        entityManager.close();
    }
}
