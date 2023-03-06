package com.example.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.Models.Student;
import com.example.demo.Repositories.StudentRepo;

@Service
public class ApiService {
@Autowired
	StudentRepo repository;
	
	public Optional<Student>Student(int id){
		return repository.findById(id);
	}
	public String updateDetails(Student stu) {
		repository.save(stu);
		return "updated";
	}
	public String deleteDetails(int id)
	{
		repository.deleteById(id);
		return "Id deleted";
	}
	public List<Student>setPages(@PathVariable int offset,@PathVariable int pageSize)
	{
		Page<Student>page=repository.findAll(PageRequest.of(offset, pageSize));
		return page.getContent();
	}
	
}
