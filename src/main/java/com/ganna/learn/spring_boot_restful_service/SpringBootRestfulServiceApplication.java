package com.ganna.learn.spring_boot_restful_service;

import com.ganna.learn.spring_boot_restful_service.employee.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@SpringBootApplication
public class SpringBootRestfulServiceApplication {

	public static void main(String[] args) {
		//SpringApplication.run(SpringBootRestfulServiceApplication.class, args);

		//IT 1 : 6000
		//IT 2 : 5000
		//HR 3 : 5000
		//HR 4: 5000

		//HR -- 10000
		//IT -- 11000

		Map<String, Integer> DepartMentWise = new HashMap<>();

		List<Employee> employeeList = List.of(new Employee(1, "IT", 6000),
				new Employee(2, "IT", 5000),
				new Employee(3, "HR", 5000),
				new Employee(4, "HR", 5000));

		Map<String, Integer> collect = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.summingInt(Employee::getSalary)));

		Set<Map.Entry<String, Integer>> entrySet = collect.entrySet();

		for (Map.Entry<String, Integer> entry : entrySet){
			System.out.println(entry.getKey()+" : "+entry.getValue());
		}
	}
}
