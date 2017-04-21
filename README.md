[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-AndroidOnboarder-green.svg?style=true)](https://android-arsenal.com/details/1/3393) ![Maven Badge](https://maven-badges.herokuapp.com/maven-central/com.github.chyrta/AndroidOnboarder/badge.svg) [![CircleCI](https://circleci.com/gh/chyrta/AndroidOnboarder.svg?style=svg)](https://circleci.com/gh/chyrta/AndroidOnboarder)

# Android Onboarder
Android Onboarder is a lightweight library that helps you to create a simple and beautiful welcome screen (as known as App Intro, Onboarding Experience and etc.) for your users.

<image src="https://raw.githubusercontent.com/chyrta/AndroidOnboarder/master/art/demo1.gif" width="250px"> <image src="https://raw.githubusercontent.com/chyrta/AndroidOnboarder/master/art/demo2.gif" width="250px"> <image src="https://raw.githubusercontent.com/chyrta/AndroidOnboarder/master/art/demo3.gif" width="250px">

## Usage

#### Gradle

Add dependency in your build.gradle

```groovy
compile 'com.github.chyrta:AndroidOnboarder:0.7'
```
#### Maven

```
<dependency>
    <groupId>com.github.chyrta</groupId>
    <artifactId>AndroidOnboarder</artifactId>
    <version>0.7</version>
    <type>pom</type>
</dependency>
```

#### Implementation

Create an activity which should inherits from OnboarderActivity. Look at the example below to see how that library works.

```java

public class IntroActivity extends OnboarderActivity {

  List<OnboarderPage> onboarderPages;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    onboarderPages = new ArrayList<OnboarderPage>();

    // Create your first page
    OnboarderPage onboarderPage1 = new OnboarderPage("Title 1", "Description 1");
    OnboarderPage onboarderPage2 = new OnboarderPage(R.string.app_title, R.string.app_description, R.drawable.my_awesome_image);

    // You can define title and description colors (by default white)
    onboarderPage1.setTitleColor(R.color.black);
    onboarderPage1.setDescriptionColor(R.color.white);

    // Don't forget to set background color for your page
    onboarderPage1.setBackgroundColor(R.color.my_awesome_color);

    // Add your pages to the list
    onboarderPages.add(onboarderPage1);
    onboarderPages.add(onboarderPage2);

    // And pass your pages to 'setOnboardPagesReady' method
    setOnboardPagesReady(onboarderPages);

  }

  @Override
  public void onSkipButtonPressed() {
    // Optional: by default it skips onboarder to the end
    super.onSkipButtonPressed();
    // Define your actions when the user press 'Skip' button
  }

  @Override
  public void onFinishButtonPressed() {
    // Define your actions when the user press 'Finish' button
  }

}
```

#### Tips

Remember that you can (Inside your Activity that extends ```OnboarderActivity```):
- Change dot's colors (active and inactive)
- Darken the layout where buttons are placed
- Change divider color, height (in dp) and visibility
- Choose to use ```FloatingActionButton``` or not
- Set text size of title and description
- Set title to skip and finish buttons
- Hide skip button from the user

```java

setActiveIndicatorColor(android.R.color.white);
setInactiveIndicatorColor(android.R.color.darker_gray);
shouldDarkenButtonsLayout(true);
setDividerColor(Color.WHITE);
setDividerHeight(2);
setDividerVisibility(View.GONE);
shouldUseFloatingActionButton(true);
setSkipButtonTitle("Skip");
setFinishButton("Finish");
setSkipButtonHidden();
setTitleTextSize(12);
setDescriptionTextSize(12);
```


## Contributions

Feel free to create issues and pull requests

## License

```
MIT License

Copyright (c) 2017 Dzmitry Chyrta, Daniel Morales

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
