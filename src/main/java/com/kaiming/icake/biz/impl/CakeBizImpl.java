package com.kaiming.icake.biz.impl;


import com.kaiming.icake.biz.CakeBiz;
import com.kaiming.icake.dao.CakeDao;
import com.kaiming.icake.entity.Cake;
import com.kaiming.icake.global.DaoFactory;

import java.util.List;

public class CakeBizImpl implements CakeBiz {
    private CakeDao cakeDao = DaoFactory.getInstance().getDao(CakeDao.class);
    /*添加蛋糕*/
    @Override
    public void add(Cake cake) {
        cakeDao.insert(cake);
    }
    /*修改*/
    @Override
    public void edit(Cake cake) {
        cakeDao.update(cake);
    }
    /* 删除*/
    @Override
    public void remove(int id) {
        cakeDao.delete(id);
    }
    /*通过id获取蛋糕*/
    @Override
    public Cake get(int id) {
        return cakeDao.select(id);
    }
    /*查询全部*/
    @Override
    public List<Cake> getAll() {
        return cakeDao.selectAll();
    }

    @Override
    public Cake getSpecial() {
        List<Cake> list = cakeDao.selectByStatus("特卖");
        if(list.size()>0) {
            return list.get(0);
        }
        return null;
    }
    /*根据索引查询*/
    @Override
    public List<Cake> getForIndex() {
        return cakeDao.selectByStatus("推荐");
    }

    /*根据分类查找*/
    @Override
    public List<Cake> getForCatalog(int cid) {
        return cakeDao.selectByCid(cid);
    }
}
