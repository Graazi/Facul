package atvd04;

import java.util.ArrayList;

public class agenda {
    
    private ArrayList<Contato> contatos;
    
    public void Agenda() {
        contatos = new ArrayList<>();
    }
    
    public void adicionarContato(Contato contato) {
        contatos.add(contato);
    }
    
    public void removerContato(Contato contato) {
        contatos.remove(contato);
    }
    
    public void listarContatos() {
        for (Contato contato : contatos) {
            System.out.println(contato.toString());
        }
    }

    public static void main(String[] args) {
        agenda agenda = new agenda();
        Contato contato = new Contato(null, null, null);
        agenda.adicionarContato(contato);    
        System.out.println("Lista de contatos:");
        agenda.listarContatos();

        agenda.removerContato(contato);

        System.out.println("Lista de contatos após a remoção de um contato:");
        agenda.listarContatos();

    }
}