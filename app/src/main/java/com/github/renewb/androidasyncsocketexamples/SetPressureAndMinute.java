package com.github.renewb.androidasyncsocketexamples;

public class SetPressureAndMinute {
    String psi[];
    String sec[];
    String cycletime;
    String mode;
    double pressure[];
    String deflate;


    public String getPresure(int i) {
        return psi[i];
    }

    public SetPressureAndMinute setPressure(String psi,int i) {
        this.psi[i] = psi;
        return this;
    }

    public double getP(int i) {
        return pressure[i];
    }

    public SetPressureAndMinute setP(double pressure,int i) {
        this.pressure[i] = pressure;
        return this;
    }

    public String getDeflate() {
        return deflate;
    }

    public SetPressureAndMinute setDeflate(String deflate) {
        this.deflate = deflate;
        return this;
    }


    public String getSec(int i) {
        return sec[i];
    }

    public SetPressureAndMinute setSec(String sec,int i) {
        this.sec[i] = sec;
        return this;
    }

    public String getCycleTime() {
        return cycletime;
    }

    public SetPressureAndMinute setCycleTime(String cycleTime) {
        this.cycletime = cycleTime;
        return this;
    }

    public String getMode() {
        return mode;
    }

    public SetPressureAndMinute setMode(String mode) {
        this.mode = mode;
        return this;
    }

    public void MakePressure(float psi[],float sec[],float cycletime){
        for(int i=0;i<4;i++){
            pressure[i] = (((5*psi[i])-(0*psi[i])/(0.8*1023))*(1023-(0.1*1023)))+(0*psi[i]);
        }

    }

}
