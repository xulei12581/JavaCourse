package com.example.demo.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "xicent.service")
public class MyServiceProperties {
    private MyServiceProperties.MyProperties myProperties = new MyServiceProperties.MyProperties();

    public MyProperties getMyProperties() {
        return myProperties;
    }

    public void setMyProperties(MyProperties myProperties) {
        this.myProperties = myProperties;
    }

    public static class MyProperties {
        public static final String DEFAULT_NAME;
        private String author;
        private String age = "18";

        static {
            DEFAULT_NAME = "wjx";
        }
        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

    }
}