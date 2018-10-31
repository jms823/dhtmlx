package com.ict.erp.dao;

import java.util.List;

public interface AddrListDAO {
	public int insertDAOBatch(List<List<String>> strList);
	public int insertDAO(List<List<String>> list);
}
