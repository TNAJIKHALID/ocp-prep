module m3 {
    requires notificationservice;

    provides com.NotificationService with com.EmailImpl;
}