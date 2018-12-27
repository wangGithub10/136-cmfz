package com.baizhi.test;

import org.junit.Test;

import java.util.UUID;

public class TestUUID {
    @Test
    public void test1() {
        System.out.println(UUID.randomUUID().toString().replace("-", ""));
    }
}
