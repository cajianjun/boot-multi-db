package com.test.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {

	
    @Autowired
    @Qualifier("primaryJdbcTemplate")
    protected JdbcTemplate primaryJdbcTemplate;
    
    @Autowired
    @Qualifier("secondaryJdbcTemplate")
    protected JdbcTemplate secondaryJdbcTemplate;

	@Override
	public void run(String... args) throws Exception {
		String sql1 = "show databases;";
		List<String> source1 = 
				primaryJdbcTemplate.queryForList(sql1,String.class);
		String sql2 = "show databases;";
		List<String> source2 = 
				secondaryJdbcTemplate.queryForList(sql2,String.class);
		System.out.println("source1 printing--------------------------->");
		for(String s:source1) {
			System.out.println(s);
		}
		System.out.println("source2 printing--------------------------->");
		for(String s:source2) {
			System.out.println(s);
		}
	}
    
	
}
