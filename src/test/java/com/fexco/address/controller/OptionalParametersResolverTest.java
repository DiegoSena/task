package com.fexco.address.controller;

import com.fexco.address.model.OptionalParameters;
import org.junit.Test;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.ServletWebRequest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Denize on 15/11/2016.
 */
public class OptionalParametersResolverTest {

    @Test
    public void test_setting_optionalParameters() throws Exception {
        OptionalParametersResolver optionalParametersResolver = new OptionalParametersResolver();
        NativeWebRequest nativeWebRequest = mock(NativeWebRequest.class);
        when(nativeWebRequest.getParameter("lines")).thenReturn("3");
        when(nativeWebRequest.getParameter("include")).thenReturn("blabla");
        when(nativeWebRequest.getParameter("exclude")).thenReturn("blabla");
        when(nativeWebRequest.getParameter("callback")).thenReturn("myfunction");
        when(nativeWebRequest.getParameter("addtags")).thenReturn("mytag");
        when(nativeWebRequest.getParameter("identifier")).thenReturn("myidentifier");
        when(nativeWebRequest.getParameter("page")).thenReturn("2");

        OptionalParameters optionalParameters = (OptionalParameters) optionalParametersResolver.resolveArgument(null, null, nativeWebRequest, null);
        assertEquals("3", optionalParameters.getLines());
        assertEquals("blabla", optionalParameters.getInclude());
        assertEquals("blabla", optionalParameters.getExclude());
        assertEquals("myfunction", optionalParameters.getCallback());
        assertEquals("mytag", optionalParameters.getAddtags());
        assertEquals("myidentifier", optionalParameters.getIdentifier());
        assertEquals("2", optionalParameters.getPage());
    }

    @Test
    public void test_setting_optionalParameters_with_no_parameters() throws Exception {
        OptionalParametersResolver optionalParametersResolver = new OptionalParametersResolver();
        NativeWebRequest nativeWebRequest = mock(NativeWebRequest.class);
        when(nativeWebRequest.getParameter(anyString())).thenReturn(null);

        OptionalParameters optionalParameters = (OptionalParameters) optionalParametersResolver.resolveArgument(null, null, nativeWebRequest, null);
        assertNull(optionalParameters.getLines());
        assertNull(optionalParameters.getInclude());
        assertNull(optionalParameters.getExclude());
        assertNull(optionalParameters.getCallback());
        assertNull(optionalParameters.getAddtags());
        assertNull(optionalParameters.getIdentifier());
        assertNull(optionalParameters.getPage());
    }
}
