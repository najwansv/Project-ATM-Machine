package org.example;

import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class UserData {
    private String userPin;
    private int balance;
    private int userName;

    public String getUserPin() {

        return userPin;
    }

    public int getBalance() {
        return balance;
    }

    public int getUserName() {

        return userName;
    }

    public void setUserPin(String userPin) {

        this.userPin = userPin;
    }

    public void setBalance(int balance) {

        this.balance = balance;
    }

    public void setUserName(int userName) {

        this.userName = userName;
    }

    /* ngebuat fungsi buat ngecek pin yang ada di database dan yang di input itu bener apa engga
    * dengan cara:
    * 1. Mengambil data pin dari database
    * 2. pake if else buat nentuin yang di input bener apa engga
    *
    * permasalahan yang dialami:
    * 1. gabisa ngambil data kalo*/

    public void sentTrigger() throws MqttException {
        String broker = "tcp://test.mosquitto.org:1883";
        String topic = "ATM/USER/PIN";
        String clientid = "publish_client";
        int qos = 0;

        try {
            MqttClient client = new MqttClient(broker, clientid, new MemoryPersistence());
            // connect options
            MqttConnectOptions options = new MqttConnectOptions();
            options.setConnectionTimeout(60);
            options.setKeepAliveInterval(60);
            client.connect(options);
            // publish
            MqttMessage message = new MqttMessage();
            message.setQos(qos);
            message.setPayload("trigger".getBytes());
            client.publish(topic, message);
            client.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // memeriksa pin yang di input

    public void checkUserPIN(String s) throws MqttException {
        String broker = "tcp://test.mosquitto.org:1883";
        String topic = "ATM/USER/PIN";
        String clientid = "subscribe_client";
        int qos = 0;

        try {
            MqttClient client = new MqttClient(broker, clientid, new MemoryPersistence());
            // connect options
            MqttConnectOptions options = new MqttConnectOptions();
            options.setConnectionTimeout(60);
            options.setKeepAliveInterval(60);

            sentTrigger();

            // setup callback
            client.setCallback(new MqttCallback() {

                public void connectionLost(Throwable cause) {
                    System.out.println("connectionLost: " + cause.getMessage());
                }
                // menerima data
                public void messageArrived(String topic, MqttMessage message) {
                    System.out.println("Pin: " + s);
                    System.out.println("topic: " + topic);
                    System.out.println("Qos: " + message.getQos());
                    System.out.println("message content: " + new String(message.getPayload()));

                }
                public void deliveryComplete(IMqttDeliveryToken token) {
                    System.out.println("deliveryComplete---------" + token.isComplete());
                }

            });
            client.connect(options);
            client.subscribe(topic, qos);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
