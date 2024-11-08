package com.edu.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_data")
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class User {

    @Id
    @EqualsAndHashCode.Include
    private Integer idUser;

    //fk role
    @ManyToOne
    @JoinColumn(name = "id_role",nullable = false, foreignKey = @ForeignKey(name = "FK_USER_ROLE"))
    private Role role;

    @Column(nullable = false,length = 50,unique = true)
    private String username;

    @Column(nullable = false,length = 120)
    private String password;

    @Column(nullable = false)
    private boolean enabled;
}
