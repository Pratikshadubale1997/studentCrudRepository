package com.hefshine.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class MyController {
	
	@Autowired
	studentRepo repo;
	
	@PostMapping("add")
		public Student save(@RequestBody Student stud) {
		Student s=repo.save(stud);
			return s;
		}
	
	@GetMapping("findAll")
	    public List<Student> findALLStudent(){
		List<Student> listOfStudent=repo.findAll();
		return listOfStudent;
	}
	
	@RequestMapping("search{id}")
		public Student findStudent(@PathVariable int id) {
		Student s=repo.findById(id).get();
		return s;
	}
	
	@PutMapping("update")
		public Student updateStuudent(@RequestBody Student stud) {
		Student s=repo.save(stud);
		return s;
	}
	
	@DeleteMapping("delete{id}")
		public void deleteStudent(@PathVariable int id) {
		repo.deleteById(id);
		System.out.println("Done Delete Operation");
		
		
	}
	
	
	}


