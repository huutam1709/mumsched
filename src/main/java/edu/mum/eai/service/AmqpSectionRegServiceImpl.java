package edu.mum.eai.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import edu.mum.eai.enums.ActionTypeEnum;
import edu.mum.eai.model.SectionRegMessage;
import mum.swe.mumsched.model.*;

@Service
public class AmqpSectionRegServiceImpl implements AmqpSectionRegService {

    public void publish(Student student, Section section, boolean reg) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("/integration/amqp-context.xml");		
		
		SectionRegMessage sectionRegMsg = new SectionRegMessage();
		sectionRegMsg.setStudentId(student.getId());
		sectionRegMsg.setCourseId(section.getCourse().getId());
		sectionRegMsg.setCourseName(section.getCourse().getName());
		
		RabbitTemplate rabbitTemplate = null;
		if(reg) {
			sectionRegMsg.setActionType(ActionTypeEnum.Register);
			rabbitTemplate = (RabbitTemplate) context.getBean("directSectionRegTemplate");
		} else {
			sectionRegMsg.setActionType(ActionTypeEnum.UnRegister);
			rabbitTemplate = (RabbitTemplate) context.getBean("directSectionUnRegTemplate");
		}
		
		rabbitTemplate.convertAndSend(sectionRegMsg);
		context.close();
    }

}
