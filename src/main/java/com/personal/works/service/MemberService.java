package com.personal.works.service;

import com.personal.works.entity.MemberEntity;

import java.util.List;


/**
 * member service
 * @author w.d
 */
public interface  MemberService {


    /**
     * 会员信息查询会员
     * @param member 会员信息
     * @return memberList
     */
    List<MemberEntity> queryMember(MemberEntity member);


    /**
     * 新增会员
     * @param member 会员信息
     * @return 数据库受影响行
     */
    int  addMember(MemberEntity member);
}
