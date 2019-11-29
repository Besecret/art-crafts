package com.personal.works.service.impl;

import com.personal.works.entity.MemberEntity;
import com.personal.works.mapper.MemberMapper;
import com.personal.works.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * member service 实现
 * @author w.d
 */

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberMapper memMapper;

    @Override
    public List<MemberEntity> queryMember() {
            return memMapper.queryMember();
    }

    @Override
    public int addMember(MemberEntity member) {
        return memMapper.addMember(member);
    }
}
