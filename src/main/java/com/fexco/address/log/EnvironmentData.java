package com.fexco.address.log;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by diego.guimaraes on 05/08/16.
 */
public class EnvironmentData {

    public String environmentName;
    public String hostName;
    public String brand;
    public String appName;
    public String appVersion;

    public String getEnvironmentName() {
        return environmentName;
    }

    public void setEnvironmentName(String environmentName) {
        this.environmentName = environmentName;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public EnvironmentData(){
        try {
            this.hostName = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            setHostName("unknown-host");
        }

        try {
            this.environmentName = System.getProperty("env");
        } catch (SecurityException e) {
            setEnvironmentName("unknown-environment");
        }

        try {
            this.brand = System.getProperty("brand");
        } catch (SecurityException e) {
            setBrand("unknown-brand");
        }

        try {
            this.appName = System.getProperty("applicationName");
        } catch (SecurityException e) {
            setAppName("unknown-app-name");
        }

        try {
            this.appVersion = System.getProperty("version");
        } catch (SecurityException e) {
            setAppVersion("unknown-app-version");
        }
    }

}
