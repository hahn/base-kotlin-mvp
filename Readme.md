# Android base MVP Kotlin

### Architecture

### Requirements :
    Min SDK Version 21
    Target SDK Version 28
    Check the compileSdkVersion, and buildToolsVersion to be the latest
    Build Tools Version 28.0.3
    Java 1.8

## How to use this base project
1. Download or cline this project then change package id (id.example.mvp) to your package id
2. You can change package ID easily using [this script](https://github.com/hahn/android-template-generator)
3. Open the project in Android Studio
4. Profit

## How to implement a new screen following MVP

Imagine you have to implement a sign in screen.

1. Create a new package under `feature` directory called `signin`
2. Create an new Activity called **```SignInActivity```**
3. Create a new interface called **```SignInView```** that extends **```MvpView```**. Add functions like ```fun showSignInSuccessfull()```
4. Create a **```SignInPresenter```** class that extends **```BasePresenter<SignInView>```**.
5. Create a **```SignInModule```** class that will provide presenter class. Sample code: 

```
@Module
class SignInModule {

    @PerFeature
    @Provides
    fun providesSignInPresenter(dataManager: DataManager): SignInPresenter = SignInPresenter(dataManager)
}
```

6. Implement functions in **```SignInPresenter```** that your Activity requires to perform the necessary actions, e.g. **```signIn(email: String)```**. Once the sign in action finishes you should call **```mvpView?.showSignInSuccessful()```**.
7. Create a **```SignInPresenterTest```** and write unit tests for **```signIn(email)```**. Remember to mock the **```SignInView```** and also the DataManager.
8. Make your activity implement **```SignInView```** and implement the required functions like **```showSignInSuccessful()```**
9. In your activity, inject a new instance of **```SignInPresenter```** and call **```presenter.attachView(this)```** from override function **```attachView()```** and **```presenter.detachView()```** from override function **```detachView()```**. In ```onCreate()``` inject that activity, like this: ```AndroidInjection.inject(this)```
10. Open file **```FeatureModule.kt```** in directory ```core/di/module``` and add abstract function for SignInActivity.
```
    @PerFeature
    @ContributesAndroidInjector(modules = [SignInModule::class])
    abstract fun bindSignInActivity(): SignInActivity
```


### Library :
  - [Retrofit 2](http://square.github.io/retrofit/)
  - [OkHTTP 3](http://square.github.io/okhttp/)
  - [RXJava](https://github.com/ReactiveX/RxJava)
  - [Dagger 2](http://google.github.io/dagger/)
  - [Sherlock](https://github.com/ajitsing/Sherlock)
  - [leak canary](https://github.com/square/leakcanary)
  - [Timber](https://github.com/JakeWharton/timber)
