package com.ghost.leapi.service;

import com.ghost.leapi.model.entity.UserInterfaceInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 20890
* @description 针对表【user_interface_info(用户调用接口关系)】的数据库操作Service
* @createDate 2024-02-04 15:57:52
*/
public interface UserInterfaceInfoService extends IService<UserInterfaceInfo> {
    /**
     * 校验用户接口调用信息
     * @param userInterfaceInfo
     * @param add
     */
    void validUserInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean add);

    /**
     * 统计接口调用次数
     * @param interfaceInfoId 被调用的接口 id
     * @param userId 调用接口的用户 id
     * @return
     */
    boolean invokeCount(Long interfaceInfoId, Long userId);
}
