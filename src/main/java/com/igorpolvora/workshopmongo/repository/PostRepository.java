package com.igorpolvora.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import com.igorpolvora.workshopmongo.domain.Post;
import java.util.List;
import java.util.Date;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    @Query("{field: { $regex: ?0, $options: 'i' }}")
    List<Post> findByTitle(String text);


    List<Post> findByTitleContainingIgnoreCase(String text);

    @Query("{$and: [{ 'title': { $regex: ?0, $options: 'i' } }, { 'date': { $gte: ?1, $lte: ?2 } }]}")
    List<Post> fullSearch(String text, Date minDate, Date maxDate);
}
