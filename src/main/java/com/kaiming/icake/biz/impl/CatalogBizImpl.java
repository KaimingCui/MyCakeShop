package com.kaiming.icake.biz.impl;

import com.kaiming.icake.biz.CatalogBiz;
import com.kaiming.icake.dao.CatalogDao;
import com.kaiming.icake.entity.Catalog;
import com.kaiming.icake.global.DaoFactory;

import java.util.List;

public class CatalogBizImpl implements CatalogBiz {
    private CatalogDao catalogDao = DaoFactory.getInstance().getDao(CatalogDao.class);

    public void add(List<Catalog> list) {
        catalogDao.batchInsert(list);
    }

    public void remove(Integer id) {
        catalogDao.delete(id);
    }

    public Catalog getRoot() {
        //根目录的id号是10000
        return catalogDao.select(10000);
    }
}
