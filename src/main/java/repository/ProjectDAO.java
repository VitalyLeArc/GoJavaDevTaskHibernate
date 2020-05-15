package repository;

import domain.Developer;
import domain.Project;

import java.util.List;
import java.util.Set;

public class ProjectDAO extends _DAO<Project> {

    public ProjectDAO() {
    }

    public Set<Developer> getDevelopersForProjectName(String projectName) {
        startNewEntityManager();
        Project project = (Project) entityManager.createQuery("from Project pr where pr.name=:prname")
                .setParameter("prname", projectName)
                .getSingleResult();
        entityManager.close();
        return project.getDevelopers();
    }

    public List<Project> getAllProjects() {
        startNewEntityManager();
        List<Project> projects = entityManager.createQuery("from Project").getResultList();
        entityManager.close();
        return projects;
    }

    public Project readByName(String projectName) {
        startNewEntityManager();
        Project project = (Project)entityManager.createQuery("from Project where name=:prname").setParameter("prname",projectName).getSingleResult();
        entityManager.close();
        return project;
    }
    /*по заданию
        список разработчиков отдельного проекта;
        список проектов в следующем формате: дата создания - название проекта - количество разработчиков на этом проекте.
        зарплату(сумму) всех разработчиков отдельного проекта ;
    */
}
