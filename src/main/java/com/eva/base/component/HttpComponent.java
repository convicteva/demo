package com.eva.base.component;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Jamin on 2017/5/22.
 */
@Component
public class HttpComponent {

    public HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    public void setSessionAttr(String key, Object value) {
        this.getRequest().getSession().setAttribute(key, value);
    }

    public <T> T getSessionAttr(String key, Class<T> attrClass) {
        return (T) this.getRequest().getSession().getAttribute(key);
    }

}
