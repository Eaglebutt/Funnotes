package ru.eaglebutt.funnotes.Model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.sql.Timestamp;

@Entity(tableName = "events")
public class Event {


    @SerializedName(value = "start_time")
    @Expose
    private long startTime;
    @SerializedName(value = "end_time")
    @Expose
    private long endTime;
    @SerializedName(value = "description")
    @Expose
    private String description;
    @SerializedName(value = "id")
    @Expose
    private int serverId;
    @SerializedName(value = "title")
    @Expose
    private String title;

    @PrimaryKey(autoGenerate = true)
    private int localId;
    private long lastUpdateTime;
    private int status;
    private long created;


    public static class STATUSES {
        public static int SYNCHRONIZED = 0;
        public static int NEW = 1;
        public static int UPDATED = 2;
        public static int DELETED = 3;
    }

    public Event() {
    }

    @Ignore
    public Event(Event event) {
        this.startTime = event.startTime;
        this.endTime = event.endTime;
        this.description = event.description;
        this.serverId = event.serverId;
        this.title = event.title;
        this.localId = event.localId;
        this.lastUpdateTime = event.lastUpdateTime;
        this.status = event.status;
        this.created = event.created;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    public long getCreated() {
        return created;
    }

    public int getServerId() {
        return serverId;
    }

    public void setServerId(int serverId) {
        this.serverId = serverId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLocalId() {
        return localId;
    }

    public void setLocalId(int localId) {
        this.localId = localId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @NonNull
    @Override
    public String toString() {
        return "local id " + localId +
                "\nserver id " + serverId +
                "\ntitle " + title +
                "\ndescription " + description +
                "\nstart time " + new Timestamp(startTime).toString() +
                "\nend time " + new Timestamp(endTime).toString()  +
                "\nstatus " + status +
                "\ncreated "+ new Timestamp(created).toString() +
                "\nupdated " + new Timestamp(lastUpdateTime) +
                "\n";
    }

    public long getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(long lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public void update(){
        lastUpdateTime = System.currentTimeMillis();
    }
}