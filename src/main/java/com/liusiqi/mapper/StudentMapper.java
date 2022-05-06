package com.liusiqi.mapper;

import com.liusiqi.mode.Student;

import java.util.List;

/**
 * @program: mybatis-demo01
 * @description:
 * @author: liusiqi1226
 * @create: 2022-05-06 12:39
 **/
public interface StudentMapper {

    void insertStudent(Student student);

    void deleteStudent(Student student);

    void updateStudent(Student student);

    List<Student> selectAllStudent();

    Student selectById(String id);
}
