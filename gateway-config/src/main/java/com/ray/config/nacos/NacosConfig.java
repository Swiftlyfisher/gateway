package com.ray.config.nacos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NacosConfig {
    private String namespace = "";
    // 自定义id
    private String dataId = "com.ray.gateway";
    private String group = "DEFAULT_GROUP";
    private long timeoutMs = 5000;
}
