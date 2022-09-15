package tech.getarrays.friends;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.getarrays.friends.model.Friends;
import tech.getarrays.friends.service.FriendsService;

import javax.transaction.Transactional;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/friends")
public class FriendsResource {
    private final FriendsService friendsService;

    public FriendsResource(FriendsService friendsService){
        this.friendsService = friendsService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<Friends>> getAllFriends () {
        List<Friends> friends = friendsService.findAllFriends();
        return new ResponseEntity<>(friends, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Friends> getFriendsById (@PathVariable("id") Long id) {
        Friends friends = friendsService.findFriendsById(id);
        return new ResponseEntity<>(friends, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Friends> addFriends(@RequestBody Friends friends){
        Friends newFriend = friendsService.addFriends(friends);
        return new ResponseEntity<>(newFriend, HttpStatus.CREATED);
//        creating a new friend on server
    }
    @PutMapping("/update")
    public ResponseEntity<Friends> updateFriends(@RequestBody Friends friends){
        Friends updateFriend = friendsService.updateFriends(friends);
        return new ResponseEntity<>(updateFriend, HttpStatus.OK);
    }
//    Transactional allowed for me to delete from app
    @Transactional
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteFriends(@PathVariable("id") Long id){
        friendsService.deleteFriends(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
