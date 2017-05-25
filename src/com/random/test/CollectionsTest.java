package com.random.test;

import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by pr250155 on 4/26/17.
 */
public class CollectionsTest {
    public static void main(String[] args){
        class Conversation {
            Lock conversationLock = new ReentrantLock();
            Condition wifeSpeaks = conversationLock.newCondition();
            Condition husbandSpeaks = conversationLock.newCondition();

        }
        Conversation conversation = new Conversation();
        new Thread(() ->{

            while(true){
                conversation.conversationLock.lock();
                try {
                    conversation.husbandSpeaks.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Wife saying interesting things!");
                conversation.wifeSpeaks.signalAll();
                conversation.conversationLock.unlock();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() ->{
            while(true){
                conversation.conversationLock.lock();
                try {
                    conversation.wifeSpeaks.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Husband saying interesting things!");
                conversation.husbandSpeaks.signalAll();
                conversation.conversationLock.unlock();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
