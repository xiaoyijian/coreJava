package com.xyj.log;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by xiaoyijian on 2016/8/2.
 */
public class GlobalLogger {
    public static void main(String[] args) {
        Logger.getLogger("global").info("start");

        Logger.getGlobal().setLevel(Level.INFO);
        Logger.getGlobal().info("File->Open menu item selected");

    }
}
