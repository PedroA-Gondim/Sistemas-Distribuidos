package br.ufu.facom.gbc074.kvs;

import org.eclipse.paho.client.mqttv3.*;

public class MQTTManager {
    private static final String BROKER = "tcp://localhost:1883";
    private static final String TOPIC = "kvs/updates";
    private final IMqttClient mqttClient;

    public MQTTManager() throws MqttException {
        this.mqttClient = new MqttClient(BROKER, MqttClient.generateClientId());
        MqttConnectOptions options = new MqttConnectOptions();
        options.setAutomaticReconnect(true);
        mqttClient.connect(options);
    }

    public void publishUpdate(String operation, String key, String value, int version) {
        try {
            String message = String.format("{\"op\":\"%s\",\"key\":\"%s\",\"value\":\"%s\",\"version\":%d}",
                    operation, key, value, version);
            mqttClient.publish(TOPIC, new MqttMessage(message.getBytes()));
        } catch (MqttException e) {
            System.err.println("Erro ao publicar: " + e.getMessage());
        }
    }
}