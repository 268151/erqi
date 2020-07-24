package com.aaa.an;

import com.aaa.annotation.RoleAnnotion;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;

/**
 * @description: RoleAspect
 * @author: 彭于晏
 * @create: 2020-07-21 19:04
 **/
@Aspect
@Component
public class RoleAspect1 {

    @Pointcut("@annotation(com.aaa.annotation.RoleAnnotion)")
    public void pointCut(){
    }


    @Around("pointCut()")
    public Object aroundAspect(ProceedingJoinPoint proceedingJoinPoint){
        Object o=null;
        HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder.getRequestAttributes())).getRequest();

        HttpSession session = request.getSession();
        /**
         * 通过目标对象获取值
         */
        String roleName=null;
        Method[] methods = proceedingJoinPoint.getTarget().getClass().getMethods();
//        String s = proceedingJoinPoint.getTarget().getClass().getAnnotation(RoleAnnotion.class).roleName();

        String name = proceedingJoinPoint.getSignature().getName();
        if(name!=null&&name!=""&& methods!=null&&methods.length>0){
            for (Method method : methods) {
                if((name).equals(method.getName())){
                    roleName = method.getAnnotation(RoleAnnotion.class).roleName();
                }
            }
        }

        Object roles = session.getAttribute("roles");
        if(roleName!=null&& roleName.equals( "管理员")){
            try {
                o = proceedingJoinPoint.proceed();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }

        return o;
    }

}
