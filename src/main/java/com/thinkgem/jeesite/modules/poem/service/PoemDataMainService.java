/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.poem.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.poem.entity.PoemDataMain;
import com.thinkgem.jeesite.modules.poem.dao.PoemDataMainDao;

/**
 * 单表生成Service
 *
 * @author lsh
 * @version 2018-09-08
 */
@Service
@Transactional(readOnly = true)
public class PoemDataMainService extends CrudService<PoemDataMainDao, PoemDataMain> {

    public PoemDataMain get(String id) {
        return super.get(id);
    }

    public List<PoemDataMain> findList(PoemDataMain poemDataMain) {
        return super.findList(poemDataMain);
    }

    public Page<PoemDataMain> findPage(Page<PoemDataMain> page, PoemDataMain poemDataMain) {
        return super.findPage(page, poemDataMain);
    }

    @Transactional(readOnly = false)
    public void save(PoemDataMain poemDataMain) {
        super.save(poemDataMain);
    }

    @Transactional(readOnly = false)
    public void delete(PoemDataMain poemDataMain) {
        super.delete(poemDataMain);
    }

}