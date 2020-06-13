package com.bensimpson.sprint2.services;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserAuditing implements AuditorAware {

    @Override
    public Optional getCurrentAuditor() {
        String uname;
        uname = "llama";
        return Optional.of(uname);
    }
}
