package com.example.springMVC.controller;

import com.example.springMVC.domain.Board;
import com.example.springMVC.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/boards") //하위 url /boards 로 시작됨
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;
    @GetMapping("/test")
    public String test(Model model){
        //key, value 파라미터로 데이터를 전송
        model.addAttribute("cnt", boardService.boardCount());
        model.addAttribute("test", boardService.boardList());

        return "hello";
    }

    @GetMapping("/main")
    public String main(Model model){
        model.addAttribute("list", boardService.boardList());

        return "boards";
    }

    @GetMapping("/view")
    public String viewBoard(Model model, Long boardId){
        model.addAttribute("view", boardService.getBoard(boardId));
        return "view";
    }

    @GetMapping("/upload")
    public String uploadBoardForm(){
        return "upload";
    }

    @PostMapping("/upload")
    public String uploadBoard(Board board){
        boardService.uploadBoard(board);
        return "redirect:/boards/main";
    }

    @PutMapping("/update")
    public String updateBoard(Board board){
        boardService.updateBoard(board);
        return "redirect:/boards/main";
    }

    @DeleteMapping("/delete")
    public String deleteBoard(Long boardId){
        boardService.deleteBoard(boardId);
        return "redirect:/boards/main";
    }

}
