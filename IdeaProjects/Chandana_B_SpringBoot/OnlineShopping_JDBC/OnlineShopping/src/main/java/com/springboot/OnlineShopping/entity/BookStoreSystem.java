package com.springboot.OnlineShopping.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookStoreSystem
{
  private Admin admin;
  private List<User> userList;
  private List<Book> bookList;
  private List<ShoppingCart> shoppingCartList;
  private List<Purchased> purchasedList;
}
