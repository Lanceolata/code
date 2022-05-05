package com.lanceolata.code.snippets.spring.boot.framework;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:global.properties")
public class GlobalProperties {
    private static final Logger LOGGER = LogManager.getLogger(GlobalProperties.class);

    @Value("${system.workingDir}")
    private String workingDir;

    @Value("${project.basedir}")
    private String projectBasedir;

    @Value("${job.name}")
    private String jobName;

    @Value("${env.type}")
    private String envType;

    @Value("${mount.cluster:}")
    private String mountCluster;

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getMountCluter() {
        return mountCluster;
    }
}
