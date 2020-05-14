package service;

import domain.Developer;
import domain.Project;
import repository.ProjectDAO;

public class ProjectService {

    private ProjectDAO projectDAO;
    
    public Project getProjectById(Long id) {
        projectDAO = new ProjectDAO();
        return projectDAO.read(Project.class, id);
    }

    public void addNewDeveloper(Project pr) {
        projectDAO = new ProjectDAO();
        projectDAO.create(pr);
    }

    public void updateDeveloperById(Project pr, Long id) {
        projectDAO = new ProjectDAO();
        projectDAO.update(Project.class, pr, id);
    }

    public void deleteDeveloperById(Long id) {
        projectDAO = new ProjectDAO();
        projectDAO.delete(Project.class, id);
    }


    private static final ProjectService projectService = new ProjectService();

    private ProjectService() {
    }

    private static ProjectService getProjectService() {
        return projectService;
    }
}
