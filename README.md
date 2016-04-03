# Android Onboarder
A light-weight library that allows your to make a simple welcome screen in Material Design.

![alt tag](https://raw.githubusercontent.com/chyrta/AndroidOnboarder/master/art/androidOnboarder.gif)

Onboarding experience is a light-weight presentation about your application for new users. Some companies like Google, Telegram use that design practise in their application.

## Sample usage
```java
public class IntroActivity extends OnboarderActivity {

  List<OnboarderPage> onboarderPages;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    onboarderPages = new ArrayList<OnboarderPage>();
    OnboarderPage onboarderPage1 = new OnboarderPage("Title 1", "Description 1");
    onboarderPage1.setTitleColor(R.color.black);
    onboarderPage1.setDescriptionColor(R.color.white);

    onboarderPages.add(onboarderPage1);

    setOnboardPagesReady(onboarderPages);

  }

  @Override
  public void onSkipButtonPressed() {

  }

  @Override
  public void onNextButtonPresed() {

  }

}
```
