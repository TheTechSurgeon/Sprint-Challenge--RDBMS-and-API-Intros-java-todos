package com.bensimpson.sprint2.services;


import com.bensimpson.sprint2.models.Todos;

public interface TodoService {
    Todos saveTodosToUser(Todos todos, long id);

    Todos updateTodos(long id);

}
