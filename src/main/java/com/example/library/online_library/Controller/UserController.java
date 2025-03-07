package com.example.library.online_library.Controller;


import com.example.library.online_library.Model.User;
import com.example.library.online_library.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

@RequestMapping("api/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public String getAllUser(Model model){
        model.addAttribute("users", userService.getAllUser());
        return "index";
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute User user){
        userService.save(user);
        return "redirect:/api/user/all";
    }
}
