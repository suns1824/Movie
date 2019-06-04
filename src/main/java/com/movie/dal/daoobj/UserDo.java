package com.movie.dal.daoobj;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserDo implements Serializable{
    private static final long serialVersionUID = 4446542094351805746L;
    private int userId;
}
