/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.poem.service;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.poem.dao.PoemDataMainDao;
import com.thinkgem.jeesite.modules.poem.entity.PoemDataMain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 单表生成Service
 *
 * @author lsh
 * @version 2018-09-08
 */
//注解，加入这个注解spring 会把这个服务当成一个bean注进来
@Service
//加上事务的注解
@Transactional(readOnly = true)
public class PoemDataMainService extends CrudService<PoemDataMainDao, PoemDataMain> {
    @Autowired
    PoemDataMainDao poemDataMainDao ;

    @Override
    public PoemDataMain get(String id) {
        //直接调用父类的方法  重写？ 重载
        return poemDataMainDao.getPoemById(id);
    }

    @Override
    public List<PoemDataMain> findList(PoemDataMain poemDataMain) {



        return super.findList(poemDataMain);
    }
    @Override
    public Page<PoemDataMain> findPage(Page<PoemDataMain> page, PoemDataMain poemDataMain) {
        return super.findPage(page, poemDataMain);
    }
    @Override
    @Transactional(readOnly = false)
    public void save(PoemDataMain poemDataMain) {
        super.save(poemDataMain);
    }
    @Override
    @Transactional(readOnly = false)
    public void delete(PoemDataMain poemDataMain) {
        super.delete(poemDataMain);
    }

}