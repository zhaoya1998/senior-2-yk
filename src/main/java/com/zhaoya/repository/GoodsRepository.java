package com.zhaoya.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.zhaoya.domain.Car;

public interface GoodsRepository extends ElasticsearchRepository<Car, Integer>{

}
