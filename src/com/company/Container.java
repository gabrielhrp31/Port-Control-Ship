package com.company;

class Container{
    private Boolean status;
    Container inferior;

    public Container(Boolean status){
        this.status=status;
        this.inferior = null;
    }

    public String getStatus() { return status ? "Cheio":"Vazio"; }
}
