package com.company;

class Container{
    private Boolean status;
    Container inferior;

    //    inicia o Container
    public Container(Boolean status){
        this.status=status;
        this.inferior = null;
    }

    // retorna uma string falando se o status do container é cheio ou vazio
    public String getStatus() { return status ? "Cheio":"Vazio"; }
}
