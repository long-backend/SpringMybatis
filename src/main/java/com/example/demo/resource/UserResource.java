package com.example.demo.resource;


import com.example.demo.mapper.UserWithAddressMapper;
import com.example.demo.mapper.UsersMapper;
import com.example.demo.model.UserWithAddress;
import com.example.demo.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
@RequestMapping("/rest/users")
public class UserResource {


    private UsersMapper usersMapper;

    public UserResource(UsersMapper usersMapper) {
        this.usersMapper = usersMapper;
    }
    @Autowired
    private UserWithAddressMapper userWithAddressMapper;


    @GetMapping("/all")
    public List<Users> getAll() {
        return usersMapper.findAll();
    }
    @GetMapping("/list")
    public String getList() {
        return "list";
    }

    @GetMapping("/insert")
    private List<Users> insert() {

        Users users = new Users();
        users.setName("Youtube");
        users.setSalary(2333L);
        users.setAddressid(2);
        usersMapper.insert(users);

        return usersMapper.findAll();
    }

    @PostMapping("/delete")
    public ModelAndView delete(@RequestParam("id") int id) {
         usersMapper.deleteAll(id);
        return new ModelAndView(new RedirectView("/rest/users/paging"));
    }

    @GetMapping("/union")
    public ModelAndView getUnion() {
        ModelAndView model= new ModelAndView();

        List<UserWithAddress> listUsers= userWithAddressMapper.findAll();

        return new ModelAndView("list","users",listUsers) ;
    }

    @GetMapping("/update")
    public ModelAndView update(@RequestParam int id ) {
        Users user = usersMapper.getUser(id);
        return new ModelAndView("update","user",user);
    }

    @PostMapping("/updateFinish")
    public ModelAndView update(Users users) {
        usersMapper.updateUser(users);
        //return ForwardController.forward("/rest/users/paging");
        return new ModelAndView(new RedirectView("/rest/users/paging"));
    }

    @GetMapping("/paging")
    public ModelAndView getAllPaging(@RequestParam(defaultValue = "1") int page ) {
        int pageSize = 2; // Số lượng bản ghi trên mỗi trang
        int totalPages = (int) Math.ceil((double) userWithAddressMapper.count() / pageSize);
        int offset = (page - 1) * pageSize; // Tính toán offset cho trang
        List<UserWithAddress> listUsers=userWithAddressMapper.findAllPaging(2,offset);
        ModelAndView model= new ModelAndView();
        model.addObject("users",listUsers);
        model.addObject("currentPage",page);
        model.addObject("totalPages",totalPages);
        model.setViewName("list");
        return model;
    }

    @GetMapping("/register")
    public ModelAndView register() {

        return new ModelAndView("regiter");
    }

    @PostMapping("/register")
    public ModelAndView registerComfirm(Users user) {
        usersMapper.insert(user);
        return new ModelAndView(new RedirectView("/rest/users/paging"));
    }




}
