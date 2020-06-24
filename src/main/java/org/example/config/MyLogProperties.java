package org.example.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.util.StringUtils;

@ConfigurationProperties(prefix = "mylog")
public class MyLogProperties {

    private String perfix;
    private String subfix;

    public String getPerfix() {
        if (StringUtils.isEmpty(perfix)) {
            return "默认前缀";
        }
        return perfix;
    }

    public void setPerfix(String perfix) {
        this.perfix = perfix;
    }

    public String getSubfix() {
        if (StringUtils.isEmpty(subfix)) {
            return "默认后缀";
        }
        return subfix;
    }

    public void setSubfix(String subfix) {
        this.subfix = subfix;
    }
}
