package com.example.springkadaitodo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springkadaitodo.entity.ToDo;

public interface ToDoRepository extends JpaRepository<ToDo, Integer> {
    // 今回は一覧だけなので追加メソッド不要
}
