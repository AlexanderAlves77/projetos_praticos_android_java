package br.com.fulldevstacks.repositories;

import br.com.fulldevstacks.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PersonRepository extends JpaRepository<Person, Long>
{

}
