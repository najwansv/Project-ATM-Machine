package org.example;

import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class GetCard {
    private String brokerUrl = "tcp://test.mosquitto.org:1883";
    private String topic = "Project/rfid/user/idcard";
    private int qos = 0;
    private String clientId = "myJavaClient";
    private MemoryPersistence persistence = new MemoryPersistence();

    public String receiveMessages() {
        final String[] messageCard = {""};
        try {
            MqttClient mqttClient = new MqttClient(brokerUrl, clientId, persistence);
            mqttClient.setCallback(new MqttCallback() {
                @Override
                public void connectionLost(Throwable cause) {
                    System.out.println("Connection lost: " + cause.getMessage());
                }

                @Override
                public void messageArrived(String topic, MqttMessage message) throws Exception {
                    System.out.println("MQTT message received: " + message.toString());
                    UserData.userCardId = message.toString(); // Update the value of the public variable
                    messageCard[0] = message.toString();
                }

                @Override
                public void deliveryComplete(IMqttDeliveryToken token) {
                    // Not used in this example
                }
            });

            mqttClient.connect();
            mqttClient.subscribe(topic, qos);
        } catch (MqttException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return messageCard[0];
    }

    public static void main() {
        GetCard getCard = new GetCard();
        getCard.receiveMessages();
    }
}