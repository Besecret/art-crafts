package com.personal.works.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * member entity
 * member 映射
 * @author w.d
 */

@Setter
@Getter
@ToString
public class MemberEntity implements Serializable {


    private static final long serialVersionUID = -1154413280289730395L;

    private  int id ;

    private String name;



}
