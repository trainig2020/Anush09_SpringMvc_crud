package com.anusha.contoller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.anusha.model.Department;
import com.anusha.service.DepartmentService;

@Controller
public class DepartmentController {
     
	 @Autowired
	 private DepartmentService departmentService;
	 
	 @RequestMapping(value = "/")
	 public ModelAndView getAllEmployees(HttpServletRequest request) {
		 System.out.println("In Controller");
		 List<Department> lstdept  = departmentService.getAllEmployees();
		 HttpSession session = request.getSession();
		 session.setAttribute("DeptList", lstdept);
		 ModelAndView modelAndView = new ModelAndView("home");
		 modelAndView.addObject("DeptList", lstdept);
		 return modelAndView;
	 }
	 
	 @RequestMapping(value = "/NewDepartment" ,method =RequestMethod.GET )
	 public ModelAndView newDepartment(HttpServletRequest request) {
		 String Register = "newform";
		 HttpSession session1 = request.getSession();
		 List<Department> lst = (List<Department>) session1.getAttribute("DeptList");
		 session1.setAttribute("DeptList", lst);
		 ModelAndView modelAndView = new ModelAndView();
		 modelAndView.addObject("Register", Register);
		 modelAndView.addObject("createdept", "newdept");
		 modelAndView.setViewName("home");
		 Department department = new Department();
		 modelAndView.addObject("department", department);
		 return modelAndView;
	 }
	 
	 @RequestMapping(value = "/CreateDepartment", method = RequestMethod.POST)
	 public ModelAndView insertDepartment(@Valid @ModelAttribute Department department,BindingResult result) {
		 
		 if ( result.hasErrors()) {
			 
		 }
		 departmentService.insertDepartment(department);
		 return new ModelAndView("redirect:/");
	 }	 
	 
	 @RequestMapping(value = "/DeleteDepartment",method = RequestMethod.GET)
	 public ModelAndView deleteDepartment(HttpServletRequest request) {
		 int deptid =Integer.parseInt(request.getParameter("DeptID"));
		 departmentService.deleteDepartment(deptid);
		 return new ModelAndView("redirect:/");
	 }
	 
	 @RequestMapping(value = "/GetDepartment",method = RequestMethod.GET)
	 public ModelAndView getDepartmentId(HttpServletRequest request) {
		int deptid =  Integer.parseInt(request.getParameter("DeptID"));
		HttpSession session2 = request.getSession();
		List<Department> lst = (List<Department>) session2.getAttribute("DeptList");
		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("DeptList", lst);
		modelAndView.addObject("departmentid", deptid);
		return  modelAndView;		
	 }
	 
}
