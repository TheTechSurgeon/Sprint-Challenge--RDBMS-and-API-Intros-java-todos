package com.bensimpson.sprint2;


import com.bensimpson.sprint2.models.Todos;
import com.bensimpson.sprint2.models.User;
import com.bensimpson.sprint2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Component
public class SeedData implements CommandLineRunner
{
    @Autowired
    UserService userService;

    @Transactional
    @Override
    public void run(String[] args) throws Exception
    {
        User u1 = new User("admin",
                "password",
                "admin@lambdaschool.local");
        u1.getTodos()
                .add(new Todos("Give Joe access rights",
                        u1));
        u1.getTodos()
                .add(new Todos("Change the color of the home page",
                        u1));

        userService.saveUser(u1);

        User u2 = new User("cinnamon",
                "1234567",
                "cinnamon@lambdaschool.local");
        u2.getTodos()
                .add(new Todos("Take a nap",
                        u2));
        u2.getTodos()
                .add(new Todos("Rearrange my hutch",
                        u2));
        u2.getTodos()
                .add(new Todos("Groom my fur",
                        u2));
        userService.saveUser(u2);

        User u3 = new User("barnbarn",
                "ILuvM4th!",
                "barnbarn@lambdaschool.local");
        u3.getTodos()
                .add(new Todos("Rearrange my hutch",
                        u3));
        userService.saveUser(u3);

        User u4 = new User("puttat",
                "password",
                "puttat@school.lambda");
        userService.saveUser(u4);

        User u5 = new User("misskitty",
                "password",
                "misskitty@school.lambda");
        userService.saveUser(u5);
    }
}
