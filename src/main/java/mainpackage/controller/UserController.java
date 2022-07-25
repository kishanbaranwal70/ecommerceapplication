package mainpackage.controller;

import mainpackage.model.LoginRequest;
import mainpackage.model.LoginResponse;
import mainpackage.model.SignupResponse;
import mainpackage.model.User;
import mainpackage.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping
    public String edit()
    {
        return "Hello World";
    }

    @PostMapping(value="/login",consumes = "application/json",produces = "application/json")
    public LoginResponse loginreq(@RequestBody LoginRequest loginRequest)
    {
        LoginResponse loginResponse = userService.authenticate(loginRequest);
        return loginResponse;
    }

    @PostMapping(value="/signup",consumes = "application/json", produces="application/json")
    public SignupResponse signup(@RequestBody User user)
    {
        SignupResponse signupResponse = userService.register(user);

        return signupResponse;
    }
}
