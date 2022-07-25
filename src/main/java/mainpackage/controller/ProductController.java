package mainpackage.controller;

import mainpackage.model.Product;
import mainpackage.model.ProductResponse;
import mainpackage.repository.ProductRepository;
import mainpackage.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping(value="addproduct",consumes = "application/json",produces="application/json")
    public ProductResponse addproduct(@RequestBody Product product)
    {
        ProductResponse productResponse = productService.productaddition(product);
        return productResponse;
    }

    @PutMapping(value="update/{id}",consumes = "application/json",produces = "application/json")
    public ProductResponse update(@PathVariable int id,@RequestBody Product product)
    {
        ProductResponse productResponse = productService.updateproduct(product);
        return productResponse;
    }

    @Autowired
    ProductRepository productRepository;

    @GetMapping(value="/product/{id}",produces = "application/json")
    public Product reqProduct(@PathVariable int id)
    {
        Product newproduct = productRepository.findByProductId(id);
        return newproduct;
    }

    @GetMapping(value="/product",produces = "application/json")
    public Product reqProduct2(@RequestParam int id)
    {
        Product newproduct = productRepository.findByProductId(id);
        return newproduct;
    }
}
