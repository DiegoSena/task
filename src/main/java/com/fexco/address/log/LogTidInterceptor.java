package com.fexco.address.log;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.MDC;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

public class LogTidInterceptor extends HandlerInterceptorAdapter {
    private static final String TID_HEADER = "x-tid";
    private static final String API_RESOURCE = "fexco-addressapi";

    public LogTidInterceptor() {
    }

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        MDC.clear();
        String tid = request.getHeader(TID_HEADER);
        if(StringUtils.isEmpty(tid)) {
            tid = API_RESOURCE+"-"+UUID.randomUUID().toString();
        }

        LogHelper.setCurrentTID(tid);
        response.addHeader(TID_HEADER, tid);
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        LogHelper.setCurrentTID(null);
    }
}