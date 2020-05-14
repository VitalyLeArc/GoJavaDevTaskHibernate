package service;

import domain.Developer;
import repository.DeveloperDAO;

public class DeveloperService {
    DeveloperDAO developerDAO;

    public Developer getDeveloperById(Long id) {
        developerDAO= new DeveloperDAO();
        return developerDAO.read(Developer.class, id);
    }
    public void addNewDeveloper(Developer dev) {
        developerDAO= new DeveloperDAO();
        developerDAO.create(dev);
    }
    public void updateDeveloperById(Developer dev, Long id) {
        developerDAO= new DeveloperDAO();
        developerDAO.update(Developer.class, dev, id);
    }
    public void deleteDeveloperById(Long id) {
        developerDAO= new DeveloperDAO();
        developerDAO.delete(Developer.class, id);
    }


    private static final DeveloperService developerService = new DeveloperService();

    private DeveloperService() {
    }

    public static DeveloperService getDeveloperService() {
        return developerService;
    }
}
