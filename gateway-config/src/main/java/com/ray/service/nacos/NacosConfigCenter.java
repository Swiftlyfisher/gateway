package com.ray.service.nacos;

import cn.hutool.core.lang.Assert;

import com.alibaba.fastjson2.JSON;
import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;
import com.ray.config.ConfigCenterOptions;
import com.ray.config.ConfigCenterProp;
import com.ray.config.nacos.NacosConfig;
import com.ray.service.ConfigCenterCDC;

import lombok.SneakyThrows;

import java.util.concurrent.Executor;

/**
 * @PROJECT_NAME: Gateway @DESCRIPTION: @USER: rhl @DATE: 2024/12/27 14:21
 */
public class NacosConfigCenter implements ConfigCenterCDC {

    private final ConfigService configService;
    private final NacosConfig nacosConfig;

    @SneakyThrows(NacosException.class)
    public NacosConfigCenter(ConfigCenterProp properties) {
        Assert.isTrue(ConfigCenterOptions.NACOS.equals(properties.getType()));
        Assert.notNull(properties.getNacosConfig());

        this.nacosConfig = properties.getNacosConfig();
        this.configService = NacosFactory.createConfigService(properties.getServerAddr());
    }

    @Override
    @SneakyThrows(NacosException.class)
    public void captureRoutesChange() {
        String dataId = this.nacosConfig.getDataId();
        String group = this.nacosConfig.getGroup();

        String config =
                this.configService.getConfig(dataId, group, this.nacosConfig.getTimeoutMs());
        System.out.println("nacos config: " + JSON.toJSONString(config));

        this.configService.addListener(
                dataId,
                group,
                new Listener() {
                    @Override
                    public Executor getExecutor() {
                        return null;
                    }

                    @Override
                    public void receiveConfigInfo(String configInfo) {
                        System.out.println("receiveConfigInfo: " + configInfo);
                    }
                });
    }
}
