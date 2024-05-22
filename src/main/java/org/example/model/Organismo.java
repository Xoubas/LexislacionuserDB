    package org.example.model;

    import jakarta.persistence.*;

    @Entity
    @Table
    public class Organismo {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer idOrganismo;

        @Column(unique = true)
        private String nome;

        @Column(name = "descripcion")
        private String descricion;

        public Organismo() {
        }

        public Organismo(String nome, String descricion) {
            this.nome = nome;
            this.descricion = descricion;
        }

        public Integer getIdOrganismo() {
            return idOrganismo;
        }

        public void setIdOrganismo(Integer idOrganismo) {
            this.idOrganismo = idOrganismo;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getDescricion() {
            return descricion;
        }

        public void setDescricion(String descricion) {
            this.descricion = descricion;
        }

        @Override
        public String toString() {
            return "Organismo{" +
                    "idOrganismo=" + idOrganismo +
                    ", nome='" + nome + '\'' +
                    ", descricion='" + descricion + '\'' +
                    '}';
        }
    }
