package boreholesystem.boreholesystem.controller;

import boreholesystem.boreholesystem.model.Owner;
import boreholesystem.boreholesystem.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;
@Controller
public class OwnerController {
    @Autowired
    private OwnerService OwnerServices;

    //ADDING Owner INTO DATABASE
    @PostMapping("/saveOwner")
    public String saveOwner(Owner Owner){
        OwnerServices.addData(Owner);
        return "redirect:/";
    }


    @GetMapping("/registerForm")
    public ModelAndView registerForm(){
        ModelAndView me=new ModelAndView("registerForm");
        Owner Owner=new Owner();
        me.addObject("register",Owner);
        return me;
    }

    //    DISPLAY OWNER INTO TABLE
    @GetMapping("/")
    public String getAll(Model model){
        model.addAttribute("OwnerList",OwnerServices.getAll());
        return "dashboad";
    }



    //    DISPLAY BY ID"
    @RequestMapping("/getById")
    @ResponseBody
    public Optional<Owner> getById(int OwnerID){
        return OwnerServices.getOwnerById(OwnerID);
    }

    @GetMapping("/delete")
    public String delete(int OwnerID){
        OwnerServices.deleteMe(OwnerID);
        return ("redirect:/");
    }

}

