package com.duwo.libnet.model

import java.io.Serializable
import java.util.*

class HttpHeaders : Serializable {
    private val serialVersionUID = 8458647755751403873L

    val FORMART_HTTP_DATA = "EEE, dd MMM y HH:mm:ss 'GMT'"
    val GMT_TIME_ZONE = TimeZone.getTimeZone("GMT")
    val HEAD_KEY_RESPONSE_CODE="ResponseCode"
    val HEAD_KEY_RESPONSE_MESSAGE="ResponseMessage"
    val HEAD_KEY_ACEPT="Accept"
    val HEAD_KEY_ACCEPT_ENCODING="Accept-Encoding"
    val HEAD_VALUE_ACCEPT_ENCODING="gzip,deflate"
    val HEAD_KEY_ACCEPT_LANGUAGE="Accept-Language"
    val HEAD_KEY_CONTENT_TYPE="Content-Type"
    val HEAD_KEY_CONTENT_LENGTH="Content-Length"
    val HEAD_KEY_CONTENT_ENCODING="Content-Encoding"




}