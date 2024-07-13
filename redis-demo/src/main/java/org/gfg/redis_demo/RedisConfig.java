package org.gfg.redis_demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration // we have create this class to make bean of  redis

public class RedisConfig {

    @Bean
    public LettuceConnectionFactory lettuceRedisConnectionFactory(){
        RedisStandaloneConfiguration redisStandaloneConfiguration =
                new RedisStandaloneConfiguration("redis-11453.c270.us-east-1-3.ec2.redns.redis-cloud.com", 11453);
        redisStandaloneConfiguration.setPassword("QbzWn5MSYqxQ5ZEMvRPzMqSC9HNoJDfc");
        LettuceConnectionFactory lettuceRedisConnectionFactory= new LettuceConnectionFactory(redisStandaloneConfiguration);
        return lettuceRedisConnectionFactory;


    }


    @Bean
    public RedisTemplate<String, Object> getRedisTemplate(){
        RedisTemplate<String,Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
//        redisTemplate.setHashKeySerializer(new JdkSerializationRedisSerializer());
//        redisTemplate.setHashValueSerializer(new JdkSerializationRedisSerializer());
        redisTemplate.setConnectionFactory(lettuceRedisConnectionFactory());
        return redisTemplate;
    }

}
