package com.thinkgem.jeesite.modules.poem.service;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.poem.dao.SongDao;
import com.thinkgem.jeesite.modules.poem.entity.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author lsh
 * @date 2018/9/8.
 */
//注解，加入这个注解spring 会把这个服务当成一个bean注进来
@Service
@Transactional(readOnly = true)
public class SongService extends CrudService<SongDao,Song> {

    @Autowired
    SongDao songDao;

    public Song getSong(String id){
        return songDao.get(id);
    }

    @Override
    public Page<Song> findPage(Page<Song> page,Song song) {
        return super.findPage(page,song);
    }

    @Override
    public List<Song> findList(Song song) {
        return super.findList(song);
    }


    @Override
    @Transactional(readOnly = false)
    public void save(Song song) {
        super.save(song);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Song song) {
        super.delete(song);
    }

}
