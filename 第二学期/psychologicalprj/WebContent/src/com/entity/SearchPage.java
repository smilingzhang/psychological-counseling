package com.entity;

public class SearchPage {
	private CourseIndexSearcher courseIndexSearcher;
	private ArticleIndexSearch articleIndexSearch;
	private ConsulterIndexSearch consulterIndexSearch;
	public CourseIndexSearcher getCourseIndexSearcher() {
		return courseIndexSearcher;
	}
	public void setCourseIndexSearcher(CourseIndexSearcher courseIndexSearchers) {
		this.courseIndexSearcher = courseIndexSearchers;
	}
	public ArticleIndexSearch getArticleIndexSearch() {
		return articleIndexSearch;
	}
	public void setArticleIndexSearch(ArticleIndexSearch articleIndexSearchs) {
		this.articleIndexSearch = articleIndexSearchs;
	}
	public ConsulterIndexSearch getConsulterIndexSearch() {
		return consulterIndexSearch;
	}
	public void setConsulterIndexSearch(ConsulterIndexSearch consulterIndexSearchs) {
		this.consulterIndexSearch = consulterIndexSearchs;
	}

	

	

}
