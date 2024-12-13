package com.theLazyCoder;

import com.theLazyCoder.Model.Post;

import java.util.List;

public interface SearchRepository {

    List<Post> findByText(String text);
}
