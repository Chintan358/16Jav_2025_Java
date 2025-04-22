package com.example.demo.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;
import jakarta.validation.Valid;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/")
	public String index(Model model)
	{
		model.addAttribute("user", new User());
		model.addAttribute("users", userService.allusers());
		return "index";
	}
	
	@PostMapping("/adduser")
	public String addUser(@Valid @ModelAttribute("user") User user,@RequestParam("file") Part file, BindingResult br,Model model,HttpServletRequest req)
	{
		String img = null;
		if(user.getId()>0)
		{
			img = userService.UserById(user.getId()).getImage();
			
		}
		
	
		//String filename = Paths.get(file.getOriginalFilename()).toString();
		String filename = Paths.get(file.getSubmittedFileName()).getFileName().toString();
		String path = req.getServletContext().getRealPath("")+File.separator+"Image";
		
		File f = new File(path);
		if(!f.exists())
		{
			f.mkdir();
		}
		
		try {
			file.write(path+File.separator+filename);
//			 Files.copy(file.getInputStream(), Paths.get(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
		
		if(br.hasErrors())	 {
			
			model.addAttribute("users", userService.allusers());
			return "index";
		}
		else
		{
		user.setImage(filename);
		userService.addOrUpdateUser(user);
		if(user.getId()>0)
		{
			File fis = new File(path+File.separator+img);
			if(fis.exists())
			{
				fis.delete();
			}
		}
		
		
		return "redirect:/";
		}
		}
		
	
	
	@GetMapping("/delete")
	public String deleteUser(@RequestParam("uid") int uid,HttpServletRequest req)
	{
		String img = userService.UserById(uid).getImage();
		userService.deleteUser(uid);
		
		File file = new File(req.getServletContext().getRealPath("")+File.separator+"Image"+File.separator+img);
		if(file.exists())
		{
			file.delete();
		}
		return "redirect:/";
	}
	
	@GetMapping("/edit")
	public String userByid(@RequestParam("uid") int uid, Model model)
	{
		model.addAttribute("user",userService.UserById(uid));
		model.addAttribute("users", userService.allusers());
		return "index";
	}
}
