package com.theLazyCoder.Model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Tutorial")
public record Post(String profile, String desc,int exp, String[] techs) {
}
