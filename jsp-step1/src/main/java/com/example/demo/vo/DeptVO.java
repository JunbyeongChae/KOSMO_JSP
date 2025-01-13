package com.example.demo.vo;

import lombok.Data;

@Data
public class DeptVO {
    private int deptno;//컬럼명 deptno
    private String dname;//컬럼명 dname
    private String loc;//컬럼명 loc
}
// int(4byte), long(8byte) -  number(5) : 99999
// float(4byte), double(8byte) -  number(7,2) : 99999,99
