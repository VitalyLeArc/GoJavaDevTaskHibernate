package repository;

import domain.Project;

public class ProjectDAO extends _DAO<Project> {

    private static final ProjectDAO projectDAO = new ProjectDAO();

    private ProjectDAO() {}

    public static ProjectDAO getProjectDao(){
        return projectDAO;
    }

    @Override
    public void create(Project project) {
        startNewEntityManager();
        entityManager.persist(project);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void read(Project project, Long id) {
        startNewEntityManager();

        entityManager.close();
    }

    @Override
    public void update(Project project, Long id) {
        startNewEntityManager();

        entityManager.close();
    }

    @Override
    public void delete(Project project, Long id) {
        startNewEntityManager();

        entityManager.close();
    }
}
