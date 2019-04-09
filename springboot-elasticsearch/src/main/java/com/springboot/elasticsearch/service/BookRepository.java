package com.springboot.elasticsearch.service;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

//页面查询地址  http://127.0.0.1:9200/atguigu/book/_search
//使用ElasticsearchRepository的子类进行检索  父类需要两个参数    类型  、 id
public interface BookRepository extends ElasticsearchRepository<Book,Integer> {
    //模糊查询数据   Book{id=1, name='我的青春恋爱物语果然有问题', author='渡航'}
    //方法命名有规定   findBy+Book实体类中的Name属性+Like为模糊查询
    public List<Book> findByNameLike(String name);
}
