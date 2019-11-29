package com.personal.works.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.personal.works.comm.Constant;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;


@Data
@ToString
public class ResultVO<T> implements Serializable {


    private static final long serialVersionUID = 5355392803700698132L;


    @JsonProperty("data")
    private List<T> data;


    @JsonProperty("subCode")
    private String subCode;

    @JsonProperty("subMsg")
    private String  subMsg;

    private Boolean code;


    public ResultVO<T> sucess(String subMsg,List<T> t){

        ResultVO<T> resultVO = new ResultVO<>();
        resultVO.setSubCode(Constant.SCCUESS_CODE);
        resultVO.setSubMsg(subMsg);
        resultVO.setData(t);
        resultVO.setCode(true);
        return resultVO;

    }

    public ResultVO<T> sucess(String subMsg){

        ResultVO<T> resultVO = new ResultVO<>();
        resultVO.setSubCode(Constant.SCCUESS_CODE);
        resultVO.setSubMsg(subMsg);
        resultVO.setCode(true);
        return resultVO;
    }

    public ResultVO<T> fail(String subMsg){

        ResultVO<T> resultVO = new ResultVO<>();
        resultVO.setSubCode(Constant.ERROR_CODE);
        resultVO.setSubMsg(subMsg);
        resultVO.setCode(false);
        return resultVO;
    }



}
