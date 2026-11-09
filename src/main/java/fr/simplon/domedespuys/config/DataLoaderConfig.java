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
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.Random;

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
        createProducts();
        createImages();
        createPurchases();
        createPurchaseProducts();

    }

    private void createUsers() {
        if (0 == userRepository.count()) {
            Faker faker = new Faker(Locale.of("fr"));

            for (int i = 0; i < 100; i++) {
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

    private void createProducts() {
        if (0 == productRepository.count()) {
            Faker faker = new Faker(Locale.of("fr"));

            for (int i = 0; i < 150; i++) {
                Product product = new Product();
                product.setLabel(faker.commerce().productName());
                if (hasProbability(1, 3)) {
                    product.setDescription(faker.lorem().paragraph(2));
                }
                product.setPrice(faker.number().numberBetween(5L, 500L));
                product.setSlug(slugger.slugify(product.getLabel()));

                Random random = new Random();
                Long brandId = random.nextLong(1, 50);
                Optional<Brand> optionalBrand = brandRepository.findById(brandId);
                optionalBrand.ifPresent(product::setBrand);

                product.setCreatedAt(getRandomDate(faker, 0, 5));

                productRepository.save(product);
            }
            productRepository.flush();
        }
    }

    private void createImages() {
        if (0 == imageRepository.count()) {
            for (int i = 0; i < 200; i++) {
                Image image = new Image();
                Random rand = new Random();
                int x = rand.nextInt();
                image.setPath("https://picsum.photos/400/300?r=" + x);
                image.setExtension("jpg");
                image.setIsDefault(hasProbability(1, 3));

                Random random = new Random();
                Long productId = random.nextLong(1, 150);
                Optional<Product> optionalProduct = productRepository.findById(productId);
                optionalProduct.ifPresent(image::setProduct);
                imageRepository.save(image);
            }

            imageRepository.flush();
        }
    }

    private void createPurchases() {
        if (0 == purchaseRepository.count()) {
            Faker faker = new Faker(Locale.of("fr"));
            for (int i = 0; i < 100; i++) {
                Purchase purchase = new Purchase();

                int currentYear = LocalDate.now().getYear();
                purchase.setNumber("PUR-" + currentYear + "-" + "0000" + i);

                purchase.setStatus(String.valueOf(getRandomStatus(faker)));
                Random random = new Random();

                Long userId = random.nextLong(1, 101);
                Optional<User> optionalUser = userRepository.findById(userId);

                if (optionalUser.isPresent()) {
                    User user = optionalUser.get();
                    purchase.setUser(user);

                    List<Address> addresses = addressRepository.findByUserId(userId);

                    if (addresses.isEmpty()) {
                        continue;
                    }

                    long addressIndex = random.nextLong(addresses.size());
                    Address address = addresses.get((int) addressIndex);

                    purchase.setAddress(address);
                    purchase.setCreatedAt(getRandomDate(faker, 0, 5));

                    purchaseRepository.save(purchase);
                }
                purchaseRepository.flush();
            }
        }
    }

    private void createPurchaseProducts() {
        if (0 == purchaseProductRepository.count()) {
            Faker faker = new Faker(Locale.of("fr"));
            Random random = new Random();

            for (int i = 0; i < 150; i++) {
                PurchaseProduct purchaseProduct = new PurchaseProduct();

                Long purchaseId = random.nextLong(1, 101);
                Optional<Purchase> optionalPurchase = purchaseRepository.findById(purchaseId);

                Long productId = random.nextLong(1, 151);
                Optional<Product> optionalProduct = productRepository.findById(productId);

                if (optionalPurchase.isPresent() && optionalProduct.isPresent()) {
                    purchaseProduct.setPurchase(optionalPurchase.get());
                    purchaseProduct.setProduct(optionalProduct.get());

                    purchaseProduct.setQuantity(faker.random().nextInt(1, 6));

                    purchaseProduct.setPrice(optionalProduct.get().getPrice());

                    purchaseProductRepository.save(purchaseProduct);
                }
            }
            purchaseProductRepository.flush();
        }
    }

    private EnumPurchaseStatus getRandomStatus(Faker faker) {
        if (hasProbability(7, 10)) {
            return EnumPurchaseStatus.PENDING;
        }

        EnumPurchaseStatus[] statuses = {
                EnumPurchaseStatus.PAID,
                EnumPurchaseStatus.SHIPPED,
                EnumPurchaseStatus.DELIVERED,
                EnumPurchaseStatus.CANCELLED
        };

        return statuses[faker.random().nextInt(statuses.length)];
    }

    private LocalDateTime getRandomDate(Faker faker, int min, int max) {
        return new java.sql.Date(faker.date().birthday(min, max).getTime()).toLocalDate().atTime(0, 0);
    }

    private boolean hasProbability(int expected, int max) {
        Random random = new Random();
        return random.nextInt(max) < expected;

    }
}
