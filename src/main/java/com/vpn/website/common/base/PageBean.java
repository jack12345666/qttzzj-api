package com.vpn.website.common.base; /**
 * 分页bean
 */
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

import java.util.List;

@Data
public class PageBean<T> {
    // 当前页
    private Integer currentPage = 1;
    // 每页显示的总条数
    private Integer pageSize = 10;
    // 总条数
    private Integer totalNum;
    // 是否有下一页
    private Integer isMore;
    // 总页数
    private Integer totalPage;
    // 开始索引
    private Integer startIndex;
    // 分页结果
    private List<T> items;

    public PageBean() {
        super();
    }

    public PageBean(Integer currentPage, Integer pageSize, Long totalNum) {
        super();
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalNum = totalNum.intValue();
        this.totalPage = this.pageSize==0?0:(this.totalNum+this.pageSize-1)/this.pageSize;
        this.startIndex = (this.currentPage-1)*this.pageSize;
        this.isMore = this.currentPage >= this.totalPage?0:1;
    }

    public PageBean(Long currentPage, Long pageSize, Long totalNum) {
        super();
        this.currentPage = currentPage.intValue();
        this.pageSize = pageSize.intValue();
        this.totalNum = totalNum.intValue();
        this.totalPage = this.pageSize==0?0:(this.totalNum+this.pageSize-1)/this.pageSize;
        this.startIndex = (this.currentPage-1)*this.pageSize;
        this.isMore = this.currentPage >= this.totalPage?0:1;
    }

    /**
     * 向旧版本兼容，将mybatis plus 的分页，转换成旧的分页对象
     * @param page
     */
    public PageBean(Page page) {
        super();
        this.currentPage = ((Long)page.getCurrent()).intValue();
        this.pageSize = ((Long)page.getPages()).intValue();
        this.totalNum = ((Long)page.getTotal()).intValue();
        this.totalPage = this.pageSize==0?0:(this.totalNum+this.pageSize-1)/this.pageSize;
        this.startIndex = (this.currentPage-1)*this.pageSize;
        this.isMore = this.currentPage >= this.totalPage?0:1;
    }

    /**
     * 向旧版本兼容，将mybatis plus 的分页，转换成旧的分页对象,配合转换后的DTO
     * @param page
     */
    public PageBean(Page page,List<T> items) {
        super();
        this.currentPage = ((Long)page.getCurrent()).intValue();
        this.pageSize = Math.toIntExact(page.getSize());
        this.totalNum = ((Long)page.getTotal()).intValue();

        this.totalPage = this.pageSize==0?0:(this.totalNum+this.pageSize-1)/this.pageSize;
        this.startIndex = (this.currentPage-1)*this.pageSize;
        this.isMore = this.currentPage >= this.totalPage?0:1;
        this.items = items;
    }
}
