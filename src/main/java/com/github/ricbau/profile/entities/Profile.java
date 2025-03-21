package com.github.ricbau.profile.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "profiles")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Profile implements IdTrait {

    @Id
    @Builder.Default
    private UUID id = UUID.randomUUID();

    private String username;

    private String firstName;

    private String lastName;

    private String profilePic;

}
