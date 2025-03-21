package com.github.ricbau.profile.mappers;

import com.github.ricbau.profile.entities.IdTrait;
import com.github.ricbau.profile.output.ResourceRef;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface ResourceRefMapper extends Converter<IdTrait, ResourceRef> {

    ResourceRef map(IdTrait idTrait);

}
