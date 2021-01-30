package com.vpn.website.common.configure;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.context.request.WebRequest;

import java.util.Locale;

/**
 * 请求参数处理
 *
 * @author obiteaaron
 * @since 2019/12/26
 */
@ControllerAdvice
public class WebMvcControllerAdvice {

    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest webRequest, Locale locale) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }
}
