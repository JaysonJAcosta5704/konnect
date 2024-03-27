package onetomany.Users;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 
 * @author Vivek Bengre
 * 
 */ 

public interface UserRepository extends JpaRepository<User, Long> {
    User findById(int id);
    void deleteById(int id);
    void deleteUserById(int id);
    User findUserByUsername(String username);
    User findByEmailId(String emailId);

    @Override
    void delete(User entity);
}
