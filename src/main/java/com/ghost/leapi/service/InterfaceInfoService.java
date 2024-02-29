package com.ghost.leapi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ghost.leapi.common.BaseResponse;
import com.ghost.leapi.model.dto.interfaceinfo.InterfaceInfoInvokeRequest;
import com.ghost.leapiclientsdk.client.LeAPIClient;
import com.ghost.leapicommon.model.entity.InterfaceInfo;

import javax.servlet.http.HttpServletRequest;

/**
* @author 20890
* @description 针对表【interface_info(接口信息)】的数据库操作Service
* @createDate 2024-01-28 16:05:31
*/
public interface InterfaceInfoService extends IService<InterfaceInfo> {

    void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add);

//    BaseResponse<Object> invokeInterfaceById(InterfaceInfoInvokeRequest interfaceInfoInvokeRequest, HttpServletRequest request);

//    String getResultByInterfaceId(Long id, String userRequestParams, LeAPIClient apiClient);
}
