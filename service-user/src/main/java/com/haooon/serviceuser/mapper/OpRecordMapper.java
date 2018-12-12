package com.haooon.serviceuser.mapper;

import com.haooon.serviceuser.entity.OpRecord;
import com.haooon.serviceuser.entity.OpRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OpRecordMapper {
    int countByExample(OpRecordExample example);

    int deleteByExample(OpRecordExample example);

    int insert(OpRecord record);

    int insertSelective(OpRecord record);

    List<OpRecord> selectByExample(OpRecordExample example);

    int updateByExampleSelective(@Param("record") OpRecord record, @Param("example") OpRecordExample example);

    int updateByExample(@Param("record") OpRecord record, @Param("example") OpRecordExample example);
}