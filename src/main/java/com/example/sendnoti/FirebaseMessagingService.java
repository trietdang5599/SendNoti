package com.example.sendnoti;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FirebaseMessagingService {

    @Autowired
    private FirebaseMessaging firebaseMessaging;

//    public FirebaseMessagingService(FirebaseMessaging firebaseMessaging) {
//        this.firebaseMessaging = firebaseMessaging;
//    }


    public String sendNotificationByToken(NotificationMessage notificationMessage) {

        Notification notification = Notification
                .builder()
                .setTitle(notificationMessage.getTitle())
                .setBody(notificationMessage.getBody())
                .build();

        Message message = Message
                .builder()
                .setToken(notificationMessage.getToken())
                .setNotification(notification)
                .putAllData(notificationMessage.getData())
                .build();
        try{
            firebaseMessaging.send(message);
            return "Send Successfully!!!";
        }
        catch (FirebaseMessagingException e){
            e.printStackTrace();
            return "Error!!!!!!";
        }
    }

}
