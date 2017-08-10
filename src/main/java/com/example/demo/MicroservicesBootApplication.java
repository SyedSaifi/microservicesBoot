package com.example.demo;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import com.example.demo.dao.TeamDao;
import com.example.demo.domain.Player;
import com.example.demo.domain.Team;

@SpringBootApplication
public class MicroservicesBootApplication extends SpringBootServletInitializer{

	/**
	 * Build as JAR
	 */
	public static void main(String[] args) {
		SpringApplication.run(MicroservicesBootApplication.class, args);
	}
	
	/**
	 * Build as WAR
	 */

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(MicroservicesBootApplication.class);
	}
	
	
	@PostConstruct
	public void init() {
		Player p1 = new Player("Lukaku", "24");
		Player p2 = new Player("Zlatan", "35");
		
		Set<Player> players = new HashSet<>();
		players.add(p1);
		players.add(p2);
		
		Team team = new Team("ManUTD", "Old Trafford", players);
		teamdao.save(team);
	}
	
	@Autowired
	TeamDao teamdao;
}
