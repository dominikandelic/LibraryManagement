package hr.dandelic.librarymanagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping(path = "/login")
    public String loginForm(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }


    /*@PostMapping(path = "/login")
    public @ResponseBody String loginUser(@ModelAttribute User user, Model model) {
        try {
        } catch (Exception e) {
            model.addAttribute("result", 'F');
        }
        return "Logged in";
    }*/

    @GetMapping(path = "/register")
    public String registerForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping(path = "/register")
    public @ResponseBody
    String registerUser(@ModelAttribute User user, Model model) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        try {
            userRepository.save(user);
        } catch (Exception e) {
            model.addAttribute("result", 'F');
        }
        return "True";
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

}
