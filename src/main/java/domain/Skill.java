package domain;

import domain.enums.EnumGrade;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "skills")
@EqualsAndHashCode(of = "id")
public class Skill {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "skill_name")
    private String name;

    @Column(name = "grade")
    @Enumerated(EnumType.STRING)
    private EnumGrade grade;

    @ManyToMany(mappedBy = "skills")
    private Set<Developer> developers = new HashSet<>();
}