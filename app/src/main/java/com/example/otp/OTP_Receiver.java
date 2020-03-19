package com.example.otp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Telephony;
import android.telephony.SmsMessage;
import android.widget.EditText;

public class OTP_Receiver extends BroadcastReceiver {
    private static EditText editText;
    public void setEditText(EditText editText){
        OTP_Receiver.editText = editText;
    }
    @Override
    public void onReceive(Context context, Intent intent) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
            SmsMessage[] messages = Telephony.Sms.Intents.getMessagesFromIntent(intent);

            for (SmsMessage smsMessage : messages)
            {
                String message = smsMessage.getMessageBody();
            }
        }
    }
}
