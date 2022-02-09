package br.com.hawker.to;

public class OfertasTO {

	private int id;
	private int idProduto;
	private int quantidade;
	private String producao;
	private String vencimento;
	private double precoUnitario;
	private int idVendedor;
	
	public OfertasTO() {
	}

	public OfertasTO(int id, int idProduto, int quantidade, String producao, String vencimento, double precoUnitario,
			int idVendedor) {
		super();
		this.id = id;
		this.idProduto = idProduto;
		this.quantidade = quantidade;
		this.producao = producao;
		this.vencimento = vencimento;
		this.precoUnitario = precoUnitario;
		this.idVendedor = idVendedor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getProducao() {
		return producao;
	}

	public void setProducao(String producao) {
		this.producao = producao;
	}

	public String getVencimento() {
		return vencimento;
	}

	public void setVencimento(String vencimento) {
		this.vencimento = vencimento;
	}

	public double getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	public int getIdVendedor() {
		return idVendedor;
	}

	public void setIdVendedor(int idVendedor) {
		this.idVendedor = idVendedor;
	}

}
