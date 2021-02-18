package com.Misakill.community.entity;


/*
*  用于分页的类
*/
public class Page {

    //当前页码
    private int current = 1;
    //一页所显示的数量
    private int limit = 10;
    //数据的总数!!
    private int rows;
    //查询路径（复用分页连接）
    private String path;

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        if(current >= 1)   //对数据进行严谨的检查
            this.current = current;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        if(limit >= 1 && limit <= 10)
            this.limit = limit;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        if(rows >= 0)
            this.rows = rows;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    /**
     * 获取当前页的起始行号
     * @return
     */
    public int getOffset(){
        return (current - 1) * limit;
    }

    /**
     * 获取总页数
     * @return
     */
    public int getTotal(){
        if(rows % limit == 0){
            return rows / limit;
        }
        else{
            return rows / limit + 1;
        }
    }

    /**
     * 这两个函数就比较抽象了，就是每一页可以显示的页面数量
     * 即 假如当前页为3 ，from写成current-2  to写成current+2 那么显示为：
     * 1 2 3 4 5
     * 即 假如当前页为3 ，from写成current-1  to写成current+1 那么显示为：
     * 2 3 4
     * @return
     */
    public int getFrom(){
        int from = current - 3;
        return from < 1 ? 1 : from;  //判断是否小于等于第一页
    }

    public int getTo(){
        int to = current + 3;
        int total = getTotal();
        return to > total ? total : to;
    }
}
