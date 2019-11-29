package com.personal.works.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.personal.works.entity.MemberEntity;
import com.personal.works.service.MemberService;
import com.personal.works.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 *  会员controller
 * @author w.d
 *
 */

@Controller
@RequestMapping("/member")
@Slf4j
public class MemberController {


    @Resource
    private MemberService memService;


    /**
     *  会员全查询，redis缓存
     * @param param 入参数
     * @return json
     */

    @RequestMapping("/queryMember")
    @ResponseBody
    @Cacheable(cacheNames = "member" ,key="'work'")
    public ResultVO<MemberEntity> queryMember(@RequestBody String param) {

        JSONObject requestMap = JSONObject.parseObject(param);
        log.info(" 会员查询入参数 param ->"+requestMap);

        List<MemberEntity> list =memService.queryMember();
        ResultVO<MemberEntity> resultVO = new ResultVO();
        resultVO=resultVO.sucess("ok",list);

        return resultVO;
    }


    @RequestMapping("/addMember")
    @ResponseBody
    @CachePut(cacheNames = "member" ,key="'work'",unless = "#result.code = false ")
    public ResultVO<MemberEntity> addMember(@RequestBody String param){

        JSONObject requestMap = JSONObject.parseObject(param);
        log.info(" 会员新增入参数 param ->"+requestMap);
        ResultVO<MemberEntity> resultVO = new ResultVO();

        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setName(requestMap.getString("name"));

        int num = memService.addMember(memberEntity);
        if(num >0){
            log.info("新增成功 !");

            List<MemberEntity> list =memService.queryMember();
            resultVO=resultVO.sucess("ok",list);

        }else{
            log.info("新增失败 !");

            resultVO=resultVO.fail(" insert fail !");

        }

        return resultVO;

    }
















}
