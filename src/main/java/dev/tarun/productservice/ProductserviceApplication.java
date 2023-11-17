package dev.tarun.productservice;

import dev.tarun.productservice.models.Product;
import dev.tarun.productservice.repositories.ProductRepository;
import org.antlr.v4.runtime.misc.LogManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductserviceApplication {
    //    private MentorRepository mentorRepository;
//
//
//    private UserRepository userRepository;
    private final ProductRepository productRepository;
//    private final CategoryRepository categoryRepository;
//    private final PriceRepository priceRepository;
//
//    public ProductserviceApplication(@Qualifier("jt_mr") MentorRepository mentorRepository,
//                                     @Qualifier("jt_ur") UserRepository userRepository,
//                                     ProductRepository productRepository,
//                                     CategoryRepository categoryRepository,
//                                     PriceRepository priceRepository) {
//        this.mentorRepository = mentorRepository;
//        this.userRepository = userRepository;
//        this.productRepository = productRepository;
//        this.categoryRepository = categoryRepository;
//        this.priceRepository = priceRepository;
//    }
    public static void main(String[] args) {
        SpringApplication.run(ProductserviceApplication.class, args);
    }
    //    @Transactional()
//    @Override
//    public void run(String... args) throws Exception {
////        Mentor mentor = new Mentor();
////        mentor.setName("Naman");
////        mentor.setEmail("Naman@scaler.com");
////        mentor.setAverageRating(4.65);
////        mentorRepository.save(mentor);
////
////        User user = new User();
////        user.setName("Sarath");
////        user.setEmail("sarathcool@yopmail.com");
////        userRepository.save(user);
////
////        List<User> users = userRepository.findAll();
////        for (User user1: users) {
////            System.out.println(user1);
////        }
//
//        Category category = new Category();
//        category.setName("Apple Devices");
////        Category savedCategory = categoryRepository.save(category);
//
//        Price price = new Price("Rupee", 10);
////        Price savedPrice = priceRepository.save(price);
//
        Product product = new Product();
        product.setTitle("iPhone 15 Pro");
        product.setDescription("The best iPhone Ever");
        product.setCategory(category);
        product.setPrice(price);
        productRepository.save(product);

}
