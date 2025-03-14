package com.revature.project1;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.fasterxml.jackson.core.Base64Variant;
import com.revature.project1.Entities.Account;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Project1Application {

	public static void main(String[] args) {
		SpringApplication.run(Project1Application.class, args);

	}

}
