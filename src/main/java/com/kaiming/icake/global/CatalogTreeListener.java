package com.kaiming.icake.global;

import com.kaiming.icake.biz.CatalogBiz;
import com.kaiming.icake.biz.impl.CatalogBizImpl;
import com.kaiming.icake.entity.Catalog;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class CatalogTreeListener implements ServletContextListener {
    private CatalogBiz catalogBiz = new CatalogBizImpl();
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Catalog root = catalogBiz.getRoot();
        sce.getServletContext().setAttribute("root",root);
    }
}
