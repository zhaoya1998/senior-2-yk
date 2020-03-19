package com.zhaoya.service;

import java.util.ArrayList;

import com.github.pagehelper.PageInfo;
import com.zhaoya.domain.Car;
import com.zhaoya.domain.Type;
import com.zhaoya.domain.Vo;

public interface CarService {

	PageInfo<Car> getPageInfo(Vo vo, int pageNum);

	ArrayList<Car> getGoodsList(Vo vo, int pageNum);

	ArrayList<Car> look(Integer cid);

	ArrayList<Type> getTypeList();

	int insert(Car car);

	Car getCarListByCid(Integer cid);

	int update(Car car);
}
