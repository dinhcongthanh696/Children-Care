package childrencare.app.controller;


import childrencare.app.model.RoleModel;
import childrencare.app.model.UserModel;
import childrencare.app.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/signIn", method = { RequestMethod.GET, RequestMethod.POST })
    public String signIn(Model model, HttpSession session,
                         @RequestParam(name = "username")String username,
                         @RequestParam(name = "email")String email,
                         @RequestParam(name = "password")String password,
                         @RequestParam(name = "currentPage", required = false , defaultValue = "/") String currentPage){
        UserModel userExist = loginService.checkUserExist(username,email,password);
        if(userExist != null){
            model.addAttribute("user",userExist);
            session.setAttribute("user",userExist);
            return "redirect:"+currentPage;
        }else{
            model.addAttribute("mess","Wrong information");
            return "redirect:"+currentPage;
        }

    }

    @RequestMapping(value = "/signUp", method = { RequestMethod.GET, RequestMethod.POST })
    public String signUp(Model model,
                         @RequestParam(name = "username")String username,
                         @RequestParam(name = "fullname")String fullname,
                         @RequestParam(name = "address")String address,
                         @RequestParam(name = "email")String email,
                         @RequestParam(name = "gender") boolean gender,
                         @RequestParam(name = "notes")String notes,
                         @RequestParam(name = "password")String pass,
                         @RequestParam(name = "phone")String phone){
        UserModel userExist1 = loginService.checkUserExist(username,email,"");
        if(userExist1 != null){
            model.addAttribute("messError","Information exist. Please change!");
        }
        UserModel userModel = new UserModel();
        userModel.setUsername(username);
        userModel.setFullname(fullname);
        userModel.setAddress(address);
        userModel.setEmail(email);
        userModel.setGender(gender);
        userModel.setNotes(notes);
        userModel.setPassword(pass);
        userModel.setPhone(phone);
        userModel.setStatus(true);
        RoleModel roleModel = new RoleModel();
        roleModel.setRoleId(4);
        userModel.setUserRole(roleModel);
        loginService.save(userModel);
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "redirect:/";
    }

}
