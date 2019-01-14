package com.example.demo.deviceSignal;

public class DeviceSignal {
    public static void main(String[] args) {
        // 声明[设备编号]
        String deviceIds = "113";
        // 声明[最终设备编号]-此设备编号用来拼接最终的命令
        StringBuffer finalDeviceId = new StringBuffer();
        // 声明信号[版本]-"+"后面的为版本编号,可以为1,2,3,4,8......
        String version = "76653" + 2;
        // 声明设备[端口号],该设备端口号采用了字符串数组写死
        String[] portNum = {"30", "31", "32", "33", "34", "35", "36", "37"};
        // 声明设备[端口状态],具体状态值需要查询#DevicePortStatusConstant枚举类
        int[] status = {0, 0, 0, 0, 0, 0, 0, 0};
        // 声明[主命令]字符串,该字符串是连接设备端口号以及设备端口状态等一系列相似指令的命令字符串
        String mainCommand = "";
        // 声明消息头
        String protocolHead = "7374616D63";
        for (char deviceId : deviceIds.toCharArray()) {
            // 开始拼接字符串类型的设备编号,先将[设备编号]转换为字符数组,然后遍历一个一个进行字符串相加的拼接
            finalDeviceId.append("3" + deviceId);
        }
        for (int i = 0; i < portNum.length; i++) {
            // 开始拼接字符串类型的设备编号主命令,大意是由多少个端口,遍历多少次.余下的端口状态由操作者决定
            mainCommand += "7074" + portNum[i] + "73743" + status[i] + "637530766F30707730656C30";
        }
        // 开始命令拼接,生成最终上行信号
        System.out.println(protocolHead + finalDeviceId.toString() + version + "656E30736C31666E30" + mainCommand + "6E6F303030303030303030303030657130303030303030307263656E64");
    }
}
