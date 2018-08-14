package com.frontenddemo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.demo.backenddemo.Dao.CustomerDao;
import com.demo.backenddemo.Model.Customer;

@Controller

public class IndexController {
	@Autowired
	private CustomerDao customerDao;
	@RequestMapping(value="/",method=RequestMethod.GET)
		public ModelAndView index(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView("register","command",new Customer());
		return mv;																		
}
	@RequestMapping(value="/register",method=RequestMethod.POST)
		public ModelAndView register(HttpServletRequest request,HttpServletResponse response) {
		Customer user=new Customer();
		user.setName(request.getParameter("name"));
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));
		user.setEnabled(true);
		user.setRole("ROLE_USER");
		ModelAndView mv=new ModelAndView("login");
		customerDao.save(user);
		return mv;
	}
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView mv=new ModelAndView("login","command",new Customer());
		return mv;
	}

	@RequestMapping(value="/validate",method=RequestMethod.POST)
	public ModelAndView validate(HttpServletResponse response,HttpServletRequest request) {
		String email=request.getParameter("username");
		String password=request.getParameter("password");
		Customer user=customerDao.findByEmail(email,password);
		ModelAndView mv=null;
		if(user!=null) {
		if(email.equals(user.getEmail()) && password.equals(user.getPassword())) {
			HttpSession session=request.getSession(true);
			session.setAttribute("email",email);	
			mv=new ModelAndView();
			return new ModelAndView("index","email",email);	
		}
		}
		else
		{
			mv=new ModelAndView("error");
		}
		return mv;
		
	}

	@RequestMapping(value="/error", method=RequestMethod.GET)
	public ModelAndView error() {
		ModelAndView mv=new ModelAndView("error");
		return mv;
	}
}
