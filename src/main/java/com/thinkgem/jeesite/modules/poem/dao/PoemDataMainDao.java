/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.poem.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.poem.entity.PoemDataMain;

/**
 * 单表生成DAO接口
 * @author lsh
 * @version 2018-09-08
 */
@MyBatisDao
public interface PoemDataMainDao extends CrudDao<PoemDataMain> {

	public PoemDataMain getPoemById(String id);
}