package claudioteles.com.github.backendpessoas.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "usuario")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Usuario implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 165630055973304779L;

	@Id
	@GeneratedValue(generator = "gerador_de_id_usuario", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "gerador_de_id_usuario", sequenceName = "sequencia_usuario", initialValue = 30, allocationSize = 1)
	@Column(name = "id_usuario", nullable = false)
	private Long idUsuario;
	
	@Column(length = 20, nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String senha;
	@Column(nullable = false)
	private boolean ativo;
	@Column(length = 20, nullable = false)
	private String regra;
	
	@Column(nullable = true)
	private String sexo;
	@Column(length = 20, nullable = true)
	private String email;
	@Temporal(TemporalType.DATE)
	@Column(name = "data_de_nascimento", nullable = false)
	private Date dataDeNascimento;
	@Column(length = 20, nullable = true)
	private String naturalidade;
	@Column(length = 20, nullable = true)
	private String nacionalidade;
	@Pattern(regexp = "(^\\d{3}\\x2E\\d{3}\\x2E\\d{3}-\\d{2}$)")// 999.999.999-99
	@Column(length = 20, nullable = false, unique = true)
	private String cpf;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "data_de_cadastro", nullable = false)
	private Date dataDeCadastro;
	@Temporal(TemporalType.DATE)
	@Column(name = "data_de_atualizacao", nullable = false)
	private Date dataDeAtualizacao;
	
	public Usuario() {
		super();
	}

	public Usuario(String nome, String senha, boolean ativo, String regra, Date dataDeNascimento, String cpf,
			Date dataDeCadastro, Date dataDeAtualizacao) {
		super();
		this.nome = nome;
		this.senha = senha;
		this.ativo = ativo;
		this.regra = regra;
		this.dataDeNascimento = dataDeNascimento;
		this.cpf = cpf;
		this.dataDeCadastro = dataDeCadastro;
		this.dataDeAtualizacao = dataDeAtualizacao;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}
	
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public boolean isAtivo() {
		return ativo;
	}
	
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	public String getRegra() {
		return regra;
	}
	
	public void setRegra(String regra) {
		this.regra = regra;
	}
	
	public String getSexo() {
		return sexo;
	}
	
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Date getDataDeNascimento() {
		return dataDeNascimento;
	}
	
	public void setDataDeNascimento(Date dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}
	
	public String getNaturalidade() {
		return naturalidade;
	}
	
	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}
	
	public String getNacionalidade() {
		return nacionalidade;
	}
	
	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public Date getDataDeCadastro() {
		return dataDeCadastro;
	}
	
	public void setDataDeCadastro(Date dataDeCadastro) {
		this.dataDeCadastro = dataDeCadastro;
	}
	
	public Date getDataDeAtualizacao() {
		return dataDeAtualizacao;
	}
	
	public void setDataDeAtualizacao(Date dataDeAtualizacao) {
		this.dataDeAtualizacao = dataDeAtualizacao;
	}
	
}
