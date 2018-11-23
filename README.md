# Picturest

Picturest is a Image loading library with async loading image and auto cache properties.


## Feature
  
  - Cache clear option with complete and partially.
  - Wide customization of ImageLoader's configuration.
  - Multiple format support: Raw,Assert,Content Provider,Local File,WebImage etc.
  - Automatic compress image.
  - Automatic memory caching.
  - Auto recycle memory.
  - Multithread image loading (async).
  - Builder Design Mode.


## Some Important Method

  **For checking logs**
  ```
  ImageLoader.log();
  ```
  
  **For display image**
  ```
  ImageLoader.createTask().web("your image link").into(imageView).start();
  ```
  
  **Cache control**
  ```
  ImageLoader.clearMemCache(80);//trim to 80%
  ImageLoader.clearMemCache();//clear all
  ImageLoader.clearDiskCache(this);//clear all
  ImageLoader.createTask().web("your image link").cleanCache(this);//clear custom memory and disk cache
  ImageLoader.createTask().web("your image link").cleanDiskCache(this);//clear custom disk cache
  ImageLoader.createTask().web("your image link").cleanMemCache();//clear custom memory cache
  ```
   
  **Set Loading and Failed Resource**
  ```
  ImageLoader.createTask().web("your image link")
           .loadingRes(R.mipmap.ic_launcher)
           .failedRes(R.drawable.ic_launcher)
           .into(imageView).start();
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
