package com.bensimpson.sprint2.repositories;


import com.bensimpson.sprint2.models.User;
import com.bensimpson.sprint2.views.UserTodoCount;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    @Query(value = "SELECT u.username AS usernames, count(td.userid) AS counttodos FROM users u LEFT JOIN todos td ON u.userid = td.userid GROUP BY u.username", nativeQuery = true)
    List<UserTodoCount> getCountUsers();
}
