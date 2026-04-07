package edu.tcu.cs.hogwartsartifactsonlinecda.client.rediscache;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisCacheClient {

    @Value("${redis.enabled:false}")
    private boolean redisEnabled;

    private final StringRedisTemplate redisTemplate;


    public RedisCacheClient(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void set(String key, String value, long timeout, TimeUnit timeUnit) {
        if (!redisEnabled) {
            return; // Skip Redis in tests
        }
        this.redisTemplate.opsForValue().set(key, value, timeout, timeUnit);
    }

    public String get(String key) {
        if (!redisEnabled) {
            return null; // Skip Redis in tests
        }
        return this.redisTemplate.opsForValue().get(key);
    }

    public void delete(String key) {
        if (!redisEnabled) {
            return;
        }
        this.redisTemplate.delete(key);
    }

    public boolean isUserTokenInWhiteList(String userId, String tokenFromRequest) {
        String tokenFromRedis = get("whitelist:" + userId);
        return tokenFromRedis != null && tokenFromRedis.equals(tokenFromRequest);
    }

}