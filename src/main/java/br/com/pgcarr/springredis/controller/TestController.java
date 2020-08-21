package br.com.pgcarr.springredis.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.cache.annotation.Cacheable;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/test")
public class TestController {

    private static final Logger LOG = Logger.getLogger(TestController.class.getName());
    //test cache with REDIS
    @Cacheable(cacheNames = "testCache", key = "{ #root.methodName, #key }")
    @PostMapping(value = "testCache", produces = {"application/json; charset=UTF-8"})
    public String testCache(@RequestParam(required = false) String key, @RequestParam(required = false) String value) {
        String result = null;
        try {
            result = new Gson().fromJson(new Gson().toJson(value), String.class);
        } catch (Exception e) {
            System.out.println(e);
        }
        return new GsonBuilder().create().toJson(result);
    }
}
