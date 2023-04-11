package io.skai.notification.repository;

import io.skai.notification.model.NewOrderNotification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewOrderNotificationRepository extends JpaRepository<Long, NewOrderNotification> {
}
