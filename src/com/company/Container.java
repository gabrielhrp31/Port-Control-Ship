package com.company;

public class Container{
    Boolean status;
    Container inferior;

    public Container(Boolean status){
        this.status=status;
        this.inferior = null;
    }
}
