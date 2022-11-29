package com.miniproject.foodapp.service;


import com.miniproject.foodapp.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Random;

@Service
public class AdminService
{
    @Autowired
    JdbcTemplate jdbcTemplate;

    int sessionId;

    public Boolean adminRegistration(Admin admin)               //admin registration
    {
        try {
            String admin_signup = "insert into admin(adminName,email,password) values(?,?,?)";
            jdbcTemplate.update(admin_signup, admin.getAdminName() ,admin.getEmail(), admin.getPassword());
            return true;
        }
        catch (Exception e)
        {
            System.out.println(e);
            return false;
        }
    }

    public int adminLogin(String email, String password)
    {
        try
        {
            String admin_login = "select * from admin where email = '" + email + "' and password ='" + password + "'";
            jdbcTemplate.query(admin_login, new BeanPropertyRowMapper<>(String.class));
            sessionId = new Random().nextInt(1,100);
            return sessionId;
        }
        catch(Exception e)
        {
            System.out.println("User does not exist");
            return -1;
        }
    }


    public String addRestaurant(Restaurant restaurant, int sId)
    {
        if(sId == sessionId)
        {

            String fileName = StringUtils.cleanPath(restaurant.getPhoto().getOriginalFilename());
            String downloadURL;
            try
            {
                if (fileName.contains(".."))
                {
                    throw new Exception("No such file" + fileName);
                }
                downloadURL = ServletUriComponentsBuilder.fromCurrentContextPath()
                        .path("/foodApp/image/")
                        .path(restaurant.getRestaurantName())
                        .toUriString();
                String finalDownloadURL = downloadURL;
                String add_dish = "insert into restaurant(restaurantId,restaurantName,freeDelivery,minimumCost,latitude,longitude,address,openTime,closeTime,photo,photoUrl) values(?,?,?,?,?,?,?,?,?,?,?)";
                jdbcTemplate.update(add_dish,restaurant.getRestaurantId(),restaurant.getRestaurantName(),restaurant.isFreeDelivery(),restaurant.getMinimumCost(),restaurant.getLatitude(),restaurant.getLongitude(),restaurant.getAddress(),restaurant.getOpenTime(),restaurant.getCloseTime(),restaurant.getPhoto().getBytes(),finalDownloadURL);
                return "Restaurant added successfully";
            }
            catch (Exception e)
            {
                System.out.println("could not save file" + fileName);
                e.printStackTrace();
                return "Unable to register / Incorrect Information";
            }
        }
        return "Incorrect sessionId";
    }

    public String addDish(Dish dish, int sId)
    {
        if(sId == sessionId)
        {
            String fileName = StringUtils.cleanPath(dish.getPhoto().getOriginalFilename());
            String downloadURL;
            try
            {
                if (fileName.contains(".."))
                {
                    throw new Exception("No such file" + fileName);
                }
                downloadURL = ServletUriComponentsBuilder.fromCurrentContextPath()
                        .path("/foodApp/image/")
                        .path(dish.getDishName())
                        .toUriString();
                String finalDownloadURL = downloadURL;
                String add_dish = "insert into dish(dishName,photo,photoUrl,cuisines,category) values(?,?,?,?,?)";
                jdbcTemplate.update(add_dish,dish.getDishName(),dish.getPhoto().getBytes(),finalDownloadURL,dish.getCuisines(),dish.getCategory());
                return "dish added successfully";
            }
            catch (Exception e)
            {
                System.out.println("could not save file" + fileName);
                e.printStackTrace();
                return "Unable to register / Incorrect Information";
            }
        }
        return "Incorrect session Id";
    }

    public String addToMenu(Menu menu, int sId)
    {
        if(sId == sessionId)
        {
            try {
                String add_menu = "insert into menu(restaurantId,dishId,price) values(?,?,?)";
                jdbcTemplate.update(add_menu, menu.getRestaurantId(), menu.getDishId(), menu.getPrice());
                return "menu added";
            } catch (Exception e) {
                System.out.println(e);
                return "unable to add menu";
            }
        }
        return "Incorrect sessionId";
    }

}
