package Lesson6;

import Lesson5.api.CategoryController;
import Lesson5.dto.GetCategoryResponse;
import Lesson5.utils.RetrofitUtils;
import lombok.SneakyThrows;
import org.apache.ibatis.session.SqlSession;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.List;
import retrofit2.Response;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class GetCategoryTest extends AbstractTest {
    static CategoryController categoryController;

    @BeforeAll
    static void beforeAll() {categoryController= RetrofitUtils.getRetrofit().create(CategoryController.class);}

    @SneakyThrows
    @Test
    void getCategoryByIdPositiveTest(){
        int idTest=2;
        Response<GetCategoryResponse> response = categoryController.getCategory(2).execute();

        assertThat(response.isSuccessful(), CoreMatchers.is(true));
        assertThat(response.body().getId(), equalTo(idTest));
        assertThat(response.body().getTitle(), equalTo("Electronic"));
        response.body().getProducts().forEach(product ->
                assertThat(product.getCategoryTitle(), equalTo("Electronic")));

        try (SqlSession session = getSqlSessionFactory().openSession()) {

            db.dao.CategoriesMapper categoriesMapper = session.getMapper(db.dao.CategoriesMapper.class);
            db.model.CategoriesExample example = new db.model.CategoriesExample();

            //example.createCriteria().andIdEqualTo(idTest);
            response.body().getProducts().forEach(product ->
                    assertThat(product.getCategoryTitle(), equalTo(categoriesMapper.selectByPrimaryKey(idTest).getTitle())));


            /*List<db.model.Categories> list = categoriesMapper.selectByExample(example);
            for (db.model.Categories s: list
                 ) {
                System.out.println(s.getTitle());

            }
            System.out.println(categoriesMapper.countByExample(example));
            System.out.println(categoriesMapper.selectByPrimaryKey(idTest).getTitle());*/

        }

    }



}

