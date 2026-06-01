package com.igorpolvora.workshopmongo.services;

import org.springframework.stereotype.Service;
import com.igorpolvora.workshopmongo.domain.Post;
import com.igorpolvora.workshopmongo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.igorpolvora.workshopmongo.services.exception.ObjectNotFoundException;
import java.util.List;
import java.util.Date;



@Service
public class PostService {

    @Autowired
    private PostRepository PostRepository;

    public Post findById(String id) {
        return PostRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }

    public List<Post> findByTitle(String text) {
        return PostRepository.findByTitle(text);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
        return PostRepository.fullSearch(text, minDate, maxDate);
    }
}
