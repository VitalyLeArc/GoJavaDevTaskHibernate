package repository;

import domain.Developer;
import domain.Project;
import repository.abstracts.DAO;

import javax.persistence.Persistence;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProjectDAO extends DAO<Project> {

    private ProjectDAO() {
    }

    private static final ProjectDAO projectDAO = new ProjectDAO();

    public static ProjectDAO getProjectDAO() {
        entityManagerFactory = Persistence.createEntityManagerFactory("persistence_task");
        return projectDAO;
    }

    public Set<Developer> getDevelopersForProjectName(String projectName) {
        startNewEntityManager();
        Project project = (Project) entityManager.createQuery("from Project pr where pr.name=:prname")
                .setParameter("prname", projectName)
                .getResultList().stream().findFirst().orElse(null);
        entityManager.close();
        return project != null ? project.getDevelopers() : new HashSet<>();
    }

    public List<Project> getAllProjects() {
        startNewEntityManager();
        List<Project> projects = entityManager.createQuery("from Project").getResultList();
        entityManager.close();
        return projects;
    }

    public Project readByName(String projectName) {
        startNewEntityManager();
        Project project = (Project) entityManager
                .createQuery("from Project where name=:prname")
                .setParameter("prname", projectName)
                .getSingleResult();
        entityManager.close();
        return project;
    }
    /*по заданию
        список разработчиков отдельного проекта;
        список проектов в следующем формате: дата создания - название проекта - количество разработчиков на этом проекте.
        зарплату(сумму) всех разработчиков отдельного проекта ;
    */
}
