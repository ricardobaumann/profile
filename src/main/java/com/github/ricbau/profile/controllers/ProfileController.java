package com.github.ricbau.profile.controllers;

import com.github.ricbau.profile.entities.Profile;
import com.github.ricbau.profile.input.ProfilePayload;
import com.github.ricbau.profile.output.ResourceRef;
import com.github.ricbau.profile.services.ProfileService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/profile")
public class ProfileController {
    private final ProfileService profileService;
    private final ConversionService conversionService;

    @PostMapping
    public ResourceRef post(@RequestBody @Valid ProfilePayload profilePayload) {
        return conversionService.convert(
                profileService.save(Objects.requireNonNull(
                        conversionService.convert(profilePayload, Profile.class))),
                ResourceRef.class
        );
    }

    @GetMapping("/{id}")
    @Cacheable(cacheNames = "profile")
    public ResponseEntity<ProfilePayload> get(@PathVariable UUID id) {
        return profileService.findById(id)
                .map(profile -> conversionService.convert(profile, ProfilePayload.class))
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
