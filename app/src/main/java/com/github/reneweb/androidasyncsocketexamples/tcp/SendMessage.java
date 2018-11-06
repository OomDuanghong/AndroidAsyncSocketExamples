package com.github.reneweb.androidasyncsocketexamples.tcp;
import android.widget.ListView;
import com.koushikdutta.async.AsyncSocket;
import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.Util;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.DataCallback;


public class SendMessage {
    private Exception ex;
    private AsyncSocket socket;
    private String message;


    public SendMessage(Exception exx,AsyncSocket sockett,String message){
        this.ex = exx;
        this.socket = sockett;
        this.message = message;
        handleConnectCompleted(ex,socket);
    }
    private void handleConnectCompleted(Exception ex, final AsyncSocket socket) {
        if(ex != null) {
            System.out.println("[Client] Fail" );
            throw new RuntimeException(ex);
        }
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
                System.out.println("[Client]" + emitter);
                System.out.println("[Client] Received Message " + new String(bb.getAllByteArray()));
            }
        });
        socket.setClosedCallback(new CompletedCallback() {
            @Override
            public void onCompleted(Exception ex) {
                if(ex != null) throw new RuntimeException(ex);
                System.out.println("[Client] Successfully closed connection");
            }
        });
        socket.setEndCallback(new CompletedCallback() {
            @Override
            public void onCompleted(Exception ex) {
                if(ex != null) throw new RuntimeException(ex);
                System.out.println("[Client] Successfully end connection");
            }
        });
    }
}