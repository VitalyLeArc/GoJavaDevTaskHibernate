package domain;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
public class Developer {
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
    private sexEnum sex;

    @ManyToMany
    @JoinTable(name = "link_developers_projects")
    @JoinColumn(name= "dev_id")
    private List<Project> projects;
}

enum sexEnum {male, female}
