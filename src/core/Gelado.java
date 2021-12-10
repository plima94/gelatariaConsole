package core;

import java.util.Objects;


public class Gelado {
    
    private int id;
    private String nome;
    private float preco;
    private String sabor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }
    
    @Override
    public String toString(){
        
        String str = " ";
        
        str += "\nId: " + id;
        str += "\nNome: " + nome;
        str += "\nPreço: " + preco;
        str += "\nSabor: " + sabor;
        
        return str;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id;
        hash = 97 * hash + Objects.hashCode(this.nome);
        hash = 97 * hash + Float.floatToIntBits(this.preco);
        hash = 97 * hash + Objects.hashCode(this.sabor);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Gelado other = (Gelado) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Float.floatToIntBits(this.preco) != Float.floatToIntBits(other.preco)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.sabor, other.sabor)) {
            return false;
        }
        return true;
    }
    
    
}
