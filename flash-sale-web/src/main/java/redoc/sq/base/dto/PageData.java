package redoc.sq.base.dto;

import org.springframework.data.domain.Page;

public class PageData {

    public static PageData convert(final Page<?> page) {
        final PageData pageData = new PageData();
        pageData.setFirst(page.isFirst());
        pageData.setLast(page.isLast());
        pageData.setNumber(page.getNumber());
        pageData.setTotalPages(page.getTotalPages());
        pageData.setNumberOfElements(page.getNumberOfElements());
        pageData.setSize(page.getSize());
        pageData.setTotalElements(page.getTotalElements());
        return pageData;
    }

    private long totalElements;

    private int numberOfElements;

    private int totalPages;

    private int number;

    private boolean first;

    private boolean last;

    private int size;

    public long getTotalElements() {
        return this.totalElements;
    }

    public void setTotalElements(final long total) {
        this.totalElements = total;
    }

    public int getNumberOfElements() {
        return this.numberOfElements;
    }

    public void setNumberOfElements(final int rows) {
        this.numberOfElements = rows;
    }

    public int getTotalPages() {
        return this.totalPages;
    }

    public void setTotalPages(final int pages) {
        this.totalPages = pages;
    }

    public boolean isFirst() {
        return this.first;
    }

    public void setFirst(final boolean first) {
        this.first = first;
    }

    public boolean isLast() {
        return this.last;
    }

    public void setLast(final boolean last) {
        this.last = last;
    }

    public int getSize() {
        return this.size;
    }

    public void setSize(final int size) {
        this.size = size;
    }

    public int getNumber() {
        return this.number;
    }

    public void setNumber(final int page) {
        this.number = page;
    }
}
