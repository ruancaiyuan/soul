package com.yuan.vo;

import com.yuan.constant.enums.ErrorCode;
import lombok.Data;

/**
 * 最终返回对象
 *
 * @param <T>
 */
@Data
public class ResultVO<T> {
    private static final int RESULT_SUCCESS = 200;

    public static int CODE_OK = RESULT_SUCCESS;
    private Integer code; //状态码；0:成功
    private String msg; //异常信息
    private T data; //数据

    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setCode(CODE_OK);
        return resultVO;
    }

    public static ResultVO success() {
        return success(null);
    }


    public static ResultVO error(String msg, Integer code) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        return resultVO;
    }


    public static ResultVO error(String msg) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(ErrorCode.SYSTEM_ERROR.getCode());
        resultVO.setMsg(msg);
        return resultVO;
    }


}