package mainpackage.services;

import mainpackage.model.LoginRequest;
import mainpackage.model.LoginResponse;
import mainpackage.model.SignupResponse;
import mainpackage.model.User;
import mainpackage.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public LoginResponse authenticate(LoginRequest loginRequest)
    {
        User currentUser =  userRepository.findByEmail(loginRequest.getEmail());
        LoginResponse loginResponse = new LoginResponse();
        if(currentUser == null )
        {
            loginResponse.setStatus(false);
            loginResponse.setMessage("User not found, Please Signup ");
        }
        else{
            loginResponse.setStatus(true);
            loginResponse.setMessage("Login Successfully");
        }
        return loginResponse;
    }

    public SignupResponse register(User user){
        User currentUser = userRepository.findByEmail(user.getEmail());
        SignupResponse signupResponse = new SignupResponse();
        if(currentUser == null){
            userRepository.save(user);
            signupResponse.setStatus(true);
            signupResponse.setMessage("Signup Successful");
        }
        else {
            signupResponse.setStatus(false);
            signupResponse.setMessage("User already exits");
        }
        return signupResponse;
    }
}
