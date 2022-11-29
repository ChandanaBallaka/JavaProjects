package com.japa.testing.oneToOne_JPA.service;


import com.japa.testing.oneToOne_JPA.entity.Product;
import com.japa.testing.oneToOne_JPA.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public Product saveProduct(Product product)
    {                                                                               //to save single object in database
       return repository.save(product);
    }

    public List<Product> saveProduct(List<Product> products)
    {                                                                                //to save all objects in database
        return repository.saveAll(products);
    }

    public List<Product> getProducts()
    {
        return  repository.findAll();
    }

    public Product getProductById(int id)
    {
        return  repository.findById(id).orElse(null);
    }

    public Product getProductByName(String name)
    {
        return  repository.findByName(name);
    }

    public String deleteProduct(int id){
        repository.deleteById(id);
        return "Product removed " + id;
    }

    public Product updateProdut(Product product){
        Product existingProduct = repository.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setPrice(product.getPrice());
        return repository.save( existingProduct);
    }
}
