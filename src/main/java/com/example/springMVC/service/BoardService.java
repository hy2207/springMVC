package com.example.springMVC.service;

import com.example.springMVC.domain.Board;
import com.example.springMVC.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardService {

    private final BoardMapper boardMapper;
    public int boardCount(){
        return boardMapper.boardCount();
    }
    public List<Board> boardList(){
        return boardMapper.findAll();
    }

    public Board getBoard(Long boardId){
        return boardMapper.getBoard(boardId);
    }

    @Transactional //생성, 수정, 삭제의 동작을 수행할 때 쿼리를 처치과정에서 오류발생시 롤백해주는 역할수행
    public void uploadBoard(Board board){
        boardMapper.uploadBoard(board);
    }

    @Transactional
    public void updateBoard(Board board){
        boardMapper.updateBoard(board);
    }

    @Transactional
    public void deleteBoard(Long boardId){
        boardMapper.deleteBoard(boardId);
    }



}
