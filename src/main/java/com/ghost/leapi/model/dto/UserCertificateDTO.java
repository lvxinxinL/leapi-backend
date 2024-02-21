package com.ghost.leapi.model.dto;

import lombok.Data;
import java.io.Serializable;

/**
 * 用户凭证
 */
@Data
public class UserCertificateDTO implements Serializable {

    /**
     * 用户 id
     */
    private Long id;

    /**
     * ak
     */
    private String accessKey;

    /**
     * sk
     */
    private String secretKey;

    private static final long serialVersionUID = 1L;
}