package com.yh.test.application.product.vo;

import java.io.Serializable;

/**
 * Class Name :
 * Description:
 * @author dell
 * Date:  2017/1/17.
 */
public class ProductVO implements Serializable {

    private static final long serialVersionUID = -928445732453552552L;

    private String name;
    private String id;
    private String serialNo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
