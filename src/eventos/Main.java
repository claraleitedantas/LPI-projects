package eventos;

import eventos.dominio.Evento;
import eventos.dominio.Organizador;
import eventos.dominio.Participante;
import eventos.dominio.Programacao;
import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        Organizador organizador = new Organizador (
            "João Silva", 
            "joao@dominio", 
            "Tecnologia"
        );

        
        Participante participante1 = new Participante(
            "Maria Souza", 
            "maria@dominio"
        );

        Participante participante2 = new Participante(
            "Carlos Oliveira", 
            "carlos@dominio"
    
        );

        Evento evento = new Evento(
            "Evento de Tecnologia", 
            LocalDate.of(2024, 6, 15),  
            "Auditorio Central",
            100, 
            organizador
        );

        System.out.println("=======Organizador========");
        
        System.out.println("Nome: " + organizador.getNome());
        System.out.println("Email: " + organizador.getEmail());
        System.out.println("Setor: " + organizador.getSetor());

        System.out.println("\n=======Participantes========");
        
        System.out.println("Nome: " + participante1.getNome());
        System.out.println("Email: " + participante1.getEmail());
        
        System.out.println("Nome: " + participante2.getNome());
        System.out.println("Email: " + participante2.getEmail());

        System.out.println("\n=======Evento========");

        System.out.println("Nome: " + evento.getNome());
        
        System.out.println("Data: " + evento.getData());
        System.out.println("Local: " + evento.getLocal());
        System.out.println("Capacidade: " + evento.getCapacidade());
        System.out.println("Organizador: " + evento.getOrganizador().getNome());

        System.out.println("\n=======TESTANDO EVENTO========");
        try {
            evento.setNome("");
        } catch (IllegalArgumentException e) {
            System.out.println("setNome: " + e.getMessage());
        }

        try {
            evento.setData(null);
        } catch (IllegalArgumentException e) {
            System.out.println("setData: " + e.getMessage());
        }

        try {
            evento.setLocal("");
        } catch (IllegalArgumentException e) {
            System.out.println("setLocal: " + e.getMessage());
        }

        try {
            evento.setCapacidade(0);
        } catch (IllegalArgumentException e) {
            System.out.println("setCapacidade: " + e.getMessage());
        }

        try {
            evento.setOrganizador(null);
        } catch (IllegalArgumentException e) {
            System.out.println("setOrganizador: " + e.getMessage());
        }

        System.out.println("\n========== TESTANDO PROGRAMACAO ==========");

        
        try {

            String tituloGrande =
                    "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
                    + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
                    + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";

            new Programacao(
                    tituloGrande,
                    LocalTime.of(14, 0),
                    "Professor João",
                    evento
            );

        } catch (IllegalArgumentException e) {
            System.out.println("Título: " + e.getMessage());
        }


        try {

            new Programacao(
                    "Palestra de Java",
                    null,
                    "Professor João",
                    evento
            );

        } catch (IllegalArgumentException e) {
            System.out.println("Horário: " + e.getMessage());
        }


       
        try {

            Programacao programacao = new Programacao(
                    "Palestra de Java",
                    LocalTime.of(14, 0),
                    "",
                    evento
            );

            System.out.println(
                    "Responsável vazio: " + programacao.getResponsavel()
            );

        } catch (IllegalArgumentException e) {
            System.out.println("Responsável: " + e.getMessage());
        }
    }
}
