package repository;

import domain.Developer;
import domain.Skill;
import domain._EnumGrade;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DeveloperDAO extends _DAO<Developer> {

    public DeveloperDAO() {
    }

    public List<Developer> getDevelopersForGrade(String gradeString) {
        _EnumGrade grade;
        gradeString = gradeString.toLowerCase();
        switch (gradeString) {
            case "junior":
                grade = _EnumGrade.Junior;
                break;
            case "middle":
                grade = _EnumGrade.Middle;
                break;
            case "senior":
                grade = _EnumGrade.Senior;
                break;
            default:
                return null;
        }
        startNewEntityManager();
        Set<Skill> skills = Set.copyOf(entityManager.createQuery("From Skill sk where sk.grade=:grade_name")
                .setParameter("grade_name", grade)
                .getResultList());
        List<Set<Developer>> lsd = skills.stream().flatMap(skill -> Stream.of(skill.getDevelopers())).collect(Collectors.toList()); //боль
        entityManager.close();
        return lsd.stream().flatMap(Set::stream).distinct()
                .collect(Collectors.toList());
    }

    public List<Developer> getDevelopersForSkill(String skill) {
        skill = skill.toLowerCase();
        if (!Arrays.asList("java", "c++", "c#", "js", "lua").contains(skill)) {
            return null;
        }
        startNewEntityManager();
        Set<Skill> skills = Set.copyOf(entityManager.createQuery("From Skill sk where sk.name=:sk_name")
                .setParameter("sk_name", skill)
                .getResultList());
        List<Set<Developer>> lsd = skills.stream().flatMap(skillInStream -> Stream.of(skillInStream.getDevelopers())).collect(Collectors.toList());
        entityManager.close();
        return lsd.stream().flatMap(Set::stream).distinct()
                .collect(Collectors.toList());
    }
    /*по заданию
        список всех Java разработчиков;
        список всех middle разработчиков;
     */
}
