package com.github.ricbau.profile.input;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProfilePayload(
        @NotBlank @NotNull String username,
        String firstName,
        String lastName,
        String profilePic
) {
}
