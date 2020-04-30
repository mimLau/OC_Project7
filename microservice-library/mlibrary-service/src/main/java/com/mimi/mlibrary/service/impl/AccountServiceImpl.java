package com.mimi.mlibrary.service.impl;

import com.mimi.mlibrary.mapper.account.EmployeeMapper;
import com.mimi.mlibrary.model.dto.account.EmployeeDto;
import com.mimi.mlibrary.model.entity.loan.LoanStatus;
import com.mimi.mlibrary.repository.account.EmployeeRepository;
import com.mimi.mlibrary.repository.account.MemberRepository;
import com.mimi.mlibrary.mapper.account.MemberMapper;
import com.mimi.mlibrary.model.dto.account.MemberDto;
import com.mimi.mlibrary.service.contract.AccountService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class AccountServiceImpl implements AccountService {

    private MemberRepository memberRepository;
    private EmployeeRepository employeeRepository;

    AccountServiceImpl( MemberRepository memberRepository, EmployeeRepository employeeRepository ) {
        this.memberRepository = memberRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public MemberDto findMemberByUsername( String username ) {
        return MemberMapper.INSTANCE.toDto( memberRepository.getMemberByUsername( username ).orElse( null) );

    }

    /*@Override
    public MemberDto findMemberByMailAndPass(String mail, String password) {
        return MemberMapper.INSTANCE.toDto( memberRepository.getMemberByEmailAndPass( mail, password ).orElse( null) );
    }*

    @Override
    public EmployeeDto findEmployeeByMailAndPass(String mail, String password) {
        return EmployeeMapper.INSTANCE.toDto( employeeRepository.getEmployeeByEmailAndPass( mail, password ).orElse( null) );
    }*/

    @Override
    public EmployeeDto findEmployeeByUsername( String username ) {
        return EmployeeMapper.INSTANCE.toDto( employeeRepository.getEmployeeByUsername( username ).orElse( null) );
    }

    @Override
    public List<MemberDto> findAll() {
        return MemberMapper.INSTANCE.toDtoList( memberRepository.findAll() );
    }

    @Override
    public MemberDto findById( int id ) {
        return MemberMapper.INSTANCE.toDto( memberRepository.findById( id ).orElse(null) );
    }

    @Override
    public MemberDto save( MemberDto memberDto ) {
        //TODO Verify if member already exists
        Optional.of( MemberMapper.INSTANCE.toEntity( memberDto ) ).ifPresent( member -> memberRepository.save( member ));

        return memberDto;
    }

    @Override
    public MemberDto getMemberById( Integer id ) {
        return MemberMapper.INSTANCE.toDto( memberRepository.getMemberById( id ).orElse(null ));
    }

    /*@Override
    public MemberDto getMemberByEmail( String email ) {
        return MemberMapper.INSTANCE.toDto( memberRepository.getMemberByEmail( email ).orElse( null) );
    }

    @Override
    public MemberDto getMemberByNames( String firstname, String lastname ) {
        return MemberMapper.INSTANCE.toDto( memberRepository.getMemberByNames( firstname, lastname ).orElse( null) );
    }*/

    @Override
    public void updateNbOfCurrentsLoans( int id ) {
         memberRepository.updateNbOfCurrentsLoans( id, 1);
    }

    @Override
    public List<MemberDto> getMembersByOutdatedLoan( ) {
        LocalDate currentDate = LocalDate.now();
        return MemberMapper.INSTANCE.toDtoList( memberRepository.getMembersByOutdatedLoan( currentDate , LoanStatus.INPROGRESS ) );
    }




}
