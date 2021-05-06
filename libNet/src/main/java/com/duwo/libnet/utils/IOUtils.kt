package com.duwo.libnet.utils

import java.io.*
import java.nio.charset.Charset


fun closeQuietly(closeable: Closeable?) {
    try {
        closeable?.close()
    } catch (e: Exception) {
        OkLogger.printStackTrace(e)
    }
}


fun flushQuietly(flushable: Flushable?) {
    try {
        flushable?.flush()
    } catch (e: Exception) {
        OkLogger.printStackTrace(e)
    }
}


fun toInputStream(input: CharSequence): InputStream {
    return ByteArrayInputStream(input.toString().toByteArray())
}

fun toInputStream(input: CharSequence, encoding: Charset):InputStream {
    val  bytes=input.toString().toByteArray(encoding)
    return  ByteArrayInputStream(bytes)
}

 fun toBufferedOutputStream(outputStream: OutputStream?): BufferedOutputStream? {
     if (outputStream==null) return  null
     return if (outputStream is BufferedOutputStream ) outputStream  else BufferedOutputStream(
         outputStream
     )
 }


fun toBufferedReader(reader: Reader):BufferedReader{
    return  if( reader is BufferedReader) reader else BufferedReader(reader)
}

fun toBufferedWriter(writer: Writer):BufferedWriter{
    return  if( writer is BufferedWriter) writer else BufferedWriter(writer)
}

@Throws(IOException::class)
fun toString(input: Reader?): String? {
    return String(toByteArray(input))
}

@Throws(IOException::class)
fun toString(input: Reader?, encoding: String?): String? {
    return String(toByteArray(input), encoding)
}

fun toString(byteArray:ByteArray):String{
    return  String(byteArray)
}


fun toString (byteArray: ByteArray?,encoding: Charset?): String {
    if (byteArray==null||encoding==null)return String()
    return try {
        String(byteArray,encoding)
    }catch (e :UnsupportedEncodingException){
        String(byteArray)
    }
}


     fun











