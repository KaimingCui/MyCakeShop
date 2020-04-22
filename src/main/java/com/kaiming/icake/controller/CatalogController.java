package com.kaiming.icake.controller;

import com.kaiming.icake.biz.CatalogBiz;
import com.kaiming.icake.biz.impl.CatalogBizImpl;
import com.kaiming.icake.entity.Catalog;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CatalogController {
    private CatalogBiz catalogBiz = new CatalogBizImpl();
    // /admin/Catalog/list.do
    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Catalog root = catalogBiz.getRoot();
        request.getServletContext().setAttribute("root",root);

        request.getRequestDispatcher("/WEB-INF/pages/admin/catalog_list.jsp").forward(request,response);
    }

    // /admin/Catalog/toAdd.do
    public void toAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Catalog root = catalogBiz.getRoot();
        request.setAttribute("root",root);
        request.getRequestDispatcher("/WEB-INF/pages/admin/catalog_add.jsp").forward(request,response);
    }
    // /admin/Catalog/add.do
    public void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String[] title = request.getParameterValues("title");
        String[] pid = request.getParameterValues("pid");
        String[] info = request.getParameterValues("info");
        List<Catalog> list = new ArrayList<Catalog>();

        for(int i=0;i<title.length;i++){
            Catalog catalog = new Catalog();
            catalog.setTitle(title[i]);
            catalog.setPid(Integer.parseInt(pid[i]));
            catalog.setInfo(info[i]);
            list.add(catalog);
        }

        catalogBiz.add(list);
        //in same directory
        response.sendRedirect("list.do");
    }
    // /admin/Catalog/remove.do
    public void remove(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        catalogBiz.remove(id);
        response.sendRedirect("list.do");
    }
}
