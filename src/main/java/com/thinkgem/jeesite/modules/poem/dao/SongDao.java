package com.thinkgem.jeesite.modules.poem.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.poem.entity.Song;

/**
 * @author lsh
 * @date 2018/9/8.
 */
//加入该注解注册成为dao ，具体百度
@MyBatisDao
//改dao要去继承crudDao，不然crudService封装不了
public interface SongDao extends CrudDao<Song> {

}
