package com.circuit.breaker.service;

import com.circuit.breaker.domain.Publication;
import com.circuit.breaker.mapper.PublicationMapper;
import com.circuit.breaker.repository.PublicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicationService {

    private final PublicationRepository publicationRepository;

    private final PublicationMapper publicationMapper;

    private final CommentService commentService;

    @Autowired
    public PublicationService(final PublicationRepository publicationRepository,
                              final PublicationMapper publicationMapper,
                              final CommentService commentService) {
        this.publicationRepository = publicationRepository;
        this.publicationMapper = publicationMapper;
        this.commentService = commentService;
    }

    public void insert(Publication publication) {
        var publicationEntity = publicationMapper.toPublicationEntity(publication);
        publicationRepository.save(publicationEntity);
    }

    public List<Publication> findAll() {
        var publications = publicationRepository.findAll();
        return publications.stream().map(publicationMapper::toPublication).toList();
    }

    public Publication findById(String id) {
        var publication = publicationRepository.findById(id)
                .map(publicationMapper::toPublication)
                .orElseThrow(RuntimeException::new);

        var comments = commentService.getComments(id);
        publication.setComments(comments);
        return publication;
    }

}
