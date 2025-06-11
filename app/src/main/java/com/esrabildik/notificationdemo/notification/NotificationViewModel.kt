package com.esrabildik.notificationdemo.notification

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NotificationViewModel @Inject constructor(
    private val notificationHelper : NotificationHelper
)  : ViewModel()
{

    fun onEvent(event: NotificationEvent) {
        when(event){
            is NotificationEvent.SendNotification -> {
                notificationHelper.showNotification(event.title,event.message)
            }
        }
    }
}