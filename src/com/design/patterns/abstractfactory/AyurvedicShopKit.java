package com.design.patterns.abstractfactory;

/**
 * Created by prajeev on 16/3/17.
 */
public class AyurvedicShopKit implements ShopKit {
    @Override
    public Product createProduct() {
        return new AyurvedicProduct();
    }
}
