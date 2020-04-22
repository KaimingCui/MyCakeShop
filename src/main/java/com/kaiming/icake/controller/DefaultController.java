package com.kaiming.icake.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kaiming.icake.biz.AccountBiz;
import com.kaiming.icake.biz.CakeBiz;
import com.kaiming.icake.biz.CatalogBiz;
import com.kaiming.icake.biz.impl.AccountBizImpl;
import com.kaiming.icake.biz.impl.CakeBizImpl;
import com.kaiming.icake.biz.impl.CatalogBizImpl;
import com.kaiming.icake.entity.Account;
import com.kaiming.icake.entity.Cake;
import com.kaiming.icake.entity.Catalog;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class DefaultController {
    private AccountBiz accountBiz = new AccountBizImpl();
    private CatalogBiz catalogBiz = new CatalogBizImpl();
    private CakeBiz cakeBiz = new CakeBizImpl();
    //toLogin.do
    public void toLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/admin/login.jsp").forward(request,response);
    }
    //login.do
    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("account");
        String password = request.getParameter("password");
        Account account = accountBiz.login(name,password);
        System.out.println(account);
        if(account == null){
            String message = "登录失败";
            request.setAttribute("msg",message);
            request.getRequestDispatcher(request.getContextPath() + "/toLogin.do").forward(request,response);
        }else{
            System.out.println("登录成功");
            request.getSession().setAttribute("ACCOUNT",account);
            response.sendRedirect(request.getContextPath() + "/admin/Cake/list.do");
        }


    }
    //quit.do
    public void quit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getSession().setAttribute("ACCOUNT",null);
        response.sendRedirect(request.getContextPath() + "/toLogin.do");


    }

    //index.do
    public void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Cake cake = cakeBiz.getSpecial();
        request.setAttribute("cake", cake);
        List<Cake> list = cakeBiz.getForIndex();
        request.setAttribute("list", list);

        request.getRequestDispatcher("/WEB-INF/pages/index.jsp").forward(request,response);
    }
    //list.do
    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int cid = Integer.parseInt(request.getParameter("cid"));
        String pageNum = request.getParameter("pageNum");
        if(pageNum==null){
            pageNum = "1";
        }


        PageHelper.startPage(Integer.parseInt(pageNum),12);
        List<Cake> list = cakeBiz.getForCatalog(cid);
        PageInfo pageInfo = PageInfo.of(list);
        request.setAttribute("pageInfo", pageInfo);
        request.setAttribute("cid",cid);
        System.out.println(pageInfo.getList().size());
        request.getRequestDispatcher("/WEB-INF/pages/list.jsp").forward(request,response);
    }

    //detail.do
    public void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));


        Cake cake = cakeBiz.get(id);
        request.setAttribute("cake",cake);
        request.getRequestDispatcher("/WEB-INF/pages/detail.jsp").forward(request,response);


    }
}
