/*
 * Project Name: xyl-core
 * File Name: FreemarkerUtils.java
 * Class Name: FreemarkerUtils
 *
 * Copyright 2014 Hengtian Software Inc
 *
 * Licensed under the Hengtiansoft
 *
 * http://www.hengtiansoft.com
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.yh.test.application.freemarker.utils;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.beanutils.ConvertUtilsBean;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.converters.ArrayConverter;
import org.apache.commons.beanutils.converters.DateConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.util.Assert;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;


import freemarker.core.Environment;
import freemarker.template.*;
import freemarker.template.utility.DeepUnwrap;

/**
 * Utils - Freemarker.
 * 
 * @author Hengtiansoft Team
 * @version 1.0_beta
 */
@SuppressWarnings("unchecked")
public final class FreemarkerUtils {


	/**
	 * 获取参数.
	 *
	 * @param name
	 *            名称
	 * @param type
	 *            类型
	 * @param params
	 *            参数
	 * @return 参数,若不存在则返回null
	 */
	public static <T> T getParameter(String name, Class<T> type, Map<String, TemplateModel> params)
			throws TemplateModelException {
		TemplateModel templateModel = params.get(name);
		if (templateModel == null) {
			return null;
		}
		ConvertUtilsBean cub = new ConvertUtilsBean();
		Object value = DeepUnwrap.unwrap(templateModel);
		return (T) cub.convert(value, type);
	}


}
