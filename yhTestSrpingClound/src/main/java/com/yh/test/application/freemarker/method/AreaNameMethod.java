package com.yh.test.application.freemarker.method;

import freemarker.template.*;
import org.apache.commons.collections.CollectionUtils;

import java.util.List;

/**
 * Class Name :
 * Description:
 * @author dell
 * Date:  2017/3/3.
 */
public class AreaNameMethod implements TemplateMethodModelEx {

    @Override
    public Object exec(List list) throws TemplateModelException {
        if(CollectionUtils.isEmpty(list)){
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for(int i =0;i<list.size();i++){
            sb.append(list.get(i).toString()).append(",");
        }
        sb= sb.deleteCharAt(sb.length()-1);
//        TemplateNumberModel
//                return new SimpleNumber(1);
        return new SimpleScalar(sb.toString());
    }


}
