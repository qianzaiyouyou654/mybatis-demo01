package com.liusiqi.mode;

import lombok.Data;

import java.util.Date;

@Data
public class Student {

    private String studentId;

    private String studentName;

    private String age;

    private String classId;

    private String delflag;

    private String createdById;

    private Date createdTime;

    private String modifiedById;

    private Date modifiedTime;
}
