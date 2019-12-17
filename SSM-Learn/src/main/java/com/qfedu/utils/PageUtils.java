package com.qfedu.utils;

import lombok.Data;

import java.util.List;
@Data
public class PageUtils<T> {

    private long pageIndex;  //当前页码
    private long pageSize;  //页面大小
    private long totalCount; //总条数
    private long pageCount;  //总页数???

    private List<T> records; //每页的数据集合

    private long numberStart; //开始的页码序号
    private long numberEnd;  //结束序号


    public PageUtils(long pageIndex, long pageSize, long totalCount, List<T> records) {
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.totalCount = totalCount;

        this.records = records;

        this.pageCount = (totalCount%pageSize==0)?(totalCount/pageSize):(totalCount/pageSize+1);

        if (this.pageCount <= 10) {
            this.numberStart = 1;
            this.numberEnd = pageCount;
        } else {
            this.numberStart = pageIndex - 4;
            this.numberEnd = pageIndex + 5;
            if (numberStart < 1) {
                this.numberStart = 1;
                this.numberEnd = 10;
            } else if (numberEnd > pageCount) {
                this.numberEnd = pageCount;
                this.numberStart = pageCount - 9;
            }
        }
    }


}
