package com.fdsc.util;


import java.util.ArrayList;
import java.util.List;

public  class PageUtil {

    /**
     * 分页列表数据
     *
     * @param tasks
     * @param page
     * @param pageSize
     * @return
     */
    public static List<?>   getPage(List<?> tasks, int page, int pageSize) {
        int beginNum = (page - 1) * pageSize;
        int endNum = 0;
        if ((page) * pageSize < tasks.size()) {
            endNum = (page) * pageSize;
        } else {
            endNum = tasks.size();
        }
        List<Object> taskList = new ArrayList<Object>(10);
        for (int i = beginNum; i < endNum; i++) {
            taskList.add(tasks.get(i));
        }
        return taskList;
    }

}
