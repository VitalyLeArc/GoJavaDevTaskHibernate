package domain;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Project {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private Long id;

    @Column(name="name")
    private String name;

    @ManyToMany
    @JoinTable(name = "link_developers_projects")
    @JoinColumn(name = "project_id")
    private List<Developer> developers;
}
