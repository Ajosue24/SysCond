package com.vv.repository;

import org.springframework.data.repository.CrudRepository;

import com.vv.model.Article;

public interface ArticleRepository extends CrudRepository<Article,Long>{

	
}
