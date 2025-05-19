package bj.sedom.springmongodbteaser.services;

import bj.sedom.springmongodbteaser.models.Category;
import bj.sedom.springmongodbteaser.models.Product;
import bj.sedom.springmongodbteaser.models.Tag;
import bj.sedom.springmongodbteaser.repositories.CategoryRepository;
import bj.sedom.springmongodbteaser.repositories.ProductRepository;
import bj.sedom.springmongodbteaser.repositories.TagRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final TagRepository tagRepository;


    //@PostConstruct
    public void init() {

        // Initialize some categories and products
        System.out.println("\n");
        System.out.println("Initialize some categories and products");

        Category electronics = new Category("Electronics", "Devices and gadgets");
        Category clothing = new Category("Clothing", "Apparel and accessories");

        categoryRepository.save(electronics);
        categoryRepository.save(clothing);

        Product phone = new Product("Smartphone", 699.99, electronics);

        productRepository.save(phone);

        Tag tag1 = tagRepository.save(new Tag("Clothes"));
        Tag tag2 = tagRepository.save(new Tag("tunique"));
        Product shirt = new Product("T-Shirt", 19.99, clothing, Set.of(tag1, tag2));
        Product laptop = new Product("Laptop", 1299.99, electronics, Set.of(tag1));

        productRepository.save(shirt);
        productRepository.save(laptop);

        productRepository.findAll().forEach(System.out::println);

        System.out.println("Search products by tag");
        productRepository.findByTags_Id(tag1.getId()).forEach(System.out::println);

        System.out.println("\n");

    }


    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProduct(String productId) {
        return productRepository.findById(productId).orElse(null);
    }

    public List<Product> getProductsByCategory(String categoryId) {
        return productRepository.findByCategory_Id(categoryId);
    }

}