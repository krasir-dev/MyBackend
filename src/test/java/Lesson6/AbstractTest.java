package Lesson6;

import Lesson5.api.ProductController;
import Lesson5.utils.RetrofitUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.BeforeAll;

import java.io.IOException;
import java.io.InputStream;

public class AbstractTest {
    static ProductController productController;
    protected static String resource = "mybatis-config.xml";
    private static SqlSessionFactory sqlSessionFactory;


    @BeforeAll
    static void initTest() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        productController = RetrofitUtils.getRetrofit().create(ProductController.class);

    }

    public static SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }

    public static ProductController getProductController() {
        return productController;
    }
}
