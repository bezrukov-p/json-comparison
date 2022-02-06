package com.company.model.services;

public class Hashes {
    private String sha1;
    private String sha256;

    public Hashes() {
    }

    public Hashes(String sha1, String sha256) {
        this.sha1 = sha1;
        this.sha256 = sha256;
    }

    public String getSha1() {
        return sha1;
    }

    public void setSha1(String sha1) {
        this.sha1 = sha1;
    }

    public String getSha256() {
        return sha256;
    }

    public void setSha256(String sha256) {
        this.sha256 = sha256;
    }
}
