package com.example.demo;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.TeamDao;
import com.example.demo.domain.Team;

@RestController
public class MicroservivesBootController {
	@Autowired
	TeamDao teamdao;
	
	@RequestMapping("hi/{name}")
	public String sayHelloWorld(Map<String, String> model, @PathVariable String name){
		model.put("name", name);
		return "hello";
	}
	
	@RequestMapping("/team/{name}")
	public Team getTeamInfo(@PathVariable String name) {
		return teamdao.findByName(name);
	}

}
