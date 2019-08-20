package com.example.demo.deviceSignal;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ChargingCabinetHeartbeatSignal {
    public static void main(String[] args) {
        // 声明消息头
        String protocolHead = "0D0AEE31";
        // 声明[设备编号]
        String deviceIds = new DecimalFormat("0000000000").format(1140);
        // 声明客户标识
        String customerIdentification = "3132";
        // 声明加密算法
        String encryptionAlgorithmCode = "81";
        // 声明信号强度
        String signalStrength = "94";
        // 声明[时间戳]
        String timestamp = new SimpleDateFormat("yyMMddHHmmss").format(new Date());
        String deviceStatus = Integer.toHexString(Integer.parseInt("11111111", 2));
        String c1 = Integer.toHexString(Integer.parseInt("11000010", 2));
        String c1Alarm = Integer.toHexString(Integer.parseInt("11000000", 2));
        String c2 = Integer.toHexString(Integer.parseInt("11000010", 2));
        String c2Alarm = Integer.toHexString(Integer.parseInt("11000000", 2));
        String c3 = Integer.toHexString(Integer.parseInt("11000010", 2));
        String c3Alarm = Integer.toHexString(Integer.parseInt("11000000", 2));
        String other = "353239313033343530303338";
        String door = c1 + c1Alarm + other + c2 + c2Alarm + other + c3 + c3Alarm + other;
        // 声明[最终设备编号]-此设备编号用来拼接最终的命令
        StringBuffer finalDeviceId = new StringBuffer();
        StringBuffer finalTimestamp = new StringBuffer();
        for (char deviceId : deviceIds.toCharArray()) {
            // 开始拼接字符串类型的设备编号,先将[设备编号]转换为字符数组,然后遍历一个一个进行字符串相加的拼接
            finalDeviceId.append("3" + deviceId);
        }
        for (char time : timestamp.toCharArray()) {
            // 开始拼接字符串类型的设备编号,先将[设备编号]转换为字符数组,然后遍历一个一个进行字符串相加的拼接
            finalTimestamp.append("3" + time);
        }
        System.out.println(""
                + protocolHead + finalDeviceId + customerIdentification + encryptionAlgorithmCode + signalStrength
                + finalTimestamp + "32383735323230" + deviceStatus + door + "FFFF3039");
    }
}
