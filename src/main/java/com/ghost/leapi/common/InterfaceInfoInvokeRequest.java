package com.ghost.leapi.common;

import lombok.Data;

import java.io.Serializable;

/**
 * 接口请求参数
 */
@Data
public class InterfaceInfoInvokeRequest implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 用户请求参数
     */
    private String userRequestParams;

    private static final long serialVersionUID = 1L;
}