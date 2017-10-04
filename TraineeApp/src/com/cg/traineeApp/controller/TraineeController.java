package com.cg.traineeApp.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
		ModelAndView mAndV = new ModelAndView("index");
		return mAndV;
	}
	
	@RequestMapping("/getOptions.do")
	public ModelAndView getOptions(){
		ModelAndView mAndV = new ModelAndView("Options");
		return mAndV;
	}
	
	
	@RequestMapping("/getEntryPage.do")
	public ModelAndView getEntryPage(){
		ModelAndView mAndV = new ModelAndView("EnterDetails");
		Trainee trainee = new Trainee(); //command object
		mAndV.addObject("trainee", trainee);
		return mAndV;
	}
	
	@RequestMapping(value="/insert.do", method=RequestMethod.POST)
	public String submitTraineeDetails(@ModelAttribute("trainee") Trainee trainee, Model mAndV) throws TraineeException{
		System.out.println(trainee);
		 service.insertNewTrainee(trainee);
		//ModelAndView mAndV = new ModelAndView();
		mAndV.addAttribute("trainee", trainee);
		//mAndV.addAttribute("pageHead", "Successful joining of employee");
		return "SuccInsertion";	
	}
	
	
	
	
	@RequestMapping("/getRetrievePage.do")
	public ModelAndView getRetrievePage(){
		ModelAndView mAndV = new ModelAndView("RetrieveSingle");
		return mAndV;
	}
	
	
	
	
	@RequestMapping("/getTraineeSingle.do")
	public ModelAndView getTraineeSingle(@RequestParam("id") int empNo) throws TraineeException{
		Trainee trainee = service.getTraineeOnId(empNo);
		ModelAndView mAndV = new ModelAndView();
		mAndV.addObject("trainee", trainee);
		mAndV.setViewName("RetrieveSingle");
		return mAndV;	
	}
	
	@RequestMapping("/getTraineeList.do")
	public ModelAndView getTraineeList() throws TraineeException{
		
		List<Trainee> traineeList = service.getTraineeList();
		ModelAndView mAndV = new ModelAndView();
		mAndV.addObject("traineeList", traineeList);
		mAndV.setViewName("TraineeList");
		return mAndV;
		
	}
	
	@RequestMapping("/getDeleteId.do")
	public ModelAndView getDeleteId(@RequestParam("id") int empNo) throws TraineeException{
		Trainee trainee = service.getTraineeOnId(empNo);
		ModelAndView mAndV = new ModelAndView();
		mAndV.addObject("trainee", trainee);
		mAndV.setViewName("Delete");
		return mAndV;	
	}
	
	
	@RequestMapping("/getDeletePage.do")
	public ModelAndView getDeletePage(){
		ModelAndView mAndV = new ModelAndView("Delete");
		return mAndV;
	}
	
	
	@RequestMapping("/delete.do")
	public String deleteTrainee(@RequestParam("id") int id) throws TraineeException{
	service.deleteTrainee(id);
	return "Deleted";
	
	}
	
	
	@RequestMapping("/getUpdatePage.do")
	public ModelAndView getUpdatePage(){
		ModelAndView mAndV = new ModelAndView("Update");
		return mAndV;
	}
	
	
	
	
	@RequestMapping("/update.do")
	public ModelAndView getUpdate(@RequestParam("id") int id, @RequestParam("name") String name, @RequestParam("loc") String loc, @RequestParam("domain") String domain) throws TraineeException{
		service.updateTrainee(id, name, domain, loc);
		ModelAndView mAndV = new ModelAndView();
		mAndV.setViewName("Updated");
		return mAndV;	
	}
	
	
	@RequestMapping("/getUpdateId.do")
	public ModelAndView getUpdateId(@RequestParam("id") int empNo) throws TraineeException{
		Trainee trainee = service.getTraineeOnId(empNo);
		ModelAndView mAndV = new ModelAndView();
		mAndV.addObject("trainee", trainee);
		mAndV.setViewName("Update");
		return mAndV;	
	}
	
}
