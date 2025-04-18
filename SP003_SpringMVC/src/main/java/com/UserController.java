package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.User;
import com.service.UserService;

@Controller
public class UserController {
		
		@Autowired
		UserService userService;
	
		@RequestMapping("/reg")
		public String reg(Model model)
		{
			User user = new User();
			model.addAttribute("user", user);
			model.addAttribute("users", userService.allusers());
			return "reg";
		}
		
//		@RequestMapping(value = "/adduser", method = RequestMethod.POST)
		@PostMapping("/adduser")
		public String addUser(@ModelAttribute("user") User user)
		{
			userService.addOrUpdateUser(user);
			return "redirect:reg";
		}
		
		@GetMapping("/delete")
		public String deleteUser(@RequestParam("uid") int uid)
		{
			userService.deleteUser(uid);
			return "redirect:reg";
		}
		
		@GetMapping("/edit")
		public String updateUser(@RequestParam("uid") int uid,Model model)
		{
			User user = userService.userById(uid);
			model.addAttribute("user", user);
			model.addAttribute("users", userService.allusers());
			return "reg";
		}
}
