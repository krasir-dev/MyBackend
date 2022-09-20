package Lesson5.api;

import Lesson5.dto.GetCategoryResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CategoryController {

    @GET("categories/{id}")
    Call<GetCategoryResponse> getCategory(@Path("id") int id);


}
