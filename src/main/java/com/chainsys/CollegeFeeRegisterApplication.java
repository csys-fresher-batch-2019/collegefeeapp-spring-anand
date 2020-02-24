package com.chainsys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@ServletComponentScan("com.chainsys")
public class CollegeFeeRegisterApplication {

	public static void main(String[] args) {
		SpringApplication.run(CollegeFeeRegisterApplication.class, args);
	}

}
