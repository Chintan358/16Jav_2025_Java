package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.Student;
import com.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@GetMapping("/")
	public String index(Model model)
	{
		model.addAttribute("student",new Student());
		model.addAttribute("students", studentService.allStudents());
		return "index";
	}
	
	@PostMapping("/addStudent")
	public String addStudent(@ModelAttribute("student") Student std)
	{
		int i = studentService.addOrUpdateStudent(std);
		return "redirect:/";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("did") int did)
	{
		studentService.deleteStudent(did);
		return "redirect:/";
	}
	
	@GetMapping("/edit")
	public String edit(@RequestParam("eid") int eid,Model model)
	{
		model.addAttribute("student",studentService.studentById(eid));
		model.addAttribute("students", studentService.allStudents());
		return "index";
	}
}
