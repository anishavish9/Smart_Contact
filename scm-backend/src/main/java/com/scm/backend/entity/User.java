package com.scm.backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class User {

    @Id
    private String id;

    @Column(nullable = false)
    @NotBlank(message = "User is required")
    @Length(min = 3, max = 100, message = "Atleast have 3 & Name must not exceeds 100 characters")
    private String name;

    @Column(unique = true, nullable = false)
    @Email(message = "Invalid email format")
    private String email;

    @Column(nullable = false)
    @Size(min = 8, message = "Password must be at least 6 characters")
    private String password;

    @Lob
    private String about;

    @Column(length = 1000)
    private String profilePicture;

    @Pattern(
            regexp = "^(\\+\\d{1,3}[- ]?)?\\d{10}$",
            message = "Phone number must be valid"
    )
    private String phoneNumber;

    private boolean enabled = false;

    private boolean emailVerified = false;

    private boolean phoneVerified = false;

    @Enumerated(value = EnumType.STRING)
    private Providers provider = Providers.SELF;

    @Column
    private String emailToken;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    //will not show in database which is unneccessary
    private Set<Contact> contacts = new LinkedHashSet<>();

}
