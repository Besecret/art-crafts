package com.personal.works.api;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

/**
 * 会员api
 * @author w.d
 */

@RestController
@RequestMapping("/api/member")
@Api(tags = "用户系统-用户管理")
public class MemberApi {

    @RequestMapping(value = "/getMember", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "更新手机号", notes = "更新手机号接口")
    public String updateMoblie(Long userId) {

        return "success";

    }


}
