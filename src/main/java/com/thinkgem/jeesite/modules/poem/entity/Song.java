package com.thinkgem.jeesite.modules.poem.entity;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * @author lsh
 * @date 2018/9/8.
 */
public class Song extends DataEntity<Song> {

    private String songName;
    private String singer;
    private String composer;
    private String lyricist;
    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getComposer() {
        return composer;
    }

    public void setComposer(String composer) {
        this.composer = composer;
    }

   public String getLyricist() {
        return lyricist;
    }

    public void setLyricist(String lyricist) {
        this.lyricist = lyricist;
    }
}