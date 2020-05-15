package service;

import domain.Developer;
import domain.Project;
import repository.ProjectDAO;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProjectService {

    private ProjectDAO projectDAO;

    public List<String> getDevelopersForProjectName(String projectName){
        projectDAO=new ProjectDAO();
        return projectDAO.getDevelopersForProjectName(projectName).stream().flatMap(dev-> Stream.of(dev.getName())).collect(Collectors.toList());
    }

    public String getAllProjectsInfo(){
        projectDAO=new ProjectDAO();
        StringBuffer sb= new StringBuffer();
        for(Project pr:projectDAO.getAllProjects()){
               sb.append("Дата создания: "+pr.getDate()+" Название проекта: "+pr.getName()+" Количество разработчиков: "+pr.getDevelopers().size()+"\n");
        }
        return sb.toString();
    }

    public BigDecimal getSumSalaryOfDevelopersForProject(String projectName){
        projectDAO=new ProjectDAO();
        return projectDAO.readByName(projectName).getDevelopers().stream()
                .map(Developer::getSalary)
                .reduce(BigDecimal::add).get();
    }
    /**/
    
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

    public static ProjectService getProjectService() {
        return projectService;
    }
}
