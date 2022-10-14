# NotificationBarCustom
[![](https://jitpack.io/v/ParkSangSun1/ImpactRecyclerView.svg)](https://jitpack.io/#ParkSangSun1/ImpactRecyclerView)

🪄 Library that scrolls RecyclerView indefinitely, helps with Carousel functionality, highlights and aligns central items to further highlight one item


## Demo
|  ImpactRecyclerView
|--|
| <img src="/gifs/ImpactRecyclerView.gif" width="300" height="600"/> |


###### <br>
## Setup

Add it in your root `build.gradle` at the end of repositories:

```groovy
allprojects {
    repositories {
        //...omitted for brevity
        maven { url 'https://jitpack.io' }
    }
}
```



Add the dependency

```groovy
dependencies {
   implementation 'com.github.ParkSangSun1:ImpactRecyclerView:$latest_release'
}
```
<br>

## Usage
In XML, write as follows:
```xml
    <com.pss.impactrv.ImpactRecyclerView
        android:id="@+id/rv"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginEnd="100dp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintTop_toTopOf="parent" />
```
<br>

In Activity or Fragment, write as follows:

```kotlin
        val recyclerView = findViewById<ImpactRecyclerView>(R.id.rv)
        recyclerView
            .init(testArray(), this) //Inserts data and context
            .listener(object : ImpactRvListener {
                //Item click processing
                override fun onClickEvent(item: ImpactRvItem, position: Int) {
                    Toast.makeText(
                        this@MainActivity,
                        "onClickEvent p:$position",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            })
            .build() //Running RecyclerView
```
