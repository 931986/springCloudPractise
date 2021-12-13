package com.SpringCloud.util;

import java.security.MessageDigest;

public class MD5 {

    //    try
//    定义char[] hexChars 0-9 a-f
//   把传来的字符转bytes[]
//    调用MessageDigest get "md5"  md.update(bytes)
//    遍历 bytes   ,通过定义的chars[]经过位运算存起来，return string(chars)
 public static  String encrypt(String str) throws Exception {

     try{

         char[] hexChars={'0','1','2','3','4','5','6','7','8','9','a','a','b','c','d','e','f'};
         byte[] bytes=str.getBytes();
         MessageDigest md=MessageDigest.getInstance("md5");
         md.update(bytes);
         int k=0;
         char[] chars=new char[bytes.length*2];
         for (byte b : bytes) {
             chars[k++] = hexChars[b >>> 4 & 0xf];
             chars[k++] = hexChars[b & 0xf];
         }
         return new String(chars);
     }catch(Exception e){
         e.printStackTrace();
         throw  new Exception("md5加密出错"+e);
     }
 }

}