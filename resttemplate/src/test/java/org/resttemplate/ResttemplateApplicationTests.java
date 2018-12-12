package org.resttemplate;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ResttemplateApplicationTests {

    @Autowired
    RestTemplateBuilder r;

    @Test
    public void get() throws JSONException {
        RestTemplate restTemplate = r.build();
        String re = restTemplate.getForObject("http://127.0.0.1:8080/user/", String.class);
        JSONObject jsonObject = new JSONObject(re);
        System.out.println(jsonObject.toString(2));
    }

    @Test
    public void post() {
        RestTemplate restTemplate = r.build();
        HttpHeaders header = new HttpHeaders();
//        header.add("Content-Type", "multipart/form-data; boundary=----WebKitFormBoundary7MA4YWxkTrZu0gW");
        header.add("Content-Type", "application/x-www-form-urlencoded");

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("username", "ben");
        params.add("password", "123456");
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(params, header);
        String re = restTemplate.postForObject("http://127.0.0.1:8080/user/", requestEntity, String.class);
        System.out.println(re);
    }

    @Test
    public void put() {
        RestTemplate restTemplate = r.build();
        int id = 1;

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("username", "ben1111111");
        params.add("password", "123456");

        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(params, null);

        restTemplate.put("http://127.0.0.1:8080/user/{1}", requestEntity, id);
    }

    @Test
    public void delete() {
        RestTemplate restTemplate = r.build();
        restTemplate.delete("http://127.0.0.1:8080/user/{1}", 9);
    }

    @Test
    public void get1() throws JSONException {
        RestTemplate restTemplate = r.build();
        String re = restTemplate.getForObject("http://127.0.0.1:8080/user/{1}", String.class, 1);
        JSONObject json = new JSONObject(re);
        System.out.println(json.toString(2));
    }

}
