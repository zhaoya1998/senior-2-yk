package com.zhaoya.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.zhaoya.domain.Car;
import com.zhaoya.domain.Type;
import com.zhaoya.domain.Vo;

public interface CarMapper {

	ArrayList<Car> getCarList(Vo vo);

	ArrayList<Car> look(@Param("cid")Integer cid);

	ArrayList<Type> getTypeList();

	int insert(Car car);

	Car getCarListByCid(@Param("cid")Integer cid);

	int update(Car car);

}
