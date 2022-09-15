package tech.getarrays.friends.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.getarrays.friends.exception.UserNotFoundException;
import tech.getarrays.friends.model.Friends;
import tech.getarrays.friends.repo.FriendsRepo;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class FriendsService {
    private final FriendsRepo friendsRepo;
@Autowired
    public FriendsService(FriendsRepo friendsRepo) {
        this.friendsRepo = friendsRepo;
    }
    public Friends addFriends(Friends friends){
    friends.setFriendCode(UUID.randomUUID().toString());
    return friendsRepo.save(friends);
    }
    public List<Friends> findAllFriends(){
    return friendsRepo.findAll();
    }
    public Friends updateFriends(Friends friends){
    return friendsRepo.save(friends);
    }
    public Friends findFriendsById(Long id){
    return friendsRepo.findFriendsById(id)
            .orElseThrow(() -> new UserNotFoundException("User by id" + id + " was not found"));
    }
    public void deleteFriends(Long id){
    friendsRepo.deleteFriendsById(id);
    }
}
