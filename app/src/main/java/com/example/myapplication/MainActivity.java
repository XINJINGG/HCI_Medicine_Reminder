package com.example.myapplication;

import android.app.AlertDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import android.Manifest;

import com.example.myapplication.databinding.ActivityMainBinding;
import com.example.myapplication.ui.account.Login;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private static final String CHANNEL_ID = "my_channel";
    private static final int NOTIFICATION_ID = 1;
    private NotificationManager notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // Request notification permission if not granted
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) { // Android 13
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.POST_NOTIFICATIONS}, 1);
            }
        }
        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        createNotificationChannel();
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        getSupportActionBar().hide();

        SharedPreferences sharedPreferences = getSharedPreferences("UserPreferences", MODE_PRIVATE);
        boolean isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false);

        if (!isLoggedIn) {
            Intent intent = new Intent(MainActivity.this, Login.class);
            startActivity(intent);
            finish();
            return;
        }

        // Inflate layout and set content view
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Initialize BottomNavigationView and NavController
        BottomNavigationView navView = findViewById(R.id.nav_view);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_alarm, R.id.navigation_medication, R.id.navigation_rewards, R.id.navigation_profile)
                .build();

        // NavController will manage fragment navigation
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);

        // Set up action bar and BottomNavigationView
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
        //showCalendarPermissionDialog();

    }
    //    ------------ FOR A/B TESTING --------------
    //    ------------ function for showing 'permission to access calender' popup -------------------
//        private void showCalendarPermissionDialog() {
//            AlertDialog.Builder builder = new AlertDialog.Builder(this);
//            builder.setTitle("Calendar Permission")
//                    .setMessage("This app requires calendar permission to access your calendar. Do you want to grant permission?")
//                    .setPositiveButton("Grant", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            // Action when 'Grant' is clicked
//                        }
//                    })
//                    .setNegativeButton("Deny", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            // Action when 'Deny' is clicked
//                        }
//                    })
//                    .show();
//        }
    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        return navController.navigateUp() || super.onSupportNavigateUp();
    }

    @Override
    protected void onStop() {
        super.onStop();
        showNotification();  // Trigger the notification when app goes to background
    }
    @Override
    protected void onPause() {
        super.onPause();
        showNotification();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        showNotification();
    }

    private void showNotification() {
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);


        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_notification)
                .setContentTitle("Medication reminder")
                .setContentText("You have 1 medication left for today.")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);

        notificationManager.notify(NOTIFICATION_ID, builder.build());
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence channelName = "My Channel";
            String channelDescription = "Channel for app closure notifications";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;

            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, channelName, importance);
            channel.setDescription(channelDescription);

            notificationManager.createNotificationChannel(channel);
        }
    }
}
