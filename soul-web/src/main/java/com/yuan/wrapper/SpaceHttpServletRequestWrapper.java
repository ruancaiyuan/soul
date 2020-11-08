package com.yuan.wrapper;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


public class SpaceHttpServletRequestWrapper extends HttpServletRequestWrapper {

    private Map<String, String[]> params = new HashMap<>();


    public SpaceHttpServletRequestWrapper(HttpServletRequest request) {
        // 将request交给父类，以便于调用对应方法的时候，将其输出
        super(request);
        Map<String, String[]> requestMap = request.getParameterMap();
        this.params.putAll(requestMap);
        this.modifyParameterValues();
    }

    //将parameter的值去除空格后重写回去
    private void modifyParameterValues() {
        Set<String> set = params.keySet();
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            String key = it.next();
            String[] values = params.get(key);
            values[0] = values[0].trim();
            params.put(key, values);
        }
    }

    private static Map<String, Object> modifyParams(String json) {
        Map<String, Object> params = JSON.parseObject(json);
        Map<String, Object> maps = new HashMap<>(params.size());
        for (String key : params.keySet()) {
            Object obj = params.get(key);
            if (null == obj) continue;
            if ("java.lang.String".equals(obj.getClass().getName())) {
                obj = obj.toString().trim();
                String str = (String) obj;
                if (StringUtils.isBlank(str)) {
                    continue;
                }
            }
            maps.put(key, obj);
        }
        return maps;
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        ServletInputStream stream = super.getInputStream();
        //非json类型，直接返回
        if (super.getHeader(HttpHeaders.CONTENT_TYPE) == null || !super.getHeader(HttpHeaders.CONTENT_TYPE).equalsIgnoreCase(MediaType.APPLICATION_JSON_VALUE)) {
            return stream;
        }
        //为空，直接返回
        String json = IOUtils.toString(stream, StandardCharsets.UTF_8);
        if (StringUtils.isEmpty(json)) return stream;
        Map<String, Object> map = modifyParams(json);
        ByteArrayInputStream bis = new ByteArrayInputStream(JSON.toJSONString(map).getBytes(StandardCharsets.UTF_8));
        return new MyServletInputStream(bis);
    }

    //获取参数值
    @Override
    public String[] getParameterValues(String name) {//同上
        return params.get(name);
    }

    //将parameter的值去除空格后重写回去
    @Override
    public String getParameter(String name) {
        String[] values = params.get(name);
        if (values == null || values.length == 0) return null;
        return values[0];
    }

    @EqualsAndHashCode(callSuper = true)
    @Data
    static class MyServletInputStream extends ServletInputStream {
        private ByteArrayInputStream bis;

        MyServletInputStream(ByteArrayInputStream bis) {
            this.bis = bis;
        }

        @Override
        public boolean isFinished() {
            return true;
        }

        @Override
        public boolean isReady() {
            return true;
        }

        @Override
        public void setReadListener(ReadListener readListener) {
        }

        @Override
        public int read() throws IOException {
            return bis.read();
        }

    }

}
