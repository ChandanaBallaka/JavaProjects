package com.miniproject.foodapp.service;


import com.twilio.Twilio;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import org.springframework.stereotype.Service;


@Service
public class SmsService
{
    private static final String ACCOUNT_SID="sid";
    private static final String AUTH_ID="auth";
    static
    {
        Twilio.init(ACCOUNT_SID,AUTH_ID);
    }
    public boolean sendSms(String mobileNumber, String tfaCode)
    {
        Message.creator(new PhoneNumber(mobileNumber), new PhoneNumber("+no"),
                "Your Two Factor AUthentication code is:"+tfaCode).create();
        return false;
    }
}
