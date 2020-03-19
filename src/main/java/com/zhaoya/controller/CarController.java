package com.zhaoya.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.zhaoya.domain.Car;
import com.zhaoya.domain.Type;
import com.zhaoya.domain.Vo;
import com.zhaoya.service.CarService;

@Controller
public class CarController {

	@Autowired
	private CarService service;
	
	@RequestMapping("list")
	public String list(Model m,Car car,Vo vo,@RequestParam(defaultValue = "1")int pageNum) {
		PageInfo<Car> info=service.getPageInfo(vo,pageNum);
		ArrayList<Type> types=service.getTypeList();
		m.addAttribute("types", types);
		m.addAttribute("vo", vo);
		m.addAttribute("info", info);
		return "list";
	}
	
	@RequestMapping("look")
	public String look(Model m,Integer cid) {
		ArrayList<Car> list=service.look(cid);
		m.addAttribute("list", list);
		return "look";
	}
	
	@ResponseBody
	@RequestMapping("getTypeList")
	public ArrayList<Type> getTypeList() {

		return service.getTypeList();
		
	}
	
	@GetMapping("add")
	public String add() {
		return "add";
	}

	@ResponseBody
	@PostMapping("add")
	public boolean add(Car car, MultipartFile file) {
		if (null != file && !file.isEmpty()) {
			String path = "e:/pic/";

			String oldfileName = file.getOriginalFilename();
			String fileName = UUID.randomUUID() + oldfileName.substring(oldfileName.lastIndexOf("."));
			File f = new File(path, fileName);
			try {
				file.transferTo(f);
				car.setPic(fileName);
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return service.insert(car) > 0;
	}
	
	@RequestMapping("toUpdate")
	public String toUpdate(Integer cid,Model m) {
		Car car=service.getCarListByCid(cid);
		m.addAttribute("car", car);
		return "update";
	}

	@ResponseBody
	@PostMapping("update")
	public boolean update(Car car, MultipartFile file) {
		if (null != file && !file.isEmpty()) {
			String path = "e:/pic/";

			String oldfileName = file.getOriginalFilename();
			String fileName = UUID.randomUUID() + oldfileName.substring(oldfileName.lastIndexOf("."));
			File f = new File(path, fileName);
			try {
				file.transferTo(f);
				car.setPic(fileName);
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return service.update(car) > 0;
	}
}
