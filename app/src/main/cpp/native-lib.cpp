#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_scantest_MainActivity_getphoneSerial(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "Phone Serial: XLJADFLJADHF:HSD";
    return env->NewStringUTF(hello.c_str());
}
extern "C" JNIEXPORT jstring JNICALL
Java_com_example_scantest_MainActivity_getphonePackages(
        JNIEnv* env,
        jobject /* this */) {
    std::string packagesString = "Phone packages: 1\n 2\n 3\n 4";
return env->NewStringUTF(packagesString.c_str());
}