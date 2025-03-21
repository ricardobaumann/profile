package com.github.ricbau.profile.controllers;

import com.github.ricbau.profile.entities.Profile;
import com.github.ricbau.profile.input.CreateProfilePayload;
import com.github.ricbau.profile.output.ResourceRef;
import com.github.ricbau.profile.services.ProfileService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/profile")
public class ProfileController {
    private final ProfileService profileService;
    private final ConversionService conversionService;

    @PostMapping
    public ResourceRef post(@RequestBody @Valid CreateProfilePayload createProfilePayload) {
        return conversionService.convert(
                profileService.save(Objects.requireNonNull(
                        conversionService.convert(createProfilePayload, Profile.class))),
                ResourceRef.class
        );
    }

}
