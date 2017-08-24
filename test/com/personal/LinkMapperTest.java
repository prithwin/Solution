package com.personal;

import org.testng.annotations.Test;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Created by prajeeva on 8/23/17.
 */
public class LinkMapperTest {
    @Test public void testSomething() {
        System.out.println("this is just testing");
        List<LinkAnalysisDO> list = new ArrayList<>();
        list.add(new LinkAnalysisDO("","",new Date() , 1 , "1"));
        list.stream().collect(Collectors.toMap(l -> l.getMerchantId() , l -> new HashMap<String, Map<String , String>>()));
    }

    class LinkAnalysisDO {
        private String attributeType;
        private String attributeValue;
        private Date lastModified;
        private Integer status;
        private String merchantId;

        public LinkAnalysisDO(String s, String s1, Date date, int i, String s2) {
            attributeType = s;
            attributeValue = s1;
            lastModified = date;
            status = i ;
            merchantId = s2;
        }


        public String getMerchantId() {
            return merchantId;
        }

        public void setMerchantId(String merchantId) {
            this.merchantId = merchantId;
        }

        public String getAttributeType() {
            return attributeType;
        }

        public void setAttributeType(String attributeType) {
            this.attributeType = attributeType;
        }

        public String getAttributeValue() {
            return attributeValue;
        }

        public void setAttributeValue(String attributeValue) {
            this.attributeValue = attributeValue;
        }

        public Date getLastModified() {
            return lastModified;
        }

        public void setLastModified(Date lastModified) {
            this.lastModified = lastModified;
        }

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }
    }

}
