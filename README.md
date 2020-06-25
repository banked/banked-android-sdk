
# Banked Checkout SDK

The Banked SDK offers an interface for processing a payment session created using the Banked API.

## Installation (Kotlin)

The Banked Android SDK is hosted on the GitHub package registry. In order to use the package you will need a GitHub account.

1) [Create Github personal access token](https://help.github.com/en/github/authenticating-to-github/creating-a-personal-access-token-for-the-command-line)

	**When creating your personal access token you need to enable the package:read permission**

1) Store personal token in a `.github-properties` file in your project. 

        gpr.usr=GITHUB_USERID
        gpr.key=PERSONAL_ACCESS_TOKEN

1) Add `.github-properties` to your `.gitignore` file to ensure you don't accidentally commit your GitHub access details.
1) Update your project `build.gradle` file to look like this:

        def githubProperties = new Properties()
        githubProperties.load(new FileInputStream(rootProject.file(".github-properties")))

        ...

        allprojects {
            repositories {
                google()
                jcenter()
                maven {
                    name = "GitHubPackages"
                    url = uri("https://maven.pkg.github.com/banked/banked-android-sdk")
                    credentials {
                        username = githubProperties['gpr.usr']
                        password = githubProperties['gpr.key']
                    }
                }
            }
        }

1) Ensure you set Java compatibility to 1.8

            android {
                compileOptions {
                    sourceCompatibility 1.8
                    targetCompatibility 1.8
                }
            }

            kotlinOptions {
                jvmTarget = "1.8"
            }

1) Update the dependancies in your app `build.gradle`

        dependencies {
         implementation 'com.banked:checkout:1.0.4'
         ....
        }
        
1) Ensure your application has the INTERNET permission in `AndroidManifest.xml`

        <uses-permission android:name="android.permission.INTERNET" />
        
1) Sync your Android gradle project and you should have the Banked Android SDK installed and ready to use!

## Usage (Kotlin)

The Checkout SDK uses dynamic fragments to handle the checkout flow. The SDK requires a FrameLayout element in the Activity or Fragment view you want to embed the Checkout flow in. The id should be `main_container`.

1) Add the FrameLayout to your view
	
	If you're calling the Checkout SDK from your MainActivity, stick this in your `activity_main.xml`.

        <FrameLayout
          android:layout_width="match_parent"
          android:layout_height="match_parent"
          android:id="@+id/main_container">
        </FrameLayout>
    
1) Generate a PaymentSession

	Use the Banked API to create a PaymentSession. Please read the API documentation for more detail - Banked API - Generating a Payment Session

	IMPORTANT - You must provide callback URLs as part of the PaymentSession which will return your users to your application once they have authorised the payment. There are success and failure redirects which you can specify - but as the SDK retrieves the PaymentSession when handling the callback, and this already has a more detailed status, its simplest to provide one callback URL for both.

	In order to handle the callback later, you will need the Payment ID - which is automatically added by Banked. However you must provide a templated URL for us to do this. Please use __PAYMENT_ID__ to indicate where to include the Payment ID.

	E.g. https://mybusinessname.com/callback/__PAYMENT_ID__ or https://mybusinessname.com/callback/?id=__PAYMENT_ID__

	You can choose not to use the templated URL - but in this case you would need to persist the Payment ID after the PaymentSession is created and handle this independently.

1) Trigger the Checkout flow by creating a custom Intent. You might want to put this in a button onclick handler.
	 
	 Replace `<payment session id>` with the ID of the payment session you created in the previous step.

        val checkoutIntent = Intent(
          this@MainActivity,
          CheckoutActivity::class.java
        )

        checkoutIntent.putExtra("paymentId", <payment session id>)

        startActivityForResult(checkoutIntent, CHECKOUT_REQUEST_CODE)
        
1) Add an intent filter to your AndroidManifest.xml file inside your activity.

	 This is required so the checkout will complete inside your application after a user has authorised a payment via their online banking or mobile banking application. Please replace `yourbusiness.com` with your desired domain name.

        <activity android:name=".MainActivity">
            ...    
            <intent-filter>
                <action android:name="android.intent.action.VIEW" />
                <category android:name="android.intent.category.DEFAULT" />
                <category android:name="android.intent.category.BROWSABLE" />

                <data
                    android:scheme="http"
                    android:host="yourbusiness.com"
                    android:pathPattern="/checkout" />
            </intent-filter>
         </activity>

1) In your Activity onCreate method add the following logic. This logic extracts the payment session ID from the app link you configured in the previous step when your application is opened via an App Link.

        val appLinkIntent = intent
        val appLinkAction = appLinkIntent.action
        val appLinkData = appLinkIntent.data

        val paymentSessionId = ""

        if (Intent.ACTION_VIEW == appLinkAction) {
            val id = appLinkData?.getQueryParameter("id")
            if (id != null) {
                paymentSessionId = id;
            };
        } 

1) Update your onCreate logic to initialise the SDK with the payment session ID extracted from the intent in the previous step if it exists

		if (paymentSessionId !== "") {
	        val checkoutIntent = Intent(
	          this@MainActivity,
	          CheckoutActivity::class.java
	        )

	        checkoutIntent.putExtra("paymentId",  paymentSessionId)

	        startActivityForResult(checkoutIntent, CHECKOUT_REQUEST_CODE)
		}
