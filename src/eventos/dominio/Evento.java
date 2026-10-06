package eventos.dominio;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.time.LocalDate;
import java.util.Set;

public class Evento {
    private Long id;
    private String nome;
    private LocalDate data;
    private String local;
    private int capacidade;
    private Organizador organizador;
    private List<Programacao> programacao;
    private Set<Participante> participantes; 

    public Evento() {
        this.programacao = new ArrayList<>();
        this.participantes = new HashSet<>();
    }

    public Evento(String nome, LocalDate data, String local, int capacidade, Organizador organizador) {
        setNome(nome);
        setData(data);
        setLocal(local);
        setCapacidade(capacidade);
        setOrganizador(organizador);
        this.programacao = new ArrayList<>();
        this.participantes = new HashSet<>();
    }

    public Long getId(){
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
         if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser nulo ou vazio.");
        }
        if (nome.length() > 120) {
            throw new IllegalArgumentException("Nome não pode ter mais de 120 caracteres.");
        }
        this.nome = nome.trim();
    }
    
    public LocalDate getData() {
        return data;
    }
 
    public void setData(LocalDate data) {
        if (data == null) {
            throw new IllegalArgumentException("Data não pode ser nula.");
        }
        this.data = data;
    }
    
    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        if (local == null || local.trim().isEmpty()) {
            throw new IllegalArgumentException("Local não pode ser nulo ou vazio.");
        }
        if (local.length() > 80) {
            throw new IllegalArgumentException("Local não pode ter mais de 80 caracteres.");
        }
        this.local = local.trim();
    }
    
    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        if (capacidade <= 0) {
            throw new IllegalArgumentException("Capacidade deve ser maior que zero.");
        }
        this.capacidade = capacidade;
    }

    public Organizador getOrganizador() {
        return organizador;
    }

    public void setOrganizador(Organizador organizador) {
        if (organizador == null) {
            throw new IllegalArgumentException("Organizador não pode ser nulo.");
        }
        this.organizador = organizador;
    }

    public List<Programacao> getProgramacao() {
        return programacao;
    }

    public Set<Participante> getParticipantes() {
        return participantes;
    }
}