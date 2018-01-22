package com.tps.device_management.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tps.device_management.dto.CourseDTO;
import com.tps.device_management.entities.Course;
import com.tps.device_management.mapper.CourseMapping;
import com.tps.device_management.repositories.CourseRepository;


@Controller
@RequestMapping("/courses")
public class CourseController {
	@Autowired
	private CourseRepository courseRepository;

	@RequestMapping(method = RequestMethod.GET)
	public String courses(ModelMap model) {
		model.addAttribute("courses", courseRepository.findAll());
		return "courses";
	}

	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public String addCourse(@PathVariable("id") int id, ModelMap model) {
		courseRepository.delete(id);
		return "redirect:/courses";
	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String addCourse(ModelMap model) {
		model.addAttribute("course", new CourseDTO());
		return "course";
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String addCourse(@ModelAttribute("course") CourseDTO courseDTO, ModelMap model) {
		Course course = CourseMapping.INSTANCE.CoursDTOToEntity(courseDTO);
		Course c = courseRepository.save(course);
		if(null != c) {
			model.addAttribute("message", "A course added");
			model.addAttribute("course", c);
		} else {
			model.addAttribute("message", "Please input again");
			model.addAttribute("course", courseDTO);
		}
		return "course";
	}

	@RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
	public String editCourse(@PathVariable("id") int id, ModelMap model) {
		model.addAttribute("course", courseRepository.findOne(id));
		return "course";
	}

	@RequestMapping(value = "edit", method = RequestMethod.POST)
	public String editStudent(@ModelAttribute("course") Course course, ModelMap model) {
		Course cs = courseRepository.save(course);
		if(null != cs) {
			model.addAttribute("message", "Update success");
			model.addAttribute("course", courseRepository.findOne(cs.getId()));
		} else {
			model.addAttribute("message", "Update failure");
			model.addAttribute("course", course);
		}
		return "course";
	}
}
