package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class Page {
    private boolean hasPrevious;
    private boolean hasNext;
    private int pageIndex;
    private int count;
    private List<Article> articles;
}
