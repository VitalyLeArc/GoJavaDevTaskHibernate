package repository;

import domain.Developer;
import domain.Skill;
import domain.ENUM_GRADE;

import javax.persistence.Persistence;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DeveloperDAO extends DAO<Developer> {
    private final static DeveloperDAO developerDAO = new DeveloperDAO();

    private DeveloperDAO() {}

    public static DeveloperDAO getDeveloperDao() {
        entityManagerFactory = Persistence.createEntityManagerFactory("persistence_task");
        return developerDAO;
    }

    public List<Developer> getDevelopersForGrade(ENUM_GRADE grade) {
        startNewEntityManager();
        List<Skill> skills = entityManager.createQuery("From Skill sk where sk.grade=:grade_name")
                .setParameter("grade_name", grade)
                .getResultList();
        List<Developer> listSetDev = skills
                .stream()
                .flatMap(skill -> skill.getDevelopers().stream())
                .collect(Collectors.toList());
        entityManager.close();
        return listSetDev;
    }

    public List<Developer> getDevelopersForSkill(String skill) {
            skill = skill.toLowerCase();
            startNewEntityManager();
            List<Skill> skills = entityManager.createQuery("From Skill sk where sk.name=:sk_name")
                    .setParameter("sk_name", skill)
                    .getResultList();
            List<Developer> listSetDev = skills
                    .stream()
                    .flatMap(skillInStream ->skillInStream.getDevelopers().stream())
                    .collect(Collectors.toList());
            entityManager.close();
            return listSetDev;
    }

    /*по заданию
        список всех Java разработчиков;
        список всех middle разработчиков;
     */
}
