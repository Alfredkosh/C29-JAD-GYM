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
    public void addFriend(Integer ownerId, Integer userId) {
        List<FriendsModel> friendsModels = friendsListRepository.findFriends(ownerId, userId);
        if (friendsModels.isEmpty()) {
            FriendsModel friendsModel = new FriendsModel();
            friendsModel.setUserAId(ownerId);
            friendsModel.setUserBId(userId);
            friendsListRepository.save(friendsModel);
            return;
        }
        throw new InternalError("Already friends");
    }
    public List<FriendsModel> getFriends(Integer userId) {
        return friendsListRepository.findFriends(userId);
    }

}


