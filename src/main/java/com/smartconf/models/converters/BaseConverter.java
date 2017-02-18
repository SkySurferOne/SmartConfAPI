package com.smartconf.models.converters;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Created by Lenovo on 2017-01-14.
 *
 * E - entity
 * D - dto
 */
public interface BaseConverter<E, D> {
    D convertFromEntity(E entity);
    E convertFromDto(D dto);

    default Collection<D> convertFromEntities(final Collection<E> entities) {
        return entities.stream()
                .map(this::convertFromEntity)
                .collect(Collectors.toList());
    }

    default Collection<E> convertFromDtos(final Collection<D> dtos) {
        return dtos.stream()
                .map(this::convertFromDto)
                .collect(Collectors.toList());
    }
}
