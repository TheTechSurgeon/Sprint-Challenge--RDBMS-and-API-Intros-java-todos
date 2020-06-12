package com.bensimpson.sprint2.services;


import com.bensimpson.sprint2.models.User;
import com.bensimpson.sprint2.views.UserTodoCount;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUserById(long id);

    User saveUser(User user);

    void deleteUser(long id);

    List<UserTodoCount> getCountUsers();


}
