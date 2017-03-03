package com.yh.test.application.freemarker.directive;

import com.yh.test.application.freemarker.utils.FreemarkerUtils;
import freemarker.core.Environment;
import freemarker.template.*;

import java.io.IOException;
import java.util.Map;

/**
 * Class Name :
 * Description:
 * @author dell
 * Date:  2017/3/3.
 */
public class AreaNameDirective implements TemplateDirectiveModel {


    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body) throws TemplateException, IOException {
        if (params.isEmpty()) {
            throw new TemplateModelException("This directive doesn't allow parameters.");
        }
        if (params == null || params.size() == 0) {
            throw new TemplateException("params can not be empty", env);
        }
        if (loopVars.length != 0) {
            throw new TemplateModelException("This directive doesn't allow loop variables.");
        }
        Long areaId = FreemarkerUtils.getParameter("areaId",Long.class, params);
        if(areaId == null){
            throw new TemplateException("params error ", env);
        }
        String areaName="";
        if(areaId ==1 ){
            areaName ="上海";
        }
        env.setVariable("myAreaName",env.getObjectWrapper().wrap(areaName));
        body.render(env.getOut());
    }
}
