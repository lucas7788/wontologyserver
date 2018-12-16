package com.github.ontio;

import com.github.ontio.thread.BlockSyncThread;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class TaskWareSyn {

    @Autowired
    private ApplicationContextProvider applicationContextProvider;


    @PostConstruct
    public void init() {

        BlockSyncThread blkSyncThread = applicationContextProvider.getBean("BlockSyncThread", BlockSyncThread.class);
        blkSyncThread.start();
    }
}
