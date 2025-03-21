package com.github.ricbau.profile.mappers;

import com.github.ricbau.profile.entities.Profile;
import com.github.ricbau.profile.input.ProfilePayload;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface ProfilePayloadMapper extends Converter<Profile, ProfilePayload> {

    ProfilePayload map(Profile profile);

}
