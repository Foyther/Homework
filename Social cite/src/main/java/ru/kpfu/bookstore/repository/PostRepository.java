package ru.kpfu.bookstore.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.bookstore.model.Post;

/**
 * Created by Nurislam on 24.04.2017.
 */
@Repository
public interface PostRepository extends CrudRepository<Post, Long> {

    @Query("Select p from Post p where id = ?1")
    Post findOneById(Long id);
}
