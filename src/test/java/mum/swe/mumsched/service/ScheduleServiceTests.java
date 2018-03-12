package mum.swe.mumsched.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import mum.swe.mumsched.enums.RoleEnum;
import mum.swe.mumsched.model.Entry;
import mum.swe.mumsched.model.Schedule;
import mum.swe.mumsched.model.User;
import mum.swe.mumsched.repository.ScheduleRepository;
import mum.swe.mumsched.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ScheduleServiceTests {

//    private FacultyRepository facultyRepository;
//    private StudentRepository studentRepository;
    
//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;

	@MockBean
    private ScheduleRepository scheduleRepository;

	@Autowired
    private ScheduleService scheduleService;
	
	@Autowired
    private EntryService entryService;
        
//	@Test
//	public void testSave()  throws Exception{
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testFindByUsername() {
//		fail("Not yet implemented");
//	}

	@Test
	public void testGenerateSchedule() throws Exception {
		Entry entry = entryService.findEntryById((long)1);
		Schedule schedule = scheduleService.generateSchedule(entry);
		schedule = scheduleService.findOneById(1);
		assertTrue(schedule.getBlockList().size()>0);
	}

//	@Test
//	public void testFindOne() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testDelete() {
//		fail("Not yet implemented");
//	}

}
