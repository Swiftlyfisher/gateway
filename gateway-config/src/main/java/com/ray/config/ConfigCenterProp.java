package com.ray.config;

import com.ray.config.nacos.NacosConfig;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @PROJECT_NAME: Gateway @DESCRIPTION: @USER: rhl @DATE: 2024/12/27 13:55
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConfigCenterProp {
    private String serverAddr;
    private ConfigCenterOptions type;
    private NacosConfig nacosConfig;
}
