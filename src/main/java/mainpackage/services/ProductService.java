package mainpackage.services;

import mainpackage.model.Product;
import mainpackage.model.ProductResponse;
import mainpackage.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;
    public ProductResponse productaddition(Product product)
    {
        Product currentProduct = productRepository.findByProductId(product.getProductId());
        ProductResponse productResponse = new ProductResponse();

        if(currentProduct == null)
        {
            productRepository.save(product);
            productResponse.setStatus(true);
            productResponse.setMessage("Product added successfully");
        }
        else {
            productResponse.setStatus(false);
            productResponse.setMessage("Product already Exists");
        }
        return productResponse;
    }

    public ProductResponse updateproduct(Product product)
    {
        Product currentProduct = productRepository.findByProductId(product.getProductId());
        ProductResponse productResponse = new ProductResponse();

        //currentProduct.setProductId(product.getProductId());
        currentProduct.setProductName(product.getProductName());
        currentProduct.setProductPrice(product.getProductPrice());

        productRepository.save(currentProduct);
        productResponse.setStatus(true);
        productResponse.setMessage("Product added successfully");
        return productResponse;
    }
}
