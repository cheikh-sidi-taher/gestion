package com.emploi.gestion.models;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="sessions")
public class Session {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = true)
    private LocalDateTime dateTimeStart;
     @Column(nullable = true)
    private int duration;

    @ManyToOne
    @JoinColumn(name = "moduleID" ,nullable = true)
    private Module module;

    @ManyToOne
    @JoinColumn(name = "classID",nullable = true)
    private Classe classe;

    @ManyToOne
    @JoinColumn(name = "teacherID",nullable = true)
    private Teacher teacher;
}
