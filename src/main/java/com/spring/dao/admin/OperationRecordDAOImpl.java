package com.spring.dao.admin;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.spring.dto.admin.OperationRecord;
import com.spring.vo.admin.OperationRecordVO;

@Repository
public class OperationRecordDAOImpl implements OperationRecordDAO {

	@Autowired
	private SqlSession sqlSession;

	static final String OPERATION_RECORD_MAPPER = "com.spring.mappers.OperationRecordMapper.";
	
	@Override
	public void createOperationRecord(OperationRecord operationRecord) throws Exception {
		
		sqlSession.insert(OPERATION_RECORD_MAPPER + "createOperationRecord", operationRecord);
	}

	@Override
	public List<OperationRecordVO> getOperationRecords(OperationRecordVO operationRecordVO) {
		
		return sqlSession.selectList(OPERATION_RECORD_MAPPER + "getOperationRecords", operationRecordVO);
	}
}