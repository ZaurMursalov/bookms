package com.example.book.model.book;

import com.example.book.model.response.BookResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PAgeAbleBookResponse {
    private List<BookResponse> bookResponses;
    private long totalElements;
    private int totalPAges;
    private boolean hasNextPage;
}
