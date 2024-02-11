package com.ghost.leapi.service.impl.inner;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ghost.leapi.common.ErrorCode;
import com.ghost.leapi.exception.BusinessException;
import com.ghost.leapi.mapper.InterfaceInfoMapper;
import com.ghost.leapicommon.model.entity.InterfaceInfo;
import com.ghost.leapicommon.service.InnerInterfaceInfoService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

/**
 * @author 乐小鑫
 * @version 1.0
 * @Date 2024-02-11-22:21
 */
@DubboService
public class InnerInterfaceInfoServiceImpl implements InnerInterfaceInfoService {

    @Resource
    private InterfaceInfoMapper interfaceInfoMapper;

    /**
     * 获取接口信息（查询模拟接口是否存在）
     * @param path
     * @param method
     * @return
     */
    @Override
    public InterfaceInfo getInterfaceInfo(String path, String method) {
        if (StringUtils.isAnyEmpty(path) || StringUtils.isAnyEmpty(method) ) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        // 根据请求接口路径和请求方法查询接口，判断接口是否存在（还可以校验请求参数）
        QueryWrapper<InterfaceInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("url", path);
        queryWrapper.eq("method", method);
        // 返回用户信息（包含 secretKey）
        return interfaceInfoMapper.selectOne(queryWrapper);
    }
}
