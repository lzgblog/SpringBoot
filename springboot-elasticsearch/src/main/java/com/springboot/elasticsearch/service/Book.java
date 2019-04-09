package com.springboot.elasticsearch.service;

import org.springframework.data.elasticsearch.annotations.Document;

//查询地址为 http://127.0.0.1:9200/atguigu/book/_search
//查询地址为 http://127.0.0.1:9200/atguigu/book/1
//图书 需要使用Document注解标准该实体类   索引的名字indexName  索引的类型type
@Document(indexName = "atguigu",type = "book")
public class Book {
    private Integer id;
    private String name;
    private String author;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
