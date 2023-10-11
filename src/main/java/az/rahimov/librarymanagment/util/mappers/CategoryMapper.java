package az.rahimov.librarymanagment.util.mappers;

import az.rahimov.librarymanagment.dto.CategoryDTO;
import az.rahimov.librarymanagment.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);
    @Mapping(source = "id",target = "id")
    @Mapping(source = "name",target = "name")
    CategoryDTO toDto (Category category);

    @Mapping(source = "id",target = "id")
    @Mapping(source = "name",target = "name")
    Category toEntity (CategoryDTO categoryDTO);


    List<Category> toEntityList(List<CategoryDTO> categoryDTOS);

    List<CategoryDTO> toDtoList(List<Category>categories);
}
