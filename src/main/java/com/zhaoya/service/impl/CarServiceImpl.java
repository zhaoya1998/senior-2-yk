package com.zhaoya.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhaoya.dao.CarMapper;
import com.zhaoya.domain.Car;
import com.zhaoya.domain.Type;
import com.zhaoya.domain.Vo;
import com.zhaoya.service.CarService;
@Service
public class CarServiceImpl implements CarService{

	@Autowired
	private CarMapper mapper;

	@Override
	public PageInfo<Car> getPageInfo(Vo vo, int pageNum) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, 3);
		ArrayList<Car> list=mapper.getCarList(vo);
		PageInfo<Car> info=new PageInfo<Car>(list);
		return info;
	}
	
	@Override
	public ArrayList<Car> getGoodsList(Vo vo, int pageNum) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, 3);
		ArrayList<Car> list=mapper.getCarList(vo);
		return list;
	}

	@Override
	public ArrayList<Car> look(Integer cid) {
		// TODO Auto-generated method stub
		return mapper.look(cid);
	}

	@Override
	public ArrayList<Type> getTypeList() {
		// TODO Auto-generated method stub
		return mapper.getTypeList();
	}

	@Override
	public int insert(Car car) {
		// TODO Auto-generated method stub
		return mapper.insert(car);
	}

	@Override
	public Car getCarListByCid(Integer cid) {
		// TODO Auto-generated method stub
		return mapper.getCarListByCid(cid);
	}

	@Override
	public int update(Car car) {
		// TODO Auto-generated method stub
		return mapper.update(car);
	}
	
	
	

}
