package com.teamapps.milkservice.objects;

/**
 * @author Mihai Alexandru
 * @date 23.12.2018
 */
public class PageResult<T, C> {

    private long totalElements;

    private long pageSize;

    private long pageNumber;

    private long totalPages;

    private C criteria;

    private T data;

    private PageResult() {
    }

    public long getTotalElements() {
        return totalElements;
    }

    public long getPageSize() {
        return pageSize;
    }

    public long getPageNumber() {
        return pageNumber;
    }

    public long getTotalPages() {
        return totalPages;
    }

    public C getCriteria() {
        return criteria;
    }

    public T getData() {
        return data;
    }


    public static final class PageResultBuilder<T, C> {
        private long totalElements;
        private long pageSize;
        private long pageNumber;
        private long totalPages;
        private C criteria;
        private T data;

        private PageResultBuilder() {
        }

        public static <T, C> PageResultBuilder<T, C> aPageResult(T data, C criteria) {
            PageResultBuilder<T, C> pageResultBuilder = new PageResultBuilder<>();
            pageResultBuilder.data = data;
            pageResultBuilder.criteria = criteria;
            return pageResultBuilder;
        }

        public PageResultBuilder<T, C> withTotalElements(long totalElements) {
            this.totalElements = totalElements;
            return this;
        }

        public PageResultBuilder<T, C> withPageSize(long pageSize) {
            this.pageSize = pageSize;
            return this;
        }

        public PageResultBuilder<T, C> withPageNumber(long pageNumber) {
            this.pageNumber = pageNumber;
            return this;
        }

        public PageResultBuilder<T, C> withTotalPages(long totalPages) {
            this.totalPages = totalPages;
            return this;
        }

        public PageResultBuilder<T, C> withCriteria(C criteria) {
            this.criteria = criteria;
            return this;
        }

        public PageResultBuilder<T, C> withData(T data) {
            this.data = data;
            return this;
        }

        public PageResult<T, C> build() {
            PageResult<T, C> pageResult = new PageResult<>();
            pageResult.totalElements = this.totalElements;
            pageResult.data = this.data;
            pageResult.pageSize = this.pageSize;
            pageResult.criteria = this.criteria;
            pageResult.pageNumber = this.pageNumber;
            pageResult.totalPages = this.totalPages;
            return pageResult;
        }
    }
}
