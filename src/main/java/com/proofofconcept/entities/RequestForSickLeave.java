package com.proofofconcept.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "sick_leave")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class RequestForSickLeave {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "req_id")
    private long id;

    @Column(name = "date")
    private LocalDate date;

    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column(name = "status")
    private String status;




}
