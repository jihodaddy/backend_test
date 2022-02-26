package com.boot.ohouse;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.boot.ohouse.dao.IDrugSaveDAO;
import com.boot.ohouse.dao.IMemberDAO;

@SpringBootApplication
@ComponentScan(basePackages= {"com.boot.ohouse"})
//@ComponentScan(basePackageClasses=MainController.class)
//@ComponentScan(basePackageClasses=MemberController.class)
@MapperScan(basePackageClasses = IMemberDAO.class)
@MapperScan(basePackageClasses = IDrugSaveDAO.class)
public class SpringBootOhouseApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootOhouseApplication.class, args);
	}

}
