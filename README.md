# MetricsServerClient
metrics-server java client base on  io.fabric8 kubernetes client

1、golang build cmd/metrics/gen.go ，生成metrics可执行程序

2、使用第一步生产的可执行程序，生成schema.json, metrics.exe >metrics.json

3、使用jsonschema2pojo(https://github.com/joelittlejohn/jsonschema2pojo)生成java module
   从https://github.com/joelittlejohn/jsonschema2pojo/releases 下载最新正式版，解压。
   执行：F:\tmp\jsonschema2pojo-0.5.1\bin>jsonschema2pojo.bat -s F:\\tmp\\metrics.json -t F:\\tmp\\gen 生成ava module 到 目录下

4、修改生成的 java module 文件，添加class anontation  
```
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
```
