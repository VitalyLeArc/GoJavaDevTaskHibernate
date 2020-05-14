package repository;

import domain.Developer;

import java.util.List;

public class DeveloperDAO extends _DAO<Developer> {

    public DeveloperDAO() {}

    public List<Developer> getDevelopersForGrade (String grade){
        startNewEntityManager();
        List<Developer> developers = entityManager.createQuery("from Developer where ").getResultList();
        return developers;
    }
    /*по заданию
            список всех Java разработчиков;
        список всех middle разработчиков;
     */


}
