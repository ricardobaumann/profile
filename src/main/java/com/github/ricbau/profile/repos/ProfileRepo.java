package com.github.ricbau.profile.repos;

import com.github.ricbau.profile.entities.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProfileRepo extends CrudRepository<Profile, UUID> {
}
