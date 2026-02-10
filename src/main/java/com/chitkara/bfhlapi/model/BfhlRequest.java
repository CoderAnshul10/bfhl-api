package com.chitkara.bfhlapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BfhlRequest {
    private Integer fibonacci;
    private int[] prime;
    private int[] lcm;
    private int[] hcf;

    @JsonProperty("AI")
    private String AI;

    // Constructors
    public BfhlRequest() {}

    // Getters and Setters
    public Integer getFibonacci() {
        return fibonacci;
    }

    public void setFibonacci(Integer fibonacci) {
        this.fibonacci = fibonacci;
    }

    public int[] getPrime() {
        return prime;
    }

    public void setPrime(int[] prime) {
        this.prime = prime;
    }

    public int[] getLcm() {
        return lcm;
    }

    public void setLcm(int[] lcm) {
        this.lcm = lcm;
    }

    public int[] getHcf() {
        return hcf;
    }

    public void setHcf(int[] hcf) {
        this.hcf = hcf;
    }

    public String getAI() {
        return AI;
    }

    public void setAI(String AI) {
        this.AI = AI;
    }
}