package tech.getarrays.friends.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.getarrays.friends.model.Friends;

import java.util.Optional;

public interface FriendsRepo extends JpaRepository<Friends, Long> {
    void deleteFriendsById(Long id);

    Optional<Friends> findFriendsById(Long id);
}
//Query method in spring