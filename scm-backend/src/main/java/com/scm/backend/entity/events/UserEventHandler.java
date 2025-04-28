package com.scm.backend.entity.events;

import com.scm.backend.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RepositoryEventHandler(User.class)
public class UserEventHandler {

    private Logger log = LoggerFactory.getLogger(UserEventHandler.class);

    @HandleBeforeCreate
    public void handleBeforeCreate(User user) {
        log.info("Going to create user ");
        user.setId(UUID.randomUUID().toString());
    }
}
