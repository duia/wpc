package com.wpc.common;
import java.io.Serializable;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseServiceImpl<T extends Serializable,PK extends Serializable> implements BaseService<T,PK>{
    
	Logger logger = LoggerFactory.getLogger(BaseServiceImpl.class);
    
    @Autowired
    protected BaseDao<T, PK> baseDao;

    @Override
    public void save(T t) {
        this.baseDao.save(t);
    }

    @Override
    public void delete(PK id) {
    	this.baseDao.delete(id);
    }
    
    @Override
    public void deleteByIds(PK[] ids) {
    	this.baseDao.deleteByIds(ids);
    }

    @Override
    public void update(T t) {
        this.baseDao.update(t);
    }

    @Override
    public T findById(PK id) {
        return baseDao.findById(id);
    }

    @Override
    public List<T> queryAll() {
        return this.baseDao.search(null);
    }
    
    @Override
    public List<T> search(T query) {
        return this.baseDao.search(query);
    }

    @Override
    public PK count() {
        return this.baseDao.count();
    }

    @Override
    public PK count(T t) {
        return this.baseDao.count(t);
    }

//    @Override
//    public MyPageModel pageModel(MyPageModel page){
//        PageModel<T> pageModel = new PageModel<T>();
//        pageModel.setParams(page.getParams());
//        List result = this.page(pageModel);
//        PK count = this.count(pageModel);
//        page.setTotalCount((Long)count);
//        page.setData(result);
//        return page;
//    }
}
