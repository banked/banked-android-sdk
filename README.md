# Banked Checkout SDK

The Banked SDK offers an interface for processing a payment session created using the Banked API.

## Installation

The Banked Android SDK is hosted on the GitHub package registry. In order to use the package you will need a GitHub account.

1) [Create Github personal access token](https://help.github.com/en/github/authenticating-to-github/creating-a-personal-access-token-for-the-command-line)
1) Store personal token in a `.github-properties` file in your project. 

        ```
        gpr.usr=GITHUB_USERID
        gpr.key=PERSONAL_ACCESS_TOKEN
        ```
1) Add `.github-properties` to your `.gitignore` file to ensure you don't accidentally commit your GitHub access details.
1) Update your app `build.gradle` file 

        ```
        def githubProperties = new Properties() githubProperties.load(new        FileInputStream(rootProject.file(".github.properties")))
        repositories {
                maven {
                    name = "GitHubPackages"
                    url = uri("https://maven.pkg.github.com/banked/banked-android-sdk")
                credentials {
                        username = githubProperties['gpr.usr']
                        password = githubProperties['gpr.key']
                    }
                }
            }
        ```
1) Update the dependancies in your app `build.gradle`

        ```
        dependencies {
         implementation 'com.banked:checkout:1.0.0'
         ....
        }
        ```
1) Sync your Android gradle project and you should have the Banked Android SDK installed and ready to use!
