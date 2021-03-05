package com.ccs.employee.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false,nullable = false)
    private Long id;
    private String name;
    private String email;
    private String jobTitle;
    private String phone;
    @Column(length = 1000)
    private String imageUrl;
    @Column(updatable = false,nullable = false)
    private String employeeCode;
}
