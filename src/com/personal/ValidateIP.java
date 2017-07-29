package com.personal;

/**
 * Created by prajeeva on 7/29/17.
 */
public class ValidateIP {
    public String validIPAddress(String ip) {
        if(ip.matches("(\\d+\\.){3}(\\d+)")) {
            for(String str : ip.split("\\.")) {
                try {
                    int num = Integer.parseInt(str);
                    if(str.length() == 2 && num < 10) {
                        return "Neither";
                    }
                    if(str.length()==3 && num < 100) {
                        return "Neither";
                    }
                    if(num > 255) return "Neither";
                } catch (Exception e) {
                    return "Neither";
                }
            }
            return "IPv4";
        } else if(ip.matches("([A-Fa-f0-9]+:){7}([A-Fa-f0-9]+)")) {
            for(String str : ip.split(":")) {
                try {
                    int num = Integer.parseInt(str,16);
                    if(str.length() == 2 && num < Integer.parseInt("10",16)) {
                        return "Neither";
                    }
                    if(str.length()==3 && num < Integer.parseInt("100",16)) {
                        return "Neither";
                    }
                    if(str.length()==4 && num < Integer.parseInt("1000",16)) {
                        return "Neither";
                    }
                    if(num > 65535) return "Neither";
                } catch (Exception e) {
                    return "Neither";
                }
            }
            return "IPv6";
        }
        return "Neither";
    }
}
