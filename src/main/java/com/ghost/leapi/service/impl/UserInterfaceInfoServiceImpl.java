package com.ghost.leapi.service.impl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ghost.leapi.common.ErrorCode;
import com.ghost.leapi.exception.BusinessException;
import com.ghost.leapi.service.UserInterfaceInfoService;
import com.ghost.leapi.mapper.UserInterfaceInfoMapper;
import com.ghost.leapicommon.model.entity.UserInterfaceInfo;
import org.springframework.stereotype.Service;

/**
* @author 20890
* @description 针对表【user_interface_info(用户调用接口关系)】的数据库操作Service实现
* @createDate 2024-02-04 15:57:52
*/
@Service
public class UserInterfaceInfoServiceImpl extends ServiceImpl<UserInterfaceInfoMapper, UserInterfaceInfo>
    implements UserInterfaceInfoService{
    @Override
    public void validUserInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean add) {
        if (userInterfaceInfo == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        Long id = userInterfaceInfo.getInterfaceInfoId();
        // 创建时，所有参数必须非空
        if (add) {
            if (id <= 0 || userInterfaceInfo.getUserId() <= 0) {
                throw new BusinessException(ErrorCode.PARAMS_ERROR);
            }
        }
        if (userInterfaceInfo.getLeftNum() <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "接口剩余调用次数为 0");
        }
    }

    @Override
    public boolean invokeCount(Long interfaceInfoId, Long userId) {
        // 校验接口和用户
        if (interfaceInfoId <= 0 || userId <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "接口或用户不存在");
        }
        // TODO 校验用户是否还有剩余调用次数
        QueryWrapper<UserInterfaceInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userId", userId);
        queryWrapper.eq("interfaceInfoId", interfaceInfoId);
        UserInterfaceInfo one = this.getOne(queryWrapper);
        if (one == null) {// 第一次调用某个接口要新增用户 - 接口关系，而不是 update
            UserInterfaceInfo userInterfaceInfo = new UserInterfaceInfo();
            userInterfaceInfo.setUserId(userId);
            userInterfaceInfo.setInterfaceInfoId(interfaceInfoId);
            userInterfaceInfo.setTotalNum(1);
            return this.save(userInterfaceInfo);
        } else {
            Integer handledTotalNum = one.getTotalNum() + 1;
            one.setTotalNum(handledTotalNum);
            return this.updateById(one);
            // 接口被调用时，剩余次数 - 1，总调用次数 + 1
//            UpdateWrapper<UserInterfaceInfo> updateWrapper = new UpdateWrapper<>();
//            updateWrapper.eq("interfaceInfoId", interfaceInfoId);
//            updateWrapper.eq("userId", userId);
//        updateWrapper.setSql("leftNum = leftNum - 1, totalNum = totalNum + 1");
//            updateWrapper.setSql("totalNum = totalNum + 1");// 目前免费开放，不限制调用次数
//            return this.update(updateWrapper);
        }
    }
}




