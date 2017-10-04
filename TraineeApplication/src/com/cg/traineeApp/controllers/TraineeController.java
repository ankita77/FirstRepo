package com.cg.traineeApp.controllers;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cg.traineeApp.entities.Trainee;
import com.cg.traineeApp.exception.TraineeException;
import com.cg.traineeApp.service.TraineeService;


@Controller
public class TraineeController {

	@Resource
	private TraineeService service;
	
	@RequestMapping("/getHomePage.do")
	public ModelAndView getHomePage(){
		System.out.println("In controller");
		ModelAndView mAndV = new ModelAndView("index");
		return mAndV;
	}
	
	@RequestMapping(value="/submitTraineeDetails.do", method=RequestMethod.POST)
	public String submitTraineeDetails(@ModelAttribute("trainee") Trainee trainee, Model mAndV) throws TraineeException{
		System.out.println(trainee);
		 service.insertNewTrainee(trainee);
		//ModelAndView mAndV = new ModelAndView();
		mAndV.addAttribute("trainee", trainee);
		mAndV.addAttribute("pageHead", "Enter trainee details");
		
		
		return "enterDetails";	
	}
	
}
