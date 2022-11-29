package com.miniproject.foodapp.controller;

import com.miniproject.foodapp.entity.Admin;
import com.miniproject.foodapp.entity.Dish;
import com.miniproject.foodapp.entity.Menu;
import com.miniproject.foodapp.entity.Restaurant;
import com.miniproject.foodapp.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController
{
    @Autowired
    AdminService adminService;

    @PostMapping("/signup")
    public ResponseEntity<String> adminRegistration(@RequestBody Admin admin)
    {
        Boolean status = adminService.adminRegistration(admin);
        if(status == true)
            return new ResponseEntity("Registered successfully", HttpStatus.CREATED) ;
        return new ResponseEntity<>("You already have the account",HttpStatus.ALREADY_REPORTED);
    }



    @PostMapping("/signIn/{email}/{password}")
    public ResponseEntity<Integer> adminLogin(@PathVariable String email, @PathVariable String password)
    {
        return new ResponseEntity(adminService.adminLogin(email,password),HttpStatus.ACCEPTED);
    }

    @PostMapping("/restaurants/{sId}")
    public ResponseEntity<String> addRestaurant(@ModelAttribute Restaurant restaurant, @PathVariable int sId)
    {
        String check = adminService.addRestaurant(restaurant,sId);
        if(check.equalsIgnoreCase("Restaurant added successfully"))
        {
            return new ResponseEntity<>(check,HttpStatus.ACCEPTED);
        }
        else if(check.equalsIgnoreCase("Incorrect sessionId")){
            return new ResponseEntity<>(check,  HttpStatus.BAD_REQUEST);
        }
        else{
            return new ResponseEntity<>("unable to add / Already added", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/dishes/{sId}")
    public ResponseEntity<String> addDish(@ModelAttribute Dish dish, @PathVariable int sId)
    {
        String check = adminService.addDish(dish,sId);
        if(check.equalsIgnoreCase("dish added successfully"))
        {
            return new ResponseEntity<>(check,HttpStatus.ACCEPTED);
        }
        else if(check.equalsIgnoreCase("Unable to register / Incorrect Information")){
            return new ResponseEntity<>(check,  HttpStatus.BAD_REQUEST);
        }
        else{
            return new ResponseEntity<>("Incorrect Session Id", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/menus/{sId}")
    public ResponseEntity<String> addToMenu(@RequestBody Menu menu, @PathVariable int sId)
    {
        String check = adminService.addToMenu(menu,sId);
        if(check.equalsIgnoreCase("menu added"))
        {
            return new ResponseEntity<>(check,HttpStatus.ACCEPTED);
        }
        else if(check.equalsIgnoreCase("unable to add menu")){
            return new ResponseEntity<>(check,  HttpStatus.BAD_REQUEST);
        }
        else {
            return new ResponseEntity<>("Incorrect sessionId",  HttpStatus.FORBIDDEN);
        }
    }
}
