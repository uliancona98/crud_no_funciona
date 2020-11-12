package mx.uady.sicei.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.uady.sicei.model.Tutoria;
import mx.uady.sicei.model.TutoriaId;;

@Repository
public interface TutoriaRepository extends CrudRepository<Tutoria, TutoriaId>{}