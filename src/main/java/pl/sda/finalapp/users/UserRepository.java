package pl.sda.finalapp.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("SELECT u from User u where lower(u.eMail)=lower(:eMail)")
    Optional<User> findByEMail(@Param("eMail") String eMail);
}