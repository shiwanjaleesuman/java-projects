/**
 * 
 */
package com.practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Shivy
 *
 */
@Controller
public class HomeController 
{
	@RequestMapping("/")
	public String homecalling()
	{
		return "home";
	}
	
	@RequestMapping("/add")
	public String add(@RequestParam("num1") int n1, @RequestParam("num2") int n2, Model m)
	{
		int res = n1+n2;
		m.addAttribute("result", res);
		return "result";
	}
	
//	@RequestMapping("/user")
//	public String addUser(Model m, User user)
//	{
//		serviceDao.addUser(user);
//		m.addAttribute("users", user);
//		
//		return "result";
//	}
	

//    @RequestMapping("/users")
//    public String home(Model model) {
//         model.addAttribute("users", userRepo.findAll());
//         return "index";
//    }
}
