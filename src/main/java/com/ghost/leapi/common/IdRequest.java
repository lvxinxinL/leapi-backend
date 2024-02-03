package com.ghost.leapi.common;

import lombok.Data;

import java.io.Serializable;

/**
 * id
 */
@Data
public class IdRequest implements Serializable {

    /**
     * id
     */
    private Long id;

    private static final long serialVersionUID = 1L;
}