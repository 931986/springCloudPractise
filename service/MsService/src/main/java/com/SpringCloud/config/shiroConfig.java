package com.SpringCloud.config;//package com.SpringCloud.config;
//
//import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
//import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.LinkedHashMap;
//import java.util.Map;
//
//@Configuration
//public class ShiroConfig {
//
//    @Bean
//    public ShiroFilterFactoryBean getBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager){
//        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
//        bean.setSecurityManager(securityManager);
//        bean.setLoginUrl("/login.jsp");
//        Map<String,String> filterMap = new LinkedHashMap<>();
//        filterMap.put("/login","anon");
//        filterMap.put("/*","authc");
//        bean.setFilterChainDefinitionMap(filterMap);
//        return bean;
//    }
//
//    @Bean("securityManager")
//    public DefaultWebSecurityManager getSecurityManage(@Qualifier("accountRealm")AccountRealm accountRealm){
//        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
//        securityManager.setRealm(accountRealm);
//        return securityManager;
//    }
//
//    @Bean("accountRealm")
//    public AccountRealm getAccountRealm(){
//        return new BosRealm();
//    }
//}
