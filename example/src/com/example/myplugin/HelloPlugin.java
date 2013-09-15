package com.example.myplugin;

import org.apache.cordova.api.CallbackContext;
import org.apache.cordova.api.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

public class HelloPlugin extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("sayHelloWorld")) {
            String msg = "Hello " + args.getString(0);
            this.say(msg, callbackContext);
            return true;
        }
        return false;
    }

    private void say(String msg, CallbackContext callbackContext) {
        if (msg != null && msg.length() > 0) {
            callbackContext.success(msg);
        } else {
            callbackContext.error("Inavlid argument");
        }
    }
}