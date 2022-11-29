package com.miniproject.foodapp.service;

import com.miniproject.foodapp.entity.*;

import com.miniproject.foodapp.request.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


@Service
public class RestaurantService implements UserDetailsService
{
    @Autowired
    JdbcTemplate jdbcTemplate;

    int pages = 2;
    int lowerLimit = 0;
    int upperLimit = pages;

    public Boolean verifyNumber(NewUser newUser)
    {
        try
        {
            String verify_number = "insert into newuser(mobileNumber) values(?)";
            jdbcTemplate.update(verify_number, newUser.getMobileNumber());
            return true;
        }catch (Exception e)
        {
            System.out.println(e);
            return false;
        }
    }

    public void update2FAProperties(String mobileNumber, String tfacode)
    {
        jdbcTemplate.update("update newuser set twoFCode=?, expiryTime=? where mobileNumber=?", new Object[]
                {
                        tfacode,(System.currentTimeMillis()/1000)+60,mobileNumber
                });
    }


    public List<Restaurant> viewRestaurants(String restaurantName)
    {
        try {
            String get_restaurants = "select restaurantId,restaurantName,rating,freeDelivery,minimumCost,address,openTime,closeTime from restaurant where restaurantName ='" + restaurantName + "'";
            return jdbcTemplate.query(get_restaurants, new BeanPropertyRowMapper<>(Restaurant.class));
        }catch (Exception e)
        {
            System.out.println(e);
            return null;
        }
    }

    public List<Dish> viewDishesByName(String dishName)
    {
        try {
            String get_restaurants = "select dishName,cuisines from dish where dishName ='" + dishName + "'";
            return jdbcTemplate.query(get_restaurants, new BeanPropertyRowMapper<>(Dish.class));
        }catch (Exception e)
        {
            System.out.println(e);
            return null;
        }
    }

    public List<Dish> viewAllDishes()
    {
        try {
            String get_restaurants = "select dishId,dishName,cuisines from dish";
            return jdbcTemplate.query(get_restaurants, new BeanPropertyRowMapper<>(Dish.class));
        }catch (Exception e)
        {
            System.out.println(e);
            return null;
        }
    }

    public byte[] getRestaurantImage(String restaurantName)
    {
        String get_image = "select photo from restaurant where restaurantName='" + restaurantName + "'";
        return jdbcTemplate.queryForObject(get_image,byte[].class);
    }

    public String getImageUrl(String restaurantName)
    {
            try {
                String url = "select photoUrl from  restaurant where restaurantName='" + restaurantName + "'";
                return jdbcTemplate.queryForObject(url, String.class);
            }
            catch (Exception e)
            {
                return "Restaurant does not exist";
            }
    }

    public byte[] getDishImage(String dishName)
    {
        String get_image = "select photo from dish where dishName='" + dishName + "'";
        return jdbcTemplate.queryForObject(get_image,byte[].class);
    }

    public String getDishImageUrl(String dishName)
    {
        try {
            String url = "select photoUrl from  dish where dishName='" + dishName + "'";
            return jdbcTemplate.queryForObject(url, String.class);
        }
        catch (Exception e)
        {
            return "Dish does not exist";
        }
    }

    public String userRegistration(User user)
    {
        try
        {
            Boolean veified = jdbcTemplate.queryForObject("select veified from newuser where mobileNumber ='" + user.getMobileNumber() + "'", Boolean.class);
           if(veified)
           {
               String user_register = "insert into user(userName,email,mobileNumber,password,latitude,longitude,address) values(?,?,?,?,?,?,?)";
               jdbcTemplate.update(user_register, user.getUserName(), user.getEmail(), user.getMobileNumber(), user.getPassword(), user.getLatitude(), user.getLongitude(), user.getAddress());
               return "Registration completed";
           }
        }
        catch(Exception e)
        {
            System.out.println(e);
            return "You already have the account/Incorrect information";
        }

        return "mobile number is not verified";
    }

    public boolean checkCode(String mobileNumber,String code)
    {
        try {
            boolean user_info = jdbcTemplate.queryForObject("select count(*) from newuser where twoFCode=? and mobileNumber=? and expiryTime>=?", new Object[]{code, mobileNumber, System.currentTimeMillis() / 1000}, Integer.class) > 0;
            String verify = "update newuser set veified = true where mobileNumber = '" + mobileNumber + "'";
            jdbcTemplate.update(verify);
            return user_info;
        }catch(Exception e)
        {
            System.out.println(e);
            return false;
        }
    }


    public void forgetPassword(String mobileNumber, String tfacode)
    {
        jdbcTemplate.update("update user set 2FAcode=?, 2FAexpiryTime=? where mobileNumber=?", new Object[]
                {
                        tfacode, (System.currentTimeMillis() / 1000) + 60, mobileNumber
                });
    }

    public boolean resetPassword(String mobileNumber, String code,String password)
    {
        try {
            boolean query = jdbcTemplate.queryForObject("select count(*) from user where 2FAcode=? and mobileNumber=? and 2FAexpiryTime>=?", new Object[]{code, mobileNumber, System.currentTimeMillis() / 1000}, Integer.class) > 0;
            String reset_pass = "update user set password ='" + password + "' where mobileNumber ='" + mobileNumber + "'";
            jdbcTemplate.update(reset_pass);
            System.out.println("updated password");
            return query;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException
    {
        String emailId = jdbcTemplate.queryForObject("select email from user where email=?", String.class, new Object[]{email});
        String password = jdbcTemplate.queryForObject("select password from user where email=?", String.class, new Object[]{email});
        return new org.springframework.security.core.userdetails.User(emailId, password, new ArrayList<>());
    }


    public String giveRatings(Rating ratings)
    {
        int id = getUserIdFromEmail();
        if(ratings.getRating() <= 5 && ratings.getRating() > 0) {
            try {
                jdbcTemplate.update("insert into rating(restaurantId,userId,rating) values(?,?,?)", ratings.getRestaurantId(), id, ratings.getRating());
                String avg_rating = "update restaurant res set res.rating=res.rating+1 , res.avgRating=(select avg(r.rating) from rating r where r.restaurantId=?) where res.restaurantId=" + ratings.getRestaurantId();
                jdbcTemplate.update(avg_rating,ratings.getRestaurantId());
                return "Thank you for rating";
            } catch (Exception e) {
                System.out.println(e);
                return "you have already rated";
            }
        }
        return "Invalid Rating";
    }


    public String addToFavourites(Favourite favourites)
    {
        int id = getUserIdFromEmail();
        try
        {
            jdbcTemplate.update("insert into favourite(restaurantId,userId) values(?,?)", favourites.getRestaurantId(), id);
            String update_res = "update restaurant set favourites=favourites+1  where restaurantId=" + favourites.getRestaurantId();
            jdbcTemplate.update(update_res);
            return "added to favourites";
        }catch (Exception e)
        {
            jdbcTemplate.update("delete from favourite where restaurantId = ? and userId= ?", favourites.getRestaurantId(), id);
            String unfavourite = "update restaurant set favourites=favourites-1  where restaurantId=" + favourites.getRestaurantId();
            jdbcTemplate.update(unfavourite);
            return "Deleted from favourites";
        }
    }

   public List<Restaurant> RestaurantsByMinimumCost()
   {
       try {
           String restaurant_details = "select restaurantName,avgRating,favourites,address,openTime,closeTime,photoUrl,minimumCost from restaurant order by minimumCost asc";
           return jdbcTemplate.query(restaurant_details, new BeanPropertyRowMapper<>(Restaurant.class));
       }catch (Exception e)
       {
           System.out.println(e);
           return null;
       }
   }

    public List<Restaurant> RestaurantsByMaximumCost()
    {
        try {
            String restaurant_details = "select restaurantName,avgRating,favourites,address,openTime,closeTime,photoUrl,minimumCost from restaurant order by minimumCost desc";
            return jdbcTemplate.query(restaurant_details, new BeanPropertyRowMapper<>(Restaurant.class));
        }catch (Exception e)
        {
            System.out.println(e);
            return null;
        }
    }

    public List<Restaurant> RestaurantsByRating()
    {
        try {
            String restaurant_details = "select restaurantName,avgRating,favourites,address,openTime,closeTime,photoUrl,minimumCost from restaurant order by avgRating desc";
            return jdbcTemplate.query(restaurant_details, new BeanPropertyRowMapper<>(Restaurant.class));
        }catch (Exception e)
        {
            System.out.println(e);
            return null;
        }
    }

    public List<Restaurant> currentlyOpenedRestaurant()
    {
        try {
            LocalTime date = LocalTime.now();
            System.out.println(date);
            String restaurant_details = "select restaurantName,avgRating,favourites,address,openTime,closeTime,photoUrl,minimumCost from restaurant where openTime ='" + date + "'";
            return jdbcTemplate.query(restaurant_details, new BeanPropertyRowMapper<>(Restaurant.class));
        }catch (Exception exception)
        {
            exception.printStackTrace();
            return null;
        }

    }

    private double calculateDistance(double userLat, double userLon, double resLat, double resLon) {

        double lon1 = Math.toRadians(userLon);
        double lon2 = Math.toRadians(resLon);
        double lat1 = Math.toRadians(userLat);
        double lat2 = Math.toRadians(resLat);

        // Haversine formula
        double dlon = lon2 - lon1;
        double dlat = lat2 - lat1;
        double a = Math.pow(Math.sin(dlat / 2), 2)
                + Math.cos(lat1) * Math.cos(lat2)
                * Math.pow(Math.sin(dlon / 2), 2);

        double c = 2 * Math.asin(Math.sqrt(a));

        // Radius of earth in kilometers. Use 3956
        // for miles
        double r = 6371;

        // calculate the result
        return (c * r);
    }

    public List<Restaurant> viewRestaurantNearMe(double userLat, double userLon)
    {
        List<Restaurant> restaurants = jdbcTemplate.query("select restaurantName,rating,avgRating,favourites,freeDelivery,minimumCost,address,openTime,closeTime,photoUrl from restaurant", new BeanPropertyRowMapper<>(Restaurant.class));
        List<Restaurant> restaurantList = new ArrayList<>();
        for (Restaurant r : restaurants) {
            double distance = calculateDistance(userLat, userLon, r.getLatitude(), r.getLongitude());
            System.out.println(distance);
            if (distance <= 30.00) {
                restaurantList.add(r);
            }
        }

        return restaurantList;
    }

    public RestaurantRequest restaurantsByCuisine(String cuisines)
    {
        try
        {
            RestaurantRequest restaurant_request = jdbcTemplate.queryForObject("select distinct cuisines from dish  where cuisines = '" + cuisines + "'", new BeanPropertyRowMapper<>(RestaurantRequest.class));
            List<Integer> dishIds = jdbcTemplate.queryForList("SELECT dishId FROM dish WHERE cuisines = ?", Integer.class,cuisines);
            List<RestaurantResponse> responses = new ArrayList<>();
            for(Integer dishId:dishIds)
            {
                List<Integer> restaurantIds = jdbcTemplate.queryForList("select restaurantId from menu where dishId = ?", Integer.class,dishId);
                for(Integer restaurantId:restaurantIds)
                {
                    List<RestaurantResponse> restaurant_response = jdbcTemplate.query("select restaurantId,restaurantName,avgRating,rating,freeDelivery,address,photoUrl from restaurant where restaurantId = " + restaurantId , new BeanPropertyRowMapper<>(RestaurantResponse.class));
//                    restaurant_request.setRestaurantResponseList(restaurant_response);
                    responses.addAll(restaurant_response);
                }
            }
            restaurant_request.setRestaurantResponseList(responses);
            return restaurant_request;
        }
        catch (Exception e)
        {
            System.out.println(e);
            return null;
        }
    }


    public MenuResponsePanel getRestaurantDetails(Integer restaurantId)
    {
        MenuResponsePanel menuResponsePanel = jdbcTemplate.queryForObject("select restaurantId,restaurantName,avgRating,rating,freeDelivery,address,photoUrl from restaurant where restaurantId = " + restaurantId , new BeanPropertyRowMapper<>(MenuResponsePanel.class));
        List<MenuPanel> menuPanels = new ArrayList<>();
        List<String> categories = jdbcTemplate.queryForList("SELECT distinct category FROM dish inner join menu on menu.dishId=dish.dishId where restaurantId = ?", String.class,restaurantId);

        for(String category:categories)
        {
            MenuPanel menuPanel = jdbcTemplate.queryForObject("select count(dish.dishId) as noOfItems from dish inner join menu on menu.dishId=dish.dishId where  restaurantId = ? and category = ?",new BeanPropertyRowMapper<>(MenuPanel.class),restaurantId,category);
            menuPanel.setCategory(category);
            List<ItemResponse> dishes = jdbcTemplate.query("select dishName,price from dish inner join menu on menu.dishId = dish.dishId and category = ? and restaurantId =?",new BeanPropertyRowMapper<>(ItemResponse.class),category,restaurantId);
            menuPanel.setItemsResponses(dishes);
            menuPanels.add(menuPanel);
        }
        menuResponsePanel.setMenuPanelList(menuPanels);
        return menuResponsePanel;
    }

    public List<Home> homePage()
    {
        try
        {
            String HOME_SCREEN = "select restaurantName,rating,avgRating,restaurantId,freeDelivery,photoUrl,address from restaurant order by avgRating desc limit ?,?";
            List<Home> home = jdbcTemplate.query(HOME_SCREEN,(rs, rowNum) ->
                    new Home(rs.getString("restaurantName"), rs.getFloat("rating"), rs.getFloat("avgRating"), rs.getInt("restaurantId"),rs.getBoolean("freeDelivery"),rs.getString("photoUrl"),rs.getString("address")),lowerLimit, upperLimit);
           lowerLimit = lowerLimit + pages;
            if (home.size() == 0) {
              lowerLimit = 0;
                return jdbcTemplate.query("select restaurantName,rating,avgRating,restaurantId,freeDelivery,photoUrl,address from restaurant order by avgRating desc limit ?,?", (rs, rowNum) ->
                     new Home(rs.getString("restaurantName"), rs.getFloat("rating"), rs.getFloat("avgRating"), rs.getInt("restaurantId"),rs.getBoolean("freeDelivery"),rs.getString("photoUrl"),rs.getString("address")),lowerLimit, upperLimit);
            }
            System.out.println(HOME_SCREEN);
           return home;
        }catch (Exception e)
        {
            System.out.println(e);
            return null;
        }
    }

    public String addCardInformation(Card card)
    {
        int id = getUserIdFromEmail();
        try
        {
           String add_card = "insert into card(cardNumber,userId,expiryDate,cvv) values(?,?,?,?)";
           jdbcTemplate.update(add_card, card.getCardNumber(), id, card.getExpiryDate(), card.getCvv());
           return "added successfully";
        }
        catch (Exception e)
        {
            System.out.println(e);
            return "error";
        }
    }

    public String getUserNameFromToken()
    {
        String username;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails)
        {
            username = ((UserDetails) principal).getUsername();
        }
        else
        {
            username = principal.toString();
        }
        return username;
    }


    public int getUserIdFromEmail()
    {
        String email = getUserNameFromToken();
        int userId = jdbcTemplate.queryForObject("select userId from user where email=?",new Object[]{email},Integer.class);
        return userId;
    }

//    public String addToCart(CartInformation cartInformation)
//    {
//        int id =  getUserIdFromEmail();
//        try {
//            jdbcTemplate.update("insert into cart(userId,restaurantId,amount) values(?,?,?)", id, cartInformation.getRestaurantId(), cartInformation.getAmount());
//            int cartId = jdbcTemplate.queryForObject("select max(cartId) from cart where userId=?", Integer.class, new Object[]{id});
//            jdbcTemplate.update("insert into item (dishId, cartId, quantity) values(?,?,?)", cartInformation.getDishId(), cartId, cartInformation.getQuantity());
//            return "Added to cart";
//        }catch (Exception e)
//        {
//            System.out.println(e);
//            return "error";
//        }
//    }

    public List<DishResponse> viewTopDishes()
    {
        String query="select dish.dishId,dish.dishName,dish.photoUrl from dish inner join item on dish.dishId=item.dishId group by dish.dishId order by count(dish.dishId)desc limit ?,?";
        List<DishResponse> dishes=new ArrayList<DishResponse>();
        jdbcTemplate.query(query, (rs, rowNum) ->
        {
            DishResponse dish=new DishResponse();
            dish.setDishId(rs.getInt("dish.dishId"));
            dish.setDishName(rs.getString("dish.dishName"));
            dish.setPhotoUrl(rs.getString("dish.photoUrl"));
            int dishCount = jdbcTemplate.queryForObject("select count(restaurantId) from menu where dishId=?", Integer.class,dish.getDishId());
            dish.setRestaurantCount(dishCount);
            dishes.add(dish);
            return dish;
        },lowerLimit,upperLimit);
        lowerLimit = lowerLimit + pages;
        if(dishes.size() == 0)
        {
            lowerLimit = 0;
            return jdbcTemplate.query(query, (rs, rowNum) ->
            {
                DishResponse dish=new DishResponse();
                dish.setDishId(rs.getInt("dish.dishId"));
                dish.setDishName(rs.getString("dish.dishName"));
                dish.setPhotoUrl(rs.getString("dish.photoUrl"));
                int dishCount = jdbcTemplate.queryForObject("select count(restaurantId) from menu where dishId=?", Integer.class,dish.getDishId());
                dish.setRestaurantCount(dishCount);
                dishes.add(dish);
                return dish;
            },lowerLimit,upperLimit);
        }

        return dishes;
    }

    public String addAddress(Address address)
    {
        int id =  getUserIdFromEmail();
        try
        {

            String user_address = "insert into address(userId,address) values(?,?)";
            jdbcTemplate.update(user_address, id, address.getAddress());
            return "Address added";
        }catch (Exception e) {
            System.out.println(e);
            return "error";
        }
    }

    public List<Address> getAddress()
    {
        int id =  getUserIdFromEmail();
        try {
            String get_address = "select *from address where userId =" + id;
            return jdbcTemplate.query(get_address, new BeanPropertyRowMapper<>(Address.class));
        }catch (Exception e)
        {
            System.out.println(e);
            return null;
        }
    }

    public List<Restaurant> restaurantBasedOnDelivery()
    {
        try
        {
            String get_restaurant = "select restaurantId,restaurantName,rating,avgRating,favourites,address,openTime,closeTime,photoUrl from restaurant where freeDelivery = true";
            return jdbcTemplate.query(get_restaurant, new BeanPropertyRowMapper<>(Restaurant.class));
        }catch (Exception e)
        {
            System.out.println(e);
            return null;
        }
    }

    public List<Favourite> viewFavourites()
    {
        int id =  getUserIdFromEmail();
        try{

            String favourites = "select* from favourite where userId=" + id;
            return jdbcTemplate.query(favourites, new BeanPropertyRowMapper<>(Favourite.class));
        }catch(Exception e)
        {
            System.out.println(e);
            return null;
        }
    }

    public List<Item> viewItems()
    {
        int id = getUserIdFromEmail();
        String query = "select cartId from cart where userId=" + id;
        List<Integer> cartIds = jdbcTemplate.queryForList(query, Integer.class);
        List<Item> list = new ArrayList<>();
        for (int cartId : cartIds) {
            System.out.println(cartId);
            String query1 = "select * from item where cartId=" + cartId;
            list.addAll(jdbcTemplate.query(query1, new BeanPropertyRowMapper<>(Item.class)));
        }
        return list;
    }


    public String placeOrder(Order orders)
    {
        int id = getUserIdFromEmail();
        try {
            jdbcTemplate.queryForObject("select cartId from orders where cartId = ?",Integer.class,orders.getCartId());
            return "You have already placed your order";
        }
        catch (Exception e) {
            try
            {
                int cart_no = jdbcTemplate.queryForObject("select max(cartId) from cart where userId = ?", Integer.class,id);
                Card card = jdbcTemplate.queryForObject("select * from card where cardNumber = ? and userId =?", new BeanPropertyRowMapper<>(Card.class), orders.getCardNumber(),id);

                System.out.println(orders.getCvv() + "" + card.getCvv());
                System.out.println(orders.getExpiryDate() + "" + card.getExpiryDate());
                if(cart_no == orders.getCartId()) {

                    if (orders.getCvv() == card.getCvv()) {
                        jdbcTemplate.queryForObject("select * from card where expiryDate = ? and cardNumber = ?", new BeanPropertyRowMapper<>(Card.class), orders.getExpiryDate(), orders.getCardNumber());
                        String query = "insert into orders(cartId,cardNumber,address,status) values(?,?,?,?)";
                        jdbcTemplate.update(query, orders.getCartId(), orders.getCardNumber(), orders.getAddress(), "successful");
                        return "Order placed..Thank you for ordering";
                    }
                    return "Invalid Card Details";
                }
                return "Invalid Cart Details";
            } catch (Exception exception) {
                exception.printStackTrace();
                return "Invalid Card Details";
            }
        }
    }

    public double getTotalPrice(CartItems cartItems)
    {
        double totalPrice = 0;
        for (Item item : cartItems.getItems()) {
            double price = jdbcTemplate.queryForObject("select price from menu where dishId =? and restaurantId=?", Double.class , item.getDishId(),cartItems.getRestaurantId());
            totalPrice += (price * item.getQuantity());
        }
        return totalPrice;
    }


    public  String addToCart(Cart cart)
    {

        String query="insert into cart(userId,restaurantId,amount) values(?,?,?)";
        jdbcTemplate.update(query,cart.getUserId(),cart.getRestaurantId(),cart.getAmount());
        return "cart added successfully";
    }


    public int getRecentlyCreatedCartId(int id)
    {
        return jdbcTemplate.queryForObject("select max(cartId) from cart where userId="+id, Integer.class);
    }



    public String addCartItems(List<Item> items,int cartId)
    {

        String query="insert into item values(?,?,?)";

        for(Item item:items)
        {
                if(item.getQuantity() > 0) {
                    jdbcTemplate.update(query, item.getDishId(), cartId,item.getQuantity());
                }

        }
        return "items added successfully";
    }


    public int addToOrder(CartItems cartItems)
    {
        int id = getUserIdFromEmail();
        Cart cart=new Cart();
        cart.setUserId(id);
        cart.setRestaurantId(cartItems.getRestaurantId());
        cart.setAmount(this.getTotalPrice(cartItems));
        addToCart(cart);
        int cartId=this.getRecentlyCreatedCartId(id);
        this.addCartItems(cartItems.getItems(),cartId);
        return cartId;

    }

    public FilterResponse searchWithFilter(Filters filter) {
        String query = this.applyFilter(filter);
        FilterResponse filterResponse = new FilterResponse();
        filterResponse.setCuisines(filter.getCuisines());
        List<RestaurantResponse> restaurantResponses = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(RestaurantResponse.class));
        filterResponse.setRestaurantResponseList(restaurantResponses);
        filterResponse.setCount(0);
        if (restaurantResponses != null)
            filterResponse.setCount(restaurantResponses.size());
        return filterResponse;
    }
    public String applyFilter(Filters filter)
    {
        String query = "select restaurant.restaurantId,dish.cuisines,restaurant.restaurantName,address,freeDelivery,rating,favourites,avgRating,openTime,closeTime,restaurant.photoUrl,minimumCost from restaurant inner join menu on restaurant.restaurantId=menu.restaurantId inner join dish on dish.dishId=menu.dishId where ";
        //dish type
        if (filter.getCuisines() != null) {
            query = query + " dish.cuisines like '%" + filter.getCuisines() + "%' ";
        } else {
            query = query + " dishType like '%' ";
        }

        //filter
        if (filter.isOpenNow()) {
            Time now = Time.valueOf(LocalTime.now());
            query = query + "and restaurant.openTime<'" + now + "' and restaurant.closeTime>'" + now + "' ";
        }

//        if (filter.isCreditCard()) {
//            query = query + "and restaurant.creditCard=true ";
//        }

        if (filter.isFreeDelivery()) {
            query = query + "and restaurant.freeDelivery=true ";
        }

        //price
        if (filter.getPrice() > 0) {
            query = query + "and restaurant.minimumCost<=" + filter.getPrice();
        }

        //order by
        if (filter.getSortBy() != null) {
            if (filter.getSortBy().equalsIgnoreCase("TOP RATED")) {
                query = query + " order by restaurant.avgRating desc";
            }

            if (filter.getSortBy().equalsIgnoreCase("COST DESC")) {
                query = query + " order by restaurant.minimumCost desc";
            }

            if (filter.getSortBy().equalsIgnoreCase("COST ASC")) {
                query = query + " order by restaurant.minimumCost asc";
            }
        }

        System.out.println(query);
        return query;


    }
}
