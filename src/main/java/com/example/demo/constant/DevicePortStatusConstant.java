/**
 * @Company {http://www.goldenetbj.cn/}
 * @author {Yan on 7/20/17}
 * @description {This [Device Port Status Constant] shows the various states that may occur on each port of the current
 * device.}
 * @description {此[设备端口状态常量]展示了目前设备各个端口可能出现的各种状态。}
 */
package com.example.demo.constant;

public enum DevicePortStatusConstant {
    //Mapping hardware status
    /*空闲*/
    Idle(0),
    /*充满断电*/
    FullyChargedStopped(1),
    /*充电中*/
    Charging(2),
    /*开启失败*/
    OpenFailed(3),
    /*关闭失败*/
    StopFailed(4),
    /*断开电源 或 用户拔电*/
    DisconnectStopped(5),
    /*异常*/
    Exception(6),
    //Custom status
    /*用户断电 或 停止充电*/
    UserStopped(7),
    /*到时断电*/
    TimeStopped(8),
    /*余额不足*/
    BalanceStopped(9),
    /*设备离线*/
    Unknown(10);

    private final int value;

    DevicePortStatusConstant(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static DevicePortStatusConstant valueOf(int value) {
        for (DevicePortStatusConstant devicePortStatusConstant : DevicePortStatusConstant.values()) {
            if (devicePortStatusConstant.ordinal() == value) return devicePortStatusConstant;
        }
        return null;
    }

    public static int[] getInUseStatusList() {
        int[] list = {DevicePortStatusConstant.Charging.getValue()};
        return list;
    }

    public static boolean isInUse(DevicePortStatusConstant portStatus) {
        if (portStatus == DevicePortStatusConstant.Charging) return true;
        return false;
    }

    public static boolean isInUse(int portStatus) {
        DevicePortStatusConstant status = DevicePortStatusConstant.valueOf(portStatus);
        return DevicePortStatusConstant.isInUse(status);
    }

    public static boolean isFullyChargedStopped(DevicePortStatusConstant portStatus) {
        if (portStatus == DevicePortStatusConstant.FullyChargedStopped) return true;
        return false;
    }

    public static boolean isFullyChargedStopped(int portStatus) {
        DevicePortStatusConstant status = DevicePortStatusConstant.valueOf(portStatus);
        return DevicePortStatusConstant.isFullyChargedStopped(status);
    }
}
