package org.kosta.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper {
	public int getTotalProductCount();

	public List<String> getMakerKindList();
}