package com.esrabildik.notificationdemo.notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.os.Build.*
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import com.esrabildik.notificationdemo.R
import javax.inject.Inject

class NotificationHelper @Inject constructor(
    private val context : Context
) {
    // her bildirim bir kanala ait olmalı
    private val channelID = "channel_id"

    fun showNotification(title : String, message : String){

        //NotificationChannel sınıfı sayesinde farklı bildirim türleri ayarlanabilir.
        val channel = NotificationChannel(
            channelID,
            "Genel Bildirimler",
            NotificationManager.IMPORTANCE_HIGH
        )
        //NotificationManager sınıfı sayesinde Android'in bildirim kanalına erişiriz ve kanalı kaydederiz.
        val manager = context.getSystemService(NotificationManager::class.java)
        manager?.createNotificationChannel(channel)


        val builder = NotificationCompat.Builder(context,channelID)
            .setSmallIcon(R.drawable.baseline_circle_notifications_24)
            .setContentTitle(title)
            .setContentText(message)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT) //Bildirimin önem derecesi

        if (ContextCompat.checkSelfPermission(context, android.Manifest.permission.POST_NOTIFICATIONS)
            == PackageManager.PERMISSION_GRANTED
        ) {
            NotificationManagerCompat.from(context).notify(1001, builder.build())
        }


    }
}