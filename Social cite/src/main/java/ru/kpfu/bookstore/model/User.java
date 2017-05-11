package ru.kpfu.bookstore.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nurislam on 01.05.2017.
 */
@Entity
@Table
public class User implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @NotNull
    @Size(min = 1, max = 255)
    @Column
    private String name;

    @NotNull
    @Email
    @Column
    private String email;

    @NotNull
    @Size(min = 1, max = 255)
    @Column
    private String password;

    @NotNull
    @Range(min = 18, max = 150)
    @Column
    private int age;

    private boolean sex; // male is true, female is false

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Post> posts = new ArrayList<>();

}
