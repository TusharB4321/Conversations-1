package eu.siacs.conversations.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import eu.siacs.conversations.R;
import eu.siacs.conversations.ui.util.SettingsUtils;

public class ConversationActivity extends AppCompatActivity {

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);  // Your splash screen layout here

		// Delay the transition to ConversationsActivity for 1-2 seconds (for splash effect)
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				startActivity(new Intent(ConversationActivity.this, ConversationsActivity.class));
				finish();  // Finish ConversationActivity so it doesn't stay in the stack
			}
		}, 1500);  // 1500 milliseconds = 1.5 seconds delay
	}

	@Override
	protected void onResume() {
		super.onResume();
		SettingsUtils.applyScreenshotPreventionSetting(this);
	}
}
