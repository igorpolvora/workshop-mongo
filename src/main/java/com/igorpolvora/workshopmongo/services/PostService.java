package com.igorpolvora.workshopmongo.services;

import org.springframework.stereotype.Service;
import com.igorpolvora.workshopmongo.domain.Post;
import com.igorpolvora.workshopmongo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.igorpolvora.workshopmongo.services.exception.ObjectNotFoundException;


@Service
public class PostService {

    @Autowired
    private PostRepository PostRepository;

    public Post findById(String id) {
        return PostRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }
}
