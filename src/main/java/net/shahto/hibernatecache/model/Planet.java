package net.shahto.hibernatecache.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cache;

import java.util.Set;

@Getter
@Setter
@ToString
@Entity
@Cache(region = "planetCache", usage = CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "planets")
public class Planet {
    @Id
    private long id;
    private String name;
    private String type;
    private float mass;
    private int diameter;
    private float distance;
    @OneToMany(mappedBy="planet", cascade=CascadeType.ALL)
    private Set<Moon> moons;
}