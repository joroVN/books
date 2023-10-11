package bg.softuni.books.model.service;

import bg.softuni.books.model.dto.AuthorDTO;
import bg.softuni.books.model.dto.BookDTO;
import bg.softuni.books.model.entity.BookEntity;
import bg.softuni.books.model.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Optional<BookDTO> getBookById(Long bookId) {
        return this.bookRepository
                .findById(bookId)
                .map(this::map);
    }

    public List<BookDTO> getAlLBooks() {
        return this.bookRepository
                .findAll()
                .stream()
                .map(this::map)
                .collect(Collectors.toList());
    }

    private BookDTO map(BookEntity bookEntity) {
        return new BookDTO()
                .setId(bookEntity.getId())
                .setTitle(bookEntity.getTitle())
                .setIsbn(bookEntity.getIsbn())
                .setAuthor(new AuthorDTO().setName(bookEntity.getAuthor().getName()));
    }

    public void deleteById(Long bookId) {
        this.bookRepository.deleteById(bookId);
    }

    public Long createBook(BookDTO newBook) {
        // TODO: implement method.

        return 50L;
    }
}
