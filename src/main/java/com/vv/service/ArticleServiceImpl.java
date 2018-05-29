package com.vv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vv.model.Article;
import com.vv.repository.ArticleRepository;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService{
	
	@Autowired
	ArticleRepository articleRepository;

	@Override
	public List<Article> getAllArticles() {
		return (List<Article>) articleRepository.findAll();
	}

	@Override
	public Article getArticleById(long id) {
		
		return articleRepository.findById(id).get();
	}

	@Override
	public void saveOrUpdate(Article article) {
		try {
			articleRepository.save(article);
		}catch(Exception e) {
			//colocar logs 
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteArticle(long id) {
		
		try {
			articleRepository.deleteById(id);
		} catch (Exception e) {
			// add logs
			e.printStackTrace();
		}
	}

}
