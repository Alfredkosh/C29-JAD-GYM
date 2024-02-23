package c29.jad.mappers;

import c29.jad.dtos.FriendDto;
import c29.jad.models.FriendsModel;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface FriendMapper {
    FriendMapper INSTANCE = Mappers.getMapper(FriendMapper.class);

    @Mapping(source = "userA.username", target = "userAName")
    @Mapping(source = "userB.username", target = "userBName")
    @Mapping(source = "userA.id", target = "userAId")
    @Mapping(source = "userB.id", target = "userBId")
    FriendDto mapToFriendDto(FriendsModel friendsModel);

    @IterableMapping(elementTargetType = FriendDto.class)
    List<FriendDto> mapToFriendDtoList(List<FriendsModel> friendsModels);
}
