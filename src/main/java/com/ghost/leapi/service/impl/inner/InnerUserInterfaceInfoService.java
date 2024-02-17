package com.ghost.leapi.service.impl.inner;

import com.ghost.leapi.service.UserInterfaceInfoService;
import com.ghost.leapicommon.service.InnerUserInterfaceService;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

/**
 * @author 乐小鑫
 * @version 1.0
 * @Date 2024-02-11-22:23
 */
@DubboService
public class InnerUserInterfaceInfoService implements InnerUserInterfaceService {

    @Resource
    private UserInterfaceInfoService userInterfaceInfoService;

    /**
     * 统计接口调用次数
     * @param interfaceInfoId
     * @param userId
     * @return
     */
    @Override
    public boolean invokeCount(long interfaceInfoId, long userId) {
        return userInterfaceInfoService.invokeCount(interfaceInfoId, userId);
    }
}
