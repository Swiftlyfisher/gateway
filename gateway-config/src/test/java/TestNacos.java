import com.alibaba.nacos.api.annotation.NacosProperties;
import com.ray.config.ConfigCenterOptions;
import com.ray.config.ConfigCenterProp;
import com.ray.config.nacos.NacosConfig;
import com.ray.service.nacos.NacosConfigCenter;
import org.junit.jupiter.api.Test;

import java.util.concurrent.locks.LockSupport;

/**
 * @PROJECT_NAME: Gateway @DESCRIPTION: @USER: rhl @DATE: 2024/12/27 16:14
 */
public class TestNacos {

    @Test
    public void testNacosCenter() {

        NacosConfigCenter nacosConfigCenter =
                new NacosConfigCenter(
                        ConfigCenterProp.builder()
                                .type(ConfigCenterOptions.NACOS)
                                .nacosConfig(new NacosConfig())
                                .serverAddr("192.168.10.3:8848")
                                .build());

        nacosConfigCenter.captureRoutesChange();

        LockSupport.park();
    }
}
