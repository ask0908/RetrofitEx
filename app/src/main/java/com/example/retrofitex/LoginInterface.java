package com.example.retrofitex;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/* 로그인에 사용할 인터페이스 */
public interface LoginInterface {

    String LOGINURL = "https://demonuts.com/Demonuts/JsonTest/Tennis/";
    @FormUrlEncoded
    @POST("simplelogin.php")
    Call<String> getUserLogin ( // 로그인 시에는 아이디, 비번만 치므로 2개의 매개변수만 메서드에 넣어준다
                                @Field("username") String uname,
                                @Field("password") String password
    );

}
