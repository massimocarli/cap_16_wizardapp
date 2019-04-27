package uk.co.massimocarli.wizardapp


import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.fragment.app.Fragment
import androidx.navigation.NavDeepLinkBuilder
import kotlinx.android.synthetic.main.right_fragment_start.view.*

/**
 * A simple [Fragment] subclass.
 *
 */
class RightFragmentStart : Fragment() {

  companion object {
    const val NOTIFICATION_ID = 1
    const val CHANNEL_ID = "DeepLinkChannel"
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    createNotificationChannel()
  }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    // Inflate the layout for this fragment
    val view = inflater.inflate(R.layout.right_fragment_start, container, false)
    val ctx = view.context
    view.launchNotificationButton.setOnClickListener {
      // We create the PendingIntent
      val deepLinkIntent = NavDeepLinkBuilder(ctx)
        .setGraph(R.navigation.wizard_navigation)
        .setDestination(R.id.leftThird)
        .createPendingIntent()
      val builder = NotificationCompat.Builder(ctx, CHANNEL_ID).apply {
        setContentIntent(deepLinkIntent)
        setSmallIcon(R.drawable.ic_mtrl_chip_checked_black)
        setContentText("Click me!")
        setContentTitle("Deep Link!")
        setPriority(NotificationCompat.PRIORITY_DEFAULT)
        setAutoCancel(true)
      }
      with(NotificationManagerCompat.from(ctx)) {
        notify(NOTIFICATION_ID, builder.build())
      }
    }
    return view
  }
  
  private fun createNotificationChannel() {
    // Create the NotificationChannel, but only on API 26+ because
    // the NotificationChannel class is new and not in the support library
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
      val name = getString(R.string.channel_name)
      val descriptionText = getString(R.string.channel_description)
      val importance = NotificationManager.IMPORTANCE_DEFAULT
      val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
        description = descriptionText
      }
      // Register the channel with the system
      val notificationManager: NotificationManager =
        context?.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
      notificationManager.createNotificationChannel(channel)
    }
  }
}
