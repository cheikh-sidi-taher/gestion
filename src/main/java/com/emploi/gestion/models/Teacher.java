package com.emploi.gestion.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="teachers")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String lastName;

     @Column(nullable=true)
    private String  firstName;

      @Column(nullable=false)
    private Integer phoneNumber;

     @Column(nullable=false)
    private String   SubjectTaught;

       @OneToMany(mappedBy = "teacher")
    private List<Session> sessions;
}
