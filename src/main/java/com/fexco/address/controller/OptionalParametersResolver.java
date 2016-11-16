package com.fexco.address.controller;

import com.fexco.address.model.OptionalParameters;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * Created by Denize on 15/11/2016.
 */
public class OptionalParametersResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getNestedParameterType().equals(OptionalParameters.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        return OptionalParameters.builder().
                lines(getParameter(webRequest, "lines")).
                include(getParameter(webRequest, "include")).
                exclude(getParameter(webRequest, "exclude")).
                addtags(getParameter(webRequest, "addtags")).
                identifier(getParameter(webRequest, "identifier")).
                callback(getParameter(webRequest, "callback")).
                page(getParameter(webRequest, "page")).build();
    }

    private String getParameter(NativeWebRequest webRequest, String parameterName) {
        return webRequest.getParameter(parameterName) != null ? webRequest.getParameter(parameterName) : null;
    }
}
