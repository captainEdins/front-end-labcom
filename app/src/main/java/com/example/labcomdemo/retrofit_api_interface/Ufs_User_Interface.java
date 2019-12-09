package com.example.labcomdemo.retrofit_api_interface;

import com.example.labcomdemo.retrofit_model.Ufs_Authentication_Model;
import com.example.labcomdemo.retrofit_model.Ufs_User_Model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface Ufs_User_Interface {
//    @GET("/lab/contact_list")
//    Call<Ufs_User_Model> getContactList();

    @GET("lab/contact_list")
    Call<List<Ufs_User_Model>> getFullList();

    @POST("oauth/token")
    @FormUrlEncoded
    Call<Ufs_Authentication_Model> login(
            @Header("Authorization") String authHeader,
            @Field("grant_type") String grantType,
            @Field("username") String username,
            @Field("password") String password
    );

    @POST("oauth/token")
    @FormUrlEncoded
    Call<Ufs_Authentication_Model> getAuth(
            @Field("grant_type") String grantType,
            @Field("username") String username,
            @Field("password") String password
    );
}

