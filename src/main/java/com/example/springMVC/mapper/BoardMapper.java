package com.example.springMVC.mapper;

import com.example.springMVC.domain.Board;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardMapper {
    // 여기서 Board클래스와 DB의 tbl_board와 연결해줌
    int boardCount();

    List<Board> findAll();

    Board getBoard(Long boardId);

    void uploadBoard(Board board);

    void updateBoard(Board board);

    void deleteBoard(Long boardId);
}
