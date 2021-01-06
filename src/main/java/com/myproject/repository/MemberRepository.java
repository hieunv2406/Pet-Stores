package com.myproject.repository;

import com.myproject.common.dto.Datatable;
import com.myproject.common.dto.ResultInsideDTO;
import com.myproject.data.dto.MemberDTO;

public interface MemberRepository {

//    EmployeeDTO findEmployeeById(Long employee_id);
//
//    ResultInsideDTO insertEmployee(EmployeeDTO employeeDTO);
//
    ResultInsideDTO updateMemberInfo(MemberDTO memberDTO);
//
//    ResultInsideDTO deleteEmployeeById(Long employeeId);

    Datatable getDatatableMember(MemberDTO memberDTO);

//    List<EmployeeDTO> getListDataExport(EmployeeDTO employeeDTO);
//
//    List<Map<String, Object>> getListEmployeeMap();
}
