package com.github.reneweb.androidasyncsocketexamples.tcp;


import com.koushikdutta.async.*;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.ConnectCallback;
import com.koushikdutta.async.callback.DataCallback;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.util.Enumeration;

// Add : import
import android.widget.Button;
import android.widget.EditText;


public class Client {

    private String host;
    private int port;
    private AsyncDatagramSocket asyncDatagramSocket;
    private InetSocketAddress host1;


    ////////////    Add    ////////////////

    private String message;


    ////////////////////////////////////////////


    //    public Client(String host, int port, String msg) { // OOM
    public Client(String host, int port, String msg) {    // BM
// passed        System.out.println("1111111 Client");
        this.host = host;
        this.port = port;
        this.message = msg;  // OOM
        System.out.println(msg + "Test ///////");
        setup1();
    }

    public Client(String ip, int port){
        System.out.println("222222222222 Client");
        this.host = ip;
        this.port = port;
        getIpAddress();
    }

    /////////////////////////////   Add     /////////////////////////////

    public String getIpAddress() {
        String ip = "";
        System.out.println("get IP");
        try {
            Enumeration<NetworkInterface> enumNetworkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (enumNetworkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = enumNetworkInterfaces
                        .nextElement();
                Enumeration<InetAddress> enumInetAddress = networkInterface
                        .getInetAddresses();
                while (enumInetAddress.hasMoreElements()) {
                    InetAddress inetAddress = enumInetAddress
                            .nextElement();

                    if (inetAddress.isSiteLocalAddress()) {
                        ip += "Server running at : "
                                + inetAddress.getHostAddress();
                    }
                }
            }

        } catch (SocketException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            ip += "Something Wrong! " + e.toString() + "\n";
        }
        return ip;
    }

    ///last add


    private void setup1() {
        System.out.println("11111111 Client setup ");
        AsyncServer.getDefault().connectSocket(new InetSocketAddress(host, port), new ConnectCallback() {
            @Override
            public void onConnectCompleted(Exception ex, final AsyncSocket socket) {
                handleConnectCompleted(ex, socket);
            }
        });
    }


//    public void send(String msg) {
//        System.out.println("send WhA...!? ");
//        asyncDatagramSocket.send(host1, ByteBuffer.wrap(msg.getBytes()));
//  }

    private void handleConnectCompleted(Exception ex, final AsyncSocket socket) {
        if (ex != null) throw new RuntimeException(ex);
        System.out.println("EiEi   handleConnectCompleted  77777777777 ");
        Util.writeAll(socket, message.getBytes(), new CompletedCallback() {
            @Override
            public void onCompleted(Exception ex) {
                if (ex != null) throw new RuntimeException(ex);
                System.out.println("[Client] Successfully wrote message");
            }
        });

        socket.setDataCallback(new DataCallback() {
            @Override
            public void onDataAvailable(DataEmitter emitter, ByteBufferList bb) {
                System.out.println("[Client] Received Message " + new String(bb.getAllByteArray()));
            }
        });

        socket.setClosedCallback(new CompletedCallback() {
            @Override
            public void onCompleted(Exception ex) {
                if (ex != null) throw new RuntimeException(ex);
                System.out.println("[Client] Successfully closed connection");
            }
        });

        socket.setEndCallback(new CompletedCallback() {
            @Override
            public void onCompleted(Exception ex) {
                if (ex != null) throw new RuntimeException(ex);
                System.out.println("[Client] Successfully end connection naja");
            }
        });

//passed         System.out.println("EiEi   handleConnectCompleted  exited  77777777777 ");
    }


}
