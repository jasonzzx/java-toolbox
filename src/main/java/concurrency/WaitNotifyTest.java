package concurrency;

import java.time.Instant;

public class WaitNotifyTest {
    public static void main(String[] args) {
        Message msg = new Message("process it");

        Waiter waiter1 = new Waiter(msg);
        new Thread(waiter1,"[Waiter 1]").start();
        Waiter waiter2 = new Waiter(msg);
        new Thread(waiter2, "[Waiter 2]").start();
        Waiter waiter3 = new Waiter(msg);
        new Thread(waiter2, "[Waiter 3]").start();

        Notifier notifier = new Notifier(msg);
        new Thread(notifier, "[Notifier]").start();
    }
}

class Message {
    private String msg;
    public Message(String str) { this.msg = str; }
    public String getMsg() { return msg; }
    public void setMsg(String str) { this.msg = str; }
}

class Waiter implements Runnable{
    private Message msg;
    public Waiter(Message m){ this.msg=m;}

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name+" started");
        synchronized (msg) {
            try{
                System.out.println(name+" waiting to get notified at time:" + Instant.now());
                msg.wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(name+" waiter thread got notified at time:" + Instant.now());
            System.out.println(name+" processed: "+msg.getMsg());
        }
    }
}

class Notifier implements Runnable {
    private Message msg;
    public Notifier(Message msg) { this.msg = msg; }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name+" started");
        try {
            Thread.sleep(1000);
            synchronized (msg) {
                System.out.println("[Notifier] Start to set message for waiters.");
                msg.setMsg("Message from Notifier");
                System.out.println("[Notifier] Notify all waiters.");
                msg.notifyAll();
//                msg.notify(); // notify() will only wake up 1 waiter thread
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


