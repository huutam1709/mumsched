package mum.swe.mumsched.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mum.swe.mumsched.service.EntryService;
import mum.swe.mumsched.model.Entry;


@RestController
@RequestMapping({"/entries"})
public class EntryRestController {
	
	@Autowired
	EntryService service;
	
	@RequestMapping("/")
	public List<Entry> findAll() {
		List<Entry> entyList = service.getList();
		return entyList;
	}
}
