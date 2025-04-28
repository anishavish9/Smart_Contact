package com.scm.backend.repository;

import com.scm.backend.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
//@RepositoryRestResource(path = "user-contacts", collectionResourceRel = "user-contacts")//can be access from this path now not the contacts only
public interface ContactRepository extends JpaRepository<Contact, String> {

    @RestResource(exported = false)
    Contact findByEmail(String Email);

    @RestResource(path = "by-phone", rel = "by-phone")
    Contact findByPhoneNumber(String PhoneNumber);

    @RestResource(path = "by-name")
    List<Contact> findByNameContainingIgnoreCase(@Param("name") String name);

//    @RestResource(path = "by-phone")
//    List<Contact> findByPhoneContainingIgnoreCase(@Param("phone") String phoneNumber);

    @RestResource(path = "by-email")
    List<Contact> findByEmailContainingIgnoreCase(@Param("email") String Email);


}


