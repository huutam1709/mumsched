package edu.mum.eai.service;

import mum.swe.mumsched.model.Student;

public interface AmqpStudentService {
    public void publish(Student student);

}
