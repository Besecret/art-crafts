package com.personal.works.service;

import com.personal.works.entity.MemberEntity;

import java.util.List;


/**
 * member service
 * @author w.d
 */
public interface  MemberService {


    /**
     * 查询会员
     * @return memberList
     */
    List<MemberEntity> queryMember();


    /**
     *
     * @param member
     * @return
     */
    int  addMember(MemberEntity member);


}
