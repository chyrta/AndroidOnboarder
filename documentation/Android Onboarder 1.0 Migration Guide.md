# Android Onboarder 1.0 Migration Guide

Android Onboarder 1.0 a is first and latest major release of Android Onboarder which helps you to create beautiful onboarding experience for the users of your app. Recently, Google has released their own [guidelines]("material.io/guidelines/growth-communications/onboarding.html") of how onboarding should works in Android apps which support Material Design pattern.

## New Requirements
Android Onboarder works starting from API 16 and targeted to Android Oreo API 26.

## Breaking API changes

### Kotlin
First release of the library was rewritten to Kotlin to reduce size of the codebase and provides support of first-class supported of the modern language by Google.

### Creating of onboarding pages
One of the weak points of the library as its many copycats around Github is creating onboarging simply with constructor and provided parameters which strongly restricted of what do we want to see in the result. Android Onboarder offers you to use classic Builder patterns while creating onboarding pages.

Previously:
```java
OnboarderPage onboarderPage1 = new OnboarderPage("Planet Earth", "Our lovely pale blue dot", R.drawable.planet1);
OnboarderPage onboarderPage2 = new OnboarderPage("Venus", "The love goddess", R.drawable.planet2);
OnboarderPage onboarderPage3 = new OnboarderPage("Mars", "Say hi to Curiosity!", R.drawable.planet3);

onboarderPage1.setBackgroundColor(R.color.onboarder_bg_1);
onboarderPage2.setBackgroundColor(R.color.onboarder_bg_2);
onboarderPage3.setBackgroundColor(R.color.onboarder_bg_3);

List<OnboarderPage> pages = new ArrayList<>();

pages.add(onboarderPage1);
pages.add(onboarderPage2);
pages.add(onboarderPage3);

for (OnboarderPage page : pages) {
    page.setTitleColor(R.color.primary_text);
    page.setDescriptionColor(R.color.secondary_text);
    page.setMultilineDescriptionCentered(true);
}

setSkipButtonTitle("Skip");
setFinishButtonTitle("Finish");

setOnboardPagesReady(pages);
```

Now:
```java
addPage(OnboarderPage.newCreator()
            .title("Planet Earth")
            .description("Our lovely pale blue dot")
            .backgroundColor(R.color.black_transparent)
            .imageResourceId(R.drawable.planet1)
            .create());
addPage(OnboarderPage.newCreator()
            .title("Venus")
            .description("The love goddess")
            .backgroundColor(R.color.black_transparent)
            .imageResourceId(R.drawable.planet2)
            .create());
addPage(OnboarderPage.newCreator()
            .title("Mars")
            .description("Say hi to Curiosity")
            .backgroundColor(R.color.black_transparent)
            .imageResourceId(R.drawable.planet3)
            .create());
addGetStartedButton(GetStartedButton.newCreator()
            .text("Get started")
            .textColorResourceId(R.color.colorAccent)
            .create());
startOnboarding();
```

### Introducing Get Started Button


### Reducing customization
Regarding Google's in direction of describing, as a creator of the library I decided to reduce the respecting to support key features as the aim of the library is to help developers reduce quantity of hours on implementing onboarding stuff.

Due to that changes, skip and finish buttons were removed.

#### Removed Skip and Finish buttons
These buttons were removed, use Getting Started.
```java
setSkipButtonTitle("Skip");
setFinishButtonTitle("Finish")
```


Previously:
```java
@Override
public void onSkipButtonPressed() {
    super.onSkipButtonPressed();
    Toast.makeText(this, "Skip button was pressed!", Toast.LENGTH_SHORT).show();
}

@Override
public void onFinishButtonPressed() {
    Toast.makeText(this, "Finish button was pressed", Toast.LENGTH_SHORT).show();
}
```

Now:
```java
@Override
public void onGetStartedButtonPressed() {
    Toast.makeText(this, "Skip button was pressed!", Toast.LENGTH_SHORT).show();
}
```

Presenting new 'Get Started', you have take care of all the stuff which should be happened after in
