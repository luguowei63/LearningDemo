package com.lgw.android.testmodule.aidl;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by lgw on 1/26/21
 */
public class Message implements Parcelable {
    public long id;//消息id
    public String content;//消息内容
    public long time;//时间

    public Message() {
    }

    protected Message(Parcel in) {
        id = in.readLong();
        content = in.readString();
        time = in.readLong();
    }

    public static final Creator<Message> CREATOR = new Creator<Message>() {
        @Override
        public Message createFromParcel(Parcel in) {
            return new Message(in);
        }

        @Override
        public Message[] newArray(int size) {
            return new Message[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(content);
        dest.writeLong(time);
    }


    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", time=" + time +
                '}';
    }
}
