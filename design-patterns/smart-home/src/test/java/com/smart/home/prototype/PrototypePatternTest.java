package com.smart.home.prototype;

import org.junit.jupiter.api.Test;

public class PrototypePatternTest {
    @Test
    public void testPrototypePattern(){
        LightPrototype originalLight = new LightPrototype("White",75);
        LightPrototype clonedLight = (LightPrototype) originalLight.cloneDevice();
        clonedLight.setColor("Warm white");

        System.out.println("Original light: "+originalLight);
        System.out.println("Cloned light: "+clonedLight);
    }
}
