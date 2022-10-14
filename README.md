# NotificationBarCustom
[![](https://jitpack.io/v/ParkSangSun1/ImpactRecyclerView.svg)](https://jitpack.io/#ParkSangSun1/ImpactRecyclerView)

🪄 Library that scrolls RecyclerView indefinitely, helps with Carousel functionality, highlights and aligns central items to further highlight one item


## Demo
|  ImpactRecyclerView
|--|
| <img src="/gifs/ImpactRecyclerView.gif" width="300" height="600"/> |


###### <br>
## Setup

Add it in your root `settings.gradle` at the end of repositories:

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

<br>

### Licensed under the [MIT License](LICENSE)

```
MIT License

Copyright (c) 2021 ParkSangSun1

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

