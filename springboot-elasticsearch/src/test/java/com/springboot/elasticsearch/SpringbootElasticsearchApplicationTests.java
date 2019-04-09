package com.springboot.elasticsearch;

import com.springboot.elasticsearch.service.Book;
import com.springboot.elasticsearch.service.BookRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


//使用elasticsearch进行检索
//使用springboot下的ElasticsearchRepository进行操作
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootElasticsearchApplicationTests {

    @Autowired
    BookRepository bookRepository;
    @Test
    public void contextLoads() {
        //页面查询地址  http://127.0.0.1:9200/atguigu/book/_search
        /*Book book = new Book();
        book.setId(1);
        book.setName("我的青春恋爱物语果然有问题");
        book.setAuthor("渡航");*/
        //使用ElasticsearchRepository的子类对象进行发布
       // bookRepository.index(book);

        //模糊查询数据   Book{id=1, name='我的青春恋爱物语果然有问题', author='渡航'}
        //方法命名有规定   固定findBy+Book实体类中的name属性首字母大写+Like为模糊查询
        List<Book> result= bookRepository.findByNameLike("青春");
        for(Book b:result){
            System.out.println(b);
        }
    }

}
