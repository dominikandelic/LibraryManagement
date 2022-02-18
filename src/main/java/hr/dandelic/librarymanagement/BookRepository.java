package hr.dandelic.librarymanagement;

import org.springframework.data.repository.CrudRepository;

import hr.dandelic.librarymanagement.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {

}
