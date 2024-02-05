package c29.jad.mappers;

import c29.jad.dtos.CourseDto;
import c29.jad.models.CourseListModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CourseMapper {
    CourseMapper INSTANCE = Mappers.getMapper(CourseMapper.class);

    List<CourseDto> toCoursesDto(List<CourseListModel> courseListModels);
}
