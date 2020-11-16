package com.yuan.util;

import cn.hutool.core.util.ObjectUtil;
import com.yuan.exception.BusinessException;

//hutool代碼的封裝
public class ObjectUtils {

    //对象是否为空
    public static void isNull(Object o, String msg) {
        boolean aNull = ObjectUtil.isNull(o);
        if (aNull == true) {
            throw new BusinessException(msg);
        }
    }


}
