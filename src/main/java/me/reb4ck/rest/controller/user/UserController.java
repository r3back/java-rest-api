package me.reb4ck.rest.controller.user;

import me.reb4ck.rest.exception.UserAlreadyCreatedException;
import me.reb4ck.rest.model.User;
import me.reb4ck.rest.model.reply.UserReply;
import me.reb4ck.rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping()
public final class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/create_user")
    public ResponseEntity<?> create(@RequestBody User user){
        Optional<User> optionalUser = userService.findByEmail(user.getEmail());
        if(optionalUser.isPresent()){
            throw new UserAlreadyCreatedException("You Already created an user with that email!");
        }else{
            optionalUser = Optional.ofNullable(userService.save(user));
            return optionalUser.isPresent() ?
                    ResponseEntity
                            .status(HttpStatus.CREATED)
                            .body(new UserReply(optionalUser.get())) :
                    ResponseEntity
                            .notFound()
                            .build();
        }
    }
}
