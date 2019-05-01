package com.company;

class Container{
    private Boolean status;
    Container inferior;

    public Container(Boolean status){
        this.status=status;
        this.inferior = null;
    }
}
