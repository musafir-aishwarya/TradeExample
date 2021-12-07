package com.example.trade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.trade.pojo.URLModel;


@Repository
@Transactional
public interface UrlRepository extends JpaRepository<URLModel, Integer>{
	
	//extends CrudRepository<UrlModel, Integer>
}
