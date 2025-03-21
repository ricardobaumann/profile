package com.github.ricbau.profile.services;

import com.github.ricbau.profile.repos.ProfileRepo;
import lombok.AllArgsConstructor;
import lombok.experimental.Delegate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProfileService {
    @Delegate
    private final ProfileRepo profileRepo;
}
