<img src="Logo.png" width="200" alt="Momentz android library">

[![](https://jitpack.io/v/bolaware/momentz.svg)](https://jitpack.io/#bolaware/momentz)

Momentz is an android library for showing timed view just like WhatsApp, 
Facebook and Instagram stories.You can embed any type of view 
into it(`ImageView`, `VideoView`, `ViewGroups` etc). 

<img src="momentz_demo.gif" alt="Momentz android library for instagram, facebook, snapchat library" width="200" height="400">

### Adding it to your project

**Step 1.** Add it in your root build.gradle at the end of repositories:

    allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

**Step 2.** Add the dependency

    dependencies {
	     implementation 'com.github.bolaware:momentz:v2.0'
	}
	
### Initiate
You can checkout the sample app in the project, initiating Momentz is as simple as this: 

    val listOfViews = listOf(
        MomentzView(textView, 5),
        MomentzView(customView, 5),
        MomentzView(locallyLoadedImageView, 6),
        MomentzView(internetLoadedImageView, 10),
        MomentzView(internetLoadedVideoView, 60)
    )

    Momentz(this, listOfViews, container, this).start()

You can start, pause, resume, go to next and previous using these methods respectively `Momentz.start()`, `Momentz.pause()`, `Momentz.resume()`, `Momentz.next()`, `Momentz.prev()`.

Run the project's app and [Check out the way I used it in the my app's MainActivity](https://github.com/bolaware/momentz/blob/master/app/src/main/java/com/bolaware/viewsslidetimer/MainActivity.kt)

```
Momentz
MIT License

Copyright (c) 2017

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
