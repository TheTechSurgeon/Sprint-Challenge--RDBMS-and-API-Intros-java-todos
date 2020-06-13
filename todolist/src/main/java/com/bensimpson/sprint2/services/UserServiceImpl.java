package com.bensimpson.sprint2.services;


import com.bensimpson.sprint2.models.Todos;
import com.bensimpson.sprint2.models.User;
import com.bensimpson.sprint2.repositories.TodosRepository;
import com.bensimpson.sprint2.repositories.UserRepository;
import com.bensimpson.sprint2.views.UserTodoCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service(value = "userService")
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;
    @Autowired
    TodosRepository todosRepository;

    @Override
    public List<User> getAllUsers() {
        List<User> rtnList = new ArrayList<>();
        userRepository.findAll().iterator().forEachRemaining(rtnList::add);
        return rtnList;
    }

    @Override
    public User getUserById(long id) {
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id + " not found"));
    }

    @Transactional
    @Override
    public User saveUser(User user) {
        User newUser = new User();

        // PUT
            userRepository.findById(user.getUserid()).orElseThrow(() -> new EntityNotFoundException(user.getUserid() + " not found for PUT request"));

            newUser.setUserid(user.getUserid());



        newUser.setUsername(user.getUsername());
        newUser.setPassword(user.getPassword());
        newUser.setPrimaryemail(user.getPrimaryemail());

        newUser.getTodos().clear();
        for (Todos t : user.getTodos()){

            Todos newTodo = new Todos();
            newTodo.setDescription(t.getDescription());
            newTodo.setUser(newUser);

            newUser.getTodos().add(newTodo);
        }

        return userRepository.save(newUser);

    }

    @Transactional
    @Override
    public void deleteUser(long id) {
        if (userRepository.findById(id).isPresent()){
            userRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("USER ID NOT FOUND");
        }
    }

    @Override
    public List<UserTodoCount> getCountUsers() {
        return userRepository.getCountUsers();
    }
}
