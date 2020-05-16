package domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "projects")
@EqualsAndHashCode(of = "id")
public class Project {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "datebegin")
    private Date date;

    @ManyToMany(mappedBy = "projects")
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
