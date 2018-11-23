package com.lucene;

import java.io.File;
import java.io.IOException;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.cjk.CJKAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.FieldType;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.junit.Test;

public class TestLucene {

	/**
	 * 
	 *@desc:建立索引库对数据建立索引
	 *@return:void
	 * @throws IOException 
	 *@trhows
	 */
	@Test
	public void testAdd() throws IOException {
		//1.创建索引写入器
		// 索引在硬盘上面的存储位置，在此工程下会生成一个hello的文件夹
		Directory directory = FSDirectory.open(new File("hello"));
		// lucene 当前使用的版本
		Version matchVersion = Version.LUCENE_44;
		// 分词器, 作用是将一段文本分词
		// analyzer 是一个抽象类，具体的切分词规则由子类实现 此时采用二分法
		Analyzer analyzer = new CJKAnalyzer(matchVersion);
		//创建索引写入其配置对象，包括lecene的版本、使用的分词器
		IndexWriterConfig config = new IndexWriterConfig(matchVersion, analyzer);
		// 构造索引写入的对象  索引要存放的位置
		IndexWriter indexWriter = new IndexWriter(directory, config);
		//2.写入文档信息
				
		//添加文档，定义文档的存储规则
		FieldType type=new FieldType();
		type.setIndexed(true);//是否要索引
		type.setStored(true);//是否需要存储
		
		// 往索引库里写数据,索引库里的数据都是document，一个document相当于一条记录
		Document document1=new Document();
		// document.add(field) 包含了两个过程：存储数据和创建索引
		//new Field(字段名，字段内容，字段的配置属性)
		document1.add(new Field("title", "doc1", type));
		document1.add(new Field("content", "我是中国人", type));
		
		Document document2=new Document();
		document2.add(new Field("title", "doc2", type));
		document2.add(new Field("content", "我们是一家人", type));
		
		// 索引库里面接收的都是document对象
		indexWriter.addDocument(document1);
		indexWriter.addDocument(document2);
		System.out.println("生成索引库");
		indexWriter.commit();
		indexWriter.close();
	}
	/**
	 * 
	 *@desc:更新索引库中的字段：更新的操作是先删除原文档编号后添加新的文档编号，编号发生变化
	 *@return:void
	 * @throws IOException 
	 * @throws ParseException 
	 *@trhows
	 */
	
	public void testUpdate() throws IOException, ParseException {
		//创建索引写入器
        Directory d = FSDirectory.open(new File("hhh"));
        Analyzer analyzer = new CJKAnalyzer(Version.LUCENE_44);
        IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_44, analyzer);
        IndexWriter writer = new IndexWriter(d, config);
        //更新对象
        Term term = new Term("title", "doc2");//更新的条件       writer.deleteDocuments(term);代表删除索引

        Document updateDoc = new Document();//更新之后的文档对象
        FieldType type = new FieldType();
        type.setIndexed(true);
        type.setStored(true);
        updateDoc.add(new Field("title", "doc2", type));
        updateDoc.add(new Field("content", "hello黄河之水天上来吧我要更新内容啦", type));
        writer.updateDocument(term, updateDoc);
        //提交更新内容 释放资源
        writer.commit();
        writer.close();
        searchIndex();
	}

	/**
	 * 
	 *@desc:查询索引库
	 *@return:void
	 * @throws IOException 
	 * @throws ParseException 
	 *@trhows
	 */
	
	//查询时可以有形参 Query query  代码中去掉Query这一行，调用时方法参数为new MatchAllDocsQuery()查询目录中的所有文档
	
	@Test
	public void searchIndex() throws IOException, ParseException {
		//1.创建索引写入器,指出索引在硬盘上的存储位置
	    Directory d = FSDirectory.open(new File("hello"));
	    //创建分词器
	    Analyzer analyzer = new CJKAnalyzer(Version.LUCENE_44);
	    //打开索引目录并读取到indexReader里
	    IndexReader r = DirectoryReader.open(d);
	    //创建索引查询对象
	    IndexSearcher searcher = new IndexSearcher(r);
	    //对哪个字段进行查询
	    QueryParser parser = new QueryParser(Version.LUCENE_44,"content", analyzer);
	    //对该字段查询的内容
	    Query query = parser.parse("中国人");
	    //search(查询对象,符合条件的前n条记录)
	    TopDocs search = searcher.search(query, 10000);//n:前几个结果
	    System.out.println("符合条件的记录有多少个:" + search.totalHits);

	    ScoreDoc[] scoreDocs = search.scoreDocs;
	    for (int i = 0; i < scoreDocs.length; i++) {
	        System.out.println("*******************************");
	        System.out.println("权重:" + scoreDocs[i].score);//相关度的排序
	        //得到document的索引号
	        int docId = scoreDocs[i].doc;
	        //根据索引号得到文档的内容
	        Document document = searcher.doc(docId);
	        System.out.println("文档编号 docId--->" + docId);
	        System.out.println("标题内容 title:--->" + document.get("content"));
	    }
		
	}
	
}
