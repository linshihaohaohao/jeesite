/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.poem.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.poem.entity.PoemDataMain;
import com.thinkgem.jeesite.modules.poem.service.PoemDataMainService;

/**
 * 单表生成Controller
 * @author lsh
 * @version 2018-09-08
 */
@Controller
@RequestMapping(value = "${adminPath}/poem/poemDataMain")
public class PoemDataMainController extends BaseController {

	@Autowired
	private PoemDataMainService poemDataMainService;
	
	@ModelAttribute
	public PoemDataMain get(@RequestParam(required=false) String id) {
		PoemDataMain entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = poemDataMainService.get(id);
		}
		if (entity == null){
			entity = new PoemDataMain();
		}
		return entity;
	}
	
	@RequiresPermissions("poem:poemDataMain:view")
	@RequestMapping(value = {"list", ""})
	public String list(PoemDataMain poemDataMain, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<PoemDataMain> page = poemDataMainService.findPage(new Page<PoemDataMain>(request, response), poemDataMain); 
		model.addAttribute("page", page);
		return "modules/poem/poemDataMainList";
	}

	@RequiresPermissions("poem:poemDataMain:view")
	@RequestMapping(value = "form")
	public String form(PoemDataMain poemDataMain, Model model) {
		model.addAttribute("poemDataMain", poemDataMain);
		return "modules/poem/poemDataMainForm";
	}

	@RequiresPermissions("poem:poemDataMain:edit")
	@RequestMapping(value = "save")
	public String save(PoemDataMain poemDataMain, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, poemDataMain)){
			return form(poemDataMain, model);
		}
		poemDataMainService.save(poemDataMain);
		addMessage(redirectAttributes, "保存单表成功");
		return "redirect:"+Global.getAdminPath()+"/poem/poemDataMain/?repage";
	}
	
	@RequiresPermissions("poem:poemDataMain:edit")
	@RequestMapping(value = "delete")
	public String delete(PoemDataMain poemDataMain, RedirectAttributes redirectAttributes) {
		poemDataMainService.delete(poemDataMain);
		addMessage(redirectAttributes, "删除单表成功");
		return "redirect:"+Global.getAdminPath()+"/poem/poemDataMain/?repage";
	}

}