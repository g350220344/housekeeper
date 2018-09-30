package com.cindata.housekeeper.web.dao;

import com.cindata.housekeeper.core.entity.Parameter;
import com.cindata.housekeeper.web.model.LoanInfo;
import com.cindata.housekeeper.web.model.LoanInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LoanInfoMapper {
    int countByExample(LoanInfoExample example);

    int deleteByExample(LoanInfoExample example);

    int insert(LoanInfo record);

    int insertSelective(LoanInfo record);

    List<LoanInfo> selectByExample(LoanInfoExample example);

    int updateByExampleSelective(@Param("record") LoanInfo record, @Param("example") LoanInfoExample example);

    int updateByExample(@Param("record") LoanInfo record, @Param("example") LoanInfoExample example);

	List<LoanInfo> getUserInfoList(Parameter params);
}