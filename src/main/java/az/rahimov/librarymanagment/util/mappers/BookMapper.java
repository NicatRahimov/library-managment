package az.rahimov.librarymanagment.util.mappers;

import az.rahimov.librarymanagment.dto.BookDTO;
import az.rahimov.librarymanagment.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "isbn", target = "isbn")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "authors", target = "authors")
    @Mapping(source = "categories", target = "categories")
    @Mapping(source = "publishers", target = "publishers")
    BookDTO toDto(Book entity);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "isbn", target = "isbn")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "authors", target = "authors")
    @Mapping(source = "categories", target = "categories")
    @Mapping(source = "publishers", target = "publishers")
    Book toEntity(BookDTO bookDTO);

    List<BookDTO> toDtoList(List<Book> books);
    List<Book> toEntityList(List<BookDTO> books);
}
