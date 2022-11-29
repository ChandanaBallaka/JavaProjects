package com.miniproject.foodapp.controller;

import com.miniproject.foodapp.entity.*;
import com.miniproject.foodapp.request.*;
import com.miniproject.foodapp.service.RestaurantService;
import com.miniproject.foodapp.service.SmsService;
import com.miniproject.foodapp.utility.JWTUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/foodApp")
public class RestaurantController
{
    @Autowired
    RestaurantService restaurantService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JWTUtility jwtUtility;
    @Autowired
    SmsService smsService;

    @PostMapping("/newUser")
    public ResponseEntity<String> verifyNumber(@RequestBody NewUser newUser)
    {
        Boolean status = restaurantService.verifyNumber(newUser);
        if(status == true)
            return new ResponseEntity("Done", HttpStatus.CREATED) ;
        return new ResponseEntity<>("Error",HttpStatus.ALREADY_REPORTED);
    }

    @PutMapping("/send2faCodeInSMS/{mobileNumber}")
    public ResponseEntity<Object> send2faCodeInSMS(@RequestBody String phoneNumber, @PathVariable String mobileNumber)
    {
        String tfaCode =String.valueOf(new Random().nextInt(9999)+1000);
        smsService.sendSms(phoneNumber,tfaCode);
        restaurantService.update2FAProperties(mobileNumber,tfaCode);
        return new ResponseEntity<>(HttpStatus.OK);
    }



    @PutMapping("/forgetPasswordCode/{mobileNumber}")
    public ResponseEntity<Object> forgetPassword(@RequestBody String phoneNumber, @PathVariable String mobileNumber) {
        String tfaCode = String.valueOf(new Random().nextInt(9999) + 1000);
        smsService.sendSms(phoneNumber, tfaCode);
        restaurantService.forgetPassword(mobileNumber, tfaCode);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/resetPassword")
    public ResponseEntity<Object> verify(@RequestParam String mobileNumber, @RequestParam String code,@RequestParam String password) {
        boolean isValid = restaurantService.resetPassword(mobileNumber, code,password);
        if (isValid) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);

    }

    @PostMapping("/register")
    public ResponseEntity<String> userRegistration(@RequestBody User user)
    {
        String check = restaurantService.userRegistration(user);
        if(check.equalsIgnoreCase("Registration completed"))
        {
            return new ResponseEntity<>(check,HttpStatus.ACCEPTED);
        }
        else  if(check.equalsIgnoreCase("You already have the account/Incorrect information"))
        {
            return new ResponseEntity<>(check,HttpStatus.FORBIDDEN);
        }
        else {
            return new ResponseEntity<>("Mobile number not verified",  HttpStatus.BAD_REQUEST);

        }
    }

    @PostMapping("/ratings")
    public ResponseEntity<String> giveRatings(@RequestBody Rating ratings)
    {
        String check = restaurantService.giveRatings(ratings);
        if(check.equalsIgnoreCase("Thank you for rating"))
        {
            return new ResponseEntity<>(check,HttpStatus.ACCEPTED);
        }
        else  if(check.equalsIgnoreCase("you have already rated"))
        {
            return new ResponseEntity<>(check,HttpStatus.FORBIDDEN);
        }
        else {
            return new ResponseEntity<>("Invalid Rating",  HttpStatus.BAD_REQUEST);

        }
    }

    @PostMapping("/favourites")
    public ResponseEntity<String> addToFavourites(@RequestBody Favourite favourites)
    {
        String check = restaurantService.addToFavourites(favourites);
        if(check.equalsIgnoreCase("added to favourites"))
        {
            return new ResponseEntity<>(check,HttpStatus.ACCEPTED);
        }
        else {
            return new ResponseEntity<>("Deleted from favourites",  HttpStatus.OK);
        }
    }

    @PutMapping("/verifyOtp")
    public ResponseEntity<Object> checkCode(@RequestParam String mobileNumber, @RequestParam String code)
    {
        boolean isValid = restaurantService.checkCode(mobileNumber, code);
        if (isValid) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @PostMapping("/cards")
    public ResponseEntity<String> addCardInformation(@RequestBody Card card)
    {
        String check = restaurantService.addCardInformation(card);
        if(check.equalsIgnoreCase("added successfully"))
        {
            return new ResponseEntity<>(check,HttpStatus.ACCEPTED);
        }
        else {
            return new ResponseEntity<>("error",  HttpStatus.FORBIDDEN);
        }
    }

    @GetMapping("/restaurants/{restaurantName}")
    public ResponseEntity<List<Restaurant>> viewRestaurants(@PathVariable String restaurantName)
    {
        if(restaurantService.viewRestaurants(restaurantName)!=null)
        {
            return  new ResponseEntity<>(restaurantService.viewRestaurants(restaurantName), HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @GetMapping("/dishes/{dishName}")
    public ResponseEntity<List<Dish>> viewDishesByName(@PathVariable String dishName)
    {
        if(restaurantService.viewRestaurants(dishName)!=null)
        {
            return  new ResponseEntity<>(restaurantService.viewDishesByName(dishName), HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @GetMapping("/dishes")
    public ResponseEntity<List<Dish>> viewAllDishes()
    {
        if(restaurantService.viewAllDishes()!=null)
        {
            return  new ResponseEntity<>(restaurantService.viewAllDishes(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @GetMapping("/restaurants")
    public ResponseEntity<List<Restaurant>> RestaurantsByMinimumCost()
    {
        if(restaurantService.RestaurantsByMinimumCost() != null)
        {
            return new ResponseEntity<>(restaurantService.RestaurantsByMinimumCost(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/highCostRestaurants")
    public ResponseEntity<List<Restaurant>> RestaurantsByMaximumCost()
    {
        if(restaurantService.RestaurantsByMaximumCost() != null)
        {
            return new ResponseEntity<>(restaurantService.RestaurantsByMaximumCost(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/topRestaurants")
    public ResponseEntity<List<Restaurant>> RestaurantsByRating()
    {
        if(restaurantService.RestaurantsByRating() != null)
        {
            return new ResponseEntity<>(restaurantService.RestaurantsByRating(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/home")
    public ResponseEntity<List<Home>> homePage()
    {
        if(restaurantService.homePage() != null)
        {
            return new ResponseEntity<>(restaurantService.homePage(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }


    @GetMapping("/url/{restaurantName}")
    public ResponseEntity<String> getImageUrl(@PathVariable String restaurantName)
    {
        return new ResponseEntity<>(restaurantService.getImageUrl(restaurantName), HttpStatus.OK);
    }

    @GetMapping("/image/{restaurantName}")
    public ResponseEntity<Resource> getRestaurantImage(@PathVariable String restaurantName) throws IOException
    {
        return ResponseEntity.ok().contentType(MediaType.parseMediaType("image/png")).header("Content-Disposition","filename=\"" + restaurantName + ".png" +"\"").body(new ByteArrayResource(restaurantService.getRestaurantImage(restaurantName)));
    }

    @GetMapping("/dishurl/{dishName}")
    public ResponseEntity<String> getDishImageUrl(@PathVariable String dishName)
    {
        return new ResponseEntity<>(restaurantService.getDishImageUrl(dishName), HttpStatus.OK);
    }


    @GetMapping("/photo/{dishName}")
    public ResponseEntity<Resource> getDishImage(@PathVariable String dishName) throws IOException
    {
        return ResponseEntity.ok().contentType(MediaType.parseMediaType("image/png")).header("Content-Disposition","filename=\"" + dishName + ".png" +"\"").body(new ByteArrayResource(restaurantService.getDishImage(dishName)));
    }

    @GetMapping("/cuisines/{cuisines}")
    public ResponseEntity<RestaurantRequest> restaurantsByCuisine(@PathVariable String cuisines)
    {
        return new ResponseEntity<>(restaurantService.restaurantsByCuisine(cuisines),HttpStatus.OK);
    }

    @PostMapping("/authenticate")
    public JWTResponse authenticate(@RequestBody JWTRequest jwtRequest) throws Exception
    {
        try
        {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            jwtRequest.getEmail(),
                            jwtRequest.getPassword()
                    )
            );
        }
        catch (BadCredentialsException e)
        {
            throw new Exception("INVALID_CREDENTIALS", e);
        }

        final UserDetails userDetails = restaurantService.loadUserByUsername(jwtRequest.getEmail());

        final String token = jwtUtility.generateToken(userDetails);

        return  new JWTResponse(token);
    }

    @GetMapping("/getMenu")
    public ResponseEntity<?> getMenuPanel(@RequestParam Integer restaurantId)
    {
        return new ResponseEntity<>(restaurantService.getRestaurantDetails(restaurantId),HttpStatus.OK);
    }

//    @PostMapping("/carts")
//    public ResponseEntity<String> addToCart(@RequestBody CartInformation cartInformation)
//    {
//        String check = restaurantService.addToCart(cartInformation);
//        if(check.equalsIgnoreCase("Added to cart"))
//        {
//            return new ResponseEntity<>(check,HttpStatus.ACCEPTED);
//        }
//        else {
//            return new ResponseEntity<>("error",  HttpStatus.FORBIDDEN);
//        }
//    }

    @GetMapping("/topdishes")
    public ResponseEntity<List<DishResponse>> viewTopDishes()
    {
        if(restaurantService.viewTopDishes() != null)
        {
            return new ResponseEntity<>(restaurantService.viewTopDishes(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/RestaurantNearMe")
    ResponseEntity<?> nearMeRestaurant(@RequestParam double latitude, @RequestParam double longitude)  {

        return ResponseEntity.ok(restaurantService.viewRestaurantNearMe(latitude, longitude));
    }

    @PostMapping("/address")
    public ResponseEntity<String> addAddress(@RequestBody Address address)
    {
        String check = restaurantService.addAddress(address);
        if(check.equalsIgnoreCase("Address added"))
        {
            return new ResponseEntity<>(check,HttpStatus.ACCEPTED);
        }
        else {
            return new ResponseEntity<>("error / Incorrect token",  HttpStatus.FORBIDDEN);
        }
    }

    @GetMapping("/address")
    public ResponseEntity<List<Address>> getAddress()
    {
        if(restaurantService.getAddress() != null)
        {
            return new ResponseEntity<>(restaurantService.getAddress(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/restaurants/delivery")
    public ResponseEntity<List<Restaurant>> restaurantBasedOnDelivery()
    {
        if(restaurantService.restaurantBasedOnDelivery() != null)
        {
            return new ResponseEntity<>(restaurantService.restaurantBasedOnDelivery(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/favorites")
    public ResponseEntity<List<Favourite>> viewFavourites()
    {
        if(restaurantService.viewFavourites() != null)
        {
            return new ResponseEntity<>(restaurantService.viewFavourites(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/items")
    public ResponseEntity<List<Item>> viewItems()
    {
        if (restaurantService.viewItems()!=null) {
            return new ResponseEntity<>(restaurantService.viewItems(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
    @PostMapping("/orders")
    public ResponseEntity<?> placeOrder(@RequestBody Order orders)
    {
        return new ResponseEntity<>(restaurantService.placeOrder(orders), HttpStatus.OK);
    }

    @GetMapping("/openNow")
    public List<Restaurant> currentlyOpenedRestaurant()
    {
        return restaurantService.currentlyOpenedRestaurant();
    }

    @PostMapping("/addToOrder")
    public ResponseEntity<?> addToOrder(@RequestBody CartItems cartItems) {
        return new ResponseEntity<>(restaurantService.addToOrder(cartItems), HttpStatus.CREATED);
    }

    @GetMapping("/filters")
    public ResponseEntity<FilterResponse> searchWithFilter(@RequestBody Filters filter)
    {
        return new ResponseEntity<>(restaurantService.searchWithFilter(filter), HttpStatus.OK);
    }
}
