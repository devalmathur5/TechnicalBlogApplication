package technicalblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import technicalblog.model.Post;
import technicalblog.model.User;
import technicalblog.model.UserProfile;
import technicalblog.service.PostService;
import technicalblog.service.UserService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private PostService postService;

    @RequestMapping("users/login")
    public String login(){
        return "users/login";
    }

    @RequestMapping("users/registration")
    public String registration(Model model){
        User user = new User();
        UserProfile profile = new UserProfile();
        // can we instantiate the above created instances with @Autowired annotation?
        /*
        All the attributes in the User object are currently null. When a user fills the form
        and submits details, all the details are mapped to the corresponding attributes in
        the User and UserProfile objects that we instantiated.
         */
        user.setProfile(profile);
        model.addAttribute("User", user);
        return "users/registration";
    }

    @RequestMapping(value="users/registration", method=RequestMethod.POST)
    public String userRegistration(User user){
        userService.registerUser(user);
        return "redirect:/users/login";
    }

    @RequestMapping(value="users/login", method=RequestMethod.POST)
    public String login(User user, HttpSession session){
        User existingUser = userService.login(user);
        if(existingUser != null) {
            session.setAttribute("loggeduser", existingUser);
            /*
            setAttribute takes in a key and a value and will store the value under the key.
            So, the value can be retrieved from the Http session object via the key in the
            future (similar to how a hashtable works).
             */
            return "redirect:/posts";   
        }
        else {
            return "users/login";
        }
    }

    @RequestMapping(value="users/logout", method=RequestMethod.POST)
    public String logoutUser(Model model, HttpSession session) {
        session.invalidate();
        //PostService postService = new PostService();
        // the above statement will give NPE because the bean wouldn't be instantiated.
        List<Post> posts = postService.getAllPosts();
        model.addAttribute("posts", posts);
        return "index";
    }
}
