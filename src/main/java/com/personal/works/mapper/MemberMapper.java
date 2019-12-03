package com.personal.works.mapper;

import com.personal.works.entity.MemberEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * member mapper
 * @author w.d
 */

@Repository
@Mapper
public interface MemberMapper {

     /**
      * 查询会员信息
      * @return member list
      */
     List<MemberEntity> queryMember(@Param("member") MemberEntity member);


     /**
      * 新增会员
      * @param member 会员信息
      * @return 数据库影响行
      */
     int addMember(@Param("member") MemberEntity member);
}
