package com.design.patterns.abstractfactory;

/**
 * Created by prajeev on 16/3/17.
 */
public class ShopKitFactory {
    public static ShopKit getShopKit(String kit) {
        if(kit.equals("A"))
            return new AyurvedicShopKit();
        if(kit.equals("L"))
            return new LiquorShopKit();
        return null;
    }
}
