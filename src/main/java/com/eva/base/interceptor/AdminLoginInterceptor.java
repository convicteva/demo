package com.eva.base.interceptor;

import com.eva.base.properties.BaseProperties;
import com.eva.base.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Jamin.Ma on 2017/5/21.
 */
@Component
public class AdminLoginInterceptor implements HandlerInterceptor {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private BaseProperties baseProperties;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String servletPath = request.getServletPath();
        logger.info("login interceptor url:"+servletPath);

        String noAuthUrl = baseProperties.getNoAuthUrlMatch();
        if(StringUtils.isEmpty(noAuthUrl)){
            return true;
        }
        // 去除不需要过滤的URL
        String[] noAuthUrlArray = baseProperties.getNoAuthUrlMatch().split(",");
        if(validateAuthUrl(servletPath,noAuthUrlArray)){
            return true;
        }
        Object obj = request.getSession().getAttribute(baseProperties.getAdminSessionKey());
        if(obj !=null && (obj instanceof Admin) ){
            return true;
        }else{
            //如果是异步请求
            boolean ajax = StringUtils.equals("XMLHttpRequest",request.getHeader("x-requested-with"));
            if(ajax){
                response.setStatus(400);
                return false;
            }else{
                response.sendRedirect(request.getContextPath() + "/");
                return false;
            }
        }
    }

    /**
     * 验证请求路径是否拦截
     * @param path
     * @param excludeUrlArray
     * @return true 不拦截
     */
    private boolean validateAuthUrl(String path, String[] excludeUrlArray) {
        for (String url : excludeUrlArray) {
            if (StringUtils.wildcardStarMatch(url, path)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
