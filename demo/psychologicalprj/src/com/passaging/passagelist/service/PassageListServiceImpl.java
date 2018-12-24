package com.passaging.passagelist.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.entity.Article;
import com.entity.BusinessType;
import com.entity.TypeTable;
import com.passaging.passagelist.dao.PassageListDaoImpl;

/**
 * 
 * @author 孙明伟
 *
 */
@Service
public class PassageListServiceImpl {
	@Resource
	private PassageListDaoImpl passageListDaoImpl;

	/**
	 * 查询该业务类型对应的所有业务类别
	 * 
	 * @param businesstypeWorkType
	 * @return
	 */
	public List<TypeTable> findTypeTableList(int businesstypeWorkType) {
		return this.passageListDaoImpl.selectTypeTableList(businesstypeWorkType);
	}

	/**
	 * 根据业务类别Id查询对应的业务类别
	 * 
	 * @param typetableId
	 * @return
	 */
	public TypeTable findTypeTable(int typetableId) {
		return this.passageListDaoImpl.selectTypeTable(typetableId);
	}

	/**
	 * 根据业务类型Id 和 业务类别Id查询出对应的List<BusinessType>
	 * 
	 * @param businesstypeWorkType
	 * @param typeTable
	 * @return
	 */
	public List<BusinessType> findBusinessType(int businesstypeWorkType, TypeTable typeTable) {
		return this.passageListDaoImpl.selectBusinessTypeList(businesstypeWorkType, typeTable);
	}

	/**
	 * 通过业务Id查询对应的文章
	 * 
	 * @param businesstypeWorkId
	 * @return
	 */
	public Article findArticle(int businesstypeWorkId) {
		return this.passageListDaoImpl.selectArticle(businesstypeWorkId);
	}

	/**
	 * 查询出符合要求的文章数量
	 * 
	 * @param businesstypeWorkType
	 * @param typeTable
	 * @return
	 */
	public int findCount(int businesstypeWorkType, TypeTable typeTable) {
		return this.passageListDaoImpl.selectCount(businesstypeWorkType, typeTable);
	}

	/**
	 * 分页查出类别表
	 * 
	 * @param pageNum
	 * @param pageSize
	 * @param businesstypeWorkType
	 * @param typeTable
	 * @return
	 */
	public List<BusinessType> findBusinessTypeByPage(int pageNum, int pageSize, int businesstypeWorkType,
			TypeTable typeTable) {
		return this.passageListDaoImpl.selectBusinessTypeByPage(pageNum, pageSize, businesstypeWorkType, typeTable);
	}
}
