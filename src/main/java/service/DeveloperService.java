package service;

import domain.Developer;
import domain.enums.EnumGrade;
import repository.DeveloperDAO;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DeveloperService {

    private static final DeveloperService developerService = new DeveloperService();

    private DeveloperService(){}

    public static DeveloperService getDeveloperService() {
        return developerService;
    }

    public List<String> getDevelopersForGrade(String grade) {
        return DeveloperDAO.getDeveloperDao().getDevelopersForGrade(EnumGrade.getEnumForString(grade))
                .stream()
                .flatMap(developer -> Stream.of(developer.getName()))
                .collect(Collectors.toList());
    }

    public List<String> getDevelopersForSkill(String skill) {
        return DeveloperDAO.getDeveloperDao().getDevelopersForSkill(skill)
                .stream()
                .flatMap(dev -> Stream.of(dev.getName()))
                .collect(Collectors.toList());
    }

    public Developer getDeveloperById(Long id) {
        return DeveloperDAO.getDeveloperDao().read(Developer.class, id);
    }

    public void addNewDeveloper(Developer dev) {
        DeveloperDAO.getDeveloperDao().create(dev);
    }

    public void updateDeveloperById(Developer dev, Long id) {
        DeveloperDAO.getDeveloperDao().update(Developer.class, dev, id);
    }

    public void deleteDeveloperById(Long id) {
        DeveloperDAO.getDeveloperDao().delete(Developer.class, id);
    }

}
