package ru.kpfu.bookstore.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.bookstore.model.Post;
import ru.kpfu.bookstore.model.User;

/**
 * Created by Nurislam on 01.05.2017.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    @Query("Select u from User u where id = ?1")
    User findOneById(int id);
}
