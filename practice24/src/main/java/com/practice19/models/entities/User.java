package com.practice19.models.entities;

import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@Data
@Entity
@Table(schema = "java_templates", name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "first_name")
    private String first_name;
    @Column(name = "last_name")
    private String last_name;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "role")
    @ColumnDefault("USER")
    private Role role;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @PrePersist
    void preInsert(){
        if(this.role == null){
            this.role = Role.USER;
        }
        if(this.status == null){
            this.status = Status.ACTIVE;
        }
    }
}
