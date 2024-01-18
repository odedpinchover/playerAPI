package com.example.demo.Configuration;

import com.example.demo.parser.PlayerParser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
@EnableWebMvc
public class ProjectConfigurations extends WebMvcConfigurerAdapter
{
	@Bean
	public PlayerParser parser(){
		return new PlayerParser();
	}
}
