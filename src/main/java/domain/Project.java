package domain;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "projects", fetch = FetchType.LAZY)
    private Set<Developer> developers = new HashSet<>();

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", developers= [ ");
        for (Developer d : developers) {
            sb.append("\"" + d.getName() + "\" ");
        }
        sb.append("]");
        return sb.toString();
    }
}
