package edu.mum.eai.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import edu.mum.eai.model.StudentMessage;
import mum.swe.mumsched.model.*;

@Service
public class AmqpStudentServiceImpl implements AmqpStudentService {

    public void publish(Student student) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("/integration/amqp-context.xml");
		RabbitTemplate rabbitTemplate = (RabbitTemplate) context.getBean("directStudentTemplate");
		
		StudentMessage studentMsg = new StudentMessage();
		studentMsg.setId(student.getId());
		studentMsg.setEmail(student.getUser().getUsername());
		studentMsg.setEntryName(student.getEntry().getName());
		studentMsg.setFirstName(student.getUser().getFirstName());
		studentMsg.setLastName(student.getUser().getLastName());
		
		rabbitTemplate.convertAndSend(studentMsg);
		context.close();
    }
}
