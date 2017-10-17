-dontshrink
-optimizationpasses 5 #指定代码的压缩级别
-dontusemixedcaseclassnames #包明不混合大小写
-dontskipnonpubliclibraryclasses #不去忽略非公共的库类
#-dontoptimize #优化  不优化输入的类文件
-dontpreverify #预校验
-ignorewarning #忽略警告
-verbose #混淆时是否记录日志
 # 混淆时所采用的算法
-optimizations !code/simplification/arithmetic,!field/*,!class/merging/*

# 保留签名，解决泛型、类型转换的问题
-keepattributes Signature
-keepattributes Exceptions

# 不混淆带有 annotation 的变量 和 函数
-keepattributes *Annotation*
-renamesourcefileattribute SourceFile
-keepattributes SourceFile,LineNumberTable

##记录生成的日志数据,gradle build时在本项目根目录输出##
#apk 包内所有 class 的内部结构
-dump proguard/class_files.txt
#未混淆的类和成员
-printseeds proguard/seeds.txt
#列出从 apk 中删除的代码
-printusage proguard/unused.txt
#混淆前后的映射
-printmapping proguard/mapping.txt
########记录生成的日志数据，gradle build时 在本项目根目录输出-end######

-keepclassmembers,allowoptimization enum * {
      public static **[] values();
      public static ** valueOf(java.lang.String);
}
