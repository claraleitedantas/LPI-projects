package eventos.dominio;

import java.util.HashSet;
import java.util.Set;

public class Participante {
    private Long id;
    private String nome;
    private String email;
    private boolean pagante;
    private Set<Evento> eventos;
    
    public Participante() {
        this.eventos = new HashSet<>();
    }

    public Participante(String nome, String email) {
        this(nome, email, false);
    }

    public Participante(String nome, String email, boolean pagante) {
        setNome(nome);
        setEmail(email);
        setPagante(pagante);
        this.eventos = new HashSet<>();
    }

    public Long getId() {
        return id;
    }   

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
       if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser nulo ou vazio.");
        }
        if (nome.length() > 100) {
            throw new IllegalArgumentException("Nome não pode ter mais de 100 caracteres.");
        }
        this.nome = nome.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
       if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email não pode ser nulo ou vazio.");
        }
        if (email.length() > 120) {
            throw new IllegalArgumentException("Email não pode ter mais de 120 caracteres.");
        }
        if (!email.matches("^[^\\s@]+@[^\\s@]+$")) {
            throw new IllegalArgumentException("Email inválido.");
        }
        this.email = email.trim();
    }

    public boolean isPagante() {
        return pagante;
    }

    public void setPagante(boolean pagante) {
        this.pagante = pagante;
    }

    public Set<Evento> getEventos() {
        return eventos;
    }   

}
