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

@Entity
@Table(name = "user_contacts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Contact {

    @Id
    private String id;


    @NotBlank(message = "Contact name is required")
    @Size(max = 100, message = "Name can't exceed 100 characters")
    private String name;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email name is required")
    private String email;

    @Pattern(
            regexp = "^(\\+\\d{1,3}[- ]?)?\\d{10}$",
            message = "Phone number must be valid"
    )
    private String phoneNumber;

    @Size(max = 500, message = "Address can have at most 250 characters")
    private String address;

    @Column(length = 100)
    private String picture;

    @Lob
    @Size(max = 1000, message = "Description can't exceed 1000 characters")
    private String description;

    private boolean favourite = false;

    @Pattern(
            regexp = "^(https?://.*)?$",
            message = "Website link must be a valid URL"
    )
    private String websiteLink;

    @Pattern(
            regexp = "^(https?://.*)?$",
            message = "LinkedIn link must be a valid URL"
    )
    private String linkedInLink;

    @Pattern(
            regexp = "^(https?://.*)?$",
            message = "Instagram link must be a valid URL"
    )
    private String instagramLink;

    @Size(max = 200, message = "Cloudinary ID can have at most 200 characters")
    private String cloudinaryImagePublicId;

    @ManyToOne
    private User user;
}
