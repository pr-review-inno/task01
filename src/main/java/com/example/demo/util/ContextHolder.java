package com.example.demo.util;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * Контекст приложения,
 * используется для проброса информации о пользователе между сервисными классами.
 *
 * @author Author
 */
@Data
@Component
public class ContextHolder {
    String userInfo;
}
