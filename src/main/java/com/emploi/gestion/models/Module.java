package com.emploi.gestion.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="modules")
public class Module {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = true)
    private String nameModule;

    @Column(nullable = true)
    private String description;
     @Column(nullable = true)
    private Integer credit; 


     @OneToMany(mappedBy = "module")
    private List<Session> sessions;
}
