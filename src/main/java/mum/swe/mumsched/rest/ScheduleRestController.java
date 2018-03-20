package mum.swe.mumsched.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mum.swe.mumsched.model.Schedule;
import mum.swe.mumsched.service.ScheduleService;

@RestController
@RequestMapping(path="/api/schedules")
public class ScheduleRestController {
	
	@Autowired
	private ScheduleService scheduleService;
	
	@RequestMapping("/")
	public List<Schedule> findAll(){
		System.out.println("do no thing here");
		return null;
	}
	
	@GetMapping("/view/{id}")
	public Schedule view(@PathVariable("id") Long id) {
		Schedule schedule = scheduleService.findOneById(id);
		return schedule;
	}

}
