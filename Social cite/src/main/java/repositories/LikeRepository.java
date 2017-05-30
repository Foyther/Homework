package repositories;

import models.Authority;
import models.Like;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Nurislam on 30.05.2017.
 */
public interface LikeRepository extends JpaRepository<Like, Integer> {
}
