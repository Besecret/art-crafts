package com.personal.works.controller;

import com.alibaba.fastjson.JSONObject;
import com.personal.works.entity.MemberEntity;
import com.personal.works.service.MemberService;
import com.personal.works.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 会员controller
 *
 * @author w.d
 */

@Controller
@RequestMapping("/member")
@Slf4j
public class MemberController {


    @Resource
    private MemberService memService;


    /**
     * 会员全查询，redis缓存
     *
     * @param param 入参数
     * @return resultVO
     */

    @RequestMapping(value = "/members", method = RequestMethod.GET)
    @ResponseBody
    @Cacheable(cacheNames = "member", key = "'work'", unless = "#result.code == false ")
    public ResultVO<MemberEntity> queryMember(@RequestBody String param) {

        JSONObject requestMap = JSONObject.parseObject(param);
        log.info(" 会员查询入参数 param ->" + requestMap);
        //全查询
        ResultVO<MemberEntity> resultVO = new ResultVO();
        try {
            List<MemberEntity> list = memService.queryMember(new MemberEntity());
            resultVO = resultVO.sucess("查询成功", list);
        } catch (Exception e) {
            log.error("查询失败");
            resultVO = resultVO.fail("查询失败");
        }
        return resultVO;
    }

    /**
     * 新增会员
     *
     * @param param 会员信息
     * @return resultVO
     */
    @RequestMapping(value = "/member", method = RequestMethod.POST)
    @ResponseBody
    @CachePut(cacheNames = "member", key = "'work'", unless = "#result.code == false ")
    public ResultVO<MemberEntity> addMember(@RequestBody String param) {

        JSONObject requestMap = JSONObject.parseObject(param);
        log.info(" 会员新增入参数 param ->" + requestMap);
        ResultVO<MemberEntity> resultVO = new ResultVO();

        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setName(requestMap.getString("name"));

        int num = memService.addMember(memberEntity);
        if (num > 0) {
            log.info("新增成功 !");

            List<MemberEntity> list = memService.queryMember(new MemberEntity());
            resultVO = resultVO.sucess("ok", list);

        } else {
            log.info("新增失败 !");
            resultVO = resultVO.fail(" insert fail !");

        }
        return resultVO;
    }


    /**
     * 使用会员id，查询会员
     *
     * @param memId 会员id
     * @return resultVO
     */
    @RequestMapping(value = "/member/{memId}", method = RequestMethod.GET)
    @ResponseBody
    @Cacheable(cacheNames = "member", key = "#memId", unless = "#result.code == false ")
    public ResultVO<MemberEntity> queryMemberById(@PathVariable("memId") int memId) {

        log.info(" 会员查询入参数 param ->" + memId);
        ResultVO<MemberEntity> resultVO = new ResultVO();
        MemberEntity member = new MemberEntity();
        member.setId(memId);
        try {

            List<MemberEntity> list = memService.queryMember(member);
            if (list.isEmpty()) {

                resultVO = resultVO.fail("不存在此用户!");
            } else {

                resultVO = resultVO.sucess("ok", list);
            }

        } catch (Exception e) {
            log.error("查询失败!");
            resultVO = resultVO.fail("查询失败!");
        }
        return resultVO;
    }
}
