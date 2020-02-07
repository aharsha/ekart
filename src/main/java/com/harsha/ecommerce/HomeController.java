package com.harsha.ecommerce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.harsha.ecommerce.dao.UserDaoImpl;
import com.harsha.ecommerce.dao.UserTransaction;
import com.harsha.ecommerce.model.User;

@Controller
public class HomeController {

	@Autowired
	UserDaoImpl  userDaoImpl;
	
	
	@RequestMapping("/register")
	public ModelAndView saveUser()
{
	ModelAndView modelAndView=new ModelAndView("reg");
	User user=new User();
	
	modelAndView.addObject("usr",user);
	
	return modelAndView;
}
	
	@RequestMapping(value="/carryuser", method=RequestMethod.POST)
	public String readProductForm(@ModelAttribute("usr") User user)
	{
		
		//send user object to database
		userDaoImpl.insertUser(user);
		
		return "home";
	}
	@RequestMapping("/login")
public ModelAndView loginUser()
{
	ModelAndView  modelAndView=new ModelAndView("login");
	modelAndView.addObject("userdata",new User());
return modelAndView;
}

	@RequestMapping("/readLoginData")
	public ModelAndView readLoginData(@ModelAttribute("userdata") User  user)
	{
		//send user object to dao to check email and password
		
		
		String page=null;
		boolean result= userDaoImpl.checkUser(user);
		if(result)
		{
			page="home";
		}
		else
		{
			page="redirect:login";
		}
		ModelAndView modelAndView=new ModelAndView(page);
		return modelAndView;
	}
}
