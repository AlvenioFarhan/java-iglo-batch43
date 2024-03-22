package com.indocyber;

@FunctionalInterface
public interface CheckBloodPressureHandler {
    public boolean isPassed(Integer[] bloodPressure);
}
