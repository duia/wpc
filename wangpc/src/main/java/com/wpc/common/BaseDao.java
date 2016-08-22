package com.wpc.common;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 
 */
public interface BaseDao<T extends Serializable,PK extends Serializable> {

    void save(T t);

    void delete(PK id);

    void deleteByIds(PK[] ids);

    void update(T t);

    T findById(PK id);

    <T> List<T> queryAll();
    
    <T> List<T> search(T query);
    
    <T> List<T> page(T query);

    PK count();

    PK count(T t);

}
