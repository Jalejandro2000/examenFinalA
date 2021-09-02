package com.example.examenfinal;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


public interface UserService {
    @GET("ws/issues.php?j_id=2")
    Call<List<UserResponse>> getaAllUsers();
}
