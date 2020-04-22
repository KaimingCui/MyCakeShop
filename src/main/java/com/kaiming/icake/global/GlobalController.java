package com.kaiming.icake.global;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@WebServlet(name = "GlobalController")
public class GlobalController extends GenericServlet {

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        /*
           .do
           /login.do DefaultController login
           /Cake/detail.do CakeController detail
           /admin/Cake/add.do CakeController add
         */

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        String path = request.getServletPath();


        System.out.println(request.getServletContext().getRealPath("/"));
        System.out.println(request.getContextPath());
        //判断后台还是前台请求
        if(path.indexOf("/admin")!= -1){
            path = path.substring(7);
        }else{
            path = path.substring(1);
        }

        //判断调用哪一个类哪一个方法
        int index = path.indexOf("/");
        String className = null;
        String methodName = null;
        if(index != -1){
            className = "com.kaiming.icake.controller." + path.substring(0,index) + "Controller";
            methodName = path.substring(index+1,path.indexOf(".do"));
        }else{
            className = "com.kaiming.icake.controller.DefaultController";
            methodName = path.substring(0,path.indexOf(".do"));
        }

        try {
            System.out.println(className);
            System.out.println(methodName);
            Class cla = Class.forName(className);
            Object obj = cla.newInstance();
            Method method = cla.getMethod(methodName,HttpServletRequest.class,HttpServletResponse.class);
            method.invoke(obj,request,response);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
