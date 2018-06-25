package com.earnest.event;

/**
 * Created by hr on 2018/6/16.
 * 只用作提醒
 */

public class MessageEvent {
    private int currMusicIndex;
    private int isNet=0;

    public int getCurrMusicIndex() {
        return currMusicIndex;
    }

    public void setCurrMusicIndex(int currMusicIndex) {
        this.currMusicIndex = currMusicIndex;
    }

    public int getIsNet(){
        return isNet;
    }

    public void setIsNet(int i){
        this.isNet=1;
    }

}
