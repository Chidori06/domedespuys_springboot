package fr.simplon.domedespuys.config;

import com.github.javafaker.Faker;
import fr.simplon.domedespuys.entity.*;
import fr.simplon.domedespuys.repository.*;
import fr.simplon.domedespuys.utils.Slugger;
import lombok.AllArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Component
@AllArgsConstructor
public class DataLoaderConfig implements CommandLineRunner {

    private Slugger slugger;
    private UserRepository userRepository;
    private BrandRepository brandRepository;
    private AddressRepository addressRepository;
    private ProductRepository productRepository;
    private ImageRepository imageRepository;
    private PurchaseRepository purchaseRepository;
    private PurchaseProductRepository purchaseProductRepository;


    @Override
    public void run(String @NonNull ... args) {

        createUsers();
        createBrands();
        createAddresses();
        createProduct();
        createImages();
        createPurchase();
        createPurchaseProduct();

    }

    private void createUsers() {
        if (0 == userRepository.count()) {
            Faker faker = new Faker(Locale.of("fr"));

            for (int i = 0; i < 200; i++) {
                User user = new User();
                user.setFirstname(faker.name().firstName());
                user.setLastname(faker.name().lastName());
                String email = user.getLastname() + "." + user.getFirstname() + "@" + faker.internet().domainName() + ".fr";
                user.setEmail(email);
                user.setPassword(faker.internet().password(12, 20));
                if (hasProbability(2, 3)) {
                    user.setPhone(faker.phoneNumber().phoneNumber());
                }

                user.setCreatedAt(getRandomDate(faker, 0, 5));
                userRepository.save(user);
            }
            userRepository.flush();
        }
    }

    private void createBrands() {
        if (0 == brandRepository.count()) {
            Faker faker = new Faker(Locale.of("fr"));

            for (int i = 0; i < 50; i++) {
                Brand brand = new Brand();
                brand.setLabel(faker.company().name());
                if (hasProbability(2, 3)) {
                    brand.setLogo(faker.company().logo());
                }
                brand.setSlug(slugger.slugify(brand.getLabel()));
                brandRepository.save(brand);
            }
            brandRepository.flush();
        }

    }

    private void createAddresses() {
        if (0 == addressRepository.count()) {
            Faker faker = new Faker(Locale.of("fr"));


            for (int i = 0; i < 150; i++) {
                Address address = new Address();
                address.setLine(faker.address().streetAddress());
                if (hasProbability(1, 4)) {
                    address.setExtraLine(faker.address().secondaryAddress());
                }
                address.setCity(faker.address().cityName());
                address.setZipCode(faker.address().zipCode());
                address.setCountry("France");

                Random random = new Random();
                Long userId = random.nextLong(1, 100);
                Optional<User> optionalUser = userRepository.findById(userId);
                //Pas la meilleure option
                //User user = optionalUser.orElseThrow();
                //address.setUser(user);

                //Meilleure option
                optionalUser.ifPresent(address::setUser);

                if (hasProbability(2, 4)) {
                    address.setFirstname(address.getUser().getFirstname());
                    address.setLastname(address.getUser().getLastname());
                    address.setPhone(address.getUser().getPhone());
                } else {
                    address.setFirstname(faker.name().firstName());
                    address.setLastname(faker.name().lastName());
                    address.setPhone(faker.phoneNumber().phoneNumber());
                }
                int year = address.getUser().getCreatedAt().getYear();
                int currentYear = LocalDate.now().getYear();
                address.setCreatedAt(getRandomDate(faker, 0, currentYear - year));

                addressRepository.save(address);
            }
            addressRepository.flush();
        }
    }

    private void createProduct() {
        if (0 == productRepository.count()) {
            Faker faker = new Faker(Locale.of("fr"));
            List<String> productsUsed = new ArrayList<>();

            for (int i = 0; i < 300; i++) {
                String name;
                do {
                    name = faker.commerce().productName();
                } while (productsUsed.contains(name));
                productsUsed.add(name);

                Product product = getProduct(
                        faker,
                        name,
                        name + " : " + faker.lorem().words(80),
                        faker.number().numberBetween(499, 30000)
                );

                Optional<Brand> optionalBrand = brandRepository.findById((long) faker.number().numberBetween(1,50));
                optionalBrand.ifPresent(product::setBrand);

                productRepository.save(product);
            }

            productRepository.flush();
        }
    }

    public void createImages() {
        if (0 == imageRepository.count()) {
            List<Product> products = productRepository.findAll();
            for (Product product : products) {
                createImagesByProduct(product, true);

                do {
                    createImagesByProduct(product, false);
                } while(hasProbability(1, 2));
            }

            imageRepository.flush();
        }
    }

    public void createPurchase() {
        if(0 == purchaseRepository.count()){
            Faker faker = new Faker(Locale.of("fr"));

            for (int i = 0; i < 500; i++) {
                Purchase purchase = new Purchase();
                String tmpNumber;
                if (i < 10) {
                    tmpNumber = "0000000000" + i;
                } else if (i < 100) {
                    tmpNumber = "000000000" + i;
                } else {
                    tmpNumber = "00000000" + i;
                }
                String number = "PUR-" + LocalDateTime.now().getYear() + "-" + tmpNumber;
                purchase.setNumber(number);

                User user;
                List<Address> addresses;
                Random random = new Random();

                do {
                    Long idUser = random.nextLong(1,100);
                    Optional<User> optionalUser = userRepository.findById(idUser);
                    user = optionalUser.orElseThrow();
                    addresses = addressRepository.findAllByUser(user);
                } while (addresses.isEmpty());

                purchase.setUser(user);
                purchase.setAddress(addresses.getFirst());

                int year = user.getCreatedAt().getYear();
                int currentYear = LocalDate.now().getYear();
                int yearBetween = currentYear - year;
                purchase.setCreatedAt(getRandomDate(faker, 0, yearBetween));

                if (yearBetween > 1) {
                    purchase.setStatus(EnumPurchaseStatus.DELIVERED.getValue());
                } else {
                    int status = faker.number().numberBetween(1, 5);
                    switch (status) {
                        case 1:
                            purchase.setStatus(EnumPurchaseStatus.PENDING.getValue());
                            break;
                        case 2:
                            purchase.setStatus(EnumPurchaseStatus.PAID.getValue());
                            break;
                        case 3:
                            purchase.setStatus(EnumPurchaseStatus.SHIPPED.getValue());
                            break;
                        default:
                            purchase.setStatus(EnumPurchaseStatus.CANCELLED.getValue());
                            break;
                    }
                }
                purchaseRepository.save(purchase);
            }
            purchaseRepository.flush();
        }
    }

    private void createPurchaseProduct() {
        if (0 == purchaseProductRepository.count()) {
            List<Purchase> purchases = purchaseRepository.findAll();
            for (Purchase purchase : purchases) {
                createPurchaseProductByPurchase(purchase);

                do {
                    createPurchaseProductByPurchase(purchase);
                } while(hasProbability(1, 3));
            }

            purchaseProductRepository.flush();
        }
    }

    private void createPurchaseProductByPurchase(Purchase purchase) {
        Faker faker = new Faker(Locale.of("fr"));
        PurchaseProduct purchaseProduct = new PurchaseProduct();
        purchaseProduct.setPurchase(purchase);
        purchaseProduct.setQuantity(faker.number().numberBetween(1, 6));

        Optional<Product> productOptional = productRepository.findById(faker.number().numberBetween(1L, 300L));
        productOptional.ifPresent(purchaseProduct::setProduct);

        int priceProduct = purchaseProduct.getProduct().getPrice();
        purchaseProduct.setPrice(priceProduct);
        if (hasProbability(1, 6)) {
            purchaseProduct.setPrice((int)(priceProduct * 1.2));
        }

        purchaseProductRepository.save(purchaseProduct);
    }

    private Product getProduct(Faker faker, String label, String description, int price) {
        Product product = new Product();
        product.setLabel(label);
        product.setCreatedAt(getRandomDate(faker, 0, 10));
        product.setPrice(price);
        product.setSlug(slugger.slugify(label));
        product.setDescription(description);
        return product;
    }

    private LocalDateTime getRandomDate(Faker faker, int min, int max) {
        return new java.sql.Date(faker.date().birthday(min, max).getTime()).toLocalDate().atTime(0, 0);
    }

    private void createImagesByProduct(Product product, boolean isDefault) {
        Image image = new Image();
        Random rand = new Random();
        image.setPath("https://picsum.photos/400/300?r=" + rand.nextInt(300));
        image.setExtension("png");
        image.setIsDefault(isDefault);
        image.setProduct(product);
        imageRepository.save(image);
    }

    private boolean hasProbability(int expected, int max) {
        Random random = new Random();
        return random.nextInt(max) < expected;

    }
}
