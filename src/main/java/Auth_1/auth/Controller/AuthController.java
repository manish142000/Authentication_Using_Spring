package Auth_1.auth.Controller;


import Auth_1.auth.DTO.UserDto;
import Auth_1.auth.Service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private AuthService _authService;

    @PostMapping("/register")
    public void Register(@RequestBody UserDto user) {
        _authService.registerUser(user);
    }

}
