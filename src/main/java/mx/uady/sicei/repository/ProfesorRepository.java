package mx.uady.sicei.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.uady.sicei.model.Profesor;

@Repository
public interface ProfesorRepository extends CrudRepository<Profesor, Integer> {
    //@Query("select u from User u where u.emailAddress = ?1")
    //User findByEmailAddress(String emailAddress);
}