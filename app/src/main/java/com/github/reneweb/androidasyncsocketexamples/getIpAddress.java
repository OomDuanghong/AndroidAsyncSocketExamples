package com.github.reneweb.androidasyncsocketexamples;

import java.net.*;

public class getIpAddress {

    public static void main(String[] args){
        System.out.println("Hello Get IP (1) ");
        InetAddress host;
        try {
            System.out.println("Hello Get IP [2]");
            host=InetAddress.getLocalHost();
            System.out.println(host);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
