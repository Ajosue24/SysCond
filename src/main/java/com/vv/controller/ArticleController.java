package com.vv.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.vv.model.Article;
import com.vv.service.ArticleService;

@Controller
@RequestMapping(value="/article")
public class ArticleController {

	@Autowired
	ArticleService articleService;
	
	
	//Traer Todos
	@RequestMapping(value="/list",method=RequestMethod.GET )
	public ModelAndView list() {
		ModelAndView model = new ModelAndView("article_list");
		List<Article> articleList= articleService.getAllArticles();
		model.addObject("articleList",articleList);
		return model;
		
	}
	//Agregar
	@RequestMapping(value="/addArticle/",method=RequestMethod.GET )
	public ModelAndView addArticle() {
		ModelAndView model = new ModelAndView();
		Article article=new Article();
		model.addObject("articleForm",article);
		model.setViewName("article_form");
		return model;
		
	}
	
	//editar
	@RequestMapping(value="/updateArticle/{id}",method=RequestMethod.GET )
	public ModelAndView editArticle(@PathVariable long id) {
		ModelAndView model = new ModelAndView();
		
		Article article=articleService.getArticleById(id);
		model.addObject("articleForm",article);
		model.setViewName("article_form");
		return model;
		
	}
	
	//Guardar
		@RequestMapping(value="/saveArticle",method=RequestMethod.POST )
		public ModelAndView save(@ModelAttribute("articleForm") Article article) {
			articleService.saveOrUpdate(article);
			return new ModelAndView("redirect:/article/list");
			
			
		}

		//Delete

				@RequestMapping(value="/deleteArticle/{id}",method = RequestMethod.GET )
				public ModelAndView delete(@PathVariable("id") long id) {
					articleService.deleteArticle(id);
					return new ModelAndView("redirect:/article/list");
					
					
				}
				//otra pruebasy el automaticamentye


}
