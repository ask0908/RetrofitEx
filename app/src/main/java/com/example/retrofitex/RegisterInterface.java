package com.example.retrofitex;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/* 회원가입 프로세스를 위한 인터페이스 */
public interface RegisterInterface {

    // String 변수 REGIURL은 회원가입 php 스크립트의 URL을 포함한다
    String REGIURL = "https://demonuts.com/Demonuts/JsonTest/Tennis/";
    @FormUrlEncoded
    @POST("simpleregister.php") // 여기에 php 파일 이름을 넣어준다. POST 방식을 쓸 것이기 때문에 @POST 어노테이션을 달아준다
    Call<String> getUserRegi (  // 매개변수로 이름, 취미, 사용자 이름, 비밀번호라는 URL 매개변수를 넣어준다
                                @Field("name") String name,
                                @Field("hobby") String hobby,
                                @Field("username") String uname,
                                @Field("password") String password
    );

}