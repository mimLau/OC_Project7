package com.mimi.mlibrary.service.impl;

import com.mimi.mlibrary.repository.account.MemberRepository;
import com.mimi.mlibrary.mapper.account.MemberMapper;
import com.mimi.mlibrary.model.dto.account.MemberDto;
import com.mimi.mlibrary.service.contract.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    private MemberRepository memberRepository;

    AccountServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
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

    @Override
    public MemberDto getMemberByEmail( String email ) {
        return MemberMapper.INSTANCE.toDto( memberRepository.getMemberByEmail( email ).orElse( null) );
    }

    @Override
    public MemberDto getMemberByNames( String firstname, String lastname ) {
        return MemberMapper.INSTANCE.toDto( memberRepository.getMemberByNames( firstname, lastname ).orElse( null) );
    }

    @Override
    public void updateNbOfCurrentsBorrowings( int id ) {
         memberRepository.updateNbOfCurrentsBorrowings( id, 1);
    }
}
