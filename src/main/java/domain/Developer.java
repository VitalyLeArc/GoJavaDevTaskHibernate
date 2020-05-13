package domain;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
public class Developer {

    public Developer(){}

    public Developer(String name, BigDecimal salary, _EnumSex sex) {
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
    private _EnumSex sex;

    @ManyToMany
    @JoinTable(name = "link_developers_projects")
    @JoinColumn(name= "dev_id")
    private List<Project> projects;
}

