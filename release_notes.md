# Release Notes

## v2.5.5
- Improved pattern matching in provider search so special characters are easier to search against
- Fixed issue when no provider brands are found when mapping the checkout session state

## v2.5.4
- Fixed issue with checkout not loading correctly when navigating back from a provider

## v2.5.3
- Fixed issue with selected provider is not remembered correctly for returning user journey

## v2.5.2
- Added payment reference to various screens
- Updated SDK text in various screens 

## v2.5.1
- Fixed minor bug in displaying region specific text

## v2.5.0
- Added Dutch (NL) strings
- Added new optional parameter (```countryCodeProviderSort```) when starting a payment to prioritise providers in the list of that country.
- Updated provider sorting rules to use new ```countryCodeProviderSort``` parameter
- Updated SDK text in various screens
- Updated UI on supplementary attributes screen
- ```com.google.android.material:material``` updated to version 1.9.0
- ```androidx.core:core-ktx``` updated to version 1.10.1

## v2.4.6-beta02
- Improved bottom sheet expand logic to prevent ```setExpandedOffset``` crash in the bottom sheet
- Fixed analytics data mapping crash

## v2.4.6-beta01
- Added potential fix for processing of close checkout events

## v2.4.5
- Fixed issue with SDK callback listener being triggered multiple times if aborted during processing step
- Added potential fix for SDK not displaying

## v2.4.4
- Added fix for bitmap recycle crash
- Added fix for fragment not attached crash

## v2.4.3
- Fixed issue where multiple SDK instances could be launched
- Updated returning user journey flows:
-- EU payment will always return to the provider selection screen
-- GB payments will return to the summary screen unless the provider is unavailable, then they will return to the provider selection screen

## v2.4.2
- Updated processing payment display time out from 30 seconds to 10 seconds

## v2.4.1
- Minor start up performance improvement

## v2.4.0
- Improved payment status checking to better reflect the final status of the payment
- Added new payment pending screen
- Updated failed payment UI state

## v2.3.8
- Added localised spanish strings

## v2.3.7
- Improved provider image mapping 

## v2.3.6
- Added localised french strings

## v2.3.5
- Improved checking of payment state when deep linking back into SDK
- Fixed string replacement issue on payment status screen

## v2.3.4
- Fixed a crash when receiving invalid image urls from the backend

## v2.3.3
- Fixed a crash when starting checkout with the keyboard open
- Added fix for potential issues mapping the logo sprite
- Updated SDK copy
- Updated kotlin to version 1.8.10

## v2.3.2
- Fixed a bug with IBANs not being validated when changing provider

## v2.3.1
- Fixed a potential crash when tracking events
- Improved exception handling in network layer
- Updated Sentry dependency to 6.15.0

## v2.3.0
- Added support for merchant incentives to be displayed
- Added fallback for unknown legal text
- Changing provider with an IBAN on the summary screen now navigates back to the enter IBAN screen
- IBANs are now validated before continuing to the next step
- Kotlin version updated 1.8.0

## v2.2.0
- Removed Avios functionality
- Search functionality added to the child provider screen
- Searching in the provider screens now highlights the search text
- Updated tracking keys for the search event
- UI improvements to the provider screens
- Added german locale support
- IBAN entry flow improved

## v2.1.1
- Fixed issue with ```OnPaymentSessionListener.onPaymentAborted()``` being called when a payment has completed or failed
- Base URL is now no longer nullable

## v2.1.0
- Update target SDK version to 32. Up from 31
- App compat version updated to 1.5.0
- Google services updated to 4.3.13
- Kotlin version updated to 1.7.10
- Added base url to enable setting a custom base URL. This overrides the enum defined endpoint

## v2.0.4
- Improved logic around checking for Espresso tests
- Kotlin version updated to 1.6.21
- Core KTX updated to 1.8.0
- AppCompat updated to 1.4.2
- Material components updated to 1.6.1

## v2.0.3
- Updated error logging
- Fixed several issues with tracking calls
- Fixed rare fragment state crash

## v2.0.2
- Updated welcome copy

## v2.0.1
- Promoted SDK to stable
- Updated servers from enum class to a sealed class

## v2.0.1-beta15
- Fixed publishing issue

## v2.0.1-beta14
- Fixed issue with deep links not opening correctly
- Added potential crash fix when opening CheckoutParentFragment

## v2.0.1-beta13
- Added potential fix for ```NullPointerException``` when opening CheckoutParentFragment
- Fixed issue with abort callback not being triggered
- Updated several dependencies to the latest versions

## v2.0.1-beta12
- Fixed issue with abort callback not being triggered

## v2.0.1-beta11
- Fixed issue when closing the bottom sheet as soon as it is opened.

## v2.0.1-beta10
- Fixed issue with payment failure callback being called twice when trying a new payment method after a rejected payment.
- Fixed bug with UI not being displayed after a failed payment is retried and was a success.

## v2.0.1-beta9
- Improved checks for url encoding and url data ordering

## v2.0.1-beta8
- Improved checks for when to reset the payment session data
- Added functionality for enabling SDK logging

## v2.0.1-beta7
- Renamed all resources in SDK to have ```banked_sdk_``` prefix to prevent being overridden in the parent app.

## v2.0.1-beta6
- Kotlin version updated to 1.6.0
- Java version updated to 11
- Target and compile SDK updated to 31 (Android 12)
- Various other dependency updates
- Initialisation moved to a later lifecycle function

## v2.0.1-beta5
- Fixed an issue where continue urls were not being correctly filtered when checking an existing payment flow.

## v2.0.1-beta4
- Added extra callback to ```OnPaymentSessionListener``` to get notified when the payment flow is aborted - ```onPaymentAborted()```.
- Clicking outside the dialog when a payment has failed or is a success will correctly trigger the ```OnPaymentSessionListener``` callback
- Minor improvements to ```OnPaymentSessionListener``` performance

## v2.0.1-beta3
- Updated copy on summary screen if there is not enough points to earn avios
- Fixed bug where sometimes the checkout popup would not open

## v2.0.1-beta2
- Updated "Agree & Continue" to "Continue"

## v2.0.1-beta1
- Removed terms checkbox from summary screen
- Onboarding screen is now always shown
- Updated onboarding screen
- Edit icons on summary screen updated to "Change" text labels

## v2.0.0
- Moving release to a final release

## v2.0.0-rc2
- Provider status is now displayed in the provider list
- Various bug fixes

## v2.0.0-rc1
- Initial version
