package com.myproject.repository;

import com.myproject.common.Constant;
import com.myproject.common.dto.BaseDTO;
import com.myproject.common.dto.Datatable;
import com.myproject.common.dto.ResultInsideDTO;
import com.myproject.common.repository.BaseRepository;
import com.myproject.common.utils.DataUtil;
import com.myproject.data.dto.MemberDTO;
import com.myproject.data.entity.MemberEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Transactional
@Repository
public class MemberRepositoryImpl extends BaseRepository implements MemberRepository {


    //    @Override
//    public EmployeeDTO findEmployeeById(Long employee_id) {
//        EmployeeEntity employeeEntity = getEntityManager().find(EmployeeEntity.class, employee_id);
//        EmployeeDTO employeeDTO = employeeEntity.toDto();
//        return employeeDTO;
//    }
//
//    @Override
//    public ResultInsideDTO insertEmployee(EmployeeDTO employeeDTO) {
//        ResultInsideDTO resultInsideDTO = new ResultInsideDTO();
//        resultInsideDTO.setKey(Constant.RESPONSE_KEY.SUCCESS);
//        EmployeeEntity employeeEntity = getEntityManager().merge(employeeDTO.toEntity());
//        resultInsideDTO.setId(employeeEntity.getEmployeeId());
//        return resultInsideDTO;
//    }
//
    @Override
    public ResultInsideDTO updateMemberInfo(MemberDTO memberDTO) {
        ResultInsideDTO resultInsideDTO = new ResultInsideDTO();
        resultInsideDTO.setKey(Constant.RESPONSE_KEY.SUCCESS);
        MemberEntity memberEntity = getEntityManager().find(MemberEntity.class, memberDTO.getUserId());
        if (memberEntity != null) {
            memberEntity = getEntityManager().merge(memberDTO.toEntity());
            resultInsideDTO.setId(memberEntity.getUserId());
        } else {
            resultInsideDTO.setKey(Constant.RESPONSE_KEY.RECORD_NOT_EXIST);
        }
        return resultInsideDTO;
    }
//
//    @Override
//    public ResultInsideDTO deleteEmployeeById(Long employeeId) {
//        ResultInsideDTO resultInsideDTO = new ResultInsideDTO();
//        resultInsideDTO.setKey(Constant.RESPONSE_KEY.SUCCESS);
//        EmployeeEntity employeeEntity = getEntityManager().find(EmployeeEntity.class, employeeId);
//        getEntityManager().remove(employeeEntity);
//        return resultInsideDTO;
//    }

    @Override
    public Datatable getDatatableMember(MemberDTO memberDTO) {
        BaseDTO baseDTO = sqlSearch(memberDTO);
        return getListDataTableBySqlQuery(baseDTO.getSqlQuery(),
                baseDTO.getParameters(), memberDTO.getPage(), memberDTO.getPageSize(),
                MemberDTO.class,
                memberDTO.getSortName(), memberDTO.getSortType());
    }

//    @Override
//    public List<EmployeeDTO> getListDataExport(EmployeeDTO employeeDTO) {
//        BaseDTO baseDTO = sqlSearch(employeeDTO);
//        return getNamedParameterJdbcTemplate().query(baseDTO.getSqlQuery()
//                , baseDTO.getParameters()
//                , BeanPropertyRowMapper.newInstance(EmployeeDTO.class));
//    }
//
//    @Override
//    public List<Map<String, Object>> getListEmployeeMap() {
//
//        Map<String, Object> beanMap = new HashMap<>();
//        String sql = " select " +
//                " t.cot1 cot1, " +
//                " t.cot2 cot2, " +
//                " t.cot3 cot3 " +
//                " from " +
//                " tabledetest t " +
//                " where " +
//                " 1 = 1 ";
//        List<Map<String, Object>> mapResult = getNamedParameterJdbcTemplate().queryForList(sql, beanMap);
//        return mapResult;
//    }

    private BaseDTO sqlSearch(MemberDTO memberDTO) {
        BaseDTO baseDTO = new BaseDTO();
        Map<String, Object> parameter = new HashMap<>();
        String sql = getSQLFromFile("member", "getDatatableMember");
        if (memberDTO != null) {
//            if (!DataUtil.isNullOrEmpty(memberDTO.getUsername())) {
//                sql += " And lower(m.username) Like lower(:username) ";
//                parameter.put("username", DataUtil.convertSqlLike(memberDTO.getUsername()));
//            }
//            if (!DataUtil.isNullOrEmpty(memberDTO.getFullName())) {
//                sql += " And lower(m.full_name) Like lower(:fullName) ";
//                parameter.put("fullName", DataUtil.convertSqlLike(memberDTO.getFullName()));
//            }
        }
        sql += " ORDER BY m.hoten ASC ";
        baseDTO.setSqlQuery(sql);
        baseDTO.setParameters(parameter);
        return baseDTO;
    }
}
