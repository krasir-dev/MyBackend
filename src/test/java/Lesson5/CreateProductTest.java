package Lesson5;

import Lesson5.api.ProductController;
import Lesson5.dto.Product;
import Lesson5.utils.RetrofitUtils;
import com.github.javafaker.Faker;
import lombok.SneakyThrows;
import okhttp3.ResponseBody;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.*;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CreateProductTest {
    static ProductController productController;
    Product product = null;
    Faker faker = new Faker();

    int id;

    @BeforeAll
    static void beforeAll(){
        productController = RetrofitUtils.getRetrofit().create(ProductController.class);
    }

    @BeforeEach
    void setUp(){
        product = new Product()
                .withTitle(faker.food().ingredient())
                .withCategoryTitle("Food")
                .withPrice((int) (Math.random() * 1000));

    }

    @Test
    void createProductInFoodCategoryTest() throws IOException {
        Response<Product> response = productController.createProduct(product).execute();
        id = response.body().getId();
        assertThat(response.isSuccessful(), CoreMatchers.is(true));
        //System.out.println(response.body().getTitle());
    }

    @Test
    void getProductById() throws IOException {
        createProductInFoodCategoryTest();
        Response<Product> response = productController.getSpecificProductById(id).execute();
        assertThat(response.isSuccessful(), CoreMatchers.is(true));
        System.out.println(response.body().toString());
    }

    @Test
    void modifyProduct() throws IOException{
        createProductInFoodCategoryTest();
        System.out.println(product.getTitle());
        System.out.println(product.getPrice());
        Product productNew = new Product()
                .withId(id)
                .withTitle(product.getTitle())
                .withCategoryTitle(product.getCategoryTitle())
                .withPrice(product.getPrice()+20);


        Response<Product> response = productController.modifyProduct(productNew).execute();
        assertThat(response.isSuccessful(), CoreMatchers.is(true));
        assertThat(response.body().getPrice(), equalTo(product.getPrice()+20));
    }

    @Test
    void getAllProducts() throws IOException{
        createProductInFoodCategoryTest();
        //Response<ResponseBody> response = productController.getAllProducts().execute();
        //assertThat(response.code(), equalTo(200));
    }

    @SneakyThrows
    @AfterEach
    void tearDown(){
        Response<ResponseBody> response = productController.deleteProductById(id).execute();
        assertThat(response.isSuccessful(), CoreMatchers.is(true));
    }

}
