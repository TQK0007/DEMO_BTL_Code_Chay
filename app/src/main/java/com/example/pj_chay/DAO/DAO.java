package com.example.pj_chay.DAO;

public interface DAO <T>{
    public int add(T t);
    public int update(T t);
    public  int delete(T t);
}
