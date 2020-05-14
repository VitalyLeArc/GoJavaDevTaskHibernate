package repository;

import domain.Project;

public class ProjectDAO extends _DAO<Project> {

    private static final ProjectDAO projectDAO = new ProjectDAO();

    private ProjectDAO() {}

    public static ProjectDAO getProjectDao(){
        return projectDAO;
    }


    /*по заданию
        список разработчиков отдельного проекта;
        список проектов в следующем формате: дата создания - название проекта - количество разработчиков на этом проекте.

        зарплату(сумму) всех разработчиков отдельного проекта;
    */
}
