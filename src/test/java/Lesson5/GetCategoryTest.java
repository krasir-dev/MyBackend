package Lesson5;

import Lesson5.api.CategoryController;
import Lesson5.dto.GetCategoryResponse;
import Lesson5.utils.RetrofitUtils;
import lombok.SneakyThrows;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import retrofit2.Response;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class GetCategoryTest {
    static CategoryController categoryController;

    @BeforeAll
    static void beforeAll() {categoryController= RetrofitUtils.getRetrofit().create(CategoryController.class);}

    @SneakyThrows
        @Test
        void getCategoryByIdPositiveTest(){
        Response<GetCategoryResponse> response = categoryController.getCategory(2).execute();

        assertThat(response.isSuccessful(), CoreMatchers.is(true));
        assertThat(response.body().getId(), equalTo(2));
        assertThat(response.body().getTitle(), equalTo("Electronic"));
        response.body().getProducts().forEach(product ->
                assertThat(product.getCategoryTitle(), equalTo("Electronic")));
    }



}
