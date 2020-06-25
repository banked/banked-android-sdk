package com.banked.demoapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.banked.checkout.CheckoutActivity

class MainActivity : AppCompatActivity() {

    var CHECKOUT_REQUEST_CODE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val appLinkIntent = intent
        val appLinkAction = appLinkIntent.action
        val appLinkData = appLinkIntent.data

        if (Intent.ACTION_VIEW == appLinkAction) {
            val id = appLinkData?.getQueryParameter("id")
            if (id != null) {
                val checkoutIntent = Intent(
                    this@MainActivity,
                    CheckoutActivity::class.java
                )

                checkoutIntent.putExtra("paymentId", id)

                startActivityForResult(checkoutIntent, CHECKOUT_REQUEST_CODE)
            };
        }

        val button: Button = findViewById(R.id.button);

        button.setOnClickListener {
            val checkoutIntent = Intent(
                this@MainActivity,
                CheckoutActivity::class.java
            )

            // This should be a payment session ID generated by calling the Banked API
            // See our documentation for more details
            // https://developer.banked.com/docs/getting-started
            //
            // You need to specify the payer details when creating the payment session
            checkoutIntent.putExtra("paymentId", "__YOUR_PAYMENT_SESSION_ID__")

            startActivityForResult(checkoutIntent, CHECKOUT_REQUEST_CODE)
        };
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Check which request we're responding to
        if (requestCode == CHECKOUT_REQUEST_CODE) {
            // Make sure the request was successful
            if (resultCode == Activity.RESULT_OK) {
                // The payment session has been completed
                // Get the value for "success" from the Extras to see if the payment was successful or failed
                val success = data?.getBooleanExtra("success", false)
            } else if (resultCode == Activity.RESULT_CANCELED) {
                // The payment session has been canceled without proceeding with the payment
            }
        }
    }
}