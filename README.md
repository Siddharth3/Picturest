# Picturest

Picturest is a ImageLoader library with async loading image and auto cache properties.


## Feature
  
  - Cache clear option with complete and partially
  - Multi Image Format Support: Raw,Assert,Content Provider,Local File,WebImage etc.
  - Auto compress Image
  - Auto cache in memory and disk.
  - Auto recycle memory
  - Async load with callback with thread pool control.
  - Custom Load framework,use your custom library to load image,such as okHttp.
  - Builder Design Mode.


## Some Important Method

  **For checking logs**
  ImageLoader.log()
  
  **For display image**
  ImageLoader.createTask().web("your image link").into(imageView).start()
  
  **Cache control**
  ```
  ImageLoader.clearMemCache(80);//trim to 80%
  ImageLoader.clearMemCache();//clear all
  ImageLoader.clearDiskCache(this);//clear all
  ImageLoader.createTask().web("your image link").cleanCache(this);//clear custom memory and disk cache
  ImageLoader.createTask().web("your image link").cleanDiskCache(this);//clear custom disk cache
  ImageLoader.createTask().web("your image link").cleanMemCache();//clear custom memory cache
  ```
   
   **Callback**
   ```
   ImageLoader.createTask().web("your image link")
            .callback(new ImageLoader.OnResultListener() {
                @Override
                public void onFailed() {
                    //your job
                    Toast.makeText(MainActivity.this,"onFailed",Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onSuccess(Bitmap bitmap) {
                    //your job
                    Toast.makeText(MainActivity.this,"onSuccess",Toast.LENGTH_SHORT).show();
                }
            })
            .into(imageView).start();
    ```
            
    **Set Loading and Failed Resource**
    ``ImageLoader.createTask().web("cdn-img.easyicon.net/image/mix.png")
           .loadingRes(R.mipmap.ic_launcher)
           .failedRes(R.drawable.ic_launcher)
           .into(imageView).start();``

  

  
