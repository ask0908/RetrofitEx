package com.example.retrofitex;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceHelper {

    /* JSON 응답에서 intro, name, hobby 필드를 받는다 */
    private final String INTRO = "intro";
    private final String NAME = "name";
    private final String HOBBY = "hobby";
    private SharedPreferences app_prefs;
    private Context context;

    public PreferenceHelper(Context context)
    {
        app_prefs = context.getSharedPreferences("shared", Context.MODE_PRIVATE);
        this.context = context;
    }

    /* 3가지 필드에 대한 put / get 함수 작성 */

    // put 메서드로 쉐어드에 정보를 저장한다
    // 사용자가 로그아웃 시 쉐어드에서 정보를 제거하거나 putXXX()에 빈 문자열을 간단히 쓸 수 있다
    public void putIsLogin(boolean loginorout)
    {
        SharedPreferences.Editor edit = app_prefs.edit();
        edit.putBoolean(INTRO, loginorout);
        edit.commit();
    }

    public boolean getIsLogin()
    {
        return app_prefs.getBoolean(INTRO, false);
    }

    public void putName(String loginorout)
    {
        SharedPreferences.Editor edit = app_prefs.edit();
        edit.putString(NAME, loginorout);
        edit.commit();
    }

    public String getName()
    {
        return app_prefs.getString(NAME, "");
    }

    public void putHobby(String loginorout)
    {
        SharedPreferences.Editor edit = app_prefs.edit();
        edit.putString(HOBBY, loginorout);
        edit.commit();
    }

    public String getHobby()
    {
        return app_prefs.getString(HOBBY, "");
    }

}
