package hr.dandelic.librarymanagement;

import org.springframework.data.repository.CrudRepository;

import hr.dandelic.librarymanagement.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {
}
