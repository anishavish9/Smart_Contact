/**
 *
 * Projection in a Spring Boot application
 * (especially when working with Spring Data JPA)
 * is useful when you want to fetch only specific fields from an entity instead
 * of the entire entity.
 *
 * **/

package com.scm.backend.Projection;

import com.scm.backend.entity.User;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "user-projection", types = {User.class})
public interface UserProjection {
//
//    String getName();
//
//    String getEmail();
//
//    String getAbout();

}
