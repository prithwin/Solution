package com.design.patterns.abstractfactory;

/**
 * Created by prajeev on 16/3/17.
 */
public class AbstractFactoryTest {
    public static void main(String[] args) {
        System.out.println(ShopKitFactory.getShopKit("A").createProduct().getNameOnLabel());
//
    }
}
