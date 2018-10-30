package com.github.reneweb.androidasyncsocketexamples.tcp;


import com.koushikdutta.async.*;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.ConnectCallback;
import com.koushikdutta.async.callback.DataCallback;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

// Add : import
import android.widget.Button;



public class Client {

    private String host;
    private int port;
    ////////////    Add    ////////////////
    private String message = "Hello Server get get";

    public Client(String host, int port,String message) {
        this.host = host;
        this.port = port;
        this.message = message;
        setup();
    }

    /////////////////////////////   add     /////////////////////////////

//    public String getIpAddress() {
//        String ip = "";
//        try {
//            Enumeration<NetworkInterface> enumNetworkInterfaces = NetworkInterface
//                    .getNetworkInterfaces();
//            while (enumNetworkInterfaces.hasMoreElements()) {
//                NetworkInterface networkInterface = enumNetworkInterfaces
//                        .nextElement();
//                Enumeration<InetAddress> enumInetAddress = networkInterface
//                        .getInetAddresses();
//                while (enumInetAddress.hasMoreElements()) {
//                    InetAddress inetAddress = enumInetAddress
//                            .nextElement();
//
//                    if (inetAddress.isSiteLocalAddress()) {
//                        ip += "Server running at : "
//                                + inetAddress.getHostAddress();
//                    }
//                }
//            }
//
//        } catch (SocketException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//            ip += "Something Wrong! " + e.toString() + "\n";
//        }
//        return ip;
//    }

    ///last add


    private void setup() {
        AsyncServer.getDefault().connectSocket(new InetSocketAddress(host, port), new ConnectCallback() {
            @Override
            public void onConnectCompleted(Exception ex, final AsyncSocket socket) {
                new SendMessage(ex,socket,message);
            }
        });

//    private void handleConnectCompleted(Exception ex, final AsyncSocket socket) {
//        if(ex != null) throw new RuntimeException(ex);
//
//        Util.writeAll(socket, messege.getBytes(), new CompletedCallback() {
//            @Override
//            public void onCompleted(Exception ex) {
//                if (ex != null) throw new RuntimeException(ex);
//                System.out.println("[Client] Successfully wrote message");
//            }
//        });
//
//        socket.setDataCallback(new DataCallback() {
//            @Override
//            public void onDataAvailable(DataEmitter emitter, ByteBufferList bb) {
//                System.out.println("[Client] Received Message " + new String(bb.getAllByteArray()));
//            }
//        });
//
//        socket.setClosedCallback(new CompletedCallback() {
//            @Override
//            public void onCompleted(Exception ex) {
//                if(ex != null) throw new RuntimeException(ex);
//                System.out.println("[Client] Successfully closed connection");
//            }
//        });
//
//        socket.setEndCallback(new CompletedCallback() {
//            @Override
//            public void onCompleted(Exception ex) {
//                if(ex != null) throw new RuntimeException(ex);
//                System.out.println("[Client] Successfully end connection naja");
//            }
//        });
    }
}
