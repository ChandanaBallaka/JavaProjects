package com.miniproject.foodapp.service;


import com.twilio.Twilio;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import org.springframework.stereotype.Service;


@Service
public class SmsService
{
    private static final String ACCOUNT_SID="ACbff437a6ad335d1783f64955b6ae34d3";
    private static final String AUTH_ID="aff9ed42ddcc3471043dddf1e4426c1c";
    static
    {
        Twilio.init(ACCOUNT_SID,AUTH_ID);
    }
    public boolean sendSms(String mobileNumber, String tfaCode)
    {
        Message.creator(new PhoneNumber(mobileNumber), new PhoneNumber("+17817454682"),
                "Your Two Factor AUthentication code is:"+tfaCode).create();
        return false;
    }
}
