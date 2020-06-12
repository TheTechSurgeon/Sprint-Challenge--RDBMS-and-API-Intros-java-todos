package com.bensimpson.sprint2.repositories;


import com.bensimpson.sprint2.models.Todos;
import org.springframework.data.repository.CrudRepository;

public interface TodosRepository extends CrudRepository<Todos, Long> {

}
