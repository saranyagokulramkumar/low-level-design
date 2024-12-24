package com.smart.home.singleton;

import com.smart.home.singleton.ControlHub;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ControlHubTest {
    static ControlHub hub1, hub2;

    @BeforeAll
    public static void init(){
        hub1 = ControlHub.getInstance();
        hub2 = ControlHub.getInstance();
    }

    @Test
    public void testInit(){
        hub1.initialize();
        assertEquals(hub1, hub2);
    }
}
