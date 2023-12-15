package com.example.sendnoti;
import lombok.Data;

import java.util.Map;


@Data
public class NotificationMessage {
    private String token;
    private String title;
    private String body;
    private String message;
    private Map<String,String> data;
}
