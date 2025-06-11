package com.esrabildik.notificationdemo.notification

sealed class NotificationEvent {
    data class SendNotification(val title : String, val message : String) : NotificationEvent()
}