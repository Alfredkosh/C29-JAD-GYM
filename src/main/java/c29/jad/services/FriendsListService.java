
package c29.jad.services;

import c29.jad.models.FriendsModel;
import c29.jad.repositories.FriendsListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendsListService {
    @Autowired
    FriendsListRepository friendsListRepository;


//    public String getUsernameById(Integer userId) {
//        FriendsModel result =  friendsListRepository.findUsernameById(userId);
//
//        return result.getUsername();
//    }

    public void addFriend(Integer ownerId, Integer userId) {
        List<FriendsModel> friendsModels = friendsListRepository.findFriends(ownerId, userId);
        if (friendsModels.size() == 0) {
            FriendsModel friendsModel = new FriendsModel();
            friendsModel.setUserAId(ownerId);
            friendsModel.setUserBId(userId);
            friendsListRepository.save(friendsModel);
            return;
        }
        System.out.print("Already friends");
    }



//    public List<FriendsModel> getProfileById(Integer userId) {
//        return friendsListRepository.findByUserId(userId);

    }


