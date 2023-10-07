package az.rahimov.librarymanagment.util;

import az.rahimov.librarymanagment.dto.AuthorDTO;
import az.rahimov.librarymanagment.model.Author;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AuthorMapper {
    AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);


    @Mapping(target = "id",source = "id")
    @Mapping(target = "firstName",source = "firstName")
    @Mapping(target = "lastName",source = "lastName")
    AuthorDTO toDto(Author author);

    @Mapping(target = "id",source = "id")
    @Mapping(target = "firstName",source = "firstName")
    @Mapping(target = "lastName",source = "lastName")
    Author toEntity (AuthorDTO authorDTO);

    List<Author> toEntityList(List<AuthorDTO> authorDTOS);

    List<AuthorDTO>toDtoList(List<Author> authors);

}
