package edu.mum.eai.service;

import mum.swe.mumsched.model.Section;
import mum.swe.mumsched.model.Student;

public interface AmqpSectionRegService {
    public void publish(Student student, Section section, boolean reg);
}
