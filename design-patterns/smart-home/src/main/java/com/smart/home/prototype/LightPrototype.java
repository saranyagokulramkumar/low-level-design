package com.smart.home.prototype;

public class LightPrototype implements DevicePrototype{
    private String color;
    private int brightness;

    public LightPrototype(String color, int brightness) {
        this.color = color;
        this.brightness = brightness;
    }

    public String getColor() {
        return color;
    }

    public int getBrightness() {
        return brightness;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setBrightness(int brightness) {
        this.brightness = brightness;
    }

    @Override
    public DevicePrototype cloneDevice() {
        try{
            return (LightPrototype)super.clone();
        }catch(CloneNotSupportedException e){
            throw new AssertionError();
        }
    }

    @Override
    public String toString() {
        return "LightPrototype{" +
                "color='" + color + '\'' +
                ", brightness=" + brightness +
                '}';
    }
}
