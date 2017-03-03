package com.yh.test.application.freemarker.configuration;

import ch.qos.logback.classic.gaffer.PropertyUtil;
import com.yh.test.application.freemarker.directive.AreaNameDirective;
import com.yh.test.application.freemarker.method.AreaNameMethod;
import freemarker.template.utility.XmlEscape;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.bind.PropertySourceUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.util.CollectionUtils;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerView;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Class Name :
 * Description:
 * @author dell
 * Date:  2017/2/24.
 */
@Configuration
@ConfigurationProperties(prefix = "spring.freemarker")
public class FreemarkerConfig {

    private Map<String, String> settings = new HashMap();
    private String templateLoaderPath;
    private Map<String, Object> variables = new HashMap();

    @Bean
    public FreeMarkerConfigurer freeMarkerConfigurer() {
        Properties p = null;
        if(!CollectionUtils.isEmpty(settings.keySet())){
            p = new Properties();
            for(String key:settings.keySet()){
                p.put(key,settings.get(key));
            }
        }

        FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
        configurer.setTemplateLoaderPath(templateLoaderPath);
        configurer.setFreemarkerSettings(p);
        configurer.setFreemarkerVariables(variables);
        XmlEscape xe = new XmlEscape();
        variables.put("xml_escape",xe);
        AreaNameDirective and = new AreaNameDirective();
        variables.put("areaName",and);
        AreaNameMethod anm = new AreaNameMethod();
        variables.put("areaNameMethod",anm);
        return configurer;
    }

    @Bean
    public FreeMarkerViewResolver productFreemarkerConfiguartion(){
        FreeMarkerViewResolver fmvr = new FreeMarkerViewResolver();
        fmvr.setViewClass(FreeMarkerView.class);
        fmvr.setOrder(0);
        fmvr.setSuffix(".ftl");
        fmvr.setContentType("text/html; charset=utf-8");
        return fmvr;
    }

    public Map<String, String> getSettings() {
        return settings;
    }

    public void setSettings(Map<String, String> settings) {
        this.settings = settings;
    }

    public String getTemplateLoaderPath() {
        return templateLoaderPath;
    }

    public void setTemplateLoaderPath(String templateLoaderPath) {
        this.templateLoaderPath = templateLoaderPath;
    }

    public Map<String, Object> getVariables() {
        return variables;
    }

    public void setVariables(Map<String, Object> variables) {
        this.variables = variables;
    }
}
