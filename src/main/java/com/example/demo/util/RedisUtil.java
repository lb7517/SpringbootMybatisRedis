package com.example.demo.util;

import com.alibaba.fastjson.JSON;
import com.example.demo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * Created by lb on 2019/5/21.
 */
@Component
public class RedisUtil {

    @Autowired
    RedisTemplate redisTemplate;

    //作用防止入缓存乱码
    @Autowired
    public void setRedisTemplate(RedisTemplate redisTemplate) {
        RedisSerializer redisSerializer = new StringRedisSerializer();
        //key序列化方式
        redisTemplate.setKeySerializer(redisSerializer);
        //value序列化
        redisTemplate.setValueSerializer(redisSerializer);
        //value hashmap序列化
        redisTemplate.setHashValueSerializer(redisSerializer);
        //key haspmap序列化
        redisTemplate.setHashKeySerializer(redisSerializer);
        this.redisTemplate = redisTemplate;
    }

    public String getStringOpts(String key){
        ValueOperations valueOperations = redisTemplate.opsForValue();
        boolean hasKey = redisTemplate.hasKey(key);
        if(hasKey){
            String objStr = String.valueOf(valueOperations.get(key));
            return objStr;
        }
        return null;
    }

    public void setStringOpts(String key, Object st, int timeOut){
        ValueOperations valueOperations = redisTemplate.opsForValue();
        String objStr = JSON.toJSONString(st);

        valueOperations.set(key, objStr, timeOut, TimeUnit.SECONDS); //设置过期时间10s
//        valueOperations.set(key, objStr); //没有这只过期时间
        return;
    }

    public String getObjectOpts(String key, String smallKey){
        //大key， 小key, 值
        HashOperations<String, String, Object> hashOperations = redisTemplate.opsForHash();
        String objStr = String.valueOf(hashOperations.get(key, smallKey));
        return objStr;
    }

    public void putObjectOpts(String key, String smallKey, Object obj){
        //大key， 小key, 值
        HashOperations<String, String, Object> hashOperations = redisTemplate.opsForHash();
        String objStr = JSON.toJSONString(obj);
        hashOperations.put(key, smallKey, objStr);
        redisTemplate.expire(key, 10, TimeUnit.DAYS.SECONDS); //第三个参数是单位
    }
}
