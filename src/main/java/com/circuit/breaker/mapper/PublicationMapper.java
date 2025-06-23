package com.circuit.breaker.mapper;

import com.circuit.breaker.controller.request.PublicationRequest;
import com.circuit.breaker.domain.Publication;
import com.circuit.breaker.repository.entity.PublicationEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PublicationMapper {

    PublicationEntity toPublicationEntity(Publication publication);

    Publication toPublication(PublicationEntity publicationEntity);

    Publication toPublication(PublicationRequest publicationRequest);

}
