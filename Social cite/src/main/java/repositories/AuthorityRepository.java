package repositories;

import models.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Nurislam on 30.05.2017.
 */
public interface AuthorityRepository extends JpaRepository<Authority, Integer> {
    Authority findByAuthority(String role_user);
}
