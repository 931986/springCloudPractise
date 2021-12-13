//package com.SpringCloud.config.Interceptor;
//
//
//import org.apache.commons.lang.StringUtils;
//
//import org.springframework.http.HttpMethod;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.servlet.HandlerInterceptor;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//public class LoginInterceptor implements  HandlerInterceptor {
//    @Override
//    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
////        HttpSession session = httpServletRequest.getSession();
////        String contextPath = session.getServletContext().getContextPath();
////        String[] requireAuthPages = new String[]{
////                "index",
////        };
////        String uri = httpServletRequest.getRequestURI();
////        uri = StringUtils.remove(uri, contextPath + "/");
////        String page = uri;
////        if (judgeUser(page, requireAuthPages)) {
////            User user = (User) session.getAttribute("user");
////
////            if (user == null) {
////                httpServletResponse.sendRedirect("login");
////                return false;
////            }
////
////        }
////        return true;
////
//        if(HttpMethod.OPTIONS.toString().equals(httpServletRequest.getMethod())){
//            httpServletResponse.setStatus(HttpStatus.NO_CONTENT.value());
//            return true;
//        }
//        Subject subject= SecurityUtils.getSubject();
//        if(!subject.isAuthenticated() && !subject.isRemembered()){
//            System.out.println(subject.isRemembered());
//            System.out.println(subject.isAuthenticated());
//
//            return false;
//        }
//        return  true;
//    }
//
//
//
//
//    public boolean judgeUser(String page,String[] requiredAuthPages){
//        boolean result = false;
//        for (String requiredAuthPage : requiredAuthPages) {
//            if(StringUtils.startsWith(page, requiredAuthPage)) {
//                result = true;
//                break;
//            }
//        }
//        return result;
//
//    }
//
//}
