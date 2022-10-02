package Lesson6;

import Lesson5.dto.Product;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import lombok.SneakyThrows;
import okhttp3.ResponseBody;
import org.apache.ibatis.session.SqlSession;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CreateProductTest extends AbstractTest {

    Product product = null;
    Faker faker = new Faker();

    int id;

    @BeforeEach
    void setUp() {
        product = new Product()
                .withTitle(faker.food().ingredient())
                .withCategoryTitle("Food")
                .withPrice((int) (Math.random() * 1000));
    }

    @Test
    void createProductInFoodCategoryTest() throws IOException {
        Response<Product> response = getProductController().createProduct(product).execute();
        id = response.body().getId();
        assertThat(response.isSuccessful(), CoreMatchers.is(true));

        try (SqlSession session = getSqlSessionFactory().openSession()) {
            db.dao.ProductsMapper productsMapper = session.getMapper(db.dao.ProductsMapper.class);
            db.model.ProductsExample example = new db.model.ProductsExample();
            assertThat(product.getTitle(), equalTo(productsMapper.selectByPrimaryKey(id).getTitle()));
            assertThat(product.getPrice(), equalTo(productsMapper.selectByPrimaryKey(id).getPrice()));
        }
    }

    @Test
    void getProductById() throws IOException {
        createProductInFoodCategoryTest();
        Response<Product> response = getProductController().getSpecificProductById(id).execute();
        assertThat(response.isSuccessful(), CoreMatchers.is(true));
        try (SqlSession session = getSqlSessionFactory().openSession()) {
            db.dao.ProductsMapper productsMapper = session.getMapper(db.dao.ProductsMapper.class);
            assertThat(response.body().getTitle(), equalTo(productsMapper.selectByPrimaryKey(id).getTitle()));
            assertThat(response.body().getPrice(), equalTo(productsMapper.selectByPrimaryKey(id).getPrice()));
        }
    }

    @Test
    void modifyProduct() throws IOException {
        createProductInFoodCategoryTest();
        Product productNew = new Product()
                .withId(id)
                .withTitle(product.getTitle())
                .withCategoryTitle(product.getCategoryTitle())
                .withPrice(product.getPrice() + 20);


        Response<Product> response = getProductController().modifyProduct(productNew).execute();
        assertThat(response.isSuccessful(), CoreMatchers.is(true));
        assertThat(response.body().getPrice(), equalTo(product.getPrice() + 20));

        try (SqlSession session = getSqlSessionFactory().openSession()) {
            db.dao.ProductsMapper productsMapper = session.getMapper(db.dao.ProductsMapper.class);
            assertThat(productNew.getTitle(), equalTo(productsMapper.selectByPrimaryKey(id).getTitle()));
            assertThat(productNew.getPrice(), equalTo(productsMapper.selectByPrimaryKey(id).getPrice()));
        }
    }

    @Test
    void getAllProducts() throws IOException {
        createProductInFoodCategoryTest();
        Response<ResponseBody> response = getProductController().getAllProducts().execute();
        ObjectMapper objectMapper = new ObjectMapper();
        assertThat(response.code(), equalTo(200));

        List<Product> productList = objectMapper.readValue(response.body().string(), new TypeReference<List<Product>>(){});

        try (SqlSession session = getSqlSessionFactory().openSession()) {
            db.dao.ProductsMapper productsMapper = session.getMapper(db.dao.ProductsMapper.class);

            productList.forEach(product ->
                    assertThat(product.getTitle(), equalTo(productsMapper.selectByPrimaryKey(product.getId()).getTitle())));
            productList.forEach(product ->
                    assertThat(product.getPrice(), equalTo(productsMapper.selectByPrimaryKey(product.getId()).getPrice())));

        }
    }

    @SneakyThrows
    @AfterEach
    void tearDown() {
        if (id > 0) {
            Response<ResponseBody> response = getProductController().deleteProductById(id).execute();
            assertThat(response.isSuccessful(), CoreMatchers.is(true));
        }
    }
    //Задание 2. Добавьте апдейт и удаление данных через БД в тестах и после них.
    @Test
    void newRecordByMyBatis(){
        db.model.Products productsNew = new db.model.Products();
        productsNew.setCategory_id(1);
        productsNew.setTitle(faker.food().ingredient());
        productsNew.setPrice((int) (Math.random() * 1000));

        System.out.println(productsNew.getTitle() + " price " + productsNew.getPrice());

        try (SqlSession session = getSqlSessionFactory().openSession()) {
            db.dao.ProductsMapper productsMapper = session.getMapper(db.dao.ProductsMapper.class);
            db.model.ProductsExample example = new db.model.ProductsExample();
            productsMapper.insert(productsNew);
            session.commit();

            assertThat(productsNew.getTitle(), equalTo(productsMapper.selectByPrimaryKey(productsNew.getId()).getTitle()));
            assertThat(productsNew.getPrice(), equalTo(productsMapper.selectByPrimaryKey(productsNew.getId()).getPrice()));
        }

        db.model.Products productsUpdate = new db.model.Products();
        productsUpdate.setId(productsNew.getId());
        productsUpdate.setCategory_id(1);
        productsUpdate.setTitle(faker.food().ingredient());
        productsUpdate.setPrice(productsNew.getPrice() + 20);

        System.out.println(productsUpdate.getTitle()+ " price " + productsUpdate.getPrice());

        try (SqlSession session = getSqlSessionFactory().openSession()) {
            db.dao.ProductsMapper productsMapper = session.getMapper(db.dao.ProductsMapper.class);
            productsMapper.updateByPrimaryKey(productsUpdate);
            session.commit();

            assertThat(productsUpdate.getTitle(), equalTo(productsMapper.selectByPrimaryKey(productsNew.getId()).getTitle()));
            assertThat(productsUpdate.getPrice(), equalTo(productsMapper.selectByPrimaryKey(productsNew.getId()).getPrice()));
        }

        try (SqlSession session = getSqlSessionFactory().openSession()) {
            db.dao.ProductsMapper productsMapper = session.getMapper(db.dao.ProductsMapper.class);
            productsMapper.deleteByPrimaryKey(productsNew.getId());
            session.commit();

        }
    }

}
