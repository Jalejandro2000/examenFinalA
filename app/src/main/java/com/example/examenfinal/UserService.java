package com.example.examenfinal;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface UserService {
    @GET("journals.php")
    Call<List<JournalsResponse>> getAllJournals();

    @GET("issues.php")
    Call<List<IssueResponse>> getaAllIssues(@Query("j_id") String id);

    @GET("pubs.php")
    Call<List<PubResponse>> getAllPub(@Query("i_id") String id);
}
