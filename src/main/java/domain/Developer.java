package domain;

import domain.enums.EnumSex;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;


@Data
@Table(name = "developers")
@Entity
@EqualsAndHashCode(of = "id")
public class Developer {

    public Developer() {
    }

    public Developer(String name, BigDecimal salary, EnumSex sex) {
        this.name = name;
        this.salary = salary;
        this.sex = sex;
    }

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "salary")
    private BigDecimal salary;

    @Column(name = "sex")
    @Enumerated(EnumType.STRING)
    private EnumSex sex;

    @ManyToMany
    @JoinTable(
            name = "link_developers_skills",
            joinColumns = {@JoinColumn(name = "dev_id")},
            inverseJoinColumns = {@JoinColumn(name = "skill_id")}
    )
    private Set<Skill> skills = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "link_developers_projects",
            joinColumns = {@JoinColumn(name = "dev_id")},
            inverseJoinColumns = {@JoinColumn(name = "project_id")}
    )
    private Set<Project> projects = new HashSet<>();


    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("Developer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", sex=" + sex +
                ", skills= [ ");
        for (Skill sk : skills) {
            sb.append("\"" + sk.getName() + "\" ");
            sb.append("\"" + sk.getGrade() + "\" ");
        }
        sb.append("], projects= [ ");

        for (Project p : projects) {
            sb.append("\"" + p.getName() + "\" ");
        }
        sb.append("]");
        return sb.toString();
    }
}




