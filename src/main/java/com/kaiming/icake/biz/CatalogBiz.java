package com.kaiming.icake.biz;

import com.kaiming.icake.entity.Catalog;

import java.util.List;

public interface CatalogBiz {
    void add(List<Catalog> list);
    void remove(Integer id);
    Catalog getRoot();
}
