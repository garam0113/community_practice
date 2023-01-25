package com.example.board.controller;

import com.example.board.entity.Board;
import com.example.board.repository.BoardRepository;
import com.example.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.criteria.CriteriaBuilder;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;
    @Autowired
    private BoardRepository boardRepository;

    @GetMapping("/board/write")
    public String boardWriteForm(){
        return "boardWrite";
    }
    @PostMapping("/board/writedo")
    public String boardWriteDo(Board board){
      boardService.write(board);
        return "";
    }
    @GetMapping("/board/list")
    public String boardList(Model model){

        model.addAttribute("list", boardService.boardList());

        return "boardList";
    }
    @GetMapping("/board/view")
    public String boardView(Model model, Integer id){

        model.addAttribute("board", boardService.boardView(id));
        return "boardView";
    }
}
