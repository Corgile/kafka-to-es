package iot.xhl.app;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import iot.xhl.app.repository.LiveMsgRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.IOException;

@SpringBootTest
class AppTests {

	@Resource
	private LiveMsgRepository bookRepository;
	@Resource
	private ElasticsearchClient client;


	@Test
	void jpaSave() {
		//List<LiveMessage> list = new ArrayList<>();
		//for (int i = 1; i < 101; i++) {
		//	LiveMessage book = new LiveMessage();
		//	book.setId(String.valueOf(i));
		//	book.setName("人间游途" + i);
		//	BookInfo bookInfo = new BookInfo();
		//	bookInfo.setAuthor("不逆" + i);
		//	bookInfo.setPrice((double) i);
		//	bookInfo.setDesc("一本介绍旅途风景的书" + i);
		//	book.setBookInfo(bookInfo);
		//	list.add(book);
		//}
		//bookRepository.saveAll(list);
	}

	@Test
	void jpaUpdate() {
		//Optional<LiveMessage> optional = bookRepository.findById("1");
		//LiveMessage book = optional.orElse(null);
		//assert book != null;
		//BookInfo bookInfo = book.getBookInfo();
		//bookInfo.setPrice(1.0);
		//book.setBookInfo(bookInfo);
		//bookRepository.save(book);
	}

	@Test
	void jpaDelete() {
		//        bookRepository.deleteById("1");
		//bookRepository.deleteAll();
	}

	@Test
	void jpaFindById() {
		//Optional<LiveMessage> optional = bookRepository.findById("1");
		//System.out.println(optional.orElse(null));
	}

	@Test
	void jpaFindAll() {
		//Pageable pageable = PageRequest.of(0, 10);
		//Page<LiveMessage> page = bookRepository.findAll(pageable);
		//page.getContent().forEach(System.out::println);
		//System.out.println(page.getContent().size());
	}

	@Test
	void clientFindAll() throws IOException {
		//精确匹配
		//        Query name = MatchQuery.of(m -> m.field("name").query("人间游途1"))._toQuery();
		//        Query author = MatchQuery.of(m -> m.field("bookInfo.author").query("不逆1"))._toQuery();
		//模糊匹配,通配符模式
		//        Query name = WildcardQuery.of(m -> m.field("name").value("人间*"))._toQuery();
		//        Query author = WildcardQuery.of(m -> m.field("bookInfo.author").value("不逆*"))._toQuery();
		//模糊匹配，容错率模式，fuzziness：即允许在查询条件的基础上误差数
		//        Query name = FuzzyQuery.of(f -> f.field("name").value("人间游途").fuzziness("1"))._toQuery();
		//        Query author = FuzzyQuery.of(f -> f.field("bookInfo.author").value("不逆").fuzziness("1"))._toQuery();
		// 组装查询条件
		//        Query query = Query.of(q -> q.bool(b -> b.must(name, author)));
		//查询id在list中的数据
		//        Query query = IdsQuery.of(id->id.values("1","2"))._toQuery();
		//查询价格大于100,小于200的数据
		// Query query = RangeQuery.of(f -> f.field("bookInfo.price").gt(JsonData.of(1)).lt(JsonData.of(100)))._toQuery();
		// //进行查询
		// SearchResponse<LiveMessage> result = client.search(s -> s
		// 				.index("book")
		// 				.query(query)
		// 				.aggregations("bookInfo.avgPrice", a -> a.avg(avg -> avg.field("bookInfo.price"))) //求平均
		// 				.aggregations("bookInfo.sumPrice", total -> total.sum(sum -> sum.field("bookInfo.price"))) //求和
		// 				.from(0)
		// 				.size(10)
		// 				.sort(f -> f.field(o -> o.field("bookInfo.price").order(SortOrder.Desc)))
		// 		, LiveMessage.class);
		// List<Hit<LiveMessage>> hits = result.hits().hits();
		// for (Hit<LiveMessage> hit : hits) {
		// 	LiveMessage book = hit.source();
		// 	System.out.println(book);
		// }
		// assert result.hits().total() != null;
		// System.err.println("总条数：" + result.hits().total().value());
		// System.err.println("平均价格：" + result.aggregations().get("bookInfo.avgPrice").avg());
		// System.err.println("总价：" + result.aggregations().get("bookInfo.sumPrice").sum());
	}

}
