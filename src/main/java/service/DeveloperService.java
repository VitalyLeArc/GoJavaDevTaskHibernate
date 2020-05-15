package service;

import domain.Developer;
import repository.DeveloperDAO;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DeveloperService {
    DeveloperDAO developerDAO;

    public List<String> getDevelopersForGrade(String grade) {
        developerDAO = new DeveloperDAO();
        return developerDAO.getDevelopersForGrade(grade).stream()
                .flatMap(developer -> Stream.of(developer.getName()))
                .collect(Collectors.toList());
    }

    public List<String> getDevelopersForSkill(String skill) {
        developerDAO = new DeveloperDAO();
        return developerDAO.getDevelopersForSkill(skill).stream()
                .flatMap(dev -> Stream.of(dev.getName()))
                .collect(Collectors.toList());
    }

    public Developer getDeveloperById(Long id) {
        developerDAO = new DeveloperDAO();
        return developerDAO.read(Developer.class, id);
    }

    public void addNewDeveloper(Developer dev) {
        developerDAO = new DeveloperDAO();
        developerDAO.create(dev);
    }

    public void updateDeveloperById(Developer dev, Long id) {
        developerDAO = new DeveloperDAO();
        developerDAO.update(Developer.class, dev, id);
    }

    public void deleteDeveloperById(Long id) {
        developerDAO = new DeveloperDAO();
        developerDAO.delete(Developer.class, id);
    }


    private static final DeveloperService developerService = new DeveloperService();

    private DeveloperService() {
    }

    public static DeveloperService getDeveloperService() {
        return developerService;
    }


}
