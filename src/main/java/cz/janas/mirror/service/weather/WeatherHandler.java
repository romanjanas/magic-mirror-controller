package cz.janas.mirror.service.weather;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class WeatherHandler extends TextWebSocketHandler {

    WebSocketSession session;

    AtomicLong degrees = new AtomicLong(0);

    @Value("${weather.city.name:Zlín}")
    String city;

    // This will send only to one client(most recently connected)
    public void updateWeather() {
        if (session != null && session.isOpen()) {
            try {
                session.sendMessage(new TextMessage(
                        "{\"iconClass\": \"owf owf-800-n\"," +
                        "\"temperature\": \"" + degrees.getAndIncrement() + "°, " + city + "\"," +
                        "\"conditions\": \"lehký déšť\"}"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Don't have open session to send data");
        }
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        System.out.println("Connection established");
        this.session = session;
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message)
            throws Exception {
        if ("CLOSE".equalsIgnoreCase(message.getPayload())) {
            session.close();
        } else {
            System.out.println("Received:" + message.getPayload());
        }
    }

}
