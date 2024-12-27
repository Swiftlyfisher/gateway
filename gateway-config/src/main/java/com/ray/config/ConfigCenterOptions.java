package com.ray.config;

import lombok.AllArgsConstructor;

/**
 * @PROJECT_NAME: Gateway @DESCRIPTION: @USER: rhl @DATE: 2024/12/27 15:21
 */
@AllArgsConstructor
public enum ConfigCenterOptions {
    NACOS("nacos"),
    ;

    private String type;
}
