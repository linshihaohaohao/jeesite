package com.thinkgem.jeesite.modules.poem.web;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.poem.entity.Song;
import com.thinkgem.jeesite.modules.poem.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
@RequestMapping(value = "${adminPath}/song")

public class Songcontroller extends BaseController {

    @Autowired
    private SongService songService;

    @ModelAttribute
    public Song getSong(@RequestParam(required = false) String id) {
        Song entity = null;
        if (StringUtils.isNotBlank(id)) {
            entity = songService.get(id);
        }
        if (entity == null) {
            entity = new Song();
        }
        return entity;
    }

    @RequestMapping(value = {"list", ""})
    public String list(Song song, HttpServletRequest request, HttpServletResponse response, Model model) {
        Page<Song> page = songService.findPage(new Page<Song>(request, response), song);
        model.addAttribute("page", page);
        return "modules/song/songList";
    }

    @RequestMapping(value = "form")
    public String form(Song song, Model model) {
        model.addAttribute("song", song);
        return "modules/song/songForm";
    }

    @RequestMapping(value = "save")
    public String save(Song song, Model model, RedirectAttributes redirectAttributes) {
        if (!beanValidator(model, song)) {
            return form(song, model);
        }
        songService.save(song);
        addMessage(redirectAttributes, "保存单表成功");
        return "redirect:" + Global.getAdminPath() + "/song/?repage";
    }

    @RequestMapping(value = "delete")
    public String delete(Song song, RedirectAttributes redirectAttributes) {
        songService.delete(song);
        addMessage(redirectAttributes, "删除单表成功");
        return "redirect:" + Global.getAdminPath() + "/song/?repage";
    }
}
