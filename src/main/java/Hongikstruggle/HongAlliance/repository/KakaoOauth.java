package Hongikstruggle.HongAlliance.repository;

import org.springframework.stereotype.Component;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

@Component
public class KakaoOauth {
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public HashMap<String, Object> getUserInfo(String accessToken){
        HashMap<String,Object> userInfo = new HashMap<String,Object>();
        String reqUrl = "https://kauth.kakao.com/oauth/token";
        try{
            URL url = new URL(reqUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Authorization", "Bearer" + accessToken);
            int responseCode = conn.getResponseCode();
            System.out.println("responseCode" + responseCode);


        }catch (Exception e){
            System.out.println(e);
        }
        return userInfo;
    }


}
