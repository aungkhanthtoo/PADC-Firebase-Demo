package com.padc.padcfirebase.fcm

import android.app.PendingIntent
import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.padc.padcfirebase.activities.MainActivity

class AppFCMService: FirebaseMessagingService() {

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        Log.d(TAG, "Refreshed token: $token")
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)
        Log.d(TAG, "onMessageReceived: ${remoteMessage.notification}")

        // Check if message contains a notification payload.
        remoteMessage.notification?.let {
            Log.d(TAG, "Message Notification Body: ${it.body}")

            val mainIntent = MainActivity.getNewIntent(this)
            val pendingIntent = PendingIntent.getActivity(
                this, 1, mainIntent, PendingIntent.FLAG_UPDATE_CURRENT
            )

            buildAndSendNotification(
                this,
                it.title ?: "FCM Testing",
                it.body ?: "FCM Testing",
                pendingIntent
            )

        }

        // Check if message contains a data payload.
        remoteMessage.data.isNotEmpty().let {
            Log.d(TAG, "Message data payload: " + remoteMessage.data)

            if (/* Check if data needs to be processed by long running job */ true) {
                // For long-running tasks (10 seconds or more) use WorkManager.

            } else {
                // Handle message within 10 seconds

            }
        }

    }

    companion object {
        const val TAG = "AppFCMService"
    }
}