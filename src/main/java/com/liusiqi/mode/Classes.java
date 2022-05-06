package com.liusiqi.mode;

import lombok.Data;

import java.util.Date;

@Data
public class Classes {

    private String classId;

    private String className;

    private String teacherId;

    private String delflag;

    private String createdById;

    private Date createdTime;

    private String modifiedById;

    private Date modifiedTime;

}
