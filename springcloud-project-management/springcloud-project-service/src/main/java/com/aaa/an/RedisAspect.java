package com.aaa.an;

import com.aaa.redis.RedisService;
import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisServer;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisCluster;

import java.util.List;

/**
 * @description: RedisAspect
 * @author: 彭于晏
 * @create: 2020-07-25 15:30
 **/
@Component
@Aspect
public class RedisAspect {

    @Autowired
    private RedisService redisService;

    @Autowired
    private JedisCluster jedisCluster;

    @Pointcut("@annotation(com.aaa.annotation.RedisAnnotation)")
    public void pointCut(){

    }

    @Pointcut("@annotation(com.aaa.annotation.RedisUpdate)")
    public void pointcut1(){

    }


    @Around("pointCut()")
    public Object aroud(ProceedingJoinPoint proceedingJoinPoint){

        String  typeName=proceedingJoinPoint.getTarget().getClass().getName();
        MethodSignature signature=(MethodSignature)proceedingJoinPoint.getSignature();
        Class returnType = signature.getReturnType();
        String key = getKey(proceedingJoinPoint);
        if(jedisCluster.hexists(typeName,key)){
            String hget = jedisCluster.hget(typeName, key);
            Object object = JSONObject.parseObject(hget, returnType);
            return object;
        }else {
            try {
                Object proceed = proceedingJoinPoint.proceed();
                if(proceed!=null){
                    Long hset = jedisCluster.hset(typeName, key, JSONObject.toJSONString(proceed));
                    if(hset==0){
                        throw  new RuntimeException("redis的hash赋值失败");
                    }
                    return proceed;
                }
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }

        return null;

    }

    public String getKey(ProceedingJoinPoint proceedingJoinPoint){
        String methodName = proceedingJoinPoint.getSignature().getName();
        Object[] args = proceedingJoinPoint.getArgs();
        StringBuffer stringBuffer=new StringBuffer(methodName);
        for (Object arg : args) {
            stringBuffer.append(args.toString());
        }
        return stringBuffer.toString();
    }



    @Around("pointcut1()")
    public Object aroudRedisUpdate(ProceedingJoinPoint proceedingJoinPoint){
        Object proceed=null;
        try {
            proceed = proceedingJoinPoint.proceed();
            if(proceed!=null){
                String name = proceedingJoinPoint.getTarget().getClass().getName();
                Long hdel = jedisCluster.hdel(name);
            }
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        return proceed;

    }


}
